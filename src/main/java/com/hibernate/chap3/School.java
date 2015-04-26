package com.hibernate.chap3;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * combine two classes as one TABLE.
 * @author lokesh
 *
 */

@Entity
@Table(schema="TESTSCHEMA")
public class School {
	
	@Id
	@GeneratedValue
	private int schoolId;
	private String schoolName;
	
	@Embedded
	private SchoolDetail detail;

	
	public SchoolDetail getDetail() {
		return detail;
	}
	public void setDetail(SchoolDetail detail) {
		this.detail = detail;
	}
		
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
