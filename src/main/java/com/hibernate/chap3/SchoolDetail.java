package com.hibernate.chap3;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * not an entity, an embedded class in school and annotated
 * as Embeddable
 * @author lokesh
 *
 */

@Embeddable
public class SchoolDetail {
	
	
	private String schoolAddress;
	private boolean isPublicSchool;
	private int studentCount;
	
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public boolean isPublicSchool() {
		return isPublicSchool;
	}
	public void setPublicSchool(boolean isPublicSchool) {
		this.isPublicSchool = isPublicSchool;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	
	
	
}
