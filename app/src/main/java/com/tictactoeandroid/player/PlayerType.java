package com.tictactoeandroid.player;

import com.tictactoeandroid.board.Board;
import com.tictactoeandroid.board.FieldType;
import com.tictactoeandroid.game.Play;

public enum PlayerType {
    RandomAI(0),
    User(1);

    public final int id;
    public int x;
    public int y;
    public Board<FieldType> board;

    PlayerType(int id) {
        this.id = id;
    }

    void setValues(int x, int y, Board<FieldType> board){
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public static PlayerType findByInt(char value) {
        for (PlayerType e : values()) {
            if (e.id == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
}
