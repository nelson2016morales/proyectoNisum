package com.testBci.jpa.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.testBci.jpa.entity.Usuarios;
import com.testBci.jpa.repository.UsuariosRepository;

class UsuariosServiceImplTest {

	private UsuariosServiceImpl usuariosServiceImpl;

	UsuariosRepository usuarioRepositoryMock = Mockito.mock(UsuariosRepository.class);

	Usuarios usuarioRequest;
	
	
	@BeforeEach
	public void setup() {
		usuariosServiceImpl = new UsuariosServiceImpl(usuarioRepositoryMock);    
		
		Usuarios usuarioCreated = new Usuarios();
		usuarioCreated.setName("nombre");
		usuarioCreated.setPassword("password");
		usuarioCreated.setEmail("mail");
		
		Mockito.when(usuarioRepositoryMock.save(usuarioRequest)).thenReturn(usuarioCreated);

	}

	@Test 
	public void crearUsuarioTest() { 		

		// given
		String nameExpected = "nombre";
		String passwordExpected = "password";
		String emailExpected = "mail";

		// when
		Usuarios usuarioFinal = usuariosServiceImpl.crearUsuario(usuarioRequest);

		// then
		assertEquals(usuarioFinal.getName(),nameExpected);
		assertEquals(usuarioFinal.getPassword(),passwordExpected);
		assertEquals(usuarioFinal.getEmail(),emailExpected);
	}

}
