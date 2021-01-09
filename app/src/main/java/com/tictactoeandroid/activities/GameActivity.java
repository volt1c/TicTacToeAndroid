package com.tictactoeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tictactoeandroid.R;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.TicTacToeGame;
import com.tictactoeandroid.player.RandomAIPlayer;
import com.tictactoeandroid.player.UserPlayer;

public class GameActivity extends AppCompatActivity {
    TicTacToeGame game;
    boolean isLastPlayOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // TODO
        // capture data from the form,
        // with the help of the abstract factory prepare the appropriate objects
        // start
        game = new TicTacToeGame(
                new UserPlayer(FieldType.Cross),
                new RandomAIPlayer(FieldType.Circle)
        );
        // end
        isLastPlayOne = false;
        updateGUIBoard();
    }

    private void updateButton(int buttonId,int x, int y){
        ((Button) findViewById(buttonId))
                .setText(fieldToString(
                (FieldType) game.copyBoard()
                        .getField(x,y)));
    }

    public void updateGUIBoard(){
        updateButton(R.id.button1,0,0);
        updateButton(R.id.button2,1,0);
        updateButton(R.id.button3,2,0);
        updateButton(R.id.button4,0,1);
        updateButton(R.id.button5,1,1);
        updateButton(R.id.button6,2,1);
        updateButton(R.id.button7,0,2);
        updateButton(R.id.button8,1,2);
        updateButton(R.id.button9,2,2);

    }

    private String fieldToString(FieldType fieldType){
        return String.valueOf(fieldType.aChar);
    }

    private void end(){
        // TODO
        // opens the EndGameActivity
        // forwards the results there
    }

    public void play(int x, int y){
        if (game.isEnd()) end();
        if(!isLastPlayOne || !(game.getPlayerTwo() instanceof UserPlayer)){
            while (!game.playOne(x, y));
            updateGUIBoard();
        }
        if (game.isEnd()) end();
        if(isLastPlayOne || game.getPlayerOne() instanceof UserPlayer){
            while (!game.playTwo(x,y));
            updateGUIBoard();
        }
        isLastPlayOne = !isLastPlayOne;
        if(!(game.getPlayerOne() instanceof UserPlayer) && !(game.getPlayerTwo() instanceof UserPlayer))
            play(0,0);
    }

    public void play1(View view){
        play(0, 0);
    }
    public void play2(View view){
        play(1, 0);
    }
    public void play3(View view){
        play(2, 0);
    }
    public void play4(View view){
        play(0, 1);
    }
    public void play5(View view){
        play(1, 1);
    }
    public void play6(View view){
        play(2, 1);
    }
    public void play7(View view){
        play(0, 2);
    }
    public void play8(View view){
        play(1, 2);
    }
    public void play9(View view){
        play(2, 2);
    }
}