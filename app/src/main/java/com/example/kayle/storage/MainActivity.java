package com.example.kayle.storage;

import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity {
    TextView t;
    Handler mHandle = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t = (TextView) findViewById(R.id.textBox);
        t.setText(0);
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

        SharedPreferences savedValue = getSharedPreferences("MyPrefsFile", 0);
        int savedInt = savedValue.getInt("intPref", 0);
        t.setText(savedInt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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

    private class SaveCount implements Runnable,View.OnClickListener {
        @Override
        public void run() {
            SharedPreferences toBeSaved = getSharedPreferences("MyPrefsFile", 0);
            SharedPreferences.Editor editor = toBeSaved.edit();
            editor.putInt("intPref", Integer.parseInt(t.getText().toString()));

            editor.commit();
        }

        @Override
        public void onClick(View v){
            mHandle.post(this);
        }
    }

    private class Advance implements Runnable, View.OnClickListener {
        @Override
        public void run(){
            int num = Integer.parseInt(t.getText().toString());
            num++;
            t.setText(num);

        }

        @Override
        public void onClick(View v) {
            mHandle.post(this);
        }
    }

}
