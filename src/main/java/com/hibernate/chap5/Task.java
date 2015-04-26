package com.hibernate.chap5;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema="TESTSCHEMA")
public class Task extends Module{
	
	private String taskName;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}
