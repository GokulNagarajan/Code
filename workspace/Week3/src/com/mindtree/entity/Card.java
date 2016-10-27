package com.mindtree.entity;

public class Card {
	public String suit;
	public String rank;
	public Card()
	{
		suit="";
		rank="";
	}
	public Card(String suit,String rank)
	{
		this.suit=suit;
		this.rank=rank;
	}
	public String getSuit()
	{
		return this.suit;
	}
	public String getRank()
	{
		return this.rank;	
	}
	public void setSuit(String suit)
	{
		this.suit=suit;
	}
	public void setRank(String rank)
	{
		this.rank=rank;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}	
	@Override
	public String toString() {
		String space="";
		for(int i=0;i<(10-suit.length());i++)
			space+=" ";
		return String.format("%s%s%s", suit,space,rank);
	}
}
