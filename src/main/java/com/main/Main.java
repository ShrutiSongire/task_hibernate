package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.entity.Student;

public class Main {

	public static void main(String[] args) {
		
			Configuration cfg=new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Student.class);
			
			
			
			SessionFactory sf= cfg.buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tr=ss.beginTransaction();
			
			
			String hqlQuery="from Student";
			Query<Student> query=ss.createQuery(hqlQuery,Student.class);
			List<Student> list=query.list();
			for (Student student : list) {
				System.out.println(student);
			}
			
			
			String hqlQuery1="insert into Student(stud_name,city)values(:stud_name,:city)";
			//Query<Student> query=ss.createQuery(hqlQuery,Student.class);
			MutationQuery query1=ss.createMutationQuery(hqlQuery1);
			query1.setParameter("stud_name", "Vishu");
			query1.setParameter("city", "Nashik");
			//ss.persist(query1);
			query1.executeUpdate();
//			
//			System.out.println("Data is inserted....");
			
//			int stud_id=4;
			
//			String hqlQuery2="update Student set stud_name=:stud_name where stud_id=:stud_id";
//			MutationQuery query2=ss.createMutationQuery(hqlQuery2);
//			query2.setParameter("stud_name", "Isha");
//			query2.setParameter("stud_id",stud_id);
//			query2.executeUpdate();
//			System.out.println("Data is updated");
			
			
//			String hqlQuery3="delete from Student where stud_id=:stud_id";
//			//Query<Student> query3= ss.createQuery(hqlQuery3,Student.class);
//			MutationQuery query3=ss.createMutationQuery(hqlQuery3);
//			query3.setParameter("stud_id", stud_id);
//			query3.executeUpdate();
//			System.out.println("Data is deleted");

			tr.commit();
			ss.close();

	}

}
