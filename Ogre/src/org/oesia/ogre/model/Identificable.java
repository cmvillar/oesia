package org.oesia.ogre.model;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@MappedSuperclass
public class Identificable {

	@Id	@Hidden
	@GeneratedValue(generator="system-uuid") 
	@GenericGenerator(name="system-uuid", strategy = "uuid") 
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
