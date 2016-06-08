package com.gdgand.rxjava.rxjavasample.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.gdgand.rxjava.rxjavasample.GApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by admin on 16. 5. 29..
 */
@Module
public class GApplicationModule {

    private GApplication gApplication;

    public GApplicationModule(GApplication mGgikkoApplication){
        this.gApplication = mGgikkoApplication;
    }

    @Provides
    @Singleton
    public Context applicationContext() {
        return gApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs(){
        return PreferenceManager.getDefaultSharedPreferences(gApplication);
    }
}
