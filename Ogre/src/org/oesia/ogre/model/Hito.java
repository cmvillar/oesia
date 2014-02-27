package org.oesia.ogre.model;

import java.sql.*;

import javax.persistence.*;

import org.openxava.annotations.*;
@Entity
/*@Views({
	@View(members="tipoHito, importe, fechaFacturacion; anexo.codigo; factura"),
	@View(name="Simple", members="tipoHito, importe, anexo.codigo")
	})
*/

public class Hito extends Identificable{
	@Required 
	@ManyToOne
	@DescriptionsList
	private TipoHito tipoHito;
	
	@Required
	private float importe;
	
	@ReadOnly
	private boolean facturado;
	
	@ReadOnly
	private Timestamp fechaFacturacion;
	
	@ManyToOne
	@DescriptionsList(descriptionProperties = "codigo")
	private Anexo anexo;
	
	@ManyToOne
	@ReadOnly
	private Factura factura;
	
	//--------------------------------------------------
	public Hito(){
		super();		
	}
	public Hito(String idHito, TipoHito tipoHito, float importe,
			boolean facturado, Timestamp fechaFacturacion) {
		super();
		super.setId(idHito);
		this.tipoHito = tipoHito;
		this.importe = importe;
		this.facturado = facturado;
		this.fechaFacturacion = fechaFacturacion;
	}
	

	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public boolean isFacturado() {
		return facturado;
	}
	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}
	public Timestamp getFechaFacturacion() {
		return fechaFacturacion;
	}
	public void setFechaFacturacion(Timestamp fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}
	public TipoHito getTipoHito() {
		return tipoHito;
	}
	public void setTipoHito(TipoHito tipoHito) {
		this.tipoHito = tipoHito;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Anexo getAnexo() {
		return anexo;
	}
	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}
	
}
