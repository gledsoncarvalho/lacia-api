package com.lacia.api.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import com.lacia.api.exception.ExpiredTokenException;
import com.lacia.api.exception.InvalidTokenException;
import com.lacia.api.model.User;

import java.util.Date;

@Service
public class TokenService {

	private String key = "String Aleatoria Secret";

	// 30 minutos
	private static final long expirationTime = 1800000;

	public String generateToken(User user) {
		return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis())).setSubject("Teste JWT API")
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(SignatureAlgorithm.HS256, key).compact();
	}

	public Claims decodeToken(String token) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	}

	public boolean validate(String token) {
		try {
			String tokenTratado = token.replace("Bearer ", "");
			Claims claims = decodeToken(tokenTratado);

			System.out.println(claims.getIssuer());
			System.out.println(claims.getIssuedAt());
			// Verifica se o token está expirado
			if (claims.getExpiration().before(new Date(System.currentTimeMillis())))
				throw new ExpiredTokenException();
			System.out.println(claims.getExpiration());
			return true;
		} catch (ExpiredTokenException et) {
			et.printStackTrace();
			throw et;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidTokenException();
		}

	}

}