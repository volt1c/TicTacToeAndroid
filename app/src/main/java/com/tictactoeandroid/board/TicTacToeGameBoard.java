package com.tictactoeandroid.board;

public class TicTacToeGameBoard {
    private Board board;

    public TicTacToeGameBoard(){
        board = new Board<FieldType>(3, 3);
        board.fill(FieldType.Empty.value);
    }

    public boolean playField(int width, int height, FieldType fieldType){
        if (board.getField(width, height) != FieldType.Empty)
            return false;
        board.setField(width, height, fieldType.value);
        return true;
    }

    public Board getGameBoard() {
        return board;
    }
}
