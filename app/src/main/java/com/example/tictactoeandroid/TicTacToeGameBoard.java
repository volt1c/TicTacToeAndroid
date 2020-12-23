package com.example.tictactoeandroid;

public class TicTacToeGameBoard {
    private Board board;

    public TicTacToeGameBoard(){
        board = new Board(3, 3);
        board.fill(Field.Empty.value);
    }

    public boolean setField(int width, int height, Field field){
        if (board.getField(width, height) != Field.Empty.value)
            return false;
        board.setField(width, height, field.value);
        return true;
    }

    public Field[][] getGameBoard() {
        Field[][] gBoard = new Field[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                gBoard[i][j] = Field.byValue(board.getField(j, i));
        return gBoard;
    }
}
