package com.tictactoeandroid.player;

import com.tictactoeandroid.board.FieldType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UserPlayerTest {
    UserPlayer player;
    @Before
    public void init(){
        player = new UserPlayer(FieldType.Cross);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentForConstructor(){
        new UserPlayer(FieldType.Empty);
    }
    @Test
    public void testGeneratePlayObjectByCoordinates(){
        player.play(null, 0, 0);
    }
}
