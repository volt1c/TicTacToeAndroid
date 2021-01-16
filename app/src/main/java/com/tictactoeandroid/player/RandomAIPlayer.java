package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;

import java.util.Random;

public class RandomAIPlayer implements Player{
    private PlayerMark mark;

    public Play play(Board board, int x, int y){
        Random rand = new Random();
        int width  = rand.nextInt(2);
        int height = rand.nextInt(2);
        while (!board.isFieldEmpty(width, height)){
            if(height != 2)
                height = next(height);
            else{
                width  = next(width);
                height = next(height);
            }
        }
        return new Play(width, height, mark.toFieldType());
    }
    private int next(int value){
        return (value == 2)? 0 : value + 1;
    }

    public RandomAIPlayer(PlayerMark mark){
        this.mark = mark;
    }
}
