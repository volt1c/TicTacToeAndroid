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
        Assert.assertEquals(FieldType.Empty,  FieldType.byValue(-1));
        assertEquals(FieldType.Circle, FieldType.byValue(0));
        assertEquals(FieldType.Cross,  FieldType.byValue(1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTryGetFieldsByWrongValue() {
        FieldType.byValue(Integer.MAX_VALUE);
    }
}
