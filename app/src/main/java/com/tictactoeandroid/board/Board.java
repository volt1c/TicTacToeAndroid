package com.tictactoeandroid.board;

import java.util.Arrays;

public class Board<TField> {
    private Object[][] fields;

    public Board(int width, int height){
        this.fields = new Object[height][width];
    }

    public void fill(TField value){
        for (Object[] row : fields) {
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

    public TField[][] getFields() {
        return (TField[][]) fields;
    }

    public TField getField(int width, int height){
        return (TField) fields[height][width];
    }

    public void setFields(TField[][] fields) {
        this.fields = fields;
    }

    public void setField(int width, int height, TField value){
        this.fields[height][width] = value;
    }
}