package learn.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import learn.entities.Player;
import learn.entities.Team;
import learn.exception.IncorrectFormatException;

public class TeamService {
	private String teamId;
	private String teamName;
	private String ground;
	private List<Player> listOfPlayer; 
	
	private PlayerService playerService = new PlayerService();

	/**
	 * This method create take input team's information from keyboard.
	 *
	 * @param scanner: Scanner
	 * @return Team
	 * @throws ParseException, IncorrectFormatException
	 */
	public Team createNewTeam(Scanner scanner) throws ParseException, IncorrectFormatException {

		System.out.println("Input team information!");
		String choice = "y";
		listOfPlayer = new ArrayList<>(); 
		
		System.out.print("Enter team ID:");
		teamId = scanner.nextLine(); 
		
		System.out.print("Enter full name of team:");
		teamName = scanner.nextLine(); 
		
		System.out.print("Enter ground:");
		ground = scanner.nextLine(); 
		
		System.out.print("Do you want to add new player for this team? (y/n)");
		choice = scanner.nextLine(); 
		
		Team team = new Team(teamId, teamName, ground, listOfPlayer);
		if (choice.equalsIgnoreCase("y")) {
			try {
				addNewPlayerToTeam(scanner, team);
			} catch (ParseException | IncorrectFormatException e) {
				System.out.println("Add player fail, because" + e.getMessage());
				e.printStackTrace();
				throw e;
			}
		}
		return team;
	}

	/**
	 * This method add player(s) to exist team.
	 *
	 * @param scanner
	 * @param team
	 * @return Boolean
	 * @throws ParseException, IncorrectFormatException
	 */
	public Boolean addNewPlayerToTeam(Scanner scanner, Team team) throws ParseException, IncorrectFormatException {
		Player player = null;
		System.out.print("\nInput new player information!");
		player = playerService.inputPlayer(scanner);
		return team.getListOfPlayer().add(player);
	}

	/**
	 * This method display all team's information.
	 *
	 * @param teams:List<Team>.
	 */
	public void displayTeam(List<Team> teams) {
		System.out.println("Team information!");
		for (Team team : teams) {
			System.out.println(team.toString());
		}
	}
}
