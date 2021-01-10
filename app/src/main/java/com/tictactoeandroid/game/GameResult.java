package com.tictactoeandroid.game;

public enum GameResult {
    None(-1),
    WinOne(0),
    WinTwo(1),
    Draw(2);

    public final int i;

    GameResult(int i) {
        this.i = i;
    }

    public static GameResult findByInt(int value) {
        for (GameResult e : values()) {
            if (e.i == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
}
