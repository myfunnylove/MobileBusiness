package com.nbu.mobile.common.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.nbu.mobile.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


@Module
public class AppModule {

     Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context context(){
        return context;
    }

    @Provides
    @Singleton
    public CalligraphyConfig calligraphyConfig(){
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    SharedPreferences preferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
