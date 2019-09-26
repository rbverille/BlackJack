package com.example.ryeverille.blackjack;

public class BlackJack {

    //put all rules


    public int sumOfTwoCards;
    public int sumOfThreeCards;
    public int sumOfFourCards;

    public int value4;

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


    public void setSumOfTwoCards(int value){
        sumOfTwoCards =  value;
    }

    public int getSumOfTwoCards(){
        return sumOfTwoCards;
    }

    public boolean playerHasCards(){
        return true;
    }

    public void setSumOfThreeCards(int value){
        sumOfThreeCards = value;
    }


    public int getSumOfThreeCards(){
        return sumOfThreeCards;
    }



    public void setSumOfFourCards(int value){
        sumOfFourCards = value;
    }


    public int getSumOfFourCards(){
        return sumOfFourCards;
    }


    public void setCardfFourValue(int value){
        value4 = value;
    }



    public int getCard4Value(){
        return value4;
    }

    public boolean gameOver(){



        return true;
    }

}
