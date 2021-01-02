package com.tictactoeandroid.board;

import com.tictactoeandroid.player.Player;

import java.util.Stack;

public class TicTacToeGame {
    private Board board;
    private Stack<Play> plays;

    public Board getGameBoard() {
        return board.clone();
    }

    private boolean playField(int width, int height, FieldType fieldType){
        if (board.getField(width, height) != FieldType.Empty)
            return false;
        plays.push( new Play(width, height, (FieldType) board.getField(width, height)) );
        board.setField(width, height, fieldType);
        return true;
    }

    public boolean playCircle(int width, int height){
        return playField(width, height, FieldType.Circle);
    }

    public boolean playCross(int width, int height){
        return playField(width, height, FieldType.Cross);
    }

    public void cancelLastPlay(){
        if(plays.isEmpty())
            return;
        Play lastPlay = plays.pop();
        board.setField(
                lastPlay.width,
                lastPlay.height,
                lastPlay.fieldType
        );
    }

    public TicTacToeGame(){
        plays = new Stack<Play>();
        board = new Board<FieldType>(3, 3);
        board.fill(FieldType.Empty);
    }

    private class Play {
        public int width;
        public int height;
        public FieldType fieldType;

        public Play(int width, int height, FieldType fieldType){
            this.width = width;
            this.height = height;
            this.fieldType = fieldType;
        }
    }
}
