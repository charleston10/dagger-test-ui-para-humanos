package com.example.charleston.daggerespresso.di.modules

import com.example.charleston.daggerespresso.api.requests.PostRequest
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

/**
 * Created by charleston on 09/02/18.
 */

@Module
class RequestModule {

    @Provides
    @Reusable
    fun provideAuthRequest(retrofit: Retrofit): PostRequest {
        return retrofit.create(PostRequest::class.java)
    }
}