package com.example.ryeverille.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    BlackJack blackJack = new BlackJack();
    //players randomized card numbers
    int randomNumPlayerCard1 = getRandomInteger(12,1);
    int randomNumPlayerCard2 = getRandomInteger(12,1);
    int randomNumPlayerCard3 = getRandomInteger(12,1);
    int randomNumPlayerCard4 = getRandomInteger(12,1);
    int randomNumPlayerCard5 = getRandomInteger(12,1);


    //dealers randomized card numbers
    int randomNumDealerCard1 = getRandomInteger(12,1);
    int randomNumDealerCard2 = getRandomInteger(12,1);
    int randomNumDealerCard3 = getRandomInteger(12,1);
    int randomNumDealerCard4 = getRandomInteger(12,1);
    int randomNumDealerCard5 = getRandomInteger(12,1);


    int counter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * adds cards when the player hits
     * @param view
     */
    public void hit(View view){
        TextView p3 = (TextView) findViewById(R.id.playerCard3);
        TextView newTotal = (TextView) findViewById(R.id.newTotal);
        TextView p4 = (TextView) findViewById(R.id.playerCard4);
        TextView cards4 = (TextView) findViewById(R.id.add4Cards);
        TextView p5 = (TextView) findViewById(R.id.playerCard5);
        TextView d3 = (TextView)findViewById(R.id.dealerCard3);
        TextView d4 = (TextView)findViewById(R.id.dealerCard4);
        TextView d5 = (TextView)findViewById(R.id.dealerCard5);

        counter+=1;

        //player card #3
        if(counter == 1){
            //make card 3 appear
            p3.setVisibility(View.VISIBLE);
            //set number to card 3
            p3.setText(String.valueOf(randomNumPlayerCard3));
            if (String.valueOf(randomNumPlayerCard3).equals("10")) {
                p3.setText(String.valueOf(getFaceCard()));
            }

           // int value3rdCard = randomNumPlayerCard3;
            //add together the sum of the players first two card + the 3rd card
            int sumThreePlayerCards = addCards(blackJack.getSumTwoPlayerCards(), randomNumPlayerCard3);
            blackJack.setThreeCardsSumPlayer(sumThreePlayerCards);
            newTotal.setText(String.valueOf(sumThreePlayerCards));

            //dealer card 3 -- if value of card 1+2 < 21 add third card
            //if(blackJack.getSumOfOneAndTwoD() < 21){

            //as long as 1+2 is under 21 hit if not dont show the cards
            if(blackJack.getSumOfOneAndTwoD() < 21){
                d3.setVisibility(View.VISIBLE);
                d3.setText(String.valueOf(randomNumDealerCard3));
                if (String.valueOf(randomNumDealerCard3).equals("10")) {
                    d3.setText(String.valueOf(getFaceCard()));
                }
                blackJack.setSumOfThreeDealerCards(addCards(blackJack.getSumOfOneAndTwoD(), randomNumDealerCard3));

            }
            rules();
            dealCard();
        }
        int sumOfFourCards;
        //player card #4
        if(counter == 2){
            p4.setVisibility(View.VISIBLE);
            p4.setText(String.valueOf(randomNumPlayerCard4));
            if (String.valueOf(randomNumPlayerCard4).equals("10")) {
                p4.setText(String.valueOf(getFaceCard()));
            }
            blackJack.setCardfFourValue(randomNumPlayerCard4);


            sumOfFourCards = addCards(blackJack.getSumOfThreeCards(), blackJack.getCard4Value());
            cards4.setText(String.valueOf(sumOfFourCards));

            //dealer card 4
            if(blackJack.getSumOfThreeDealerCards() < 21){
                d4.setText(String.valueOf(randomNumDealerCard4));
                d4.setVisibility(View.VISIBLE);
                if (String.valueOf(randomNumDealerCard4).equals("10")) {
                    d4.setText(String.valueOf(getFaceCard()));
                }
               //total of 4 dealer cards
                int dealer4CardSum = addCards(blackJack.getSumOfThreeDealerCards(),randomNumDealerCard4);
                blackJack.setSumOfFourDealerCards(dealer4CardSum);
            }
            rules();
            dealCard();
        }

        //player card 5
        if(counter == 3){
            p5.setVisibility(View.VISIBLE);
            p5.setText(String.valueOf(randomNumPlayerCard5));
            if (String.valueOf(randomNumPlayerCard5).equals("10")) {
                p5.setText(String.valueOf(getFaceCard()));
            }
            int sumOfFiveCards = addCards(blackJack.getSumOfFourCards(),randomNumPlayerCard5);

            //dealer 5th card
            if(blackJack.getSumOfFourDealerCards() < 21 && blackJack.getSumOfThreeDealerCards() < 21)
                d5.setVisibility(View.VISIBLE);
                d5.setText(String.valueOf(randomNumDealerCard5));
            rules();
        }
    }

    /**
     * generate a random integer to be used for the player and dealer cards
     * @param maximum
     * @param minimum
     * @return random int
     */
    public int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    /**
     * make a J Q K for the cards
     * @return
     */
    public char getFaceCard() {
        String chars = "JQK";
        Random rnd = new Random();
        char c = chars.charAt(rnd.nextInt(chars.length()));
        return c;
    }

    /**
     *
     * @param view
     */
    public void letsPlay(View view){
        Button hit;
        hit = (Button) findViewById(R.id.hitButton);
        hit.setVisibility(View.VISIBLE);

        Button stop;
        stop = (Button) findViewById(R.id.stopButton);
        stop.setVisibility(View.VISIBLE);

       dealCard();
    }

    public int addCards(int card1, int card2){
        int sum = card1 + card2;
        return sum;
    }


    public void rules(){
        Button disableButton;
        TextView gameOver = (TextView) findViewById(R.id.gameOver);

        int totalOfFourCards = addCards(blackJack.getSumOfThreeCards(), blackJack.getCard4Value());
        int fiveCardsTotal = addCards(blackJack.getSumOfFourCards(),randomNumPlayerCard5);

        if(blackJack.getSumOfThreeCards() > 21 || blackJack.getSumOfFourCards() > 21 || fiveCardsTotal > 21 ){
            gameOver.setText("Dealer Won");
            gameOver.setVisibility(View.VISIBLE);

            //disable the hit button if the game is over
            disableButton = (Button) findViewById(R.id.hitButton);
            disableButton.setEnabled(false);
        }
        if( blackJack.getSumOfThreeDealerCards() > 21|| blackJack.getSumOfFourDealerCards()> 21){
            gameOver.setText("Player Won");
            gameOver.setVisibility(View.VISIBLE);

            //disable the hit button if the game is over
            disableButton = (Button) findViewById(R.id.hitButton);
            disableButton.setEnabled(false);
        }
        if((blackJack.getSumOfThreeCards() > 21 &&  blackJack.getSumOfThreeDealerCards() > 21) || (blackJack.getSumOfFourCards() > 21) && blackJack.getSumOfFourDealerCards()> 21 ){
            gameOver.setText("Tie");
            gameOver.setVisibility(View.VISIBLE);

            //disable the hit button if the game is over
            disableButton = (Button) findViewById(R.id.hitButton);
            disableButton.setEnabled(false);
        }
    }


    /**
     * Starts the game by dealing two cards to both the dealer and player
     */
    public void dealCard(){



        //player textviews
        TextView playerCard1 = (TextView) findViewById(R.id.playerCard1);
        TextView playerCard2 = (TextView) findViewById(R.id.playerCard2);

        //player card 1 + card 2
        TextView playerTotal =(TextView) findViewById(R.id.sum);

        //dealer textviews
        TextView dealerCard1 = (TextView) findViewById(R.id.dealerCard1);
        TextView dealerCard2 = (TextView) findViewById(R.id.dealerCard2);

        //dealer card 1 + card 2
        TextView cpTotal =(TextView) findViewById(R.id.cpTotal);
        TextView gameOver = (TextView) findViewById(R.id.gameOver);

        if (counter == 0 ) {
                //card #1 for player
                playerCard1.setVisibility(View.VISIBLE);
                playerCard1.setText(String.valueOf(randomNumPlayerCard1));
                if (String.valueOf(randomNumPlayerCard1).equals("11")) {
                    playerCard1.setText("A");
                }
                if (String.valueOf(randomNumPlayerCard1).equals("10")) {
                    playerCard1.setText(String.valueOf(getFaceCard()));
                }
                int playerCurrentTotal = addCards(randomNumPlayerCard1, randomNumPlayerCard2);
                blackJack.setSum2PlayerCards(playerCurrentTotal);

                playerTotal.setText(String.valueOf(playerCurrentTotal));

                //card #2 for player
                playerCard2.setVisibility(View.VISIBLE);
                playerCard2.setText(String.valueOf(randomNumPlayerCard2));
                if (String.valueOf(randomNumPlayerCard2).equals("11")) {
                    playerCard2.setText("A");
                }
                if (String.valueOf(randomNumPlayerCard2).equals("10")) {
                    playerCard2.setText(String.valueOf(getFaceCard()));
                }

                //card #1 for dealer
                dealerCard1.setVisibility(View.VISIBLE);
                dealerCard1.setText(String.valueOf(randomNumDealerCard1));
                if (String.valueOf(randomNumDealerCard1).equals("11")) {
                    dealerCard1.setText("A");
                }
                if (String.valueOf(randomNumDealerCard1).equals("10")) {
                    dealerCard1.setText(String.valueOf(getFaceCard()));
                }

                //card #2 for dealer
                dealerCard2.setVisibility(View.VISIBLE);
                dealerCard2.setText(String.valueOf(randomNumDealerCard2));
                if (String.valueOf(randomNumDealerCard2).equals("10")) {
                    dealerCard2.setText(String.valueOf(getFaceCard()));
                }
                if (String.valueOf(randomNumDealerCard2).equals("11")) {
                    dealerCard2.setText("A");
                }
                int cpCurrentTotal = addCards(randomNumDealerCard1, randomNumDealerCard2);
                blackJack.setSumOfDealOneAndTwo(cpCurrentTotal);
                cpTotal.setText(String.valueOf(cpCurrentTotal));

                Button disableButton;

                if(cpCurrentTotal > 21){
                    gameOver.setText("Player Won");
                    gameOver.setVisibility(View.VISIBLE);

                    //disable the hit button if the game is over
                    disableButton = (Button) findViewById(R.id.hitButton);
                    disableButton.setEnabled(false);
                }
            //if (cpCurrentTotal == 21) {
                    //set the dealers final number to 21
            //}
        }
        else{



         //   blackJack.setSumOfFourCards(totalOfFourCards);

        }
    }
}
