package com.example.vue.response;

import java.util.Set;

/**
 * 账户验证后返回的信息
 * @author lilx
 * @create 2019-01-17 17:44
 */
public class AuthenticationResponse {
	private String token;
	private Set<String> authorities;
	private Long userId;

	public AuthenticationResponse() {
	}

	public AuthenticationResponse(Long userId, String token, Set<String> authorities) {
		this.userId = userId;
		this.token = token;
		this.authorities = authorities;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
