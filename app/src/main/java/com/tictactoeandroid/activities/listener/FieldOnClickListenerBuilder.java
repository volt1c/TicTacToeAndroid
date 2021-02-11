package com.tictactoeandroid.activities.listener;

import android.view.View;

import com.tictactoeandroid.activities.GameActivity;
import com.tictactoeandroid.game.TicTacToeGame;

public class FieldOnClickListenerBuilder {
    public View.OnClickListener build(int x, int y, GameActivity game) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                game.play(x, y);
            }
        };
    }
}
