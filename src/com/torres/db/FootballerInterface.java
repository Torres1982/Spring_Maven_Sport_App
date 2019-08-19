package com.torres.db;

import java.util.List;

import com.torres.model.Footballer;

public interface FootballerInterface {
	public List<Footballer> retrieveAllFootballersFromDb();
	public void createNewFootballer(Footballer footballer);
	public Footballer getFootballerById(int id);
}
