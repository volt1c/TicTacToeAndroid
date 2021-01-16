package com.tictactoeandroid.board;

public enum FieldType {
    Empty(' '),
    Circle('O'),
    Cross('X');

    public final char mark;
    public static FieldType getByMark(char value) {
        for (FieldType e : values()) {
            if (e.mark == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
    FieldType(char c) {
        this.mark = c;
    }
}