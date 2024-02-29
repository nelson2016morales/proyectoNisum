package com.testBci.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="telefonos")
public class Telefonos {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID pid;
	
	private String number;
	
	private int citycode;
	
	private int contrycode;
	
	public UUID getPid() {
		return pid;
	}
	public void setPid(UUID pid) {
		this.pid = pid;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public int getContrycode() {
		return contrycode;
	}
	public void setContrycode(int contrycode) {
		this.contrycode = contrycode;
	}
}
