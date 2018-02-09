package com.example.photontest.di.modules;

import android.content.Context;

import com.example.photontest.helper.ResourceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ResourceModule {

    @Singleton
    @Provides
    ResourceHelper providesResourceHelper(Context context) {
        return new ResourceHelper(context);
    }

}
