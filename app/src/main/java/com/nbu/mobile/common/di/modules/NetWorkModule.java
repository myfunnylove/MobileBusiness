package com.nbu.mobile.common.di.modules;

import android.content.Context;

import com.nbu.mobile.common.utils.Const;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by Sarvar on 31.08.2017.
 */

@Module(includes = AppModule.class)
public class NetWorkModule {

        @Provides
        @Singleton
        File file(Context context){
            return new File(context.getCacheDir(),"nbu_app_cache");
        }

        @Provides
        @Singleton
        Cache cache(File cacheFile){
            return new Cache(cacheFile, Const.CACHE_MAX_SIZE);
        }

        @Provides
        @Singleton
        OkHttpClient client(Context context,Cache cache){
            return new OkHttpClient.Builder()
                                    .connectTimeout(7, TimeUnit.MINUTES)
                                    .readTimeout   (7, TimeUnit.MINUTES)
                                    .writeTimeout  (7, TimeUnit.MINUTES)
                                    .cache(cache)
                                    .build();


        }
}
