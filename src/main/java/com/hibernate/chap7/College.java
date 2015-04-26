package com.hibernate.chap7;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="TESTSCHEMA")
public class College {
	

	@Id
	@GeneratedValue
	private int collegeId;
	private String collegeName;
	
	/**
	 * two provide two key properties, target entity, which refers to the related
	 * entity and mapped by refers to the variable used in other entity.
	 * Always not advisable to keep fetchtype as eager as loads of related data
	 * might cause performance issues.
	 */
	@OneToMany(targetEntity=Student.class, 
			mappedBy="college",
			cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Student> students;
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
