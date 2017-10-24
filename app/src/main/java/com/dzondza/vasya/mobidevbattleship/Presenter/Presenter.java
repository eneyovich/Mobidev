package com.dzondza.vasya.mobidevbattleship.Presenter;

/**
 * Presenter interface in MVP.
 */

public interface Presenter {

    boolean isAvailablePlace(int position, int[] field);

    void createField();

    int[] getFieldWithShips();
}