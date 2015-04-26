package com.hibernate.chap1;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * mvn compile exec:java -Dexec.mainClass=com.mastertheboss.hibernate.HibernateTest
 * @author lokesh
 *
 */
/*use jpa annotations, as its a java standard and irrespective of orm framework all follow
*jpa annotations.
*/

@Entity
@Table(schema="TESTSCHEMA", name="Employee")
public class Employee {
	
	@Id
	@TableGenerator(schema="TESTSCHEMA", name="empid", table="empoktb",pkColumnName="empkey", 
	pkColumnValue="empvalue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="empid")
	@Column(name="empId")
	private int id;
	private String employeeName;
	private boolean permanent;
	private Calendar employeeJoiningDate;
	private Date employeeLloginTime;
	private String password;
	
	@Column(nullable=false)
	private String emailAddress;
	
	
	/*
	 * make it not null - Column(nullable = false)
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/*
	 * prevent persisting data - Transient
	 * 
	 */
	@Transient
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Basic
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getEmployeeJoiningDate() {
		return employeeJoiningDate;
	}
	public void setEmployeeJoiningDate(Calendar employeeJoiningDate) {
		this.employeeJoiningDate = employeeJoiningDate;
	}
	public Date getEmployeeLloginTime() {
		return employeeLloginTime;
	}
	public void setEmployeeLloginTime(Date employeeLloginTime) {
		this.employeeLloginTime = employeeLloginTime;
	}
	
	
}
