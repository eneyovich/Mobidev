package com.dzondza.vasya.mobidevbattleship.Model;

import static com.dzondza.vasya.mobidevbattleship.Constants.FIELD_LENGTH;

/**
 * contains field for ships
 */

public class ModelImpl implements Model{
    private int[] field = new int[FIELD_LENGTH];

    public int[] getField() {
        return field;
    }

    public void setField(int[] field) {
        this.field = field;
    }
}