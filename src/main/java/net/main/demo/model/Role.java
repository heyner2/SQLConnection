package net.main.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int id;
public String role;

public Role() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Role(int id, String role) {
	this.id = id;
	this.role = role;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}
