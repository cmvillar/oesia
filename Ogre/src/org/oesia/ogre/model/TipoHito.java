package org.oesia.ogre.model;

import java.sql.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class TipoHito {

	@Id @Required
	private int identificador;
	@Required @Column(length=20)
	private String descripcion;
	@Required @Column(length=2)
	private float porcentaje;
	//Fecha a partir de la cual se activa el porcentaje
	@Stereotype ("DATETIME")
	private Timestamp fechaActivacion;
	
	public TipoHito(){
		
	}
	
	public TipoHito(int identificador, String descripcion, float porcentaje,
			Timestamp fechaActivacion) {
		super();
		this.identificador = identificador;
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
		this.fechaActivacion = fechaActivacion;
	}
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Timestamp getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(Timestamp fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	
}
