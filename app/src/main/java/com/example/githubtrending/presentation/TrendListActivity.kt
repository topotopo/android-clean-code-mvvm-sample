package com.example.githubtrending.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.githubtrending.R
import com.example.githubtrending.databinding.ActivityTrendListBinding
import com.example.githubtrending.presentation.common.GIT_MODEL_URL
import com.example.githubtrending.presentation.list.TrendListFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class TrendListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrendListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trend_list)
        setSupportActionBar(binding.toolbar)
        loadTrendListFragment()
    }

    private fun loadTrendListFragment() {
        val trendingFragment =
            TrendListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, trendingFragment).commit()
    }

    fun loadTrendDetailsFragment(url: String) {
        val trendingFragment =
            TrendDetailsFragment()
        val bundle = Bundle()
        bundle.putString(GIT_MODEL_URL, url)
        trendingFragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.container, trendingFragment).commit()
    }
}
