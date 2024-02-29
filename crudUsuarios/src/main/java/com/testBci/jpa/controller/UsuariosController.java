package com.testBci.jpa.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.testBci.jpa.entity.Usuarios;
import com.testBci.jpa.services.IUsuariosService;
import com.testBci.jpa.services.UsuariosServiceImpl;
import com.testBci.jpa.tockens.JwtTocken;

import dtos.UsuariosResponseDto;
import jakarta.validation.Valid;
import mappers.MapperUsuariosResponse;

@RestController
public class UsuariosController {

	@Autowired
	UsuariosServiceImpl usuarioServiceImpl;
	
	@PostMapping("/crearUsuario")
	public ResponseEntity<Object> crearUsuario(@Valid @RequestBody Usuarios usuarioRequest, 
			BindingResult bindingResult){	

		if(bindingResult.hasErrors()){
			return new ResponseEntity<Object>(Map.of(
					"mensaje", bindingResult.getFieldError().getDefaultMessage()),HttpStatus.BAD_REQUEST);
		}
		else{
			Optional<Usuarios> opcionalUsuario = usuarioServiceImpl.buscarUsuarioPorCorreo(usuarioRequest.getEmail());
			UsuariosResponseDto usuariosResponse= new UsuariosResponseDto();

			if(opcionalUsuario.isPresent()) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
						"mensaje", "El correo ya se encuentra registrado"));
			}
			else{
				usuarioRequest.setToken((new JwtTocken().getJwtTockenCustom(usuarioRequest)));
				usuarioRequest.setIsActive(true);
				
				MapperUsuariosResponse mapperUsuariosResponse = new MapperUsuariosResponse();
				usuariosResponse = mapperUsuariosResponse.Map(usuarioServiceImpl.crearUsuario(usuarioRequest));
				return ResponseEntity.status(HttpStatus.OK).body(usuariosResponse);
			}	
		}
	}

	@GetMapping("/traerUsuarios")
	public ResponseEntity<List<Usuarios>> traerUsuarios(){
		return new ResponseEntity<List<Usuarios>>( usuarioServiceImpl.buscarUsuarios(),HttpStatus.OK);	
	}

	@PutMapping("/actualizarUsuario/{id}")
	public ResponseEntity<Object> actualizarUsuario(@PathVariable("id") UUID id, @RequestBody Usuarios usuarioRequest, BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors()){
			return new ResponseEntity<Object>(Map.of(
					"mensaje", bindingResult.getFieldError().getDefaultMessage()),HttpStatus.BAD_REQUEST);
		}
		else {
			Optional<Usuarios> opcionalUsuario = usuarioServiceImpl.buscarUsuario(id);
			Usuarios nuevoUsuario= new Usuarios();
			if(opcionalUsuario.isPresent()) {
				nuevoUsuario = opcionalUsuario.get();
				nuevoUsuario.setEmail(usuarioRequest.getEmail());
				nuevoUsuario.setName(usuarioRequest.getName());
				nuevoUsuario.setPassword(usuarioRequest.getPassword());
				nuevoUsuario.setPhones(usuarioRequest.getPhones());
				usuarioServiceImpl.actualizarUsuario(nuevoUsuario);
				return ResponseEntity.ok(nuevoUsuario);
			}	
			else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
						"mensaje", "El Usuario no existe"));
			}
		}
	}

	@DeleteMapping("/borrarUsuario/{id}")
	public ResponseEntity<Object> borrarUsuario(@PathVariable("id") UUID id) {
		Optional<Usuarios> opcionalUsuario = usuarioServiceImpl.buscarUsuario(id);
		Usuarios nuevoUsuario= new Usuarios();
		if(opcionalUsuario.isPresent()) {
			this.usuarioServiceImpl.borrarUsuarioPorId(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(nuevoUsuario);
		}	
		else{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
					"mensaje", "El Usuario no existe"));
		}
	}

	@GetMapping("/traerUsuario/{id}")
	public ResponseEntity<Optional<Usuarios>> traerUsuario(@PathVariable("id") UUID id){		
		return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.buscarUsuario(id));
	}
	
	//usado en test
	public UsuariosController(IUsuariosService usuariosService){
		usuarioServiceImpl=(UsuariosServiceImpl) usuariosService;
	}	
}
