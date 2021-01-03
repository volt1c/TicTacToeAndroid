package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.game.Play;

public interface Player {
    Play play(Object[][] board);

}
