package com.hibernate.chap5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestInheritance {
	public static void main(String[] args) {
		AnnotationConfiguration config= new AnnotationConfiguration();
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
		
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Project project = new Project();
		project.setProjectName("hibernate");
		
		Module module = new Module();
		module.setProjectName("module project");
		module.setModuleName("hibernate module");
		
		Task task = new Task();
		task.setModuleName("task module");
		task.setProjectName("task project");
		task.setTaskName("hibernate task");
		
		session.save(project);
		session.save(module);
		session.save(task);
		
		session.getTransaction().commit();
		
		
		
	}
}
