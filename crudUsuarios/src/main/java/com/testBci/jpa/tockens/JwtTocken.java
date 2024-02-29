package com.testBci.jpa.tockens;

import com.testBci.jpa.entity.Usuarios;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTocken {
	
	public String getJwtTockenCustom(Usuarios usuarioRequest) {
		try{
	        Claims claim= Jwts.claims() 
	                .setSubject(usuarioRequest.getName());
	            claim.put("name", String.valueOf(usuarioRequest.getName()));
	            claim.put("password", usuarioRequest.getPassword());
	            claim.put("email", usuarioRequest.getEmail());
	            String secret = "secret";
	        return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, secret).compact();					
		}
		catch (Exception e) {
			return new String("Error al crear token");
		}		
	}	
}
