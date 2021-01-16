package com.tictactoeandroid.game;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.board.TicTacToeBoard;
import com.tictactoeandroid.player.Player;

public class TicTacToeGame {
    private TicTacToeBoard gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private GameResult gameResult;

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
    private boolean isRowEndGame(int id, FieldType value){
        Board board = gameBoard.getGameBoard();
        for(int i = 0; i < 3; i++)
            if(board.getField(id, i) != value)
                return false;
        return true;
    }
    private boolean isColumnEndGame(int id, FieldType value){
        Board board = gameBoard.getGameBoard();
        for(int i = 0; i < 3; i++)
            if(board.getField(i, id) != value)
                return false;
        return true;
    }
    private boolean areSlantsEndGame(FieldType type){
        Board board = gameBoard.getGameBoard();
        return (board.getField(0,0) == type && board.getField(1,1) == type && board.getField(2,2) == type) ||
                (board.getField(2,0) == type && board.getField(1,1) == type && board.getField(0,2) == type);
    }
    public boolean isEnd(){
        Board board = gameBoard.getGameBoard();
        for (int i = 0; i < 3; i++) {
            if (isRowEndGame(i, FieldType.Circle) || isColumnEndGame(i, FieldType.Circle) || areSlantsEndGame(FieldType.Circle)) {
                gameResult = GameResult.CircleWin;
                return true;
            }
            if(isRowEndGame(i, FieldType.Cross) || isColumnEndGame(i, FieldType.Cross) || areSlantsEndGame(FieldType.Cross)) {
                gameResult = GameResult.CrossWin;
                return true;
            }
        }
        if(board.isFull()) {
            gameResult = GameResult.Draw;
            return true;
        }
        return false;
    }
    public GameResult getGameResult() {
        isEnd();
        return gameResult;
    }
    public Board copyBoard(){
        return gameBoard.getGameBoard();
    }

    public TicTacToeGame(Player playerOne, Player playerTwo){
        gameBoard = new TicTacToeBoard();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameResult = GameResult.None;
    }
}
