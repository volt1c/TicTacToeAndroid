package com.tictactoeandroid.board;

public enum FieldType {
    Empty(' '),
    Circle('O'),
    Cross('X');

    public final char aChar;

    private FieldType(char c) {
        this.aChar = c;
    }

    public static FieldType byValue(char value) {
        for (FieldType e : values()) {
            if (e.aChar == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
}
