package com.torres.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.db.FootballerDb;
import com.torres.model.Footballer;

@Service
public class FootballerServiceImpl implements FootballerService {
	@Autowired
	private FootballerDb footballerDb;
	
	@Override
	@Transactional
	public List<Footballer> getAllFootballers() {
		return footballerDb.retrieveAllFootballersFromDb();
	}

	@Override
	@Transactional
	public void createFootballer(Footballer footballer) {
		footballerDb.createNewFootballer(footballer);
	}

	@Override
	@Transactional
	public Footballer getFootballer(int id) {
		return footballerDb.getFootballerById(id);
	}
}
