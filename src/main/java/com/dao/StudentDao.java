package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class StudentDao {
	public void insert() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Student S = new Student();
		S.setStud_name("Shan");
		S.setCity("Dhule");

		Student S1 = new Student();
		S1.setStud_name("Nitin");
		S1.setCity("Amravati");

		Student S2 = new Student();
		S2.setStud_name("Shlok");
		S2.setCity("Pune");

		ss.persist(S);
		ss.persist(S1);
		ss.persist(S2);

		System.out.println("Data is inserted....");

		tr.commit();
		ss.close();
	}
	
	public void update() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 3;
		Student S = ss.get(Student.class, id);
		S.setStud_name("Sahil");
		S.setCity("Banglore");
		ss.merge(S);
		System.out.println("Data is updated");
		tr.commit();
		ss.close();
		
	}
	public void delete()
	{
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		
		
		
		SessionFactory sf= cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		int id=3;
		Student S=ss.get(Student.class, id);
		ss.remove(S);
		System.out.println("Data is deleted");
		tr.commit();
		ss.close();
	}
	
	public void select() {

		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		
		
		
		SessionFactory sf= cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		List<Student> list=ss.createQuery("from Student",Student.class).list();
		for (Student student : list) {
			System.out.println("Student name:"+student.getStud_name());
			
			System.out.println("Student city:"+ student.getCity());
			
		}
	}

}
