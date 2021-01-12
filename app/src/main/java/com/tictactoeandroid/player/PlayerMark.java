package com.tictactoeandroid.player;

import com.tictactoeandroid.board.FieldType;

public enum PlayerMark {
    Circle(FieldType.Circle),
    Cross(FieldType.Cross);

    public final FieldType mark;

    PlayerMark(FieldType mark) {
        this.mark = mark;
    }
}
