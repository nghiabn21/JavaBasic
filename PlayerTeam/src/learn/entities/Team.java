package learn.entities;

import java.util.List;

public class Team {

	private String teamId;
	private String teamName;
	private String ground;
	private List<Player> listOfPlayer;

	/**
	 * Constructor for Team class without Parameters.
	 */
	public Team() {
		super();
	}

	/**
	 * Constructor for Team class without Parameters.
	 * 
	 * @param teamId
	 * @param teamName
	 * @param ground
	 * @param listOfPlayer
	 */
	public Team(String teamId, String teamName, String ground, List<Player> listOfPlayer) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.ground = ground;
		this.listOfPlayer = listOfPlayer;
	}

	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the ground
	 */
	public String getGround() {
		return ground;
	}

	/**
	 * @param ground the ground to set
	 */
	public void setGround(String ground) {
		this.ground = ground;
	}

	/**
	 * @return the listOfPlayer
	 */
	public List<Player> getListOfPlayer() {
		return listOfPlayer;
	}

	/**
	 * @param listOfPlayer the listOfPlayer to set
	 */
	public void setListOfPlayer(List<Player> listOfPlayer) {
		this.listOfPlayer = listOfPlayer;
	}

	/*
	 * Method to display Team information.
	 */
	@Override
	public String toString() {
		return "teamId:" + teamId + ", teamName: " + teamName + ", ground: " + ground + "\n" + ", listOfPlayer: " 
				+ listOfPlayer;
	}
}