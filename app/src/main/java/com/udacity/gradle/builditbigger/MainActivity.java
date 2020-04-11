package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.doiliomatsinhe.androidlibrary.JokeActivity;

import static com.doiliomatsinhe.androidlibrary.JokeActivity.JOKE;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button jokeButton = findViewById(R.id.button_text);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCallToGetJoke();
            }
        });


    }

    private void makeCallToGetJoke() {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new OnEventListener<String>() {
            @Override
            public void onSuccess(String message) {
                Log.d(TAG, getString(R.string.success) + message);

                Intent i = new Intent(getApplicationContext(), JokeActivity.class);
                i.putExtra(JOKE, message);
                startActivity(i);
            }

            @Override
            public void onFailure(Exception e) {

                Log.d(TAG, getString(R.string.failure) + e.getMessage());

            }
        });
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

}
