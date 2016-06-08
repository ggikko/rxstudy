package com.gdgand.rxjava.rxjavasample.util.repository;

import android.content.Context;

import com.gdgand.rxjava.rxjavasample.dagger.injector.ApplicationInjector;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;

/**
 * Created by admin on 16. 6. 8..
 */
public class DatabaseRealm {

    @Inject Context mContext;

    RealmConfiguration realmConfiguration;

    public DatabaseRealm() {
        ApplicationInjector.getApplicationComponent().inject(this);
    }

    public void setup() {
        if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration.Builder(mContext).build();
            Realm.setDefaultConfiguration(realmConfiguration);
        } else {
            throw new IllegalStateException("database already configured");
        }
    }

    public Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    public <T extends RealmObject> T add(T model) {
        Realm realm = getRealmInstance();
        realm.beginTransaction();
        realm.copyToRealm(model);
        realm.commitTransaction();
        return model;
    }
    
    public void transactionAsync(Realm.Transaction transaction, Realm.Transaction.OnSuccess success) {
        Realm realm = getRealmInstance();
        realm.beginTransaction();
        realm.commitTransaction();
        realm.executeTransactionAsync(transaction,success);
    }

    public <T extends RealmObject> long findCountGreaterThanOrEqualTo(Class<T> clazz, String filename, int value) {
        return getRealmInstance().where(clazz).greaterThanOrEqualTo(filename,value).count();
    }

}
