package com.example.aman.parse;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {

    public int caramount = 0;
    ParseObject Counter = new ParseObject("Counter");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "KNXmdVtjwAnIho2tbL4ESmx9Vb0ZRhjZYqP1DdrF", "uPCNVlsEfsCHQsPdMYeYNwtL49akltBpbNymjtP8");
        Counter.put("CarAmount", caramount);
        Counter.saveInBackground();
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

    public void clickUp(View v){
        caramount++;
        Counter.increment("CarAmount");
        Counter.saveInBackground();
    }
    public void clickDown(View v){
        caramount--;
        Counter.increment("CarAmount", -1);
        Counter.saveInBackground();
    }
}
