package com.testBci.jpa.entity;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuariosTest {

	private Usuarios sut;

	@BeforeEach
    public void setup() {
        sut = new Usuarios();
    }
	
	@Test 
    public void createUsuariosTest() {
		assertNotNull(sut);        
    }
}
