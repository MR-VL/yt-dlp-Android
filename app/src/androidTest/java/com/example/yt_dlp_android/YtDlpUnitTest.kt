package com.example.yt_dlp_android

import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test

class YtDlpUnitTest {

    companion object {
        @JvmStatic
        @BeforeClass
        fun setUpPython() {
            if (!Python.isStarted()) {
                Python.start(AndroidPlatform(App.instance))  // You need a custom `App` class (see below)
            }
        }
    }

    @Test
    fun testYtDlpExtractInfo() {
        val py = Python.getInstance()
        val ytDlpModule = py.getModule("yt_dlp")!!
        val youtubeDL = ytDlpModule.get("YoutubeDL")!!

        val options = py.builtins.callAttr("dict")
        val ydl = youtubeDL.call(options)

        // Rick Astley — safe, short video for testing
        val result = ydl.callAttr("extract_info", "https://www.youtube.com/watch?v=dQw4w9WgXcQ", true)

        val title = result["title"].toString()
        println("Title: $title")

        assertTrue("Title should not be empty", title.isNotEmpty())
    }
}
