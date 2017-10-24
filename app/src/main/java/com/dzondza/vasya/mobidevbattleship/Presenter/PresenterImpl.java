package com.dzondza.vasya.mobidevbattleship.Presenter;

import com.dzondza.vasya.mobidevbattleship.Model.ModelImpl;
import com.dzondza.vasya.mobidevbattleship.Model.Model;
import com.dzondza.vasya.mobidevbattleship.R;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.dzondza.vasya.mobidevbattleship.Constants.FIELD_LENGTH;
import static com.dzondza.vasya.mobidevbattleship.Constants.LAST_IN_LINE;
import static com.dzondza.vasya.mobidevbattleship.Constants.LINE_LENGTH;


/**
 * Presenter implementation, with field for ships
 */

public class PresenterImpl implements Presenter {

    private final Model mModel = new ModelImpl();

    //sets final field, filled with all ships to Model
    public void createField() {
        int[] finalField = new FieldCreation().createFieldWithShips();
        mModel.setField(finalField);
    }


    //returns true if position is available for ship's deck in the square field
    public boolean isAvailablePlace(int position, int[] field) {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        Future<Boolean> isAvailablePlace = threadPool.submit(() -> {

            int up = position - LINE_LENGTH >= 0 && position - LINE_LENGTH < FIELD_LENGTH ? position - LINE_LENGTH : position;
            int upLeft = up - 1 >= 0 && up - 1 < FIELD_LENGTH ? up - 1 : position;
            int upRight = up + 1 >= 0 && up + 1 < FIELD_LENGTH ? up + 1 : position;

            int down = position + LINE_LENGTH >= 0 && position + LINE_LENGTH < FIELD_LENGTH ? position + LINE_LENGTH : position;
            int downLeft = down - 1 >= 0 && down - 1 < FIELD_LENGTH ? down - 1 : position;
            int downRight = down + 1 >= 0 && down + 1 < FIELD_LENGTH ? down + 1 : position;

            int next = position + 1 >= 0 && position + 1 < FIELD_LENGTH ? position + 1 : position;
            int prev = position - 1 >= 0 && position - 1 < FIELD_LENGTH ? position - 1 : position;


            if (position % LINE_LENGTH == 0) {
                return (field[position] == R.drawable.no_ship_square && field[next] == R.drawable.no_ship_square
                        && field[up] == R.drawable.no_ship_square && field[upRight] == R.drawable.no_ship_square
                        && field[down] == R.drawable.no_ship_square && field[downRight] == R.drawable.no_ship_square);

            } else if ((position - LAST_IN_LINE) % LINE_LENGTH == 0) {
                return (field[position] == R.drawable.no_ship_square && field[prev] == R.drawable.no_ship_square
                        && field[down] == R.drawable.no_ship_square && field[downLeft] == R.drawable.no_ship_square
                        && field[up] == R.drawable.no_ship_square && field[upLeft] == R.drawable.no_ship_square);
            } else {
                return (field[position] == R.drawable.no_ship_square && field[next] == R.drawable.no_ship_square
                        && field[prev] == R.drawable.no_ship_square && field[downLeft] == R.drawable.no_ship_square
                        && field[down] == R.drawable.no_ship_square && field[downRight] == R.drawable.no_ship_square
                        && field[upRight] == R.drawable.no_ship_square && field[up] == R.drawable.no_ship_square
                        && field[upLeft] == R.drawable.no_ship_square);
                }
            });

        try {
            return isAvailablePlace.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }


    public int[] getFieldWithShips() {
        createField();
        return mModel.getField();
    }
}