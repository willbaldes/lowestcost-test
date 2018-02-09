package com.example.photontest.di.components;

import com.example.photontest.di.modules.MainViewModule;
import com.example.photontest.di.scopes.MainView;
import com.example.photontest.ui.MainActivity;

import dagger.Component;

@MainView
@Component(dependencies = {AppComponent.class}, modules = {MainViewModule.class})
public interface MainViewComponent {

    void inject(MainActivity activity);

}
