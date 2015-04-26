package com.hibernate.chap6;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema="TESTSCHEMA")
public class PersonDetail {
	@Id
	@GeneratedValue
	@JoinColumn(name="pDetail_PK")//define the custom column name that will be foreign key column.
	private int personDetailId;
	private String zipCode;
	private String job;
	private double income;
	
	/*
	 * to make it bidirectional, create object ref for person
	 */
	@OneToOne(mappedBy="personDetail", cascade=CascadeType.ALL)
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getPersonDetailId() {
		return personDetailId;
	}
	public void setPersonDetailId(int personDetailId) {
		this.personDetailId = personDetailId;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
	
	
}
