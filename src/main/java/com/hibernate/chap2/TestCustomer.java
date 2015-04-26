package com.hibernate.chap2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCustomer {
	public static void main(String[] args) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Customer.class);
		configuration.configure("hibernate.cfg.xml");
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCreditScore(730);
		customer.setRewardPoints(200);
		customer.setCustomerName("Alex");
		customer.setCustomerAddress("75 palmer st, quincy");
		
		session.save(customer);
		session.getTransaction().commit();
		
	}
}
