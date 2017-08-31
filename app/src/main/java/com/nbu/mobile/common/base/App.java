package com.nbu.mobile.common.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.nbu.mobile.common.di.components.DaggerAppComponent;
import com.nbu.mobile.common.di.modules.AppModule;
import com.nbu.mobile.common.di.modules.DAOModule;
import com.nbu.mobile.common.di.modules.NetWorkModule;
import com.nbu.mobile.common.di.modules.RestModule;
import com.nbu.mobile.common.rest.API;

import javax.inject.Inject;

import io.realm.Realm;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class App extends Application {

    @Inject
    public Context context;



    @Inject
    public Realm realm;

    @Inject
    CalligraphyConfig calligraphyConfig;

    @Inject
    API service;

    @Inject
    SharedPreferences preferences;

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        Realm.init(this);
        Utils.init(this);
        DaggerAppComponent.builder()
                            .appModule(new AppModule(this))
                            .dAOModule(new DAOModule())
                            .netWorkModule(new NetWorkModule())
                            .restModule(new RestModule())
                            .build()
                            .inject(this);
        CalligraphyConfig.initDefault(calligraphyConfig);





    }

    public static App instance(){

        if (instance == null) instance = new App();

        return instance;
    }


}
