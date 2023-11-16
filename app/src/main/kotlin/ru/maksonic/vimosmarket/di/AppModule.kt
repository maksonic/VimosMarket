package ru.maksonic.vimosmarket.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.maksonic.vimosmarket.ActivityNavigatorCore
import ru.maksonic.vimosmarket.navigation.router.ActivityNavigator
import javax.inject.Singleton

/**
 * @Author maksonic on 16.11.2023
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGlide(@ApplicationContext context: Context) = Glide.with(context)
        .setDefaultRequestOptions(RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA))

    @Provides
    fun provideActivityNavigator(): ActivityNavigator = ActivityNavigatorCore()
}