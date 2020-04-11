package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.doiliomatsinhe.androidlibrary.JokeActivity;

import static com.doiliomatsinhe.androidlibrary.JokeActivity.JOKE;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressBar loading;
    private Button jokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loading = findViewById(R.id.progressBar);
        jokeButton = findViewById(R.id.button_text);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoadingIndicator();
                makeCallToGetJoke();
            }
        });


    }

    private void showLoadingIndicator() {
        loading.setVisibility(View.VISIBLE);
        jokeButton.setVisibility(View.GONE);
    }

    private void hideLoadingIndicator() {
        loading.setVisibility(View.GONE);
        jokeButton.setVisibility(View.VISIBLE);
    }

    private void makeCallToGetJoke() {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new OnEventListener<String>() {
            @Override
            public void onSuccess(String message) {
                hideLoadingIndicator();
                Log.d(TAG, getString(R.string.success) + message);

                Intent i = new Intent(getApplicationContext(), JokeActivity.class);
                i.putExtra(JOKE, message);
                startActivity(i);
            }

            @Override
            public void onFailure(Exception e) {
                hideLoadingIndicator();

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
