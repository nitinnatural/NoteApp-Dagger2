package com.example.stayaboard.presentation;

import android.app.Application;
import android.content.Context;
import com.example.stayaboard.presentation.di.component.AppComponent;
import com.example.stayaboard.presentation.di.component.DaggerAppComponent;
import com.example.stayaboard.presentation.di.modules.AppModule;


public class StayAboardApplication extends Application {

    private static AppComponent appComponent;

    private static Context mContext;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);

    }

    @Override
    public void onCreate() {
        mContext = this;
        super.onCreate();
        initializeInjector();

    }

    public void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static Context getContext(){
        return mContext;
    }

    public static StayAboardApplication getInstance() {
        return (StayAboardApplication) mContext;
    }


}
