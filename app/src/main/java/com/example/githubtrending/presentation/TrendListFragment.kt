package com.example.githubtrending.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubtrending.R
import com.example.githubtrending.databinding.FragmentTrendListBinding
import com.example.githubtrending.presentation.common.CommonAppAdapter
import com.example.githubtrending.presentation.common.PageState
import com.mmicu.commonadapter.CommonItemHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendListFragment : Fragment() {

    private lateinit var binding: FragmentTrendListBinding

    private val listViewModel: TrendListViewModel by viewModels()
    lateinit var adapter: CommonAppAdapter
    var items = mutableListOf<CommonItemHolder<*>>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_trend_list,
            container,
            false
        )
        initializeViews()
        initializeObservers()
        return binding.root
    }

    private fun initializeViews() {
        adapter =
            CommonAppAdapter(items)
        binding.rvTrending.layoutManager = LinearLayoutManager(context)
        binding.rvTrending.adapter = adapter

        adapter.setItemClickListener { pos, data, view ->

        }

        binding.swipeRefresh.setOnRefreshListener {
            listViewModel.fetchTRendingList(true)
        }

        listViewModel.fetchTRendingList(true)
    }

    private fun initializeObservers() {
        listViewModel.trendingRepoList.observe(viewLifecycleOwner, Observer {
            items.clear()
            items.addAll(it)
            adapter.notifyDataSetChanged()
        })

        listViewModel.pageState.observe(viewLifecycleOwner, Observer { pageState ->
            when (pageState) {
                is PageState.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                    binding.rvTrending.visibility = View.GONE
                }
                is PageState.Success -> {
                    binding.swipeRefresh.isRefreshing = false
                    binding.loading.visibility = View.GONE
                    binding.rvTrending.visibility = View.VISIBLE
                }
                is PageState.Error -> {
                    binding.swipeRefresh.isRefreshing = false
                    binding.loading.visibility = View.GONE
                    binding.rvTrending.visibility = View.VISIBLE
                }
            }

        })
    }
}