package com.testBci.jpa.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testBci.jpa.entity.Usuarios;
import com.testBci.jpa.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

	@Autowired
	private UsuariosRepository usuarioRepository;

	@Override
	public Usuarios crearUsuario(Usuarios usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuarios> buscarUsuario(UUID id) {		
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuarios> buscarUsuarios() {
		return this.usuarioRepository.findAll();
	}
	
	@Override
	public Usuarios actualizarUsuario(Usuarios usuario) {
		return this.usuarioRepository.saveAndFlush(usuario);
	}

	@Override
	public void borrarUsuarioPorId(UUID id) {
		usuarioRepository.deleteById(id);
	}
	
	@Override
	public Optional<Usuarios> buscarUsuarioPorCorreo(String email) {
		return usuarioRepository.buscarUsuarioPorCorreo(email);
	}
	
	//usado en test
	public UsuariosServiceImpl(UsuariosRepository usuarioRepository){
		this.usuarioRepository=usuarioRepository;
	}
}
