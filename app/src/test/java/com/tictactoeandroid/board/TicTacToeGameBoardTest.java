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
        assertTrue(gameBoard.playField(0, 0, Field.Circle));
        assertFalse(gameBoard.playField(0, 0, Field.Cross));
    }
    @Test
    public void testGetGameBoard(){
        Field[][] board = new Field[3][3];
        for (Field[] e: board)
            Arrays.fill(e, Field.Empty);

        assertEquals(gameBoard.getGameBoard(), board);
    }
}
