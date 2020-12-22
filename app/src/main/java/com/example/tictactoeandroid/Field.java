package com.example.tictactoeandroid;

public enum Field {
    Empty(-1),
    Circle(0),
    Cross(1);

    final int value;

    private Field(int i) {
        this.value = i;
    }

    public static Field byValue(int value) {
        for (Field e : values()) {
            if (e.value == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
}
