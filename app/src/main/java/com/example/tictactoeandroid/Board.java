package com.example.tictactoeandroid;

import java.util.Arrays;

public class Board {
    private int[][] fields;

    public Board(int width, int height){
        this.fields = new int[height][width];
    }

    public void fill(int value){
        if (fields.length == 0)
            return;

        for (int[] row : fields) {
            Arrays.fill(row, value);
        }
    }

    public int size(char t){
        if (t != 'r' && t != 'c')
            throw new IllegalArgumentException();

        if (fields.length == 0)
            return 0;
        else if (t == 'r')
            return fields[0].length;
        return fields.length;
    }

    public int[][] getFields() {
        return fields;
    }

    public int getField(int width, int height){
        return fields[height][width];
    }

    public void setFields(int[][] fields) {
        this.fields = fields;
    }

    public void setField(int width, int height, int value){
        this.fields[height][width] = value;
    }
}