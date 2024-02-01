package com.rahatshah.mediaplayerdemo.di


import android.app.Application
import com.rahatshah.mediaplayerdemo.data.MediaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMediaList(context: Application): MediaRepository {
        return MediaRepository(context)
    }


}
