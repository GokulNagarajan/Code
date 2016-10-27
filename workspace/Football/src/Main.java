import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import serviceinterface.Service;

import com.mindtree.entity.*;

public class Main implements Service {
	private static Scanner scan;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/football_match_db", "root",
					"Welcome123");
			System.out.println("Connecting the database");
			System.out.println();
			Statement stmt = con.createStatement();
			int choice = 0, i = 0, n;
			System.out.println("Selecting the table teams");
			ResultSet rs;
			Team[] teams = new Team[10];
			scan = new Scanner(System.in);
			Main main = new Main();
			rs = stmt.executeQuery("SELECT * FROM TEAMS");
			while (rs.next()) {
				teams[i] = new Team();
				teams[i].teamId = rs.getString(1);
				teams[i].teamCity = rs.getString(2);
				i++;
			}
			n = i;
			i = 0;
			while (true) {
				try {
					System.out.println("***********************");
					System.out.println("1. Add match details");
					System.out
							.println("2. List all matches won by a given team");
					System.out.println("3. Exit");
					System.out.println("***********************");
					System.out.println("Enter choice");
					choice = scan.nextInt();
				} catch (Exception e) {
					System.out.println("\nEnter valid Choice");
					scan.next();
					continue;
				}
				if (choice == 1) {
					for (int x = 0; x < n; x++) {
						String space = "";
						for (int s = 0; s < (40 - teams[x].teamId.length()); s++) {
							space = space + " ";
						}
						System.out.println(teams[x].teamId + space
								+ teams[x].teamCity);
					}
					System.out.println();
					main.getDetails(stmt);
				} else if (choice == 2) {
					for (int x = 0; x < n; x++) {
						String space = "";
						for (int s = 0; s < (40 - teams[x].teamId.length()); s++) {
							space = space + " ";
						}
						System.out.println(teams[x].teamId + space
								+ teams[x].teamCity);
					}
					System.out.println();
					main.displayDetails(stmt);
				} else if (choice == 3) {
					break;
				} else
					System.out.println("Enter Valid Choice");
			}
			System.out.println("Closing the database");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void displayDetails(Statement stmt) throws SQLException {
		String sql, name;
		int count = 0;
		ResultSet rs;
		scan.nextLine();
		while (true) {
			System.out.println("Enter Team Name");
			name = scan.nextLine();
			sql = "SELECT COUNT(*) FROM TEAMS " + "WHERE TEAM_NAME LIKE '"
					+ name + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count == 0) {
				System.out.println("Team Name not in the Table");
				continue;
			} else
				break;
		}
		System.out.println();
		System.out.println("Team Name : " + name);
		System.out.println("***********************");
		System.out.println("MATCH DATE\t\t\t-\t\tOPPONENT\t\t\t GOALS");
		Match match;
		ArrayList<Match> al = new ArrayList<Match>();
		sql = "SELECT match_id,match_date,second_team_name,first_team_name,second_team_goals,first_team_goals FROM MATCHES "
				+ "WHERE SECOND_TEAM_NAME LIKE '"
				+ name
				+ "' "
				+ "UNION "
				+ "SELECT match_id,match_date,first_team_name,second_team_name,first_team_goals,second_team_goals FROM MATCHES  "
				+ "WHERE FIRST_TEAM_NAME LIKE '"
				+ name
				+ "'"
				+ " ORDER BY (FIRST_TEAM_GOALS-SECOND_TEAM_GOALS),match_date DESC";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			match = new Match();
			match.firstTeam = new Team();
			match.secondTeam = new Team();
			match.matchId = rs.getInt(1);
			match.matchDate = rs.getTimestamp(2);
			match.firstTeam.teamId = name;
			match.secondTeam.teamId = rs.getString(4);
			match.firstTeamScore = rs.getInt(5);
			match.secondTeamScore = rs.getInt(6);
			al.add(match);
		}

		for (int i = 0; i < al.size(); i++) {
			String space = "";
			for (int s = 0; s < (30 - al.get(i).secondTeam.teamId.length()); s++) {
				space = space + " ";
			}
			System.out.printf("%s\t\t-\t\t%s%s\t%2d - %2d",
					al.get(i).matchDate, al.get(i).secondTeam.teamId, space,
					al.get(i).firstTeamScore, al.get(i).secondTeamScore);
			System.out.println();
		}
		System.out.println("***********************");
	}

	public void getDetails(Statement stmt) throws SQLException {
		Match matches = new Match();
		matches.firstTeam = new Team();
		matches.secondTeam = new Team();
		String sql = new String();
		String date = new String();
		int count = 0;
		ResultSet rs;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
		java.util.Date sqlDate;
		java.sql.Timestamp timestamp;
		scan.nextLine();
		do {
			System.out.println("Select First Team Name");
			matches.firstTeam.teamId = scan.nextLine();
			sql = "SELECT COUNT(*) FROM TEAMS " + "WHERE TEAM_NAME LIKE '"
					+ matches.firstTeam.teamId + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count == 1) {
				System.out.println("Select Second Team Name");
				matches.secondTeam.teamId = scan.nextLine();
				sql = "SELECT COUNT(*) FROM TEAMS " + "WHERE TEAM_NAME LIKE '"
						+ matches.secondTeam.teamId + "'";
				rs = stmt.executeQuery(sql);
				count = 0;
				while (rs.next()) {
					count = rs.getInt(1);
				}
			}
			if (count == 1) {
				if (matches.firstTeam.teamId.equals(matches.secondTeam.teamId))
					System.out.println("Enter different teams");
				else {
					break;
				}
			} else {
				System.out.println("Team Name not in the Table");
				continue;
			}
		} while (true);
		while (true) {
			try {
				System.out
						.println("Enter match date in the format dd-MM-yyyy hh:mm AM/PM");
				date = scan.nextLine();
				dateFormat.setLenient(false);
				sqlDate = dateFormat.parse(date);
				if (sqlDate.getYear() < 70 || sqlDate.getYear() > 138) {
					System.out.println("\nEnter year between 1970 to 2038");
					continue;
				}
				timestamp = new java.sql.Timestamp(sqlDate.getTime());
				matches.matchDate = timestamp;
				break;
			} catch (Exception e) {
				System.out.println("\nEnter valid date input");
				continue;
			}
		}
		while (true) {
			try {
				System.out.println("Enter Goal scored by First Team Name");
				matches.firstTeamScore = scan.nextInt();
				System.out.println("Enter Goal scored by Second Team Name");
				matches.secondTeamScore = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("\nEnter valid goal input");
				scan.next();
				continue;
			}
		}
		sql = "INSERT INTO MATCHES (MATCH_DATE, FIRST_TEAM_NAME, SECOND_TEAM_NAME, FIRST_TEAM_GOALS, SECOND_TEAM_GOALS) "
				+ "VALUES ('"
				+ matches.matchDate
				+ "','"
				+ (String) matches.firstTeam.teamId
				+ "','"
				+ (String) matches.secondTeam.teamId
				+ "','"
				+ matches.firstTeamScore
				+ "','"
				+ matches.secondTeamScore
				+ "')";
		stmt.executeUpdate(sql);
		System.out.println("Match details Added");

	}

}