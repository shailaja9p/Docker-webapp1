package com.patha.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patha.entity.IPLMatchDetailsEntity;
import com.patha.service.IPLMatchDetailsService;

@RestController
@RequestMapping("/iplMatch-api")
public class IPLMatchController {

	@Autowired
	private IPLMatchDetailsService playerService;
	
	@GetMapping("/getAllPlayers")
	public  ResponseEntity<?>  showAllPlayers(){
		try {
			//use service
			List<IPLMatchDetailsEntity> list=playerService.getAllPlayers();
			return new ResponseEntity<List<IPLMatchDetailsEntity>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/register")
	public  ResponseEntity<String> registerPlayer(@RequestBody IPLMatchDetailsEntity player){
		try {
		//use service
			System.out.println(player.getSpecialization()+" "+player.getNoOfMatchesPlayed());
		String resultMsg=playerService.addPlayer(player);
		return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{no}")
	public  ResponseEntity<?>  findPlayerByNo(@PathVariable("no") int no){
		try {
			//use service
			IPLMatchDetailsEntity player=playerService.findPlayerByNo(no);
			return new ResponseEntity<IPLMatchDetailsEntity>(player,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/modify")
	public  ResponseEntity<?> modifyPlayerDetails(@RequestBody IPLMatchDetailsEntity player){
		
		try {
			//use service
			String resultMsg=playerService.updatePlayer(player);
			return  new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}//method
	@DeleteMapping("/delete/{playerid}")
	public  ResponseEntity<?>  deleteTouristById(@PathVariable("playerid") int playerid){
		try {
			//use service
			String resultMsg=playerService.deletePlayer(playerid);
			return  new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
