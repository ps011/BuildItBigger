package com.udacity.gradle.builditbigger;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.ps11.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.jokeshow.JokeShow;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, ProgressDialog>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog progress;
    @Override
    protected String doInBackground(Pair<Context, ProgressDialog>... params) {
        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://192.168.1.13:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-142407.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }
        progress = params[0].second;
        context = params[0].first;
       String name = "ABC";

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }



    @Override
    protected void onPostExecute(String result) {
        progress.dismiss();
        Intent i = new Intent(context, JokeShow.class);
        i.putExtra("joke",result);
        context.startActivity(i);
    }
}