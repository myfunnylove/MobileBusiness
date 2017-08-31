package com.nbu.mobile.common.di.modules;

import com.nbu.mobile.common.dao.NbuRealmModule;
import com.nbu.mobile.common.dao.RealmDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Sarvar on 31.08.2017.
 */

@Module
public class DAOModule {




//    @Provides
//    @Singleton
//    public NbuRealmModule module(){
//        return new NbuRealmModule();
//    }

    @Provides
    @Singleton
    public RealmConfiguration configuration(){

        return new RealmConfiguration.Builder()
                .name(RealmDAO.dbName)
                .schemaVersion(RealmDAO.dbVersion)
//                .modules(realmModule)
                .build();
    }

    @Provides
    @Singleton
    public Realm realm(RealmConfiguration configuration){
        return Realm.getInstance(configuration);
    }

}
