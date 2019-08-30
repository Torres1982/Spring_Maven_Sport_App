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
	
	// Insert a New Footballer into DB
	@Override
	public void createNewFootballer(Footballer footballer) {
		Session session = sessionFactory.getCurrentSession();
		// If it's a new Footballer it will Save, otherwise it will get a Hidden Form Id and Update existing Footballer
		session.saveOrUpdate(footballer);		
		//System.out.println("!!! TESTING UPDATE !!! ID: " + footballer.getId());
	}
	
	// Retrieve all Footballers
	@Override
	public List<Footballer> retrieveAllFootballersFromDb() {
		Session session = sessionFactory.getCurrentSession();
		Query<Footballer> query = session.createQuery("from Footballer", Footballer.class);
		List<Footballer> footballersList = query.getResultList();
		
		return footballersList;
	}

	// Retrieve the Footballer by given Footballer ID
	@Override
	public Footballer getFootballerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Footballer footballer = session.get(Footballer.class, id);
		
		return footballer;
	}

	@Override
	public void deleteExistingFootballer(int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Footballer where id=:footballerId");
		query.setParameter("footballerId", id);
		query.executeUpdate();
		
		System.out.println("Footballer Successfully Deleted! ID: " + id);
	}
}
