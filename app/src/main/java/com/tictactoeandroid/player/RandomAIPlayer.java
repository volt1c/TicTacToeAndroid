package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;

import java.util.Random;

public class RandomAIPlayer implements Player{
    private FieldType kind;
    public Play play(Board board){
        Random rand = new Random();
        int width  = rand.nextInt(2);
        int height = rand.nextInt(2);
        while (!board.isFieldEmpty(width, height)){
            width  = next(width);
            height = next(height);
        }
        return new Play(width, height, kind);
    }

    private int next(int value){
        return (value == 2)? 0 : value + 1;
    }

    public RandomAIPlayer(){
        // TODO
    }
}
