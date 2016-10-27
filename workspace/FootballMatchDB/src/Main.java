import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.entity.*;

public class Main {
	private static Scanner scan;
	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/football_match_db","root","Welcome123");  
			System.out.println("Connecting the database");
			System.out.println();
			Statement stmt=con.createStatement();
			int choice=0,i=0,n,count=0;
			System.out.println("Selecting the table teams");
			ResultSet rs;
			String sql,date,name;
			Team [] teams=new Team[10];
			Match matches;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
			java.sql.Timestamp timestamp ;
			ArrayList<Match> al;
			scan=new Scanner(System.in);
			rs=stmt.executeQuery("SELECT * FROM TEAMS");   
			while(rs.next())  
			{
				teams[i]=new Team();
				teams[i].teamId=rs.getString(1);
				teams[i].teamCity=rs.getString(2);
				i++;
			}
			n=i;
			i=0;
			while(true)
			{
				try
				{
				System.out.println("***********************");
				System.out.println("1. Add match details");
				System.out.println("2. List all matches won by a given team");
				System.out.println("3. Exit");
				System.out.println("***********************");
				System.out.println("Enter choice");
				choice=scan.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("\n Enter valid Choice");
					scan.next();
					continue;
				}
				if(choice==1)
				{
					for(int x=0;x<n;x++)
					{
						String space = "";
						for(int s=0; s<(40-teams[x].teamId.length()); s++)
						{space = space + " ";}
						System.out.println(teams[x].teamId+space+teams[x].teamCity);
					}
					System.out.println();
					matches=new Match();
					matches.firstTeam=new Team();
					matches.secondTeam=new Team();
					scan.nextLine();
					do
					{
					System.out.println("Select First Team Name");
					matches.firstTeam.teamId=scan.nextLine();
					sql="SELECT COUNT(*) FROM TEAMS "+"WHERE TEAM_NAME LIKE '"+matches.firstTeam.teamId+"'";
					rs=stmt.executeQuery(sql);
					while(rs.next())
					{	count=rs.getInt(1); }
					if(count==1)
					{
					System.out.println("Select Second Team Name");
					matches.secondTeam.teamId=scan.nextLine();
					sql="SELECT COUNT(*) FROM TEAMS "+"WHERE TEAM_NAME LIKE '"+matches.secondTeam.teamId+"'";
					rs=stmt.executeQuery(sql);
					count=0;
					while(rs.next())
					{	count=rs.getInt(1); }
					}
					if(count==1)
					{
					if(matches.firstTeam.teamId.equals(matches.secondTeam.teamId))
						System.out.println("Enter different teams");
					else
					{
						break;
					}
					}
					else 
					{
						System.out.println("Team Name not in the Table");
						continue;
					}
					}while(true);
					while(true)
					{
					try
					{
					System.out.println("Enter match date in the format dd-MM-yyyy hh:mm AM/PM");
					date=scan.nextLine();
					timestamp = new java.sql.Timestamp(dateFormat.parse(date).getTime());
					matches.matchDate=timestamp;
					break;
					}
					catch(Exception e)
					{
						System.out.println("\n Enter valid date input");
						scan.next();
						continue;
					}
					}
					while(true)
					{
					try
					{
					System.out.println("Enter Goal scored by First Team Name");
					matches.firstTeamScore=scan.nextInt();
					System.out.println("Enter Goal scored by Second Team Name");
					matches.secondTeamScore=scan.nextInt();
					break;
					}
					catch(Exception e)
					{
						System.out.println("\n Enter valid goal input");
						scan.next();
						continue;
					}
					}
					sql="INSERT INTO MATCHES (MATCH_DATE, FIRST_TEAM_NAME, SECOND_TEAM_NAME, FIRST_TEAM_GOALS, SECOND_TEAM_GOALS) "+"VALUES ('"+matches.matchDate+"','"+(String)matches.firstTeam.teamId+"','"+(String)matches.secondTeam.teamId+"','"+matches.firstTeamScore+"','"+matches.secondTeamScore+"')";
					stmt.executeUpdate(sql);
					System.out.println("Match details Added");
				}
				else if(choice==2)
				{
					for(int x=0;x<n;x++)
					{
						String space = "";
						for(int s=0; s<(40-teams[x].teamId.length()); s++)
						{space = space + " ";}
						System.out.println(teams[x].teamId+space+teams[x].teamCity);
					}
					System.out.println();
					scan.nextLine();
					while(true)
					{
					System.out.println("Enter Team Name");
					name=scan.nextLine();
					sql="SELECT COUNT(*) FROM TEAMS "+"WHERE TEAM_NAME LIKE '"+name+"'";
					rs=stmt.executeQuery(sql);
					while(rs.next())
					{	count=rs.getInt(1); }
					if(count==0)
					{
						System.out.println("Team Name not in the Table");
						continue;
					}
					else
						break;
					}
					sql="SELECT * FROM MATCHES "+"WHERE FIRST_TEAM_NAME LIKE '"+name+"'"+" ORDER BY (FIRST_TEAM_GOALS-SECOND_TEAM_GOALS) DESC";
					rs=stmt.executeQuery(sql);
					System.out.println();
					System.out.println("Team Name : "+name);
					System.out.println("***********************");
					System.out.println("MATCH DATE\t\t\t-\t\tOPPONENT\t\t\t GOALS");
					Match match;
					al=new ArrayList<Match>();
					
					while(rs.next())
					{
						match=new Match();
						match.firstTeam=new Team();
						match.secondTeam=new Team();
						match.matchId=rs.getInt(1);
						match.matchDate=rs.getTimestamp(2);
						match.firstTeam.teamId=name;
						match.secondTeam.teamId=rs.getString(4);
						match.firstTeamScore=rs.getInt(5);
						match.secondTeamScore=rs.getInt(6);
						al.add(match);
					}
					sql="SELECT * FROM MATCHES "+"WHERE SECOND_TEAM_NAME LIKE '"+name+"'"+" ORDER BY (SECOND_TEAM_GOALS-FIRST_TEAM_GOALS) DESC";
					rs=stmt.executeQuery(sql);
					while(rs.next())
					{
						match=new Match();
						match.firstTeam=new Team();
						match.secondTeam=new Team();
						match.matchId=rs.getInt(1);
						match.matchDate=rs.getTimestamp(2);
						match.firstTeam.teamId=name;
						match.secondTeam.teamId=rs.getString(3);
						match.firstTeamScore=rs.getInt(6);
						match.secondTeamScore=rs.getInt(5);
						al.add(match);
					}
					sort(al);
					for(i=0;i<al.size();i++)
					{
						String space = "";
						for(int s=0; s<(30-al.get(i).secondTeam.teamId.length()); s++)
						{space = space + " ";}
						System.out.printf("%s\t\t-\t\t%s%s\t%2d - %2d", al.get(i).matchDate,al.get(i).secondTeam.teamId,space,al.get(i).firstTeamScore,al.get(i).secondTeamScore);
						System.out.println();
					}
					System.out.println("***********************");
				}
				else if(choice==3)
				{
					break;
				}
				else
					System.out.println("Enter Valid Choice");
			}
			System.out.println("Closing the database");
			con.close();  
			}
		catch(Exception e)
		{ System.out.println(e);}  
	}

	private static void sort(ArrayList<Match> al) {
		int i,j;
		Match swap;
		for(i=0;i<al.size()-1;i++)
		{
			for(j=i+1;j<al.size();j++)
			{
				if((al.get(i).firstTeamScore-al.get(i).secondTeamScore)<=(al.get(j).firstTeamScore-al.get(j).secondTeamScore))
				{
					if(al.get(i).firstTeamScore<=al.get(j).firstTeamScore)
					{
						swap=al.get(i);
						al.set(i, al.get(j));
						al.set(j, swap);
					}
				}
			}
		}
	}

}
