package com.example.charleston.daggerespresso.di.modules

import com.example.charleston.daggerespresso.api.requests.PostRequest
import com.example.charleston.daggerespresso.api.services.PostService
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by charleston on 09/02/18.
 */

@Module
class ServiceModule {

    @Provides
    @Reusable
    fun providePostService(request: PostRequest): PostService {
        return PostService(request)
    }
}