package org.oesia.ogre.model;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@View(members="codigo, horas, importeHoraFacturacion, importe;"+
		"nombreFichero;"+
		"estado, proyecto, esVarios")

@Entity
public class Anexo extends Identificable{
	
	@Required @Column(length=20)
	private String codigo;
	
	@Column(length=100)
	private String nombreFichero;
	
	@Required
	private boolean esVarios=false;
	
	@Required
	private int horas;
	
	@Required @Stereotype("MONEY")
	private BigDecimal importeHoraFacturacion;
	
	
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList
	private EstadoAnexo estado;
	
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList
	private Proyecto proyecto;
	
	@OneToMany(mappedBy="anexo")
	private Collection<Hito> hitos;
	
	public Anexo(){
		
	}
	public Anexo(String idAnexo, String codigo, String nombreFichero, int horas, 
			BigDecimal importeHoraFacturacion, EstadoAnexo estado, boolean esVarios, Proyecto proyecto){
		super.setId(idAnexo);
		this.codigo = codigo;
		this.nombreFichero=nombreFichero;
		this.horas = horas;
		this.importeHoraFacturacion = importeHoraFacturacion;
		this.estado = estado;
		this.esVarios = esVarios;
		this.proyecto = proyecto;
		
	}
	
	@Stereotype("MONEY") 
	@Depends("horas, importeHoraFacturacion")
	public BigDecimal getImporte(){
		if(importeHoraFacturacion==null)
			return new BigDecimal(0);
		else
			return importeHoraFacturacion.multiply(new BigDecimal(horas));
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreFichero() {
		return nombreFichero;
	}
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public BigDecimal getImporteHoraFacturacion() {
		return importeHoraFacturacion;
	}
	public void setImporteHoraFacturacion(BigDecimal importeHoraFacturacion) {
		this.importeHoraFacturacion = importeHoraFacturacion;
	}
	public EstadoAnexo getEstado() {
		return estado;
	}
	public void setEstado(EstadoAnexo estado) {
		this.estado = estado;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public boolean isEsVarios() {
		return esVarios;
	}
	public void setEsVarios(boolean esVarios) {
		this.esVarios = esVarios;
	}
	
}
