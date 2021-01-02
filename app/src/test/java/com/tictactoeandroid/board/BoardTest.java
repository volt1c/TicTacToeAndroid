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
         board = new Board(3,4);
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
        assertEquals(board.size('r'),3); // row
        assertEquals(board.size('c'),4); // column
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
}
