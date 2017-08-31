package com.nbu.mobile.common.di.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nbu.mobile.common.rest.API;
import com.nbu.mobile.common.utils.Const;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sarvar on 31.08.2017.
 */

@Module(includes = {NetWorkModule.class})
public class RestModule {

    @Provides
    @Singleton
    Gson gson(){
        return new GsonBuilder().create();
    }


    @Provides
    @Singleton
    GsonConverterFactory converterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory callAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit retrofit(GsonConverterFactory converterFactory, OkHttpClient client,RxJavaCallAdapterFactory callAdapterFactory){

        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();


    }

    @Provides
    @Singleton
    API service(Retrofit retrofit){
        return retrofit.create(API.class);
    }
}
