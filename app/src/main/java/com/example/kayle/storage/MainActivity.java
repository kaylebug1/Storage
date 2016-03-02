package com.example.kayle.storage;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * This is the main activity. We are going to put ALLLLLL our code here
 * @author Steve, Kayle, and "Steve"
 */
public class MainActivity extends AppCompatActivity {
    /**The textbox with incrementing value*/
    TextView t;
    /** Not sure if this is necessary. But it should help us update GUI state */
    Handler mHandle = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t = (TextView) findViewById(R.id.textBox);
        t.setText("0");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.advanceButton).setOnClickListener(new Advance());
        findViewById(R.id.saveButton).setOnClickListener(new SaveCount());
    }

    /**
     * This does its own thing. We didn't make this code
     *
     * @param menu Probably an options menu
     * @return true, apparently
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     *  Same here as with onCreateOptionsMenu
     * @param item Probably the item selected from the menu
     * @return sometimes the onOptionsItemSelected method of the super class, sometimes not.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This handles the SaveCount event, triggered by hitting the Save button
     */
    private class SaveCount implements Runnable,View.OnClickListener {
        @Override
        public void run() {

        }

        @Override
        public void onClick(View v){
            mHandle.post(this);
        }
    }


    /**
     * This handles the Advance event, triggered by hitting the Advance button
     */
    private class Advance implements Runnable, View.OnClickListener {
        @Override
        public void run(){
            int num = Integer.parseInt(t.getText().toString());
            num++;
            t.setText(String.valueOf(num));
        }

        @Override
        public void onClick(View v) {
            mHandle.post(this);
        }
    }

}
