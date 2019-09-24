package com.example.ryeverille.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    BlackJack bj = new BlackJack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void letsPlay(View view){
       dealACard();
    }

    public void dealACard(){
        TextView tv = (TextView) findViewById(R.id.PlayerCard1);

        if (bj.hasNoCards()){
            tv.setText("1");
            //deal them two cards
        }

    }



}
