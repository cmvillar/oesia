package org.oesia.ogre.tests;

import java.math.*;
import java.sql.*;

import javax.persistence.*;

import org.oesia.ogre.model.*;
import org.openxava.tests.*;

import static org.openxava.jpa.XPersistence.*;


public class ImputacionTest extends ModuleTestBase{
	
	private Imputacion imputacion;
	private Usuario usuario;
	private Proyecto proyecto;
	private EstadoAnexo estadoAnexo;
	private Anexo anexo;
	
	public ImputacionTest(String testName){
		super(testName, "Imputacion");
	}
	
	protected void setUp() throws Exception{
		testCreateImputacion();
		super.setUp();
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
		removeImputacion();
	}
	

	public void testCreateImputacion(){
		usuario = new Usuario("cmvillar22", "cmvillar22");
		proyecto = new Proyecto("prj1","prueba imputacion",new Timestamp(System.currentTimeMillis()));
		estadoAnexo = new EstadoAnexo(100, "estado 10");
		anexo = new Anexo("0001","ANEXO001", "Files", 200, 
				new BigDecimal(27.5), estadoAnexo, false, proyecto);
		imputacion = new Imputacion();
		imputacion.setUsuario(usuario);
		imputacion.setAnexo(anexo);
		imputacion.setId("imp001");
		imputacion.setSemana(20);
		imputacion.setDescripcion("pruebas imputacion 20");
		imputacion.setHoras(new BigDecimal(33));
		imputacion.setValidada(true);
		imputacion.setDiaImputacion(new Timestamp(System.currentTimeMillis()));
		/*getManager().persist(usuario);
		getManager().persist(estadoAnexo);
		getManager().persist(proyecto);
		getManager().persist(anexo);
		getManager().persist(imputacion);
		*/
		commit();

	}
	private void removeImputacion(){
		remove(imputacion,anexo, proyecto, usuario, estadoAnexo);
		commit();
	}
	
	private void remove(Object ... entities) { 
		for (Object entity: entities)
			getManager().remove(getManager().merge(entity));
	}
}
