package org.oesia.ogre.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
@View(members="nombre, pwd;"+
	"proyectos")

@Entity
public class Usuario {
	@Id @Required
	private String nombre;
	@Required @Column(length=16)
	private String pwd;
	
	@ManyToMany
	@JoinTable(name="USUARIO_PROYECTO",
	 joinColumns=@JoinColumn(name="USUARIO_NOMBRE"),
	 inverseJoinColumns=@JoinColumn(name="PROYECTOS_IDPROYECTO")
	)
	private Collection<Proyecto> proyectos;

	public Usuario(){
	}
	
	public Usuario(String nombre, String pwd, Collection<Proyecto> proyectos) {
		super();
		this.nombre = nombre;
		this.pwd = pwd;
		this.proyectos = proyectos;
	}
	
	public Usuario(String nombre, String pwd){
		this.nombre=nombre;
		this.pwd=pwd;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Collection<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Collection<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
}
