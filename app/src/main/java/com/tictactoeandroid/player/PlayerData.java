package com.tictactoeandroid.player;

public class PlayerData {
    public final PlayerType type;
    public final PlayerMark mark;

    public PlayerData(PlayerType type, PlayerMark mark){
        this.type = type;
        this.mark = mark;
    }
}
