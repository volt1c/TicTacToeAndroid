package com.tictactoeandroid.player;

import com.tictactoeandroid.board.FieldType;

public enum PlayerMark {
    Circle(FieldType.Circle),
    Cross(FieldType.Cross);

    private final FieldType fieldType;

    public FieldType toFieldType(){
        return this.fieldType;
    }

    PlayerMark(FieldType mark) {
        this.fieldType = mark;
    }
}
