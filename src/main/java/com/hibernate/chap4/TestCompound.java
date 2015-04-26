package com.hibernate.chap4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCompound {
	public static void main(String[] args) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Accounts.class);
		configuration.configure("hibernate.cfg.xml");
		
		//new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Accounts accounts = new Accounts();
		accounts.setAccountBalance(10000);
		CompoundKey compoundKey = new CompoundKey(1,1);
		accounts.setCompoundKey(compoundKey);
		session.save(accounts);
		session.getTransaction().commit();
		
	}
}
