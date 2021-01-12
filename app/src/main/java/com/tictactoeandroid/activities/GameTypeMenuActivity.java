package com.tictactoeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("PlayerType",1);
        editor.apply();
        Intent intent = new Intent(GameTypeMenuActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    }

    public void SelectAiPlayer(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("PlayerType",0);
        editor.apply();
        Intent intent = new Intent(GameTypeMenuActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}