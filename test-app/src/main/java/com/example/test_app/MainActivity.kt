package com.example.test_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import parser.Parser
import rendering.ComposeRendering
import java.lang.StringBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inputStream = this.resources.openRawResource(R.raw.state)
        val reader = inputStream.bufferedReader()
        val stringBuilder = StringBuilder()
        var line: String?

        while (reader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }

        reader.close()
        inputStream.close()

        val start = Parser.parse(stringBuilder.toString())

        setContent {
            Column(Modifier.background(color = Color(android.graphics.Color.WHITE))) {
                ComposeRendering.StartRender(start)
            }
        }
    }
}
