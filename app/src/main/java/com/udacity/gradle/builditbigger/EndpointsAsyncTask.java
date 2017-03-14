package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.toddskinner.builditbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by toddskinner on 3/13/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    public AsyncResponse delegate = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-161420.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Source: http://stackoverflow.com/questions/12575068/how-to-get-the-result-of-onpostexecute-to-main-activity-because-asynctask-is-a
        delegate.processFinish(result);
    }
}
