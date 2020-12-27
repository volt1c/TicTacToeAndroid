package com.tictactoeandroid.board;

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
    public void testSetCircleOnEmptyFieldAndTryOverwrite(){
        assertTrue(gameBoard.playField(0, 0, FieldType.Circle));
        assertFalse(gameBoard.playField(0, 0, FieldType.Cross));
    }
    @Test
    public void testGetGameBoard(){
        FieldType[][] board = new FieldType[3][3];
        for (FieldType[] e: board)
            Arrays.fill(e, FieldType.Empty);

        assertEquals(gameBoard.getGameBoard(), board);
    }
}
