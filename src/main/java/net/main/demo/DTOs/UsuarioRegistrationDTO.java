package net.main.demo.DTOs;

public class UsuarioRegistrationDTO {

	public UsuarioRegistrationDTO() {		
	}
	
public UsuarioRegistrationDTO(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}
public String username;
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
public String pass;

}
