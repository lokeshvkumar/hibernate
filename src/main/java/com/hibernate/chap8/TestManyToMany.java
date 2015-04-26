package com.hibernate.chap8;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.chap7.College;
import com.hibernate.chap7.Student;

public class TestManyToMany {
	public static void main(String[] args) {
		AnnotationConfiguration config= new AnnotationConfiguration();
		config.addAnnotatedClass(Event.class);
		config.addAnnotatedClass(Delegate.class);

		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);
		
		Delegate del1 = new Delegate();
		del1.setDelegateName("john");
		
		Delegate del2 = new Delegate();
		del2.setDelegateName("patrick");
		
		Delegate del3 = new Delegate();
		del3.setDelegateName("lisa");
		
		Event event1 = new Event();
		event1.setEventName("JAVA 101");
		event1.getDelegates().add(del1);
		event1.getDelegates().add(del2);
		
		Event event2 = new Event();
		event2.setEventName("AWS 101");
		event2.getDelegates().add(del3);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.save(del1);
		session.save(del2);
		session.save(del3);
		session.save(event1);
		session.save(event2);
	
		session.getTransaction().commit();
		
	}
}
