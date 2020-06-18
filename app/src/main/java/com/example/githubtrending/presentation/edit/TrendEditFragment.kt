package com.example.githubtrending.presentation.edit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.githubtrending.R
import com.example.githubtrending.databinding.FragmentTrendEditBinding
import com.example.githubtrending.presentation.common.BaseFragment
import com.example.githubtrending.presentation.util.GIT_MODEL_URL
import com.example.githubtrending.presentation.util.PageState
import com.example.githubtrending.presentation.util.extensions.loadCircularAvatar

class TrendEditFragment : BaseFragment() {

    private val editViewModel: TrendEditViewModel by viewModels()
    lateinit var binding: FragmentTrendEditBinding
    lateinit var url: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_trend_edit,
            container,
            false
        )
        initializeObservers()
        initializeUi()
        url = arguments?.getString(GIT_MODEL_URL) ?: ""
        editViewModel.getTrendingDetails(url)

        return binding.root
    }

    private fun initializeObservers() {
        editViewModel.trendingModel.observe(viewLifecycleOwner, Observer {
            binding.data = it
            it.avatar?.let { avatar ->
                loadAvatar(avatar)
            }
        })

        editViewModel.pageState.observe(viewLifecycleOwner, Observer { pageState ->
            when (pageState) {
                is PageState.Success -> {
                    binding.loading.visibility = View.GONE
                }
                is PageState.Error -> {
                    binding.loading.visibility = View.GONE
                    showErrorDialog()
                }
                is PageState.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun initializeUi() {
        binding.save.setOnClickListener {
            saveTrendingModel(url)
            parentFragmentManager.popBackStack()
        }
    }

    private fun loadAvatar(url: String) {
        binding.avatar.loadCircularAvatar(url)
    }

    private fun saveTrendingModel(url: String) {
        val newGitTrendingModel = editViewModel.trendingModel.value
        newGitTrendingModel.apply {
            val name = if (binding.nameForm.text.toString().isEmpty()) {
                binding.nameForm.hint.toString()
            } else {
                binding.nameForm.text.toString()
            }

            val description = if (binding.descriptionForm.text.toString().isEmpty()) {
                binding.descriptionForm.hint.toString()
            } else {
                binding.descriptionForm.text.toString()
            }

            this?.name = name
            this?.description = description
        }

        Log.v("MXN", "git trending model -> ${newGitTrendingModel}")
        newGitTrendingModel?.let {
            editViewModel.updateTrendingDetails(url, it)
        }
    }

}