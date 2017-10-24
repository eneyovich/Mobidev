package com.dzondza.vasya.mobidevbattleship;

import com.dzondza.vasya.mobidevbattleship.Presenter.Presenter;
import com.dzondza.vasya.mobidevbattleship.Presenter.PresenterImpl;

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

    @Test
    public void isCorrectLength() {
        Presenter presenter = new PresenterImpl();
        int fieldLength = presenter.getFieldWithShips().length;
        assertEquals(100, fieldLength);
    }
}