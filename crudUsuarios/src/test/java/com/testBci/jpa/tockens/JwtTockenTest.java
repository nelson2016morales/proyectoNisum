package com.testBci.jpa.tockens;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.testBci.jpa.entity.Usuarios;

class JwtTockenTest {

private JwtTocken sut;
	
	@BeforeEach
    public void setup() {
        sut = new JwtTocken();
    }
	
	@Test 
    public void getJwtTockenCustomTest() {
        
		String jwtTokenExpected = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJub21icmUiLCJuYW1lIjoibm9tYnJlIiwicGFzc3dvcmQiOiJwYXNzd29yZCIsImVtYWlsIjoibWFpbCJ9.ZVPLlW-icRpIwtFqSmb3fyocUp3XKfvjUjyUITTLJNSLId6_3gqtWcSr8iuHCtwFbLWnW23ZpIjPPko7zgfGBA";
		
		// given
		Usuarios usuario = new Usuarios();
		usuario.setName("nombre");
		usuario.setPassword("password");
		usuario.setEmail("mail");
        
		// when
		String jwtTockenCustom = sut.getJwtTockenCustom(usuario);
        
		// then
         assertEquals(jwtTokenExpected,jwtTockenCustom);
    }
}
