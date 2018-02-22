package com.example.charleston.daggerespresso.extensions

import android.content.Context
import android.support.annotation.RawRes
import org.apache.commons.io.IOUtils


/**
 * Created by charleston on 22/02/18.
 */
infix fun Context.getJson(@RawRes raw: Int): String {
    val inputStream = resources.openRawResource(raw)
    val json = IOUtils.toString(inputStream)
    IOUtils.closeQuietly(inputStream)
    return json
}