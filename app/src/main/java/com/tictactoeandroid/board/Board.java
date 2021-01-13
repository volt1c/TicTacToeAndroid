package com.tictactoeandroid.board;

import java.util.Arrays;

public class Board<TField> {
    private Object[][] fields;
    private TField defValue;
    private int width;
    private int height;

    public void fill(TField value){
        for (Object[] row : fields) {
            Arrays.fill(row, value);
        }
    }
    public Board<TField> clone(){
        return new Board<TField>(width, height, fields, defValue);
    }
    public int size(char t){

        if (fields.length == 0)
            return 0;
        else if (t == 'w')
            return width;
        else if (t == 'h')
            return height;
        throw new IllegalArgumentException();
    }
    public TField[][] getFields() {
        return (TField[][]) fields;
    }
    public TField getField(int width, int height){
        return (TField) fields[height][width];
    }
    public void setField(int width, int height, TField value){
        this.fields[height][width] = value;
    }
    public  boolean isFieldEmpty(int width, int height){
        return getField(width, height) == defValue;
    }
    public boolean isEmpty(){
        return Arrays.deepEquals(fields, new Board<TField>(width, height, defValue).getFields());
    }
    public boolean isFull(){
        for (int i = 0; i < height; ++i)
            for (int j = 0; j < width; ++j)
                if (fields[i][j] == defValue)
                    return false;
        return true;
    }

    public Board(int width, int height,TField defValue){
        this.fields = new Object[height][width];
        this.defValue = defValue;
        this.width = width;
        this.height = height;
        fill(defValue);
    }
    protected Board(int width, int height, Object[][] fields,TField defValue){
        this.width = width;
        this.height = height;
        this.fields = fields;
        this.defValue = defValue;
    }

}