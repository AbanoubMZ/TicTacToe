package com.abanoub.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int playerOneScore=0;
    public int playerTwoScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            playerOneScore=savedInstanceState.getInt("P1S");
            playerTwoScore=savedInstanceState.getInt("P2S");
            TextView score=findViewById(R.id.tv2);
            score.setText(playerOneScore+" - "+playerTwoScore);
            Log.d("SCORE", String.valueOf(playerOneScore));
        }
    }
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("P1S", playerOneScore);
        savedInstanceState.putInt("P2S", playerOneScore);
        super.onSaveInstanceState(savedInstanceState);

    }
    public void btnClick(View view){
        Button selectedBtn= (Button) view;
        selectedBtn.setBackgroundColor(Color.BLACK);
        int selectedCell=0;
        switch(selectedBtn.getId()){
            case R.id.btn1:
                selectedCell=1;
                break;
            case R.id.btn2:
                selectedCell=2;
                break;
            case R.id.btn3:
                selectedCell=3;
                break;
            case R.id.btn4:
                selectedCell=4;
                break;
            case R.id.btn5:
                selectedCell=5;
                break;
            case R.id.btn6:
                selectedCell=6;
                break;
            case R.id.btn7:
                selectedCell=7;
                break;
            case R.id.btn8:
                selectedCell=8;
                break;
            case R.id.btn9:
                selectedCell=9;
                break;
        }
        playGame(selectedCell,selectedBtn);
    }
    int activePlayer=1; // 1 = player1 active -- 2 = player2 active
    ArrayList<Integer> player1= new ArrayList<Integer>(); //holds player1 data
    ArrayList<Integer> player2= new ArrayList<Integer>(); //holds player2 data

    public void playGame(int selectedCell,Button selectedBtn){
        Log.d("Player: ",String.valueOf(selectedCell));
        Log.d("Button: ",String.valueOf(selectedBtn.getText().toString()));

        if(activePlayer==1){
            selectedBtn.setText("X");
            selectedBtn.setTextSize(24);
            selectedBtn.setTextColor(Color.WHITE);
            selectedBtn.setBackgroundColor(Color.RED);
            player1.add(selectedCell);
            activePlayer=2;

            //singlePlayer();
        }else if(activePlayer==2) {
            selectedBtn.setText("O");
            selectedBtn.setTextSize(24);
            selectedBtn.setTextColor(Color.WHITE);
            selectedBtn.setBackgroundColor(Color.BLUE);
            player2.add(selectedCell);
            activePlayer = 1;
        }
        selectedBtn.setEnabled(false);
        checkWinner();
    }
    public void checkWinner(){
        int winner=-1;
        //Rows
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1;
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2;
        }
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner=1;
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner=2;
        }
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1;
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2;
        }
        //Columns
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1;
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2;
        }
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1;
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2;
        }
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1;
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2;
        }
        //Cross cases
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner=1;
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner=2;
        }
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner=1;
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner=2;
        }

        TextView scoreView=(TextView) findViewById(R.id.tv2);
        if(winner!=-1){
            if(winner==1){
                Toast.makeText(this,"Player 1 Wins",Toast.LENGTH_LONG).show();
                playerOneScore++;
            }else{
                Toast.makeText(this,"Player 2 Wins",Toast.LENGTH_LONG).show();
                playerTwoScore++;
            }
            scoreView.setText(playerOneScore+" - "+playerTwoScore);
            newGame();
        }

    }

    public void newGameM(View view){

    }
    public void newGame(){
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
    public void singlePlayer(){
        ArrayList<Integer> emptyCells = new ArrayList<>();
        for(int i=1;i<10;i++){
            if(!(player1.contains(i)||player2.contains(i))){
                emptyCells.add(i);
            }
        }
        Random random= new Random();
        int randIdx=random.nextInt(emptyCells.size()-0)+0;
        int cellID= emptyCells.get(randIdx);
        Button selectedBtn;
        switch (cellID){
            case 1:
                selectedBtn=(Button) findViewById(R.id.btn1);
                break;
            case 2:
                selectedBtn=(Button) findViewById(R.id.btn2);
                break;
            case 3:
                selectedBtn=(Button) findViewById(R.id.btn3);
                break;
            case 4:
                selectedBtn=(Button) findViewById(R.id.btn4);
                break;
            case 5:
                selectedBtn=(Button) findViewById(R.id.btn5);
                break;
            case 6:
                selectedBtn=(Button) findViewById(R.id.btn6);
                break;
            case 7:
                selectedBtn=(Button) findViewById(R.id.btn7);
                break;
            case 8:
                selectedBtn=(Button) findViewById(R.id.btn8);
                break;
            case 9:
                selectedBtn=(Button) findViewById(R.id.btn9);
                break;
            default:
                selectedBtn=(Button) findViewById(R.id.btn1);
                break;
        }
        playGame(cellID,selectedBtn);



    }
}
