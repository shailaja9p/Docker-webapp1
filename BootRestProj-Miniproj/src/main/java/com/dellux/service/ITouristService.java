package com.dellux.service;

import java.util.List;

import com.dellux.entity.Tourist;
import com.dellux.error.TouristNotFoundException;

public interface ITouristService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> getAllTourists();
	public Tourist getTouristById(int id) throws TouristNotFoundException;
	public List<Tourist> getTouristByName(String name) throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
}
