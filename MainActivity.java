package com.example.ryeverille.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

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
        TextView playerCard3 = (TextView) findViewById(R.id.playerCard3);
        TextView newTotal = (TextView) findViewById(R.id.newTotal);
        TextView playerCard4 = (TextView) findViewById(R.id.playerCard4);
        TextView cards4 = (TextView) findViewById(R.id.add4Cards);
        TextView playerCard5 = (TextView) findViewById(R.id.playerCard5);
        counter+=1;

        //player card #3
        if(counter == 1){
            //make card 3 appear
            playerCard3.setVisibility(View.VISIBLE);
            //set number to card 3
            playerCard3.setText(String.valueOf(randomNumPlayerCard3));
            if (String.valueOf(randomNumPlayerCard3).equals("10")) {
                playerCard3.setText(String.valueOf(getFaceCard()));
            }

            int value3rdCard = randomNumPlayerCard3;
            //add together the sum of the players first two card + the 3rd card
            int sumOfThreeCards = addCards(blackJack.getSumOfTwoCards(), value3rdCard);
            blackJack.setSumOfThreeCards(sumOfThreeCards);
            newTotal.setText(String.valueOf(sumOfThreeCards));
            dealCard();
        }
        int sumOfFourCards;
        //player card #4
        if(counter == 2){
            playerCard4.setVisibility(View.VISIBLE);
            playerCard4.setText(String.valueOf(randomNumPlayerCard4));
            if (String.valueOf(randomNumPlayerCard4).equals("10")) {
                playerCard4.setText(String.valueOf(getFaceCard()));
            }
            blackJack.setCardfFourValue(randomNumPlayerCard4);

            sumOfFourCards = addCards(blackJack.getSumOfThreeCards(), blackJack.getCard4Value());
            cards4.setText(String.valueOf(sumOfFourCards));
            dealCard();
        }

        //player card 5
        if(counter == 3){
            playerCard5.setVisibility(View.VISIBLE);
            playerCard5.setText(String.valueOf(randomNumPlayerCard5));
            if (String.valueOf(randomNumPlayerCard5).equals("10")) {
                playerCard5.setText(String.valueOf(getFaceCard()));
            }
            int sumOfFiveCards = addCards(blackJack.getSumOfFourCards(),randomNumPlayerCard5);
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
                blackJack.setSumOfTwoCards(playerCurrentTotal);

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
                if (String.valueOf(randomNumDealerCard2).equals("11")) {
                    dealerCard2.setText("A");
                }
                int cpCurrentTotal = addCards(randomNumDealerCard1, randomNumDealerCard2);
                cpTotal.setText(String.valueOf(cpCurrentTotal));
        }
        else{
            Button disableButton;
            int totalOfFourCards = addCards(blackJack.getSumOfThreeCards(), blackJack.getCard4Value());
            int fiveCardsTotal = addCards(blackJack.getSumOfFourCards(),randomNumPlayerCard5);

            blackJack.setSumOfFourCards(totalOfFourCards);
            if(blackJack.getSumOfThreeCards() > 21 ||  totalOfFourCards > 21 || fiveCardsTotal >21){
                gameOver.setText("Dealer Won");
                gameOver.setVisibility(View.VISIBLE);

                //disable the hit button if the game is over
                disableButton = (Button) findViewById(R.id.hitButton);
                disableButton.setEnabled(false);
            }
        }
    }
}
