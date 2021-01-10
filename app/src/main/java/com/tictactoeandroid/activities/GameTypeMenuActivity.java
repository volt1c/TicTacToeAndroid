package com.tictactoeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.tictactoeandroid.R;

public class GameTypeMenuActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type_menu);

    }

    public void SelectPlayer(View view){
        editor.putInt("PlayerType",1);
        Intent intent = new Intent(GameTypeMenuActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    }

    public void SelectAiPlayer(View view){
        editor.putInt("PlayerType",0);
        Intent intent = new Intent(GameTypeMenuActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}