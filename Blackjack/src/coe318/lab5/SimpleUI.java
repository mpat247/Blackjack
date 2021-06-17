package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() 
    {
        //house
        System.out.println("House holds:" + game.getHouseCards().toString());
        //your
        System.out.println("You hold:" + game.getYourCards().toString());
    }

  @Override
    public boolean hitMe() 
    {
        //do you want to hit? answers in yes or no
        System.out.println("Another card? (Answer in (yes or no)");
        //user input
        String choice; 
        choice = user.nextLine();
        boolean hit; 
        hit = false;
        
        //switch statement
        //If no, hit is false, if yes then hit is true, if neither, ask to type yes or no
        switch (choice)
        {
            case "no":
                hit = false;
                break;
            case "yes":
                hit = true;
                break;
            default:
                System.out.println("Type yes or no");
                hitMe();
        }
        return hit;
    }

  @Override
    public void gameOver() 
    {
        this.display();
        int score, houseScore;
        //your score
        score = game.score( game.getYourCards());
        //house score
        houseScore = game.score( game.getHouseCards());
        
        //printing house score and your score
        System.out.println( "House Score: " + houseScore );
        System.out.println( "Your Score: " + score );
        
        //determining who wins
        if ((score <=21) && ( houseScore > 21 || houseScore < score))
        {
            System.out.println("You win");
        }
        else
        {
            System.out.println("House wins");            
        }
            
        System.out.println("Thank you for playing");
    }

}