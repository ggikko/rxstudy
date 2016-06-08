package com.gdgand.rxjava.rxjavasample.dagger.injector;

import com.gdgand.rxjava.rxjavasample.GApplication;
import com.gdgand.rxjava.rxjavasample.dagger.component.DaggerGApplicationComponent;
import com.gdgand.rxjava.rxjavasample.dagger.component.GApplicationComponent;
import com.gdgand.rxjava.rxjavasample.dagger.module.GApplicationModule;

import lombok.Getter;

/**
 * Created by ggikko on 16. 5. 27..
 */
public class InjectorCreator {

    @Getter
    private GApplicationComponent applicationComponent;

    public ApplicationInjector makeApplicationInjector(GApplication application) {
        applicationComponent = DaggerGApplicationComponent.builder()
                .gApplicationModule(new GApplicationModule(application))
                .build();
        return new ApplicationInjector(applicationComponent);
    }
}
