package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RandomAIPlayerTest {
    RandomAIPlayer player;
    @Before
    public void init(){
        player = new RandomAIPlayer(PlayerMark.Cross);
    }
    @Test
    public void testPlayRandomFieldWhenOneFieldEmpty(){
        Board<FieldType> board = new Board<FieldType>(3, 3, FieldType.Empty);
        board.fill(FieldType.Circle);
        board.setField(0,0, FieldType.Empty);

        Play play = player.play(board, -1, -1);

        assertEquals(0, play.width);
        assertEquals(0, play.height);
        assertEquals(FieldType.Cross, play.fieldType);
    }
}
