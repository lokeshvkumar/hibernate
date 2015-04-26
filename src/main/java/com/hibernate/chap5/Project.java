package com.hibernate.chap5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * JOINED STRATEGY IS BEST. 
 * SINGLE CAN DESIGN ISSUES, WITH TOO MANY TABLES COLUMNS CAN GROW
 * WITH TABLE_PER_CLASS EACH TABLE WILL redefine the columns to store the values from parent.
 * @author lokesh
 *
 */
@Entity
@Table(schema="TESTSCHEMA")
@Inheritance(strategy=InheritanceType.JOINED)
public class Project {
	
	@Id
	@GeneratedValue
	private int projectId;
	private String projectName;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}
