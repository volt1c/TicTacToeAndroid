package com.tictactoeandroid.game;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.TicTacToeGameBoard;
import com.tictactoeandroid.player.Player;

public class TicTacToeGame {
    private TicTacToeGameBoard gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private GameResult endResult;

    public Player getPlayerOne() {
        return playerOne;
    }
    public Player getPlayerTwo() {
        return playerTwo;
    }
    private boolean play(Play play){
        return gameBoard.play(play);
    }
    public boolean playOne(int x, int y){
        return play(playerOne.play(copyBoard(), x, y));
    }
    public boolean playTwo(int x, int y){
        return play(playerTwo.play(copyBoard(), x, y));
    }
    public boolean isEnd(){
        // TODO
        // check is there 3 Circles/Crosses in line
        // and is board full
        // set result
        return false;
    }
    public GameResult getEndResult() {
        return endResult;
    }
    public Board copyBoard(){
        return gameBoard.getGameBoard();
    }

    public TicTacToeGame(Player playerOne, Player playerTwo){
        gameBoard = new TicTacToeGameBoard();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.endResult = GameResult.None;
    }
}
