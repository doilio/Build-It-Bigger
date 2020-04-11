package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private MyApi myApiService = null;
    private OnEventListener<String> callback;
    private Exception exception;
    private static final String MY_URL = "http://10.0.2.2:8080/_ah/api/";

    public EndpointsAsyncTask(OnEventListener<String> callback) {
        this.callback = callback;
    }

    public EndpointsAsyncTask() {
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(MY_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {

            return myApiService.fetchJokes().execute().getData();
        } catch (IOException e) {
            exception = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {

        if (callback != null) {
            if (exception == null) {
                callback.onSuccess(result);
            } else {
                callback.onFailure(exception);
            }
        }
    }
}


