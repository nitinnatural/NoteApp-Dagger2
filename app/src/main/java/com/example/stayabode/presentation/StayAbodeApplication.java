package com.example.stayabode.presentation;

import android.app.Application;
import android.content.Context;
import com.example.stayabode.presentation.di.component.AppComponent;
import com.example.stayabode.presentation.di.component.DaggerAppComponent;
import com.example.stayabode.presentation.di.modules.AppModule;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class StayAbodeApplication extends Application {

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

    public static StayAbodeApplication getInstance() {
        return (StayAbodeApplication) mContext;
    }


}
