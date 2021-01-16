package com.tictactoeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tictactoeandroid.R;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.TicTacToeGame;
import com.tictactoeandroid.player.Player;
import com.tictactoeandroid.player.PlayerData;
import com.tictactoeandroid.player.PlayerFactory;
import com.tictactoeandroid.player.PlayerMark;
import com.tictactoeandroid.player.PlayerType;
import com.tictactoeandroid.player.UserPlayer;

public class GameActivity extends AppCompatActivity {
    TicTacToeGame game;
    boolean isLastPlayOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",MODE_PRIVATE);

        PlayerType playerType = PlayerType.getByIndex(sharedPreferences.getInt("PlayerType",0));
        PlayerData data = new PlayerData(playerType, PlayerMark.Circle);

        Player playerOne = new UserPlayer(PlayerMark.Cross);
        Player playerTwo = new PlayerFactory().create(data);

        game = new TicTacToeGame(playerOne, playerTwo);
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
        return String.valueOf(fieldType.mark);
    }
    private void end(){
        int result = game.getGameResult().index;
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("gameResult",result);
        editor.apply();
        Intent intent = new Intent(this,EndGameActivity.class);
        startActivity(intent);
        finish();
    }
    private void playPlayer(int x, int y, int playerId){
        if((playerId == 1)? game.playOne(x, y) : game.playTwo(x, y))
            isLastPlayOne = !isLastPlayOne;
        updateGUIBoard();
    }
    // TODO
    // partially move to TicTacToeGame.java
    public void play(int x, int y){
        if(!isLastPlayOne || !(game.getPlayerOne() instanceof UserPlayer)){
            playPlayer(x, y, 1);
        }
        if (game.isEnd())
            end();
        if(isLastPlayOne || game.getPlayerTwo() instanceof UserPlayer){
            playPlayer(x, y, 2);
        }
        if (game.isEnd())
            end();
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