package com.tictactoeandroid.player;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PlayerFactoryTest {
    PlayerFactory factory;
    @Before
    public void init(){
        factory = new PlayerFactory();
    }

    @Test
    public void testGetAIPlayer(){

    }
}
