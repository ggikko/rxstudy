package com.gdgand.rxjava.rxjavasample.dagger.component;

import com.gdgand.rxjava.rxjavasample.GApplication;
import com.gdgand.rxjava.rxjavasample.dagger.module.GApplicationModule;
import com.gdgand.rxjava.rxjavasample.dagger.module.RepositoryModule;
import com.gdgand.rxjava.rxjavasample.scroll.FasterListActivity;
import com.gdgand.rxjava.rxjavasample.util.repository.DatabaseRealm;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ggikko on 16. 5. 29..
 */


@Singleton
@Component(modules = {GApplicationModule.class, RepositoryModule.class})
public interface GApplicationComponent {
    void inject(GApplication application);
    void inject(DatabaseRealm databaseRealm);
    void inject(FasterListActivity fasterListActivity);
}
