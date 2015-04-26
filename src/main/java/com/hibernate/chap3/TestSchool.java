package com.hibernate.chap3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestSchool {
	public static void main(String[] args) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(School.class);
		configuration.configure("hibernate.cfg.xml");
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		School school = new School();
		school.setSchoolName("hebbal");
		SchoolDetail detail = new SchoolDetail();
		detail.setPublicSchool(true);
		detail.setSchoolAddress("200 palmer st, quincy");
		detail.setStudentCount(2000);
		school.setDetail(detail);		
		session.save(school);
		session.getTransaction().commit();
		
	}
}
