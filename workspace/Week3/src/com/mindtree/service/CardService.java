package com.mindtree.service;
import java.util.*;

import com.mindtree.entity.*;

public class CardService {
		public static int count=0;
		Card [] cards=new Card[52];
		Map<String,ArrayList<String>> m=new HashMap<String,ArrayList<String>>();
	public boolean addCardToDeck(Card card)
	{
		if(count==52)
		{
			System.out.println("Deck is full");
			return false;
		}
		for(int i=0;i<count;i++)
			if(cards[i].equals(card))
				return false;
		cards[count]=card;
		count++;
		if(m.containsKey(card.suit))
		{
			ArrayList<String> al=m.get(card.suit);
			for(String str:al)
			{
				if(str.equalsIgnoreCase(card.rank))
				{
					System.out.println("Card already present in deck");
					return false;
				}
			}
			m.get(card.suit).add(card.rank);
			return true;
		}
		else
			m.put(card.suit, new ArrayList<String>(Arrays.asList(card.rank)));
		return true;
	}
	public void getCards()
	{
		System.out.println("Printing by Array of Cards\n");
		for(int i=0;i<count;i++)
		{
			System.out.println(cards[i]);
		}
		System.out.println("\nPrinting by HashMap of Cards\n");
		 for(Map.Entry me:m.entrySet())
		{
			 String space="",key=(String)me.getKey();
			 for(int i=0;i<(10-key.length());i++)
					space+=" ";
			 System.out.printf("%s%s : %s", me.getKey(),space,m.get(me.getKey()));
			 System.out.println("");
		}
	}
}
