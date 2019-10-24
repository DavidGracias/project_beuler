package project_beuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem054 {
	
//	In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
//
//	If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.
//
//	The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.
//
//	How many hands does Player 1 win?
	
	class Card{
		final char[] values = new char[] {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
		final char[] suits = new char[] {'H', 'C', 'D', 'S'};
		public char value;
		public char suit;
		
		Card(String card){
			this.value = card.charAt(0);
			this.suit = card.charAt(1);
		}
		
		private int value() {
			for(int i = 0; i < values.length; i++)
				if(values[i] == this.value) return i;
			return -1;
		}
		private int suit() {
			for(int i = 0; i < suits.length; i++)
				if(suits[i] == this.suit) return i;
			return -1;
		}
	}
	
	class Player{
		
		private Card[] hand = new Card[5];
		
		Player(String deal) {
			String[] dealArr = deal.split(" ");
			for(int i = 0; i < dealArr.length; i++)
				hand[i] = new Card(dealArr[i]);
		}
		
		private boolean hasBetterHand(Player p2) {
			double[] h1 = this.score(hand);
			double[] h2 = p2.score(p2.hand);
			System.out.println();
			for(int i = 0; i < h1.length; i++)
				if(h1[i] > h2[i]) return true;
				else if(h1[i] < h2[i]) return false;
			return false;
		}
		
		private double[] score(Card[] hand) {
			System.out.println(this);
			int[] v_counter = new int[13];
			int[] s_counter = new int[4];
			for(Card card : hand) {
				v_counter[card.value()]++;
				s_counter[card.suit()]++;
			}
//			0 Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
//			1 Straight Flush: All cards are consecutive values of same suit.
//			2 Four of a Kind: Four cards of the same value.
//			3 Full House: Three of a kind and a pair.
//			4 Flush: All cards of the same suit.
//			5 Straight: All cards are consecutive values.
//			6 Three of a Kind: Three cards of the same value.
//			7 Two Pairs: Two different pairs.
//			8 One Pair: Two cards of the same value.
//			9 High Card: Highest value card.
			
			
			double[] cond = new double[10];
			for(int z = 0; z < cond.length; z++)
				cond[z] = -1;
			for(int suit : s_counter)
				if(suit == 5)
					cond[4] = 1;
			int max = 0;
			for(int value = 0; value < v_counter.length; value++) {
				if(v_counter[value] > 0) {
					max = value;
					if(value < v_counter.length-4) {
						int z = 1;
						for(z = 1; z < 5; z++)
							if(v_counter[value+z] == 0) break;
						if(z == 5) {
							if(cond[4] == -1)
								cond[5] = value;
							else {
								cond[4] = -1;
								if(value == 8)
									cond[0] = 1;
								else cond[1] = value;
							}
						}
					}
					
				}
				
				if(v_counter[value] == 4)
					cond[2] = value;
				else if(cond[8] == -1 && v_counter[value] == 2)
					cond[8] = value;
				
				else if(cond[8] > -1 && v_counter[value] == 2) {
					String zero = "";
					if(Math.min(value, cond[8]) < 10) zero = "0";
					cond[7] = Double.parseDouble( (int)Math.max(value, cond[8])+"."+zero+ (int)Math.min(value, cond[8]));
					cond[8] = -1;
				}
				else if(cond[6] == -1 && v_counter[value] == 3)
					cond[6] = value;
				
				else if( (cond[8] > -1 && v_counter[value] == 3) || (cond[6] > -1 && v_counter[value] == 2) ) {
					double three = cond[6]; cond[6] = -1;
					if(v_counter[value] == 3) three = value;
					
					double two = cond[8]; cond[8] = -1;
					if(v_counter[value] == 2) two = value;
					String zero = "";
					if(two < 10) zero = "0";
					cond[7] = Double.parseDouble( three+"."+zero+ two );
				}
			}
			cond[9] = max;

			for(double h : cond)
				System.out.print(h+" ");
			System.out.println();
			return cond;
		}
	
		public String toString() {
			String output = "[ ";
			for(Card c : this.hand)
				output+= c.value+""+c.suit+", ";
			return output.substring(0, output.length()-2)+" ]";
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//-------------------------------POKER-------------------------------
		File file = new File(System.getProperty("user.dir")+"/src/project_beuler/problem054.txt");
		Scanner reader = new Scanner(file);
		int winner = 0;
		while(reader.hasNextLine()) {
			String deal = reader.nextLine();
//			String deal = "5D 8C 9S JS AC 2C 5C 7D 8S QH";
			Player p1 = (new problem054()).new Player( deal.substring(0, deal.length()/2) );
			Player p2 = (new problem054()).new Player( deal.substring(   deal.length()/2+1) );
			if(p1.hasBetterHand(p2))
				winner++;
//			break;
		} reader.close();
		System.out.println(winner);
	}

}
