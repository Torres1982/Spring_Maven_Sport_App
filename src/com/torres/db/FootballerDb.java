package com.torres.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.torres.model.Footballer;

@Repository
public class FootballerDb implements FootballerInterface {
	@Autowired
	private SessionFactory sessionFactory;
	
	// Build the Spring DB Session Factory
//	private SessionFactory buildFootballerSessionFactory() {
//		return new Configuration()
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Footballer.class)
//				.buildSessionFactory();
//	}
	
	// Insert a New Footballer into DB
	@Override
	public void createNewFootballer(Footballer footballer) {
//		sessionFactory = buildFootballerSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		// If it's a new Footballer it will Save, otherwise it will get a Hidden Form Id and Update existing Footballer
		System.out.println("!!! TESTING UPDATE BEFORE SAVE !!! ID: " + footballer.getId());
		session.saveOrUpdate(footballer);
		System.out.println("!!! TESTING UPDATE AFTER SAVE !!! ID: " + footballer.getId());
//		try {
//			System.out.println("Creating a new Footballer ...");
//			session.beginTransaction();
//			session.save(footballer);
//			session.getTransaction().commit();
//			
//			System.out.println("Transaction Committed Successfully!");
//		} catch(Exception e) {
//			System.out.println("Exception has occurred!");
//		} finally {
//			session.close();
//			sessionFactory.close();
//		}
	}
	
	// Retrieve all Footballers
	@Override
	public List<Footballer> retrieveAllFootballersFromDb() {
		Session session = sessionFactory.getCurrentSession();
		Query<Footballer> query = session.createQuery("from Footballer", Footballer.class);
		List<Footballer> footballersList = query.getResultList();
		
		return footballersList;
//		sessionFactory = buildFootballerSessionFactory();
//		session = sessionFactory.getCurrentSession();
//		
//		try {
//			System.out.println("Retrieving Footballers ...");
//			session.beginTransaction();
//			@SuppressWarnings("unchecked")
//			List<Footballer> footballersList = session.createQuery("from Footballer").getResultList();
//			
//			return footballersList;
//		} finally {
//			session.close();
//			sessionFactory.close();
//		}
	}

	// Retrieve the Footballer by given Footballer ID
	@Override
	public Footballer getFootballerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Footballer footballer = session.get(Footballer.class, id);
		
		return footballer;
	}
}
