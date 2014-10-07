package com.pma.validator;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

/**
 * Esta clase define las especificaciones que debe cumplir el validador
 * 1.- tendra� que tener una longitud mayor o igual a 4 caracteres
 * 2.- tendra� que tener al menos una min�uscula
 * 3.- tendr�a que tener al menos alguna mayu�scula
 * 4.- tendr�a que tener al menos un n�mero y una letra
 *  
 * @author cmvillar
 *
 */

public class ValidatorPwdSpec {
	public boolean validate(String pwd){
		return false;
	}
	
	@Test
	public void lengthBiggerEqualFour() {
		Assert.assertEquals(true, validate(""));
	}

}
