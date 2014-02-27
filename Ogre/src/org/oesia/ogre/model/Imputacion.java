package org.oesia.ogre.model;

import java.math.*;
import java.sql.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.oesia.ogre.calculators.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
@View(members="usuario, semana, diaImputacion, anexo, horas;"+
		"descripcion")

@Entity
public class Imputacion extends Identificable{

	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList
	private Usuario usuario;
	
	@Required
	@DefaultValueCalculator(ActualNumberOfWeekCalculator.class)
	@Column(length=2)
	private int semana;

	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Timestamp diaImputacion;
	
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties = "codigo")
	private Anexo anexo;
	
	@Required
	@Column(length=3)
	private BigDecimal horas;
	
	@Required @Column(length=250)
	private String descripcion;
	
	private Boolean validada;
	
	
	
	public int getSemana() {
		return semana;
	}
	public void setSemana(int semana) {
		this.semana = semana;
	}
	public Timestamp getDiaImputacion() {
		return diaImputacion;
	}
	public void setDiaImputacion(Timestamp diaImputacion) {
		this.diaImputacion = diaImputacion;
	}
	public Anexo getAnexo() {
		return anexo;
	}
	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}
	public BigDecimal getHoras() {
		return horas;
	}
	public void setHoras(BigDecimal horas) {
		this.horas = horas;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getValidada() {
		return validada;
	}
	public void setValidada(Boolean validada) {
		this.validada = validada;
	}
}
