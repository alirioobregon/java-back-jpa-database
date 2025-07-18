package com.example.ali.java_back_jpa_database.security;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

public class TokenJwtConfig {
    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CONTENT_TYPE = "application/json";

}
