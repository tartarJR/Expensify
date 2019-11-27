package com.tatar.expensify.di.app.module

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.tatar.expensify.R
import com.tatar.expensify.di.app.scope.PerApp
import dagger.Module
import dagger.Provides

@Module
object GlideModule {

    @PerApp
    @Provides
    internal fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.login_background)
            .error(R.drawable.sad_face_background)
    }

    @PerApp
    @Provides
    internal fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide
            .with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    // Just and example
    @PerApp
    @Provides
    internal fun provideAppDrawable(application: Application): Drawable {
        return ContextCompat.getDrawable(application, R.drawable.ic_launcher_foreground)!!
    }
}
