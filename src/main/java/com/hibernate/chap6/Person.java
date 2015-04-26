package com.hibernate.chap6;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Uni and Bi-directional
 * @author lokesh
 *
 */
@Entity
@Table(schema="TESTSCHEMA")
public class Person {
	
	@Id
	@GeneratedValue
	private int persdonId;
	private String personName;
	
	/*
	 * If corresponding records needs to be deleted, then REMOVE, AND REFRESH to refresh data in
	 * corresponding table. CascadeType.ALL covers all scenarios.
	 * Fetch refers to loading corresponding record from related table or not. default is eager for
	 * OneToOne. But for OneToMany, its lazy.
	 */
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="pDetail_FK")//define the custom column name that will be foreign key column.
	private PersonDetail personDetail;
	
	public PersonDetail getPersonDetail() {
		return personDetail;
	}
	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}
	public int getPersdonId() {
		return persdonId;
	}
	public void setPersdonId(int persdonId) {
		this.persdonId = persdonId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	
}
