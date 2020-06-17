package com.example.githubtrending.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.githubtrending.R
import com.example.githubtrending.databinding.FragmentTrendDetailsBinding
import com.example.githubtrending.presentation.util.GIT_MODEL_URL
import com.example.githubtrending.presentation.util.PageState
import com.example.githubtrending.presentation.util.loadCircularAvatar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendDetailsFragment : Fragment() {

    private val listViewModel: TrendDetailsViewModel by viewModels()
    lateinit var binding: FragmentTrendDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_trend_details,
            container,
            false
        )
        initializeObservers()
        arguments?.getString(GIT_MODEL_URL)?.let {
            listViewModel.getTrendingDetails(it)
        }

        return binding.root
    }

    private fun initializeObservers() {
        listViewModel.trendingModel.observe(viewLifecycleOwner, Observer { gitTrendingModel ->
            binding.data = gitTrendingModel
            gitTrendingModel.avatar?.let {
                loadAvatar(it)
            }
        })

        listViewModel.pageState.observe(viewLifecycleOwner, Observer { pageState ->
            when (pageState) {
                is PageState.Success -> {
                    binding.loading.visibility = View.GONE
                }
                is PageState.Error -> {
                    binding.loading.visibility = View.GONE
                }
                is PageState.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun loadAvatar(url: String) {
        binding.avatar.loadCircularAvatar(url)
    }
}