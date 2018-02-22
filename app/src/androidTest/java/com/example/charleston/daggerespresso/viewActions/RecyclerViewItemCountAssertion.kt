package com.example.charleston.daggerespresso.viewActions

import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.ViewAssertion
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`


/**
 * Created by charleston on 22/02/18.
 */
class RecyclerViewItemCountAssertion : ViewAssertion {

    private val matcher: Matcher<Int>

    constructor(expectedCount: Int) {
        this.matcher = `is`(expectedCount)
    }

    constructor(matcher: Matcher<Int>) {
        this.matcher = matcher
    }

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }

        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter
        assertThat(adapter.itemCount, matcher)
    }

}