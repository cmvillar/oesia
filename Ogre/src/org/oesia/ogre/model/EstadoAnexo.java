package org.oesia.ogre.model;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * El anexo podr‡ estar en los siguientes estados:
 * - En elaboraci—n
 * - Enviado
 * - Aceptado
 * - Cancelado
 * @author cmvillar
 *
 */

@Entity
public class EstadoAnexo {
	
	@Id @Required
	private int idEstadoAnexo;
	@Required @Column(length=15)
	private String descripcion;
	
	public EstadoAnexo(){
		
	}
	public EstadoAnexo(int idEstadoAnexo, String descripcion) {
		super();
		this.idEstadoAnexo = idEstadoAnexo;
		this.descripcion = descripcion;
	}
	
	public int getIdEstadoAnexo() {
		return idEstadoAnexo;
	}
	public void setIdEstadoAnexo(int idEstadoAnexo) {
		this.idEstadoAnexo = idEstadoAnexo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
