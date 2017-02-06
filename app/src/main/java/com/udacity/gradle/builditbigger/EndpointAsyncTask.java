package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by NUSNAFIF on 2/4/2017.
 */


//public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {
public class EndpointAsyncTask extends AsyncTask<com.udacity.gradle.builditbigger.MainActivityFragment, Void, String> {

    public static String LOG_TAG = EndpointAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;
    private Context context;
    private com.udacity.gradle.builditbigger.MainActivityFragment mainActivityFragment;


    public EndpointAsyncTask() {

    }

    @Override
//    protected String doInBackground(Context... params) {
    protected String doInBackground(com.udacity.gradle.builditbigger.MainActivityFragment... params) {

        mainActivityFragment = params[0];
        context = mainActivityFragment.getActivity();

        if (myApiService == null) {  // Only do this once

            // end options for devappserver
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                    .setRootUrl("https://xxx.appspot.com/_ah/api/");
                    .setRootUrl("https://udacity-p04-05022017.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mainActivityFragment.loadedJoke = result;
        mainActivityFragment.launchDisplayJokeActivity();
    }
}
