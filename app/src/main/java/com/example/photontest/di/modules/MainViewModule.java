package com.example.photontest.di.modules;

import com.example.photontest.di.scopes.MainView;
import com.example.photontest.ui.MainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainViewModule {

    private final MainContract.View mainView;

    public MainViewModule(MainContract.View mainView) {
        this.mainView = mainView;
    }

    @MainView
    @Provides
    MainContract.View providesMainView() {
        return mainView;
    }

}
