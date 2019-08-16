package com.torres.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.torres.model.Footballer;

public class FootballerDb {
	private static SessionFactory factory;
	private static Session session;
	
	// Build the Spring DB Session Factory
	private static SessionFactory buildFootballerSessionFactory() {
		return new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Footballer.class)
				.buildSessionFactory();
	}
	
	// Insert a New Footballer into DB
	public static void createNewFootballer(Footballer footballer) {
		factory = buildFootballerSessionFactory();
		session = factory.getCurrentSession();

		try {
			System.out.println("Creating a new Footballer ...");
			session.beginTransaction();
			session.save(footballer);
			session.getTransaction().commit();
			
			System.out.println("Transaction Committed Successfully!");
		} catch(Exception e) {
			System.out.println("Exception has occurred!");
		} finally {
			session.close();
			factory.close();
		}
	}
	
	// Retrieve all Footballers
	public static List<Footballer> retrieveAllFootballersFromDb() {
		factory = buildFootballerSessionFactory();
		session = factory.getCurrentSession();
		
		try {
			System.out.println("Retrieving Footballers ...");
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Footballer> footballersList = session.createQuery("from Footballer").getResultList();
			
			return footballersList;
		} finally {
			session.close();
			factory.close();
		}
	}
}
