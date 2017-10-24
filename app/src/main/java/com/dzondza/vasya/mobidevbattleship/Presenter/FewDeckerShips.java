package com.dzondza.vasya.mobidevbattleship.Presenter;

import com.dzondza.vasya.mobidevbattleship.R;

import java.util.Random;

import static com.dzondza.vasya.mobidevbattleship.Constants.LAST_IN_LINE;
import static com.dzondza.vasya.mobidevbattleship.Constants.LINE_LENGTH;

/**
 * adds 2-,3- and 4-decker ships to field
 */

class FewDeckerShips {

    private final Presenter mPresenter = new PresenterImpl();

    //creates horizontal and vertical 2-, 3- and 4-decker ships
    private void createFewDeckerShips(int[] field, int decksNumber, boolean isHorizontal) {
        Random randomLocation = new Random();
        boolean isNotShipCreated = true;

        while (isNotShipCreated) {
            boolean isAnyAvailablePlaceForShip = true;
            int firstDeckPosition;

            //finds available place for first deck of the HORIZONTAL or VERTICAL i-decker ship
            if (isHorizontal) {
                firstDeckPosition = LINE_LENGTH * randomLocation.nextInt(LAST_IN_LINE) + randomLocation.nextInt(LINE_LENGTH - decksNumber);
            } else {
                firstDeckPosition = LINE_LENGTH * randomLocation.nextInt(LINE_LENGTH - decksNumber) + randomLocation.nextInt(LAST_IN_LINE);
            }

            //checks available place for HORIZONTAL or VERTICAL i-decker ships
            for (int i = 0; i < decksNumber; i++) {
                if (isHorizontal) {
                    isAnyAvailablePlaceForShip = isAnyAvailablePlaceForShip && mPresenter.isAvailablePlace(firstDeckPosition + i, field);
                } else {
                    isAnyAvailablePlaceForShip = isAnyAvailablePlaceForShip && mPresenter.isAvailablePlace(firstDeckPosition + i * LINE_LENGTH, field);
                }
            }

            if (isAnyAvailablePlaceForShip) {
                for (int i = 0; i < decksNumber; i++) {
                    if (isHorizontal) {
                        //inserts horizontal ship's decks in [firstDeckPosition + i]
                        field[firstDeckPosition + i] = R.drawable.ship_square;
                    } else {
                        //inserts vertical ship's decks in [firstDeckPosition + LINE_LENGTH * i]
                        field[firstDeckPosition + LINE_LENGTH * i] = R.drawable.ship_square;
                    }
                }
                isNotShipCreated = false;
            }
        }
    }


    //adds 2-, 3- and 4- decker ships to field
    int[] addFewDeckerShipsToField(int[] shipsField) {

        Random randomVerticalOrHorizontalShip = new Random();
        int shipsNumber = 0;

        while (shipsNumber < 6) {
            //creates random horizontal(if randomVerticalHorizontalShip is even number)
            // or vertical(if randomVerticalHorizontalShip is odd number) ship
            boolean isHorizontal = randomVerticalOrHorizontalShip.nextInt(1000) % 2 == 0;

            if (shipsNumber == 0) {
                createFewDeckerShips(shipsField, 4, isHorizontal);
            } else if (shipsNumber >= 1 && shipsNumber <= 2) {
                createFewDeckerShips(shipsField, 3, isHorizontal);
            } else {
                createFewDeckerShips(shipsField, 2, isHorizontal);
            }
            shipsNumber ++;
        }
        return shipsField;
    }
}