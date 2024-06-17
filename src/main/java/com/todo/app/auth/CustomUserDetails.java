package com.todo.app.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User { //SpringSecurityのUserクラスをインポート ここにユーザー情報を仮置く

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	インスタンスをファイルやメモリ、データベースに保存する→シリアライズ
//	シリアライズ可能なクラスの固有のバージョン番号のことをシリアルバージョンUIDとらしい(UniqueID)

	
	public CustomUserDetails(String email, String password, Collection<? extends GrantedAuthority> authorities) {
		super(email, password, authorities);
		// 今回の仕様はemailログインのため、username-> emailに変更
	}
	
	public String getEmail() {
		return getUsername();
	}
	//UsenameをEmailに変更したため、getメソッドも変えとく。
	
}
