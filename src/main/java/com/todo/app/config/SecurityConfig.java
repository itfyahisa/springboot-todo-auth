package com.todo.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
             .authorizeHttpRequests(authorize -> authorize
            		 .requestMatchers("/user/login", "/user/register").permitAll() //ログインページは認証許可
//            		 .requestMatchers("/user/register").permitAll() //登録ページは認証許可
            		 .anyRequest().authenticated()) //ほかのリクエストは認証がいる
//			.httpBasic(Customizer.withDefaults()); //ポップアップが出てきて認証するやつ
//			.formLogin(Customizer.withDefaults()); //Springのデフォルトフォームが出てきて認証するやつ
            .formLogin(login -> login
            		.loginPage("/user/login") //loginページはここ
            		.loginProcessingUrl("/user/login") //デフォルトは 'login' , ログインフォームからの送信先を変更
            		.usernameParameter("email") // username を email に変更
            		.passwordParameter("password")
            		.defaultSuccessUrl("/top", true)) //ログインした後のリンク先を変更
            .logout(logout ->logout
            		.logoutUrl("/user/logout") //logoutページはここ
            		.deleteCookies("JSESSIONID") //ログアウトしたらいったんcookie削除しとく
            		.logoutSuccessUrl("/user/login")); //ログアウトしたらログインページに戻す
	    return http.build();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
//    	return NoOpPasswordEncoder.getInstance();　//エンコーダーを使いたくないときに使った。
        
//     int strength = 12;
//     return new BCryptPasswordEncoder(strength);
//     コストファクターでハッシュ化の強度を変えられる default=10 -> 2^10(1024)回 12で4096回
//	    $2a$ : Bcryptのバージョン
//	    10$ : コストファクター（この場合は10）
//	    EixZaYVK1fsbw1ZfbX3OXe : ソルト（Base64でエンコードされた16バイトのソルト）
//	    PaWxn96p36oDp3QY19x6Q8wGJ9.E0UO : ハッシュ化されたパスワード

    }
}