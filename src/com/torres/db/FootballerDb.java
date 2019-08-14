package com.torres.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.torres.model.Footballer;

public class FootballerDb {
	// Build the Spring DB Session Factory
	private static SessionFactory buildFootballerSessionFactory() {
		return new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Footballer.class)
				.buildSessionFactory();
	}
	
	// Insert a New Footballer into DB
	public static void createNewFootballer(Footballer footballer) {
		SessionFactory factory = buildFootballerSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating a new Footballer ...");
			session.beginTransaction();
			session.save(footballer);
			session.getTransaction().commit();
			
			System.out.println("Transaction Committed Successfully!");
		} finally {
			factory.close();
		}
	}
	
	// Retrieve all Footballers
	public static void retrieveAllFootballers() {
		SessionFactory factory = buildFootballerSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Retrieving Footballers ...");
			session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Footballer> footballersList = session.createQuery("from Footballer").getResultList();
			
			for (Footballer footballer: footballersList) {
				//TODO Replace this with Display in the jsp page
				System.out.println(footballer);
			}
		} finally {
			factory.close();
		}
	}
}
