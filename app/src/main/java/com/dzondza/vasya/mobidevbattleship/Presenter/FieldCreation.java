package com.dzondza.vasya.mobidevbattleship.Presenter;

import com.dzondza.vasya.mobidevbattleship.R;

import static com.dzondza.vasya.mobidevbattleship.Constants.FIELD_LENGTH;

/**
 * Creates field with ships
 */

class FieldCreation {

    //returns clear field for ships
    private int[] createNewClearField() {
        int[] field = new int[FIELD_LENGTH];
        for (int i = 0; i < FIELD_LENGTH; i++) {
            field[i] = R.drawable.no_ship_square;
        }
        return field;
    }


    //returns final field, filled with all ships
    int[] createFieldWithShips() {

        int[] clearField = createNewClearField();

        int[] fieldWithFewDeckerShips = new FewDeckerShips().addFewDeckerShipsToField(clearField);

        int[] finalField = new OneDeckerShips().add1DeckerShipsToField(fieldWithFewDeckerShips);

        return finalField;
    }
}