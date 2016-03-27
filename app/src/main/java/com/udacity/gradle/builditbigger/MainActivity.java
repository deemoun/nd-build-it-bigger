package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dmitry.JokeTeller;
import com.dyarygin.jokeandroidlibrary.JokeActivity;


public class MainActivity extends ActionBarActivity implements SyncInterface {

    public String jokeForIntent;
    EndpointsAsyncTask endpointsAsyncTask;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onStart() {
        super.onStart();

        jokeForIntent = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();

        if (endpointsAsyncTask.getStatus() == AsyncTask.Status.FINISHED){

            // If AsyncTask already executed, clear everything
            endpointsAsyncTask = null;
            try {
                endpointsAsyncTask.listener = null;
                endpointsAsyncTask.execute();
            } catch (NullPointerException e){
                System.out.println("NPE exception " + e.getLocalizedMessage());
            }
        } else {
            endpointsAsyncTask.listener = this;
            endpointsAsyncTask.execute();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            System.out.print("Nothing to send in Intent");
        }
    }


    @Override
    public void onTaskCompleted(String result) {
        if(result != null) {
            jokeForIntent = result;
        } else {
            System.out.print("Result is null! Was AsyncTask executed?");
        }
    }
}
