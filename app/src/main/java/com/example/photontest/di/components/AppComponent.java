package com.example.photontest.di.components;

import android.content.Context;

import com.example.photontest.di.modules.AppModule;
import com.example.photontest.di.modules.ResourceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ResourceModule.class})
public interface AppComponent {
    Context appContext();
}
