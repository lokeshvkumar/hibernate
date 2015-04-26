package com.hibernate.chap5;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * split one class to two tables
 * @author lokesh
 *
 */
@Entity
@Table(schema="TESTSCHEMA")
public class Module extends Project{
	
	private String moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
	
}
