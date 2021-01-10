package com.tictactoeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tictactoeandroid.R;

public class GameTypeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type_menu);
    }

    public void SelectPlayer(View view){
        Intent intent = new Intent(GameTypeMenuActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    }

    public void SelectAiPlayer(View view){
        Intent intent = new Intent(GameTypeMenuActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}