package com.dzondza.vasya.mobidevbattleship;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *     To run these tests, change modifiers of - boolean isAvailablePlace(int position, int[] availableField)
 *     and int[] createNewField() methods in FieldCreation class to more open and uncomment methods
 *     in this class.
 */
public class MyUnitTests {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

//    @Test
//    public void isCorrectPosition() {
//        FieldCreation fieldCreation = new FieldCreation();
//        int[] newField = fieldCreation.createNewField();
//
//        assertEquals(true, fieldCreation.isAvailablePlace(1, newField));
//        assertEquals(true, fieldCreation.isAvailablePlace(85, newField));
//        assertEquals(true, fieldCreation.isAvailablePlace(99, newField));
//        assertEquals(true, fieldCreation.isAvailablePlace(7, newField));
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void isWrongPosition() {
//        FieldCreation fieldCreation = new FieldCreation();
//        int[] newField = fieldCreation.createNewField();
//
//        fieldCreation.isAvailablePlace(-1, newField);
//        fieldCreation.isAvailablePlace(100, newField);
//    }
}