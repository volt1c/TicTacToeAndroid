package com.tictactoeandroid.game;

public enum GameResult {
    None(-1),
    CrossWin(0),
    CircleWin(1),
    Draw(2);

    public final int index;
    public static GameResult getByIndex(int value) {
        for (GameResult e : values()) {
            if (e.index == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
    GameResult(int index) {
        this.index = index;
    }
}
