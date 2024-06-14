package com.todo.app.auth;

import java.util.Collections;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo.app.entity.User;
import com.todo.app.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserMapper userMapper;
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return userMapper.findByUsername(username).map(user -> new CustomUserDetails(
//					user.getUsername(), 
//					user.getPassword(), 
//					Collections.emptyList()
//					)
//				).orElseThrow(() -> new UsernameNotFoundException(
//						"Given username is not found. (username = '"+ username + "')"
//			)
//		);
//	}
	
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> optionalUser = userMapper.findByUsername(email);
//        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//    }
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		User user = userMapper.findByEmail(email)
				.orElseThrow(
						() -> new UsernameNotFoundException("User not found with email: " + email)
						);
		CustomUserDetails customUserDetails = new CustomUserDetails(user.getEmail(), user.getPassword(), Collections.emptyList());
		return customUserDetails;
	}

}
