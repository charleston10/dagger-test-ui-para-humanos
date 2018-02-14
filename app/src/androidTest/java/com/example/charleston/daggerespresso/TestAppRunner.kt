package com.example.charleston.daggerespresso

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

/**
 * Created by charleston on 14/02/18.
 */
class TestAppRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApp::javaClass.name, context)
    }
}