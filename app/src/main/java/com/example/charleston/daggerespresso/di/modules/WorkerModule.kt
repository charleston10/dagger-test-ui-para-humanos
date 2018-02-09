package com.example.charleston.daggerespresso.di.modules

import com.example.charleston.daggerespresso.api.requests.PostRequest
import com.example.charleston.daggerespresso.api.workers.PostWorker
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by charleston on 09/02/18.
 */

@Module
class WorkerModule {

    @Provides
    @Reusable
    fun provideAuthWorker(request: PostRequest): PostWorker {
        return PostWorker(request)
    }
}