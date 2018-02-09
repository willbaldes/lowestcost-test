package com.example.photontest.app;

import android.app.Application;

import com.example.photontest.di.components.AppComponent;
import com.example.photontest.di.components.DaggerAppComponent;
import com.example.photontest.di.modules.AppModule;

public class PhotonApp extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
