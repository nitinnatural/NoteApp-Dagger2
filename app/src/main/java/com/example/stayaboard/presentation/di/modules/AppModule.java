package com.example.stayaboard.presentation.di.modules;


import com.example.stayaboard.presentation.StayAboardApplication;
import com.example.stayaboard.presentation.di.AppScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class AppModule {

    private StayAboardApplication app;

    public AppModule(StayAboardApplication app) {
        this.app = app;
    }

    @Provides
    @AppScope
    StayAboardApplication provideAppContext() {
        return app;
    }

    @Provides
    @Named("Thread")
    @AppScope
    Scheduler providesThreadScheduler() {
        return Schedulers.io();
    }


    @Provides
    @Named("PostExecution")
    @AppScope
    Scheduler providesPostExecutionScheduler() {
        return AndroidSchedulers.mainThread();
    }

}
