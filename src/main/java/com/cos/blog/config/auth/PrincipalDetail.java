package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

public class PrincipalDetail implements UserDetails{
	private User user; // 콤포지션: 객체를 품고 있는 것.

	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료되지 않았는지 리턴한다.(true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있는지 아닌지 리턴한다.(true:잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료됐는지 안 됐는지 리턴한다.(true:만료 안 됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화(사용가능)인지 리턴한다. (true:활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// 계정의 권한 목록을 리턴한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		
		// GrantedAuthority 인터페이스에 메소드는 getAuthority() 하나이기에 아래와 같이 람다식으로 선언가능
		collectors.add(()->{return "ROLE_"+user.getRole();});
		
		return collectors;
	}
}
