package com.stefanini.appointmentapp.security.DTO;

public class ResponseDto {
	private String userName;
	private String jwtKey;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJWTKey() {
		return jwtKey;
	}
	public void setJWTKey(String jWTKey) {
		jwtKey = jWTKey;
	}
	
	
}
