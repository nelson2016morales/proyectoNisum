package com.testBci.jpa.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testBci.jpa.entity.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, UUID>{
	
	@Query("SELECT u FROM Usuarios u WHERE u.email=?1")
	Optional<Usuarios> buscarUsuarioPorCorreo(String email);
}
