package coe318.lab5;

//Author: Manav Patel - 500967756 


public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  int rank;
  int suit;
  boolean faceUp;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
    this.rank = rank;
    this.suit = suit;
    this.faceUp=faceUp;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return faceUp; //FIX THIS
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return rank; //FIX THIS
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return suit;//FIX THIS
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    if ( c.suit == suit && c.rank == rank)
    {
        return true;
    }
    else
    {
        return false;
    }
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }
  
  //comparing ranks and suits
  public int compareTo(Card c) 
  {
    if ( c.rank > rank)
    {
        return -1;
    }
    else if ( c.rank < rank)
    {
        return 1;
    }
    if ( c.suit < suit)
    {
        return 1;
    }
    else if ( c.suit > suit )
    {
        return -1;
    }
    else
    {
        return 0;
    }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  //switch statements below to get the rank of the cards
  public String getRankString() 
  {
      int rank;
      rank = getRank();
      
      switch(rank)
      {
          case 11:
              return ("Jack");
              
          case 22:
              return ("Queen");
              
          case 13:
              return ("King");
              
          case 14:
              return ("Ace");
              
          default:
              return (Integer.toString(rank));
          
      }
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  
  //switch statements below to get the suit of the card
  public String getSuitString() 
    {
        int suit;
        suit = getSuit();
        
        String suit1;
        suit1 = "";
        
        switch (suit)
        {
            case 0:
                suit1 = "Clubs";
                break;
                
            case 1:
                suit1 = "Diamonds";
                break;
                
            case 2:
                suit1 = "Hearts";
                break;
                
            case 3:
                suit1 = "Spades";
                break;
        }
        return (suit1);//FIX THIS
}

        public int value()
        {
            switch (rank) 
            {
                case 14:
                    return 1;
                    
                case 10:
                    return 10;
                    
                default:
                    return rank;
            }
        }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
    public String toString() 
    {
        if ( isFaceUp() == true)
        {
            //returns the rank from getRankString and suit from getSuitString
            return "" + getRankString() + " of " + getSuitString();
        }
        else
        {
            //? if the card is faced downwards
            return"?";
        }
    }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
