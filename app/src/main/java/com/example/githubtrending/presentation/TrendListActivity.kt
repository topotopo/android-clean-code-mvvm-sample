package com.example.githubtrending.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubtrending.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend_list)
    }
}
