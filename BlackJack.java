package com.example.ryeverille.blackjack;

public class BlackJack {

    //put all rules


    public int sumOfTwoCards;
    public int sumOfThreeCards;
    public int sumOfFourCards;
    public int sumOfOneAndTwoD;
    public int sumOfThreeDealerCards;
    public int sumOfFourDealerCards;


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


    public void setSum2PlayerCards(int value){
        sumOfTwoCards =  value;
    }

    public int getSumTwoPlayerCards(){
        return sumOfTwoCards;
    }


    public void setThreeCardsSumPlayer(int value){
        sumOfThreeCards = value;
    }


    public int getSumOfThreeCards(){
        return sumOfThreeCards;
    }



    public boolean playerWins(){
        if(sumOfOneAndTwoD < sumOfTwoCards || sumOfThreeDealerCards < sumOfThreeCards || sumOfFourDealerCards < sumOfFourCards){
            return true;
        }
        return false;
    }


    public boolean dealerWins(){
        if(sumOfOneAndTwoD > sumOfTwoCards || sumOfThreeDealerCards > sumOfThreeCards || sumOfFourDealerCards > sumOfFourCards) {
            return true;
        }
        return false;
    }

    //or if they are both over 21
    public boolean tiegame(){
        if(sumOfOneAndTwoD == sumOfTwoCards || sumOfThreeDealerCards == sumOfThreeCards || sumOfFourDealerCards == sumOfFourCards) {
            return true;
        }
        return false;
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


    public void setSumOfDealOneAndTwo(int value){
        sumOfOneAndTwoD = value;
    }

    public int getSumOfOneAndTwoD(){
        return sumOfOneAndTwoD;
    }

    public void setSumOfThreeDealerCards(int value){
        sumOfThreeDealerCards = value;
    }

    public int getSumOfThreeDealerCards(){
        return sumOfThreeDealerCards;
    }



    public void setSumOfFourDealerCards(int value){
        sumOfFourDealerCards = value;
    }

    public int getSumOfFourDealerCards(){
        return sumOfFourDealerCards;
    }


    public boolean not21(int value){
       if (value < 21){
           return true;
       }
       return false;
    }


    public boolean blackjack(){
        return true;
    }



}
