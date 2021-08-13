package net.main.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {

	public Usuario(String username, String pass, Role role) {		
		this.username = username;
		this.pass = pass;
		this.role=role;
	}
	
	public Usuario(String username, String pass) {		
		this.username = username;
		this.pass = pass;		
	}
	
	public Usuario() {		
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String username;
	public String pass;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role", referencedColumnName = "id")
	public Role role;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}

public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}

}
