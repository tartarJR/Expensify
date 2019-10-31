package com.tatar.expensify.di.app.module

import android.content.Context
import com.tatar.expensify.di.app.scope.PerApp
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

@Module
object NetworkModule {

    @JvmStatic
    @PerApp
    @Provides
    internal fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()
    }

    @JvmStatic
    @PerApp
    @Provides
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { msg -> Timber.i(msg) })
        interceptor.level = HttpLoggingInterceptor.Level.BASIC

        return interceptor
    }

    @JvmStatic
    @PerApp
    @Provides
    internal fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 1000 * 1000)
    }

    @JvmStatic
    @PerApp
    @Provides
    internal fun provideCacheFile(context: Context): File {
        return File(context.cacheDir, "network_cache")
    }
}