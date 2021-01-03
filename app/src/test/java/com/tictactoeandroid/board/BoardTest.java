package com.tictactoeandroid.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BoardTest {
    Board board;
    @Before
    public void init(){
         board = new Board(3,4, 0);
    }
    @Test
    public void testSetAllDefault(){
        int[][] correct = new int[4][3];
        for (int[] e: correct)
            Arrays.fill(e, -1);
        board.fill(-1);

        assertEquals(board.getFields(), correct);
    }
    @Test
    public void testGetSizeByChar(){
        assertEquals(board.size('w'),3); // W-idth
        assertEquals(board.size('h'),4); // H-eight
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSizeByIllegalArgument(){
        board.size('x');
    }

    @Test
    public void testClone(){
        Board clone = board.clone();

        assertEquals(board.getFields(), clone.getFields());
    }

    @Test
    public void testIsEmptyWhenEmpty(){
        assertTrue(board.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty(){
        board.setField(0, 0,1);

        assertFalse(board.isEmpty());
    }

}
