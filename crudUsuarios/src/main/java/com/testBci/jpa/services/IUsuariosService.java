package com.testBci.jpa.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.testBci.jpa.entity.Usuarios;

public interface IUsuariosService {

	Usuarios crearUsuario(Usuarios request);
	
	Usuarios actualizarUsuario(Usuarios usuario);
	
	List<Usuarios> buscarUsuarios();
	
	void borrarUsuarioPorId(UUID id);
	
	Optional<Usuarios> buscarUsuario(UUID id);
	
	Optional<Usuarios> buscarUsuarioPorCorreo(String email);
}
