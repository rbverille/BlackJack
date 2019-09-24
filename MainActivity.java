package com.example.ryeverille.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    BlackJack blackJack = new BlackJack();
    int randomNumPlayerCard1 = getRandomInteger(12,1);
    int randomNumPlayerCard2 = getRandomInteger(12,1);
    int randomNumDealerCard1 = getRandomInteger(12,1);
    int randomNumDealerCard2 = getRandomInteger(12,1);
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * generate a random integer to be used for the player and dealer cards
     * @param maximum
     * @param minimum
     * @return random int
     */
    public int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }


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
       dealCard();
    }


    /**
     * Starts the game by dealing two cards to both the dealer and player
     */
    public void dealCard(){
        TextView playerCard1 = (TextView) findViewById(R.id.playerCard1);
        TextView playerCard2 = (TextView) findViewById(R.id.playerCard2);
        TextView dealerCard1 = (TextView) findViewById(R.id.dealerCard1);
        TextView dealerCard2 = (TextView) findViewById(R.id.dealerCard2);

        if (blackJack.hasNoCards()) {

            //card #1 for player
            playerCard1.setVisibility(View.VISIBLE);
            playerCard1.setText(String.valueOf(randomNumPlayerCard1));
            if(String.valueOf(randomNumPlayerCard1).equals("11")){
                playerCard1.setText("A");
            }
            if(String.valueOf(randomNumPlayerCard1).equals("10")){
                playerCard1.setText(String.valueOf(getFaceCard()));
            }

            //card #2 for player
            playerCard2.setVisibility(View.VISIBLE);
            playerCard2.setText(String.valueOf(randomNumPlayerCard2));
            if(String.valueOf(randomNumPlayerCard2).equals("11")){
                playerCard2.setText("A");
            }
            if(String.valueOf(randomNumPlayerCard2).equals("10")){
                playerCard2.setText(String.valueOf(getFaceCard()));
            }

            //card #1 for dealer
            dealerCard1.setVisibility(View.VISIBLE);
            dealerCard1.setText(String.valueOf(randomNumDealerCard1));
            if(String.valueOf(randomNumDealerCard1).equals("11")){
                dealerCard1.setText("A");
            }
            if(String.valueOf(randomNumDealerCard1).equals("10")){
                dealerCard1.setText(String.valueOf(getFaceCard()));
            }

            //card #2 for dealer
            dealerCard2.setVisibility(View.VISIBLE);
            dealerCard2.setText(String.valueOf(randomNumDealerCard2));
            if(String.valueOf(randomNumDealerCard2).equals("11")){
                dealerCard2.setText("A");
            }
        }
    }
}
