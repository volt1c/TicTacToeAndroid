package com.tictactoeandroid.game;

import com.tictactoeandroid.board.FieldType;

public class Play {
    public int width;
    public int height;
    public FieldType fieldType;

    public Play(int width, int height, FieldType fieldType){
        this.width = width;
        this.height = height;
        this.fieldType = fieldType;
    }
}