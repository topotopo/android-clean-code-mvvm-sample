package com.example.githubtrending.data.helper

import android.content.Context
import java.io.InputStream
import java.util.*

class FakeJsonFileReader {

    fun readMockJson(context: Context, mockFileId: Int): String {
        val stream: InputStream? = context.resources.openRawResource(mockFileId)
        return streamToString(stream!!)
    }

    private fun streamToString(stream: InputStream): String {
        var s: Scanner? = null
        try {
            s = Scanner(stream)
            s.useDelimiter("\\Z")
            return if (s.hasNext()) s.next() else ""
        } finally {
            s?.close()
        }
    }
}