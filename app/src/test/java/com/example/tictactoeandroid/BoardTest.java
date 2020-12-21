package com.example.tictactoeandroid;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
        board.fill(-1);

        assertEquals(board.getFields(), new int[][]{
                {-1,-1,-1},
                {-1,-1,-1},
                {-1,-1,-1},
                {-1,-1,-1}
        });
    }
    @Test
    public void testGetSizeByChar(){
        assertEquals(board.size('r'),3);
        assertEquals(board.size('c'),4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSizeByIllegalArgument(){
        board.size('x');

    }
}
