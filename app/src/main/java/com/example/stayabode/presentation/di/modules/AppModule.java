package com.example.stayabode.presentation.di.modules;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.stayabode.presentation.StayAbodeApplication;
import com.example.stayabode.presentation.di.AppScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Prakhar on 11/30/2017.
 */
@Module
public class AppModule {

    private StayAbodeApplication app;

    public AppModule(StayAbodeApplication app) {
        this.app = app;
    }

    @Provides
    @AppScope
    StayAbodeApplication provideAppContext() {
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


    @Provides
    @AppScope
    SharedPreferences providesSharedPreferences(StayAbodeApplication application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
