package com.example.ryeverille.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import org.w3c.dom.Text;
import java.util.Random;


/**
 * This class serves as the main functionality of the application
 *  @author Rain Soto, Rye Verille
 *  @version 1.0
 *  10/1/2019
 */
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
     *  This method prduces the functionality of the stop button
     * @param view  - to access the GUI components
     *
     */
    public void stop(View view) {
        Button hitButton, stopButton, playButton;
        TextView gameOver = (TextView) findViewById(R.id.gameOver);

        //disable the hit button if the game is over
        hitButton = (Button) findViewById(R.id.hitButton);
        hitButton.setEnabled(false);

        //disable stop button
        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setEnabled(false);

        //disable play button
        playButton = (Button) findViewById(R.id.button);
        playButton.setEnabled(false);

        if(blackJack.playerWins()){
            gameOver.setVisibility(View.VISIBLE);
            gameOver.setText("Player Wins");
        }
        if(blackJack.dealerWins()){
            gameOver.setVisibility(View.VISIBLE);
            gameOver.setText("Dealer Wins");
        }
        if( blackJack.tieGame()) {
            gameOver.setVisibility(View.VISIBLE);
            gameOver.setText("Tie Game ");
        }
    }

    /**
     * adds cards when the player hits
     * @param view - to access GUI components
     */
    public void hit(View view){
        TextView playerCard3 = (TextView) findViewById(R.id.playerCard3);
        TextView playerCard4 = (TextView) findViewById(R.id.playerCard4);
        TextView playerCard5 = (TextView) findViewById(R.id.playerCard5);
        TextView dealerCard3 = (TextView)findViewById(R.id.dealerCard3);
        TextView dealerCard4 = (TextView)findViewById(R.id.dealerCard4);
        TextView dealerCard5 = (TextView)findViewById(R.id.dealerCard5);

        counter+=1;

        //player card #3
        if(counter == 1){
            //make card 3 appear
            playerCard3.setVisibility(View.VISIBLE);
            playerCard3.setText(String.valueOf(randomNumPlayerCard3));
            if (String.valueOf(randomNumPlayerCard3).equals("10")) {
                playerCard3.setText(String.valueOf(getFaceCard()));
            }
            if (String.valueOf(randomNumPlayerCard3).equals("11")) {
                playerCard3.setText("A");
            }

            //add together the sum of the players first two card + the 3rd card
            blackJack.setThreeCardsSumPlayer(addCards(blackJack.getSumTwoPlayerCards(), randomNumPlayerCard3));

            //as long as 1+2 is under 21 hit if not dont show the cards
            if(blackJack.getSumOfTwoDealerCards() < 21){
                dealerCard3.setVisibility(View.VISIBLE);
                dealerCard3.setText(String.valueOf(randomNumDealerCard3));
                if (String.valueOf(randomNumDealerCard3).equals("10")) {
                    dealerCard3.setText(String.valueOf(getFaceCard()));
                }
                if (String.valueOf(randomNumDealerCard3).equals("11")) {
                    dealerCard3.setText("A");
                }
                blackJack.setSumOfThreeDealerCards(addCards(blackJack.getSumOfTwoDealerCards(), randomNumDealerCard3));
            }
            rules();
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

            if (String.valueOf(randomNumPlayerCard4).equals("11")) {
                playerCard4.setText("A");
            }

            //sum of 4 cards
            sumOfFourCards = addCards(blackJack.getSumOfThreeCards(), randomNumPlayerCard4);
            blackJack.setSumOfFourCards(sumOfFourCards);

            //dealer card 4
            if(blackJack.getSumOfTwoDealerCards() < 21 && blackJack.getSumOfThreeDealerCards() < 21){
                dealerCard4.setText(String.valueOf(randomNumDealerCard4));
                dealerCard4.setVisibility(View.VISIBLE);
                if (String.valueOf(randomNumDealerCard4).equals("10")) {
                    dealerCard4.setText(String.valueOf(getFaceCard()));
                }
                if (String.valueOf(randomNumDealerCard4).equals("11")) {
                    dealerCard4.setText("A");
                }
               //total of 4 dealer cards
                blackJack.setSumOfFourDealerCards( addCards(blackJack.getSumOfThreeDealerCards(),randomNumDealerCard4));
            }
            rules();
            dealCard();
        }

        if(counter == 3){
            //5th player card
            playerCard5.setVisibility(View.VISIBLE);
            playerCard5.setText(String.valueOf(randomNumPlayerCard5));
            if (String.valueOf(randomNumPlayerCard5).equals("10")) {
                playerCard5.setText(String.valueOf(getFaceCard()));
            }
            if (String.valueOf(randomNumPlayerCard5).equals("11")) {
                playerCard5.setText("A");
            }
            //sum of five player cards
            blackJack.setSumOfFiveCards(addCards(blackJack.getSumOfFourCards(),randomNumPlayerCard5));


            //dealer 5th card
            if(blackJack.getSumOfTwoDealerCards() < 21 && blackJack.getSumOfThreeDealerCards() < 21 && blackJack.getSumOfFiveDealerCards() < 21) {
                if (String.valueOf(randomNumDealerCard5).equals("10")) {
                    dealerCard5.setText(String.valueOf(getFaceCard()));
                }
                if (String.valueOf(randomNumDealerCard5).equals("11")) {
                    dealerCard5.setText("A");
                }
                dealerCard5.setVisibility(View.VISIBLE);
                dealerCard5.setText(String.valueOf(randomNumDealerCard5));

                //sum of five dealer cards
                blackJack.setSumOfFiveDealerCards(addCards(blackJack.getSumOfFourDealerCards(), randomNumDealerCard5));
            }
            rules();
        }
    }

    /**
     * generate a random integer to be used for the player and dealer cards
     * @param maximum - max generated random number
     * @param minimum - min generated random number
     * @return random int - the random number
     */
    public int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    /**
     * randomly generate a J, Q, or K
     * @return  J Q or K randomly
     */
    public char getFaceCard() {
        String chars = "JQK";
        Random rnd = new Random();
        char c = chars.charAt(rnd.nextInt(chars.length()));
        return c;
    }

    /**
     * functionality of the play button - start the game and make all buttons visible
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

    /**
     * add together cards that in currently in the player or dealers hand
     * @param card1 - player or dealer card
     * @param card2 - player or dealer card
     * @return the sum of the cards
     */
    public int addCards(int card1, int card2){
        int sum = card1 + card2;
        return sum;
    }


    /**
     * restart the game
     * @param view  - to access the button to restart the game
     */
    public void restartGame(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /**
     * accounts for the rules of the game to the display who won the game
     */
    public void rules(){
        Button hitButton, stopButton;
        TextView gameOver = (TextView) findViewById(R.id.gameOver);

        if(blackJack.getSumOfThreeCards() > 21 || blackJack.getSumOfFourCards() > 21 || blackJack.getSumOfFiveCards() > 21 && blackJack.getSumOfFiveDealerCards() <= 21){
            gameOver.setText("Dealer Won!");
            gameOver.setVisibility(View.VISIBLE);

            //disable the hit button if the game is over
            hitButton = (Button) findViewById(R.id.hitButton);
            hitButton.setEnabled(false);

            stopButton = (Button) findViewById(R.id.stopButton);
            stopButton.setEnabled(false);
        }
        if( blackJack.getSumOfThreeDealerCards() > 21|| blackJack.getSumOfFourDealerCards() > 21 || (blackJack.getSumOfFiveDealerCards() > 21 && blackJack.getSumOfFiveCards() <= 21)){
            gameOver.setText("Player Won!");
            gameOver.setVisibility(View.VISIBLE);

            //disable the hit button if the game is over
            hitButton = (Button) findViewById(R.id.hitButton);
            hitButton.setEnabled(false);

            stopButton = (Button) findViewById(R.id.stopButton);
            stopButton.setEnabled(false);
        }
        if((blackJack.getSumOfThreeCards() > 21 && blackJack.getSumOfThreeDealerCards() > 21) ||( blackJack.getSumOfFourCards() > 21 && blackJack.getSumOfFourDealerCards()> 21) || (blackJack.getSumOfFiveCards() > 21 && blackJack.getSumOfFiveDealerCards()>21) ){
            gameOver.setText("Tie!");
            gameOver.setVisibility(View.VISIBLE);

            //disable the hit button if the game is over
            hitButton = (Button) findViewById(R.id.hitButton);
            hitButton.setEnabled(false);

            stopButton = (Button) findViewById(R.id.stopButton);
            stopButton.setEnabled(false);
        }
    }


    /**
     * Starts the game by dealing two cards to both the dealer and player
     */
    public void dealCard(){

        TextView playButton = (TextView) findViewById(R.id.button);
        TextView restartButton = (TextView) findViewById(R.id.restartGame);
        TextView playerCard1 = (TextView) findViewById(R.id.playerCard1);
        TextView playerCard2 = (TextView) findViewById(R.id.playerCard2);
        TextView dealerCard1 = (TextView) findViewById(R.id.dealerCard1);
        TextView dealerCard2 = (TextView) findViewById(R.id.dealerCard2);
        TextView gameOver = (TextView) findViewById(R.id.gameOver);
        Button hitButton, stopButton;

        playButton.setVisibility(View.INVISIBLE);
        restartButton.setVisibility(View.VISIBLE);

        if (counter == 0 ) {
            //card #1 for player
                playerCard1.setVisibility(View.VISIBLE);
                playerCard1.setText(String.valueOf(randomNumPlayerCard1));
                if (String.valueOf(randomNumPlayerCard1).equals("11")) {
                    playerCard1.setText("A");
                    //player has blackjack
                    if(randomNumPlayerCard1 == 'K' || randomNumPlayerCard2 == 'K')  {
                        blackJack.playerBlackJack();
                    }
                }
                if (String.valueOf(randomNumPlayerCard1).equals("10")) {
                    playerCard1.setText(String.valueOf(getFaceCard()));
                }

                //card #2 for player
                playerCard2.setVisibility(View.VISIBLE);
                playerCard2.setText(String.valueOf(randomNumPlayerCard2));
                if (String.valueOf(randomNumPlayerCard2).equals("11")) {
                    playerCard2.setText("A");

                    //player has blackjack
                    if(randomNumPlayerCard1 == 'K' || randomNumPlayerCard2 == 'K')  {
                        blackJack.playerBlackJack();
                    }
                }
                if (String.valueOf(randomNumPlayerCard2).equals("10")) {
                    playerCard2.setText(String.valueOf(getFaceCard()));
                }
                blackJack.setSum2PlayerCards(addCards(randomNumPlayerCard1, randomNumPlayerCard2));

                //card #1 for dealer
                dealerCard1.setVisibility(View.VISIBLE);
                dealerCard1.setText(String.valueOf(randomNumDealerCard1));
                if (String.valueOf(randomNumDealerCard1).equals("11")) {
                    dealerCard1.setText("A");

                    //dealer has blackjack
                    if(randomNumDealerCard1 == 'K' || randomNumDealerCard2 == 'K')  {
                        blackJack.dealerBlackJack();
                    }
                }
                if (String.valueOf(randomNumDealerCard1).equals("10")) {
                    dealerCard1.setText(String.valueOf(getFaceCard()));
                }

                //card #2 for dealer
                dealerCard2.setVisibility(View.VISIBLE);
                dealerCard2.setText(String.valueOf(randomNumDealerCard2));
                if (String.valueOf(randomNumDealerCard2).equals("10")) {
                    dealerCard2.setText(String.valueOf(getFaceCard()));

                    if(randomNumDealerCard1 == 'K' || randomNumDealerCard2 == 'K')  {
                        blackJack.dealerBlackJack();
                    }
                }
                if (String.valueOf(randomNumDealerCard2).equals("11")) {
                    dealerCard2.setText("A");
                }
                blackJack.setSumOfTwoDealerCards(addCards(randomNumDealerCard1, randomNumDealerCard2));

                if(blackJack.getSumOfTwoDealerCards() > 21){
                    gameOver.setText("Player Won");
                    gameOver.setVisibility(View.VISIBLE);

                    //disable the hit button if the game is over
                    hitButton = (Button) findViewById(R.id.hitButton);
                    hitButton.setEnabled(false);
                    stopButton = (Button) findViewById(R.id.stopButton);
                    stopButton.setEnabled(false);
                }
        }
    }
}
