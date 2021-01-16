package com.tictactoeandroid.game;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.player.Player;
import com.tictactoeandroid.player.PlayerData;
import com.tictactoeandroid.player.PlayerMark;
import com.tictactoeandroid.player.PlayerType;
import com.tictactoeandroid.player.UserPlayer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TicTacToeGameTest {
    TicTacToeGame game;
    @Before
    public void init(){
        game = new TicTacToeGame(
                new UserPlayer(PlayerMark.Cross),
                new UserPlayer(PlayerMark.Circle)
        );
    }
    @Test
    public void testOnePlayEmptyFieldThenTwoTryPlayTheSameField(){
        assertTrue(game.playOne(0,0));
        assertFalse(game.playTwo(0,0));
    }
    @Test
    public void testTwoPlayEmptyFieldThenOneTryPlayTheSameField(){
        assertTrue(game.playTwo(0,0));
        assertFalse(game.playOne(0,0));
    }
    @Test
    public void testCopyBoard(){
        game.playOne(0,0);
        Board board = new Board<FieldType>(3, 3, FieldType.Empty);
        board.setField(0,0, FieldType.Cross);

        assertArrayEquals(game.copyBoard().getFields(), board.getFields());
    }
    @Test
    public void testCopyEmptyBoard(){
        Board<FieldType> board = new Board<FieldType>(3, 3, FieldType.Empty);

        assertArrayEquals(game.copyBoard().getFields(), board.getFields());
    }
    @Test
    public void testCheckIsGameEndedWhenPlayerOneWin(){
        game.playOne(0,0);
        game.playOne(1,1);
        game.playOne(2,2);

        assertTrue(game.isEnd());
    }
    @Test
    public void testCheckIsGameEndedWhenBoardEmpty(){
        assertFalse(game.isEnd());
    }
    @Test
    public void testCheckIsGameEndedWhenBoardFullDraw(){
        game.playOne(0,0);
        game.playOne(1,1);
        game.playOne(1,2);
        game.playOne(2,1);
        game.playTwo(2,2);
        game.playTwo(1,0);
        game.playTwo(2,0);
        game.playTwo(0,1);
        game.playTwo(0,2);

        assertTrue(game.isEnd());
    }
}
