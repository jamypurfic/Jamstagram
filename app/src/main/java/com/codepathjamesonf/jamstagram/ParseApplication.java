package com.codepathjamesonf.jamstagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Z0M85piXB2KVD9EM3Bvvpjah2bvSKsVMF1rN6FLL")
                .clientKey("YnCMvJ3D6yfmOSh9Hi1z3MzTOX6NVj6lg87IHgAQ")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
