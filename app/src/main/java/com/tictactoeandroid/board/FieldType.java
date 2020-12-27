package com.tictactoeandroid.board;

public enum FieldType {
    Empty(-1),
    Circle(0),
    Cross(1);

    final int value;

    private FieldType(int i) {
        this.value = i;
    }

    public static FieldType byValue(int value) {
        for (FieldType e : values()) {
            if (e.value == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
}
