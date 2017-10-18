package com.dzondza.vasya.mobidevbattleship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridView;

/**
 * Application's MainActivity
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playingFieldInitialize();

        refreshButtonInitialize();
    }


    private void playingFieldInitialize() {
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));
    }


    private void refreshButtonInitialize() {
        Button button = (Button) findViewById(R.id.button_refresh);

        button.setOnClickListener(v -> recreate());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.exit_settings) {
            System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}