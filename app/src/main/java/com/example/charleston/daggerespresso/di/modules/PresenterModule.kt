package com.example.charleston.daggerespresso.di.modules

import com.example.charleston.daggerespresso.api.workers.PostWorker
import com.example.charleston.daggerespresso.features.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by charleston on 09/02/18.
 */
@Module
class PresenterModule {

    @Provides
    @Reusable
    fun provideMainPresenter(worker: PostWorker): MainPresenter {
        return MainPresenter(worker)
    }
}