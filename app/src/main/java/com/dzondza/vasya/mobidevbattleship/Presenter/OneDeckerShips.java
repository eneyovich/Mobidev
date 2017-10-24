package com.dzondza.vasya.mobidevbattleship.Presenter;

import com.dzondza.vasya.mobidevbattleship.R;

import java.util.Random;

import static com.dzondza.vasya.mobidevbattleship.Constants.LAST_POSITION;

/**
 * adds 1-decker ships to field
 */

class OneDeckerShips {

    private final Presenter mPresenter = new PresenterImpl();

    //creates 4 random 1-decker ships
    int[] add1DeckerShipsToField(int[] availableField) {
        Random randomShipsLocation = new Random();
        int shipsNumber = 4;

        while (shipsNumber > 0) {
            int shipPosition = randomShipsLocation.nextInt(LAST_POSITION);
            if (mPresenter.isAvailablePlace(shipPosition, availableField)) {
                availableField[shipPosition] = R.drawable.ship_square;
                shipsNumber --;
            }
        }
        return availableField;
    }
}