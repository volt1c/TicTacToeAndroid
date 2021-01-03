package com.tictactoeandroid.board;

import com.tictactoeandroid.game.TicTacToeGameBoard;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TicTacToeGameBoardTest {
    TicTacToeGameBoard gameBoard;

    @Before
    public void init(){
        gameBoard = new TicTacToeGameBoard();
    }
    @Test
    public void testSetCircleOnEmptyFieldAndTryOverwriteCross(){
        assertTrue(gameBoard.playCircle(0, 0));
        assertFalse(gameBoard.playCross(0, 0));
    }
    @Test
    public void testSetCrossOnEmptyFieldAndTryOverwriteCircle(){
        assertTrue(gameBoard.playCircle(0, 0));
        assertFalse(gameBoard.playCross(0, 0));
    }
    @Test
    public void testGetGameBoard(){
        FieldType[][] board = new FieldType[3][3];
        for (FieldType[] e: board)
            Arrays.fill(e, FieldType.Empty);

        assertEquals(gameBoard.getGameBoard().getFields(), board);
    }
    @Test
    public void testPlayFieldsThenCancelLastPlay(){
        gameBoard.playCircle(0,0);
        gameBoard.playCross(2, 2);

        assertEquals(gameBoard.getGameBoard().getField(0, 0), FieldType.Circle);
        assertEquals(gameBoard.getGameBoard().getField(2, 2), FieldType.Cross);

        gameBoard.cancelLastPlay();

        assertEquals(gameBoard.getGameBoard().getField(2, 2), FieldType.Empty);
    }
}
