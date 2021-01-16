package com.tictactoeandroid.board;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FieldTypeTest {
    @Test
    public void testGetFieldsByValue() {
        Assert.assertEquals(FieldType.Empty,  FieldType.getByMark(' '));
        assertEquals(FieldType.Circle, FieldType.getByMark('O'));
        assertEquals(FieldType.Cross,  FieldType.getByMark('X'));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTryGetFieldsByWrongValue() {
        FieldType.getByMark('☺');
    }
}
