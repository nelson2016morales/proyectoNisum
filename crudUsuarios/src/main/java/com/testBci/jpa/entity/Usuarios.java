package com.testBci.jpa.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;


@Entity
@Table(name="usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)	
	private UUID id;
	
	@CreationTimestamp
    private Instant created;

	@UpdateTimestamp
    private Instant modified;
	
	@CreationTimestamp
	private Instant lastLogin;
	
	private String token;
	
	private Boolean isActive;
	
	
	
	private String name;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
    message = "El Formato de correo es incorrecto")
	private String email;
	
	private String password;
	
	
	
	
	
	
	
	
	
	
	
	@OneToMany(targetEntity = Telefonos.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_fk", referencedColumnName = "id")
	
	private List<Telefonos> phones;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Telefonos> getPhones() {
		return phones;
	}
	public void setPhones(List<Telefonos> phones) {
		this.phones = phones;
	}
		
	public Instant getCreated() {
		return created;
	}
	public void setCreated(Instant created) {
		this.created = created;
	}
	
	public Instant getModified() {
		return modified;
	}
	
	public void setModified(Instant modified) {
		this.modified = modified;
	}
		
	public Instant getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Instant lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
