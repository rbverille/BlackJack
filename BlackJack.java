package com.example.ryeverille.blackjack;

public class BlackJack {

    //put all rules


    public int value3;

//has no cards
    public boolean hasNoCards(){
        return true;
    }


//blackjack --> cards == 21


//players hand 2 cards
public boolean hand2(){
        return true;
}

//dealers hand 2 cards


//hit = i want another card


//stop = i dont want any other card
    public boolean stop(){
        return true;
    }

//after 3 hits the button is disabled bc game is over


//player won
    public boolean playerWon(){
        return true;
    }

//dealer won
    public boolean dealerWon(){
        return true;
    }

//tie
    public boolean tieGame(){
        return true;
    }


    public void setValue(int value){
        value3 =  value;
    }

    public int getValue3(){
        return value3;
    }

}
