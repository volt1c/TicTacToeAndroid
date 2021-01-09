package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;

public class UserPlayer implements Player{
    FieldType type;
    // TODO
    public Play play(Board board, int x, int y) {
        return new Play(x, y, type);
    }

    public UserPlayer(FieldType type){
        if(type == FieldType.Empty)
            throw new IllegalArgumentException();
        this.type = type;
    }
}
