package com.gdgand.rxjava.rxjavasample;

import android.app.Application;

import com.gdgand.rxjava.rxjavasample.dagger.component.GApplicationComponent;
import com.gdgand.rxjava.rxjavasample.dagger.injector.ApplicationInjector;
import com.gdgand.rxjava.rxjavasample.dagger.injector.InjectorCreator;
import com.gdgand.rxjava.rxjavasample.util.repository.DatabaseRealm;

import javax.inject.Inject;

import lombok.Getter;

/**
 * Created by admin on 16. 6. 8..
 */
public class GApplication extends Application {

    //injector creator
    @Getter
    protected InjectorCreator injectorCreator;

    //app component
    @Getter private GApplicationComponent ggikkoApplicationComponent;

    //db
    @Inject
    DatabaseRealm databaseRealm;

    @Override
    public void onCreate() {
        super.onCreate();
        this.injectorCreator = makeInjectorCreator();
        inject();
        databaseRealm.setup();
    }

    /** initiate injector */
    protected InjectorCreator makeInjectorCreator() {
        return new InjectorCreator();
    }

    /** inject by using Injector */
    protected final void inject() {
        final ApplicationInjector applicationInjector = injectorCreator.makeApplicationInjector(GApplication.this);
        ggikkoApplicationComponent = applicationInjector.getApplicationComponent();
        applicationInjector.inject(this);
    }
}
