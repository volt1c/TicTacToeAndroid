package com.tictactoeandroid.game;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.player.Player;

public class TicTacToeGame {
    private TicTacToeGameBoard gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private boolean isLastPlayedOne;

    public void playTurn(){
        Player player = getPlayerForThisTurn();
        Board board = gameBoard.getGameBoard();
        player.play(board);
    }

    private Player getPlayerForThisTurn(){
        return isLastPlayedOne? playerOne : playerTwo;
    }

    public TicTacToeGame(Player playerOne, Player playerTwo){
        gameBoard = new TicTacToeGameBoard();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        isLastPlayedOne = false;
    }
}
