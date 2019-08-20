package com.torres.service;

import java.util.List;

import com.torres.model.Footballer;

public interface FootballerService {
	public List<Footballer> getAllFootballers();
	public void createFootballer(Footballer footballer);
	public Footballer getFootballer(int id);
	public void deleteFootballer(int id);
}
