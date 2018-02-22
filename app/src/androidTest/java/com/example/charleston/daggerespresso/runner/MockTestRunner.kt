package com.example.charleston.daggerespresso.runner

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import com.example.charleston.daggerespresso.TestApp

/**
 * Created by charleston on 22/02/18.
 */
class MockTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApp::class.java.name, context)
    }
}