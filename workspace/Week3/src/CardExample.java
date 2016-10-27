import java.util.Scanner;

import com.mindtree.entity.Card;
import com.mindtree.service.CardService;


public class CardExample {
	private static Scanner scan;
	public static void main(String[] args) {
		String [] suits={"Clubs", "Diamonds", "Hearts", "Spades"};
		String [] ranks={"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
				"Queen", "King"};
		int suitIndex=0,rankIndex=0;
		String choice="";
		Card c;
		CardService cs=new CardService();
		scan=new Scanner(System.in);
		while(true)
		{
			try
			{
			System.out.println("Enter the Cards Suit index");
			suitIndex=scan.nextInt();
			if(suitIndex<0||suitIndex>3)
			{
				System.out.println("Enter Suits index between 0 to 3");
				continue;
			}
			}
			catch(Exception e)
			{
				System.out.println("Enter Suits index between 0 to 3");
				continue;
			}
			while(true)
			{
			try
			{
			System.out.println("Enter the Cards Rank index");
			rankIndex=scan.nextInt();
			if(rankIndex<0||rankIndex>12)
			{
				System.out.println("Enter Ranks index between 0 to 12");
				continue;
			}
			break;
			}
			catch(Exception e)
			{
				System.out.println("Enter Ranks index between 0 to 12");
				continue;
			}
			}
			c=new Card(suits[suitIndex],ranks[rankIndex]);
			/*
			 c=new Card();
			 c.setSuit(suits[suitIndex]);
			 c.setRank(ranks[rankIndex]);
			 */
			if(!cs.addCardToDeck(c))
				System.out.println("Card already present in Deck");
			scan.nextLine();
			System.out.println("Enter Y/y to continue adding Cards to Deck");
			choice=scan.nextLine();
			if(!choice.equalsIgnoreCase("y"))
				break;
		}
		cs.getCards();
	}

}
