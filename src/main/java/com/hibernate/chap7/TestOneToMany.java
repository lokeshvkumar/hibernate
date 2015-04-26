package com.hibernate.chap7;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.chap6.Person;
import com.hibernate.chap6.PersonDetail;

public class TestOneToMany {

		public static void main(String[] args) {
			AnnotationConfiguration config= new AnnotationConfiguration();
			config.addAnnotatedClass(College.class);
			config.addAnnotatedClass(Student.class);

			config.configure("hibernate.cfg.xml");

			new SchemaExport(config).create(true, true);

			College college = new College();
			college.setCollegeName("SIT");
			
			List<Student> students = new ArrayList<Student>();
			Student student = new Student();
			student.setStudentName("loki");
			student.setCollege(college);
			
			Student student2 = new Student();
			student2.setStudentName("poorni");
			student2.setCollege(college);
			
			college.setStudents(students);
			
			SessionFactory factory = config.buildSessionFactory();
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.save(college);
			session.save(student);
			session.save(student2);
			session.getTransaction().commit();
			
			
		}
	}
