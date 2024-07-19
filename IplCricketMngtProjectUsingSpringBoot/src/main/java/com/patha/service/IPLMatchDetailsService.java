package com.patha.service;

import java.util.List;

import com.patha.entity.IPLMatchDetailsEntity;

public interface IPLMatchDetailsService {
	
	public List<IPLMatchDetailsEntity> getAllPlayers();

	public String addPlayer(IPLMatchDetailsEntity player);

	public IPLMatchDetailsEntity findPlayerByNo(int no);

	public String updatePlayer(IPLMatchDetailsEntity player);

	public String deletePlayer(int no);
	
}
