package com.loftymr.plist.data.di

import com.loftymr.plist.data.remote.service.PListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

/**
 * Created by talhafaki on 29.09.2022.
 */

@Module
@InstallIn(ViewModelComponent::class)
class ServiceModule {

    @Provides
    fun provideSurveyService(retrofit: Retrofit): PListService =
        retrofit.create(PListService::class.java)
}