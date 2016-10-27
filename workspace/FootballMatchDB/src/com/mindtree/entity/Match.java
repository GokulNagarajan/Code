package com.mindtree.entity;

import java.sql.Date;

public class Match {
	public int matchId;
	public java.util.Date matchDate;
	public int firstTeamScore;
	public int secondTeamScore;
	public Team firstTeam;
	public Team secondTeam;
	public Match()
	{
		matchId=0;
		matchDate=new Date(0);
		firstTeamScore=0;
		secondTeamScore=0;
		firstTeam=new Team();
		secondTeam=new Team();
	}
}
