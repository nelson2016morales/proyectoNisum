package com.testBci.jpa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testBci.jpa.entity.Telefonos;

public interface TelefonosRepository extends JpaRepository<Telefonos, UUID>{

}
