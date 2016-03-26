package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dmitry.JokeTeller;
import com.dyarygin.jokeandroidlibrary.JokeActivity;


public class MainActivity extends ActionBarActivity implements SyncInterface {

    EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
    public String jokeForIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeForIntent = null;

        // Passing a listener from EndpointsAsyncTask
        endpointsAsyncTask.listener = this;
        endpointsAsyncTask.execute();
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

    public void tellJoke(View view){
        JokeTeller jokeTeller = new JokeTeller();
        Toast.makeText(this, jokeTeller.tellJokes(), Toast.LENGTH_SHORT).show();
    }

    public void launchLibraryActivity(View view){
        Intent myIntent = new Intent(this, JokeActivity.class);
        if (jokeForIntent != null) {
            myIntent.putExtra("joke", jokeForIntent);
            startActivity(myIntent);
        } else {
            // Some handling
        }
    }

    @Override
    public void onTaskCompleted(String result) {
        jokeForIntent = result;
    }
}
