package com.gdgand.rxjava.rxjavasample.dagger.module;

import com.gdgand.rxjava.rxjavasample.util.repository.DatabaseRealm;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by ggikko on 16. 5. 27..
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public DatabaseRealm provideDatabaseRealm() {
        return new DatabaseRealm();
    }
}
