package com.tictactoeandroid.game;

public enum GameResult {
    None(-1),
    CrossWin(0),
    CircleWin(1),
    Draw(2);

    private final int index;
    public static GameResult fromInt(int value) {
        for (GameResult e : values()) {
            if (e.index == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
    public int toInt(){
        return index;
    }

    GameResult(int index) {
        this.index = index;
    }
}
