package com.codepathjamesonf.jamstagram;

import android.app.Application;

import com.parse.Parse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Use for monitoring Parse OkHttp traffic
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        // See https://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Z0M85piXB2KVD9EM3Bvvpjah2bvSKsVMF1rN6FLL")
                .clientKey("YnCMvJ3D6yfmOSh9Hi1z3MzTOX6NVj6lg87IHgAQ")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
