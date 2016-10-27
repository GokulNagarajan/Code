package com.mindtree.entity;
import java.sql.Timestamp;


public class Match {
	public int matchId;
	public Timestamp matchDate;
	public int firstTeamScore;
	public int secondTeamScore;
	public Team firstTeam;
	public Team secondTeam;
	public Match()
	{
		matchId=0;
		matchDate=new Timestamp(0);
		firstTeamScore=0;
		secondTeamScore=0;
		firstTeam=new Team();
		secondTeam=new Team();
	}
}
