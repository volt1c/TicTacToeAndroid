package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;

public enum PlayerType {
    RandomAI(0),
    User(1);

    public final int id;

    public static PlayerType findByInt(int value)
            throws IllegalArgumentException{
        for (PlayerType e : values()) {
            if (e.id == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
    PlayerType(int id) {
        this.id = id;
    }
}
