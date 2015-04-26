package com.hibernate.chap1;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * mvn compile exec:java -Dexec.mainClass=TestEmployee
 * @author lokesh
 *
 */
public class TestEmployee {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Employee.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);//print to log files and run against the database, run only once to create.
		
		SessionFactory factory = config.buildSessionFactory();//resource intensive object. Minimize session factory creation.
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Employee employeeAlex = new Employee();//not associated to a session then its transient.
		employeeAlex.setEmployeeName("Loki");
		//employeeAlex.setId(1);
		employeeAlex.setEmailAddress("alex@gmall.com");
		employeeAlex.setEmployeeJoiningDate(Calendar.getInstance());
		employeeAlex.setEmployeeJoiningDate(new GregorianCalendar());
		employeeAlex.setEmployeeLloginTime(Date.valueOf("2015-04-21"));
		session.save(employeeAlex);
		session.getTransaction().commit();//object gets saved once commit gets executed
	}
}
