package org.oesia.ogre.model;

import java.sql.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
@View(members="nombre, fechaAlta")

@Entity
public class Proyecto extends Identificable{
	
	@Required @Column(length=10)
	private String nombre;
	
	@Required @Stereotype("DATETIME")
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Timestamp fechaAlta;

/*	@PrePersist
	private void calcularContador() {
		idProyecto = new Long(System.currentTimeMillis()).intValue(); 
	}
	*/
	
	//--------------------------------------------------
	public Proyecto(){
		
	}
	public Proyecto(String idProyecto, String nombre, Timestamp fechaAlta) {
		super();
		super.setId(idProyecto);
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
}
