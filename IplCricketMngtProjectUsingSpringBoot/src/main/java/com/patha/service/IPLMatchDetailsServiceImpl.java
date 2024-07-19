package com.patha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patha.entity.IPLMatchDetailsEntity;
import com.patha.repository.IPLMatchReposirtoy;

@Service("playerService")
public class IPLMatchDetailsServiceImpl implements IPLMatchDetailsService {

	@Autowired
	private IPLMatchReposirtoy playerRepo;
	
	@Override
	public List<IPLMatchDetailsEntity> getAllPlayers() {
		List<IPLMatchDetailsEntity> list=playerRepo.findAll();
		return list;
	}

	@Override
	public String addPlayer(IPLMatchDetailsEntity player) {
		Integer idVal=playerRepo.save(player).getPlayerId();
		return "Player is registered with the IdValue::"+idVal;
	}

	@Override
	public IPLMatchDetailsEntity findPlayerByNo(int no) {
		return  playerRepo.findById(no).orElseThrow(()->new IllegalArgumentException("invalid id"));
	}

	@Override
	public String updatePlayer(IPLMatchDetailsEntity player) {
		Optional<IPLMatchDetailsEntity> opt=playerRepo.findById(player.getPlayerId());
		if(opt.isPresent()) {
			int idVal=playerRepo.save(player).getPlayerId();
			return  idVal+" Player details are updated";
		}
		return player.getPlayerId()+"  Player is not found";
	}

	@Override
	public String deletePlayer(int no) {
		Optional<IPLMatchDetailsEntity> opt=playerRepo.findById(no);
		if(opt.isPresent()) {
			playerRepo.deleteById(no);
			return no+" Player is deleted";
		}
		return  no+" Player is not found for deletion";
	}

}
