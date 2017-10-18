package com.dzondza.vasya.mobidevbattleship;

import java.util.Random;

/**
 * creates field with ships
 */

public class FieldCreation {

    //returns final field, filled with all ships
    protected int[] finalField() {
        int[] clearField = createNewField();

        int[] fieldWithFewDeckerShips = addFewDeckerShipsToField(clearField);

        int[] finalField = add1DeckerShips(fieldWithFewDeckerShips);

        return finalField;
    }


    //creates field for ships with positions from 0 to 99
    private int[] createNewField() {
        int[] field = new int[100];
        for (int i = 0; i < field.length; i++) {
            field[i] = R.drawable.no_ship_square;
        }
        return field;
    }


    //creates horizontal and vertical 2-, 3- and 4-decker ships
    private void fewDeckerShip(int[] field, int decksNumber, boolean isHorizontal) {
        Random randomLocation = new Random();
        boolean isNotShipCreated = true;

        while (isNotShipCreated) {
            boolean isAnyAvailablePlaceForShip = false;
            int shipPosition;

            if (isHorizontal) {
                shipPosition = 10 * randomLocation.nextInt(9) + randomLocation.nextInt(10 - decksNumber);
            } else {
                shipPosition = 10 * randomLocation.nextInt(10 - decksNumber) + randomLocation.nextInt(9);
            }

            switch (decksNumber) {
                //checks available place for HORIZONTAL 2-decker ships at positions: from 0,1 to 98,99
                //or checks available place for VERTICAL 2-decker ships at positions: from 0,10 to 89,99
                case 2:
                    if (isHorizontal) {
                        isAnyAvailablePlaceForShip = isAvailablePlace(shipPosition, field) && isAvailablePlace(shipPosition + 1, field);
                    } else {
                        isAnyAvailablePlaceForShip = isAvailablePlace(shipPosition, field)
                                && isAvailablePlace(shipPosition + 10, field);
                    }
                    break;
                //checks available place for HORIZONTAL 3-decker ships at positions: from 0-1-2 to 97-98-99
                //or checks available place for VERTICAL 3-decker ships at positions: from 0-10-20 to 79-89-99
                case 3:
                    if (isHorizontal) {
                        isAnyAvailablePlaceForShip = isAvailablePlace(shipPosition, field) && isAvailablePlace(shipPosition + 1, field)
                                && isAvailablePlace(shipPosition + 2, field);
                    } else {
                        isAnyAvailablePlaceForShip = isAvailablePlace(shipPosition, field)
                                && isAvailablePlace(shipPosition + 10, field) && isAvailablePlace(shipPosition + 20, field);
                    }
                    break;
                //checks available place for HORIZONTAL 4-decker ship at positions: from 0-1-2-3 to 96-97-98-99
                //checks available place for VERTICAL 4-decker ship at positions: from 0-10-20-30 to 69-79-89-99
                case 4:
                    if (isHorizontal) {
                        isAnyAvailablePlaceForShip = isAvailablePlace(shipPosition, field) && isAvailablePlace(shipPosition + 1, field)
                                && isAvailablePlace(shipPosition + 2, field) && isAvailablePlace(shipPosition + 3, field);
                    } else {
                        isAnyAvailablePlaceForShip = isAvailablePlace(shipPosition, field)
                                && isAvailablePlace(shipPosition + 10, field) && isAvailablePlace(shipPosition + 20, field)
                                && isAvailablePlace(shipPosition + 30, field);
                    }
                    break;
            }
            if (isAnyAvailablePlaceForShip) {
                for (int i = 0; i < decksNumber; i++) {
                    if (isHorizontal) {
                        //inserts horizontal ship's decks in [shipPosition + i]
                        field[shipPosition + i] = R.drawable.ship_square;
                    } else {
                        //inserts vertical ship's decks in [shipPosition + 10 * i]
                        field[shipPosition + 10 * i] = R.drawable.ship_square;
                    }
                }
                isNotShipCreated = false;
            }
        }
    }


    //adds 2-, 3- and 4- decker ships to field
    private int[] addFewDeckerShipsToField(int[] shipsField) {
        Random randomVerticalOrHorizontalShip = new Random();

        int shipsNumber = 0;

        while (shipsNumber < 6) {
            //creates random horizontal(randomVerticalHorizontalShip is even number)
            // or vertical(randomVerticalHorizontalShip is odd number) ship
            boolean isHorizontal = randomVerticalOrHorizontalShip.nextInt(1000) % 2 == 0;

                switch (shipsNumber) {
                    case 0:
                        fewDeckerShip(shipsField, 4, isHorizontal);
                        break;
                    case 1:
                    case 2:
                        fewDeckerShip(shipsField, 3, isHorizontal);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        fewDeckerShip(shipsField, 2, isHorizontal);
                        break;
                }

            shipsNumber ++;
        }
        return shipsField;
    }


    //creates 4 random 1-decker ships
    private int[] add1DeckerShips(int[] array) {
        Random randomShipsLocation = new Random();
        int shipsNumber = 4;
        while (shipsNumber > 0) {
            int shipPosition = randomShipsLocation.nextInt(99);
            if (isAvailablePlace(shipPosition, array)) {
                array[shipPosition] = R.drawable.ship_square;
                shipsNumber --;
            }
        }
        return array;
    }


    //returns true if position is available for  ship's deck
    private boolean isAvailablePlace(int position, int[] availableField) {

        if (position == 0) {
            return (availableField[0] == R.drawable.no_ship_square && availableField[1] == R.drawable.no_ship_square
                    && availableField[10] == R.drawable.no_ship_square && availableField[11] == R.drawable.no_ship_square);

        } else if (position >= 1 && position <= 8) {
            return (availableField[position] == R.drawable.no_ship_square && availableField[position - 1] == R.drawable.no_ship_square
                    && availableField[position + 1] == R.drawable.no_ship_square && availableField[position + 9] == R.drawable.no_ship_square
                    && availableField[position + 10] == R.drawable.no_ship_square && availableField[position + 11] == R.drawable.no_ship_square);

        } else if (position == 9) {
            return  (availableField[position] == R.drawable.no_ship_square && availableField[position - 1] == R.drawable.no_ship_square
                    && availableField[position + 9] == R.drawable.no_ship_square && availableField[position + 10] == R.drawable.no_ship_square);

        } else if (position == 90) {
            return (availableField[position] == R.drawable.no_ship_square && availableField[position + 1] == R.drawable.no_ship_square
                    && availableField[position - 10] == R.drawable.no_ship_square && availableField[position - 9] == R.drawable.no_ship_square);

        } else if (position >= 91 && position <= 98) {
            return (availableField[position] == R.drawable.no_ship_square && availableField[position - 1] == R.drawable.no_ship_square
                    && availableField[position + 1] == R.drawable.no_ship_square && availableField[position - 9] == R.drawable.no_ship_square
                    && availableField[position - 10] == R.drawable.no_ship_square && availableField[position - 11] == R.drawable.no_ship_square);

        } else if (position == 99) {
            return (availableField[99] == R.drawable.no_ship_square && availableField[98] == R.drawable.no_ship_square
                    && availableField[88] == R.drawable.no_ship_square && availableField[89] == R.drawable.no_ship_square);

        } else if (position % 10 == 0) {
            return (availableField[position] == R.drawable.no_ship_square && availableField[position + 1] == R.drawable.no_ship_square
                    && availableField[position - 10] == R.drawable.no_ship_square && availableField[position - 9] == R.drawable.no_ship_square
                    && availableField[position + 10] == R.drawable.no_ship_square && availableField[position + 11] == R.drawable.no_ship_square);

        } else  if ( (position - 9) % 10 == 0) {
            return (availableField[position] == R.drawable.no_ship_square && availableField[position - 1] == R.drawable.no_ship_square
                    && availableField[position + 10] == R.drawable.no_ship_square && availableField[position + 9] == R.drawable.no_ship_square
                    && availableField[position - 10] == R.drawable.no_ship_square && availableField[position - 11] == R.drawable.no_ship_square);
        } else {
            return (availableField[position] == R.drawable.no_ship_square && availableField[position + 1] == R.drawable.no_ship_square
                    && availableField[position - 1] == R.drawable.no_ship_square && availableField[position + 9] == R.drawable.no_ship_square
                    && availableField[position + 10] == R.drawable.no_ship_square && availableField[position + 11] == R.drawable.no_ship_square
                    && availableField[position - 9] == R.drawable.no_ship_square && availableField[position - 10] == R.drawable.no_ship_square
                    && availableField[position - 11] == R.drawable.no_ship_square);
        }
    }
}