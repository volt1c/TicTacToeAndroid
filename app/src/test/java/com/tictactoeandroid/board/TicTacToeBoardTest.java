package com.tictactoeandroid.board;

import com.tictactoeandroid.game.Play;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TicTacToeBoardTest {
    TicTacToeBoard gameBoard;

    @Before
    public void init(){
        gameBoard = new TicTacToeBoard();
    }
    @Test
    public void testSetCircleOnEmptyFieldAndTryOverwriteCross(){
        assertTrue(gameBoard.play(new Play(0,0, FieldType.Circle)));
        assertFalse(gameBoard.play(new Play(0,0, FieldType.Cross)));
    }
    @Test
    public void testSetCrossOnEmptyFieldAndTryOverwriteCircle(){
        assertTrue(gameBoard.play(new Play(0,0, FieldType.Cross)));
        assertFalse(gameBoard.play(new Play(0,0, FieldType.Circle)));
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
        gameBoard.play(new Play(0,0, FieldType.Circle));
        gameBoard.play(new Play(2,2, FieldType.Cross));

        assertEquals(gameBoard.getGameBoard().getField(0, 0), FieldType.Circle);
        assertEquals(gameBoard.getGameBoard().getField(2, 2), FieldType.Cross);

        gameBoard.cancelLastPlay();

        assertEquals(gameBoard.getGameBoard().getField(2, 2), FieldType.Empty);
    }
}
