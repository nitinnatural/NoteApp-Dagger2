package com.example.stayaboard.presentation.di.component;

import com.example.stayaboard.SplashActivity;
import com.example.stayaboard.presentation.StayAboardApplication;
import com.example.stayaboard.presentation.di.AppScope;
import com.example.stayaboard.presentation.di.modules.AppModule;
import com.example.stayaboard.presentation.di.modules.RepositoryModule;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {

    void inject(StayAboardApplication perpuleApplication);

    void inject(SplashActivity splashActivity);

}
