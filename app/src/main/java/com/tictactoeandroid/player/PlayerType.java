package com.tictactoeandroid.player;

public enum PlayerType {
    RandomAI(0),
    User(1);

    private final int index;

    public static PlayerType fromInt(int value)
            throws IllegalArgumentException{
        for (PlayerType e : values()) {
            if (e.index == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
    public int toInt(){
        return index;
    }

    PlayerType(int index) {
        this.index = index;
    }
}
