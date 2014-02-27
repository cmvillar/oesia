package org.oesia.ogre.model;

import java.sql.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@Entity
public class Factura extends Identificable{
	@Required
	private String descripcion;
	
	@ReadOnly
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Timestamp fechaOperacion;
	
	@OneToMany(mappedBy="factura")
	/*@ListProperties(
			"tipoHito.number, importe, anexo.codigo")*/
	private Collection<Hito> hitos;
	
	//--------------------------------------------------
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Collection<Hito> getHitos() {
		return hitos;
	}
	public void setHitos(Collection<Hito> hitos) {
		this.hitos = hitos;
	}
	public Timestamp getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(Timestamp fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	
	
}
