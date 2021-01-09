package com.tictactoeandroid.board;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;
import com.tictactoeandroid.player.Player;

import java.util.Stack;

public class TicTacToeGameBoard {
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
    public boolean play(Play play){
        return playField(play.width, play.height, play.fieldType);
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

    public TicTacToeGameBoard(){
        plays = new Stack<Play>();
        board = new Board<FieldType>(3, 3, FieldType.Empty);
        board.fill(FieldType.Empty);
    }
}
