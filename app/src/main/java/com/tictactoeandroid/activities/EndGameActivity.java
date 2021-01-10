package com.tictactoeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.tictactoeandroid.R;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        int result = sp.getInt("gameResult",0);
    }
}