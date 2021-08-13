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
public class Persona {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int id;
public String nombre;
public String apellido;

//one to one relationship cascade will apply every change on the relation as well
@OneToOne(cascade = CascadeType.ALL)
//we tell to join on persona usuario on the usuario id
@JoinColumn(name = "usuario", referencedColumnName = "id")
public Usuario usuario;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


}
