package com.hibernate.chap6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.chap5.Module;
import com.hibernate.chap5.Project;
import com.hibernate.chap5.Task;

/**
 * for every single person, one record in persondetail table
 * @author lokesh
 *
 */
public class TestOneToOne {
	public static void main(String[] args) {
		AnnotationConfiguration config= new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Person person = new Person();
		person.setPersonName("lokesh");
		
		PersonDetail personDetail = new PersonDetail();
		personDetail.setIncome(100000);
		personDetail.setJob("IT");
		personDetail.setZipCode("02169");
		
		person.setPersonDetail(personDetail);
		
		session.save(person);//no need to save persondetail, since its cascadetype is cascadetype.all
		
		session.getTransaction().commit();
	}
}
