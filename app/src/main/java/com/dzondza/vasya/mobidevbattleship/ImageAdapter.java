package com.dzondza.vasya.mobidevbattleship;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Adapter for GridView, that is field for ships
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private FieldCreation mFieldCreation = new FieldCreation();

    private int[] finishedField = mFieldCreation.finalField();

    ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return finishedField.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView fieldItem;
        if (convertView == null) {
            fieldItem = new ImageView(mContext);
            fieldItem.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
            fieldItem.setScaleType(ImageView.ScaleType.CENTER_CROP);
            fieldItem.setPadding(15, 15, 15, 15);
        } else {
            fieldItem = (ImageView) convertView;
        }
        fieldItem.setImageResource(finishedField[position]);
        return fieldItem;
    }
}