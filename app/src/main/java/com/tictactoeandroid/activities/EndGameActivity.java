package com.tictactoeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tictactoeandroid.R;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        int result = sp.getInt("gameResult",0);
        TextView text= (TextView) findViewById(R.id.textView3);
        if(result==0){
            text.setText("X Wins");
        }
        if(result==1){
            text.setText("O Wins");
        }
        if(result==2){
            text.setText("Draw");
        }

    }

    public void playAgain(View view){
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
        finish();
    }

    public void BackToMenu(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}