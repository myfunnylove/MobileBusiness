package com.nbu.mobile.common.di.components;

import com.nbu.mobile.common.base.App;
import com.nbu.mobile.common.di.modules.AppModule;
import com.nbu.mobile.common.di.modules.DAOModule;
import com.nbu.mobile.common.di.modules.NetWorkModule;
import com.nbu.mobile.common.di.modules.RestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Sarvar on 31.08.2017.
 */
@Singleton
@Component(modules = {AppModule.class, DAOModule.class, NetWorkModule.class,RestModule.class})
public interface AppComponent {

    void inject(App app);
}
