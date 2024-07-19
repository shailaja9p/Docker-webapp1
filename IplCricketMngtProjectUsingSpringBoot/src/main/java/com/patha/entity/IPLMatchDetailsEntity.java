package com.patha.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name="REST_IPLMatch_TABLE")
		public class IPLMatchDetailsEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer playerId;
		
		@Column(length = 20)
		private  String  playerName;
			
		@Column(length = 20)
		private  String  matchLocation;
		
		private  Integer  playerAge;
		
		@Column(length = 30)
		private  String specialization;
		
		private  Integer noOfMatchesPlayed;

		public Integer getPlayerId() {
			return playerId;
		}

		public String getPlayerName() {
			return playerName;
		}

		public String getMatchLocation() {
			return matchLocation;
		}

		public Integer getPlayerAge() {
			return playerAge;
		}

		

		public void setPlayerId(Integer playerId) {
			this.playerId = playerId;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public void setMatchLocation(String matchLocation) {
			this.matchLocation = matchLocation;
		}

		public void setPlayerAge(Integer playerAge) {
			this.playerAge = playerAge;
		}


		public IPLMatchDetailsEntity(Integer playerId, String playerName, String matchLocation, Integer playerAge,
				String specialization, Integer noOfMatchesPlayed) {
			super();
			this.playerId = playerId;
			this.playerName = playerName;
			this.matchLocation = matchLocation;
			this.playerAge = playerAge;
			this.specialization = specialization;
			this.noOfMatchesPlayed = noOfMatchesPlayed;
		}

		public String getSpecialization() {
			return specialization;
		}

		public Integer getNoOfMatchesPlayed() {
			return noOfMatchesPlayed;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

		public void setNoOfMatchesPlayed(Integer noOfMatchesPlayed) {
			this.noOfMatchesPlayed = noOfMatchesPlayed;
		}

		public IPLMatchDetailsEntity() {
			super();
		}
		
		
	}


