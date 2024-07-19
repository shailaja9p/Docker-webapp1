package com.dellux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dellux.entity.Tourist;
import com.dellux.error.TouristNotFoundException;
import com.dellux.repository.ITouristRepo;

@Service
public class ITouristServiceImpl implements ITouristService {
	
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		
		int idVal = touristRepo.save(tourist).getTid();
		return "Tourist is saved with id value "+idVal;
	}


	@Override
	public List<Tourist> getAllTourists() {
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}


	@Override
	public Tourist getTouristById(int id) throws TouristNotFoundException {
		// TODO Auto-generated method stub
		
		Tourist tourist = touristRepo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist with"+id+" is not found"));
		return tourist;
	}


	@Override
	public List<Tourist> getTouristByName(String name) throws TouristNotFoundException {
		return touristRepo.getTouristByName(name);
	}


	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(tourist.getTid());
		if(opt.isPresent()) {
			touristRepo.save(tourist);
			return "";
		}else {
			throw new TouristNotFoundException();
		}
	}


	
}
