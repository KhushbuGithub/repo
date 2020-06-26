package com.capgemini.bookmydoctor;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.capgemini.bookmydoctor.dto.User;

import lombok.Data;

@SuppressWarnings("serial")
@Component
@Data
public class UserDetailsImpl implements UserDetails {

	private User userInfoBean;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userInfoBean.getUserType());

		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {

		return userInfoBean.getPassword();
	}

	@Override
	public String getUsername() {
		return userInfoBean.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
