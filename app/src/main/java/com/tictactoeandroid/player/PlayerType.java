package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;

public enum PlayerType {
    RandomAI(0),
    User(1);

    public final int id;
    public FieldType type;


    PlayerType(int id) {
        this.id = id;
    }

    void setType(FieldType type)
        throws IllegalArgumentException{
        if (type == FieldType.Empty)
            throw new IllegalArgumentException();
        this.type = type;
    }

    public static PlayerType findByInt(int value)
            throws IllegalArgumentException{
        for (PlayerType e : values()) {
            if (e.id == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
}
