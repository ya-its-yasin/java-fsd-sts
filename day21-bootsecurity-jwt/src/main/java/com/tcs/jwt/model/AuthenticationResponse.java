package com.tcs.jwt.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

	private final String jwt;
}
