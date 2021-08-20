package com.school.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.school.bean.School;
import com.school.bean.Student;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils {
	private static String JWT_SECRET = "Very secret";
	private static int JWT_EXPIRY = 60* 60*1000;
	public String getToken(Student token) {

		Date issuedAt = new Date();

		Date expiresAt = new Date(issuedAt.getTime() + JWT_EXPIRY);

		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("username", token.getStdUsername());
		return Jwts.builder().setClaims(claims).setIssuedAt(issuedAt).setExpiration(expiresAt).signWith(SignatureAlgorithm.HS512, JWT_SECRET)
			.compact();

	}
	public String getToken(School token) {
		
		Date issuedAt = new Date();

		Date expiresAt = new Date(issuedAt.getTime() + JWT_EXPIRY);

		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("userId", token.getSchoolName());
		claims.put("username", token.getSchoolPlace());
		return Jwts.builder().setClaims(claims).setIssuedAt(issuedAt).setExpiration(expiresAt).signWith(SignatureAlgorithm.HS512, JWT_SECRET)
			.compact();
	}
			

		
	
}
