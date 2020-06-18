package com.example.githubtrending.presentation.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.githubtrending.R
import com.example.githubtrending.presentation.details.TrendDetailsFragment
import com.example.githubtrending.presentation.edit.TrendEditFragment
import com.example.githubtrending.presentation.list.TrendListFragment

/**
 * Navigates to the activity / fragments within the app.
 */
class NavigatorHelper {

    fun loadTrendListFragment(supportFragmentManager: FragmentManager) {
        val trendingFragment =
            TrendListFragment()
        loadFragment(supportFragmentManager, trendingFragment)
    }

    fun loadTrendDetailsFragment(url: String, supportFragmentManager: FragmentManager) {
        val trendingFragment =
            TrendDetailsFragment()
        val bundle = Bundle()
        bundle.putString(GIT_MODEL_URL, url)
        trendingFragment.arguments = bundle
        loadFragment(supportFragmentManager, trendingFragment, "details")
    }

    fun loadTrendEditFragment(url: String, supportFragmentManager: FragmentManager) {
        val trendingFragment =
            TrendEditFragment()
        val bundle = Bundle()
        bundle.putString(GIT_MODEL_URL, url)
        trendingFragment.arguments = bundle
        loadFragment(supportFragmentManager, trendingFragment, "edit")
    }

    private fun loadFragment(
        supportFragmentManager: FragmentManager,
        fragment: Fragment,
        name: String = ""
    ) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
            .addToBackStack(name).commit()
    }
}