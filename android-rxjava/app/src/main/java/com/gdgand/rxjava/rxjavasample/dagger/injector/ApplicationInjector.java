package com.gdgand.rxjava.rxjavasample.dagger.injector;

import com.gdgand.rxjava.rxjavasample.GApplication;
import com.gdgand.rxjava.rxjavasample.dagger.component.GApplicationComponent;

import lombok.Getter;

public class ApplicationInjector {

    @Getter
    private static GApplicationComponent applicationComponent;

    public ApplicationInjector(GApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public void inject(GApplication application) {
        applicationComponent.inject(application);
    }
}
