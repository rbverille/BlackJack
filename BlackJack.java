package com.example.ryeverille.blackjack;

public class BlackJack {

    private int sumOfTwoCards;
    private int sumOfThreeCards;
    private int sumOfFourCards;
    private int sumOfFiveCards;
    private int sumOfTwoDealerCards;
    private int sumOfThreeDealerCards;
    private int sumOfFourDealerCards;
    private int sumOfFiveDealerCards;


    /**
     * setting the sum of the players two cards
     * @param value - the sum of the players two cards
     */
    public void setSum2PlayerCards(int value){
        sumOfTwoCards =  value;
    }

    /**
     * getting the sum of the players two cards
     * @return the sum of the two cards
     */
    public int getSumTwoPlayerCards(){
        return sumOfTwoCards;
    }

    /**
     * setting the sum of the players three cards
     * @param value - the sum of the players three cards
     */
    public void setThreeCardsSumPlayer(int value){
        sumOfThreeCards = value;
    }

    /**
     * getting the sum of the players three cards
     * @return the sum of the three cards
     */
    public int getSumOfThreeCards(){
        return sumOfThreeCards;
    }

    /**
     *  setting the sum of the dealers four cards
     * @param value - the sum of the dealers four cards
     */
    public void setSumOfFourCards(int value){
        sumOfFourCards = value;
    }


    /**
     * getting the sum of the dealers four cards
     * @return the sum of the four cards
     */
    public int getSumOfFourCards(){
        return sumOfFourCards;
    }


    /**
     *  setting the sum of the dealers four cards
     * @param value - the sum of the dealers four cards
     */
    public void setSumOfFiveCards(int value){
        sumOfFiveCards = value;
    }


    /**
     * getting the sum of the dealers four cards
     * @return the sum of the four cards
     */
    public int getSumOfFiveCards(){
        return sumOfFiveCards;
    }


    /**
     * setting the sum of two dealer  cards
     * @param value - the sum of the dealers two cards
     */
    public void setSumOfTwoDealerCards(int value){
        sumOfTwoDealerCards = value;
    }

    /**
     * getting the sum of the dealeres two cards
     * @return the sum of the two cards
     */
    public int getSumOfTwoDealerCards(){
        return sumOfTwoDealerCards;
    }

    /**
     * setting the sum of the dealer three cards
     * @param value - the sum of the dealers three cards
     */
    public void setSumOfThreeDealerCards(int value){
        sumOfThreeDealerCards = value;
    }

    /**
     * getting the sum of the dealers three cards
     * @return the sum of the three cards
     */
    public int getSumOfThreeDealerCards(){
        return sumOfThreeDealerCards;
    }

    /**
     * setting the sum of the players four cards
     * @param value - the sum of the players four cards
     */
    public void setSumOfFourDealerCards(int value){
        sumOfFourDealerCards = value;
    }

    /**
     * getting the sum of the dealers four cards
     * @return the sum of the four cards
     */
    public int getSumOfFourDealerCards(){
        return sumOfFourDealerCards;
    }


    /**
     * setting the sum of the players five cards
     * @param value - the sum of the players five cards
     */
    public void setSumOfFiveDealerCards(int value){
        sumOfFiveDealerCards = value;
    }

    /**
     * getting the sum of the dealers five cards
     * @return the sum of the five cards
     */
    public int getSumOfFiveDealerCards(){
        return sumOfFiveDealerCards;
    }


    /**
     * decide if the player has won
     * @return - true if the sum results in the player winning, else return false
     */
    public boolean playerWins(){
        if(sumOfTwoDealerCards < sumOfTwoCards || sumOfThreeDealerCards < sumOfThreeCards || sumOfFourDealerCards < sumOfFourCards || sumOfFiveDealerCards < sumOfFiveCards){
            return true;
        }

        return false;
    }

    /**
     * Decide if the dealer has won
     * @return - true if the dealers cards are greater than the players cards, else return false
     */
    public boolean dealerWins(){
        if((sumOfTwoDealerCards > sumOfTwoCards || sumOfThreeDealerCards > sumOfThreeCards) || (sumOfFourDealerCards > sumOfFourCards || sumOfFiveDealerCards > sumOfFiveCards)) {
            return true;
        }
        return false;
    }


    /**
     * Decide if the game is a tie
     * @return - true if the dealers cards are equal to the players cards, else return false
     */
    public boolean tieGame(){
        if(sumOfTwoDealerCards == sumOfTwoCards ){
            return true;
        }
        return false;
    }


    /**
     * Player or Dealer has blackjack (A and K)
     * @return true if the player or dealer has blackjack
     */
    public boolean dealerBlackJack(){
        return true;
    }

    public boolean playerBlackJack(){
        return true;
    }



}
