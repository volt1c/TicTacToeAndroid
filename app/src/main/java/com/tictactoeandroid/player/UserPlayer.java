package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;

public class UserPlayer implements Player{
    PlayerMark mark;
    // TODO
    public Play play(Board board, int x, int y) {
        return new Play(x, y, mark.mark);
    }

    public UserPlayer(PlayerMark mark){
        this.mark = mark;
    }
}
