package com.tictactoeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tictactoeandroid.R;
import com.tictactoeandroid.activities.listener.FieldOnClickListenerBuilder;
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
    Button[][] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",MODE_PRIVATE);

        PlayerType playerType = PlayerType.fromInt(sharedPreferences.getInt("PlayerType",0));
        PlayerData data = new PlayerData(playerType, PlayerMark.Circle);

        Player playerOne = new UserPlayer(PlayerMark.Cross);
        Player playerTwo = new PlayerFactory().create(data);

        setButtons();
        game = new TicTacToeGame(playerOne, playerTwo);
        isLastPlayOne = false;
        updateGUIBoard();
    }

    public void setButtons() {
        buttons = new Button[][]{
                {(Button) findViewById(R.id.button1), (Button) findViewById(R.id.button2), (Button) findViewById(R.id.button3)},
                {(Button) findViewById(R.id.button4), (Button) findViewById(R.id.button5), (Button) findViewById(R.id.button6)},
                {(Button) findViewById(R.id.button7), (Button) findViewById(R.id.button8), (Button) findViewById(R.id.button9)}
        };
        FieldOnClickListenerBuilder builder = new FieldOnClickListenerBuilder();
        for (int y = 0; y < 3; y++)
            for (int x = 0; x < 3; x++)
                buttons[y][x].setOnClickListener(builder.build(x, y, this));

    }

    private void updateButton(Button button, int x, int y){
        button.setText(fieldToString(
                (FieldType) game.copyBoard()
                        .getField(x,y)));
    }
    public void updateGUIBoard(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                updateButton(buttons[i][j], j, i);
    }
    private String fieldToString(FieldType fieldType){
        return String.valueOf(fieldType.mark);
    }
    private void end(){
        int result = game.getGameResult().toInt();
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
}