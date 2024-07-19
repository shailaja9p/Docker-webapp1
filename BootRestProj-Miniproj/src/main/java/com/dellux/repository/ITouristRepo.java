package com.dellux.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dellux.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

	@Query("from Tourist where name=:name")
	public List<Tourist> getTouristByName(String name);
}
