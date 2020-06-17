package com.example.githubtrending

import com.example.githubtrending.data.api.GitTrendingApi
import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.usecase.GetTrendingListUseCase
import com.example.githubtrending.helper.CoroutineTestRule
import com.example.githubtrending.helper.getTestValue
import com.example.githubtrending.presentation.list.TrendListViewModel
import com.example.githubtrending.presentation.util.PageState
import com.example.githubtrending.presentation.util.PageStateHelper
import com.mmicu.commonadapter.CommonItemHolder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import java.io.IOException

class TrendListViewModelTest : BaseTest() {

    private lateinit var viewModel: TrendListViewModel

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    @Mock
    lateinit var gitTrendApi: GitTrendingApi

    @Mock
    lateinit var gitTrendingModel: GitTrendingModel

    @Mock
    lateinit var useCase: GetTrendingListUseCase

    @Before
    fun setup() {
        viewModel = TrendListViewModel(useCase, PageStateHelper())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test fetch git trending list successfully should return a list and set page to success`() {
        val repositorySuccessResult = ResultStatus.Success(listOf(gitTrendingModel))

        coroutineTestRule.testDispatcher.runBlockingTest {
            Mockito.`when`(useCase.getTrendingList(true)).thenReturn(repositorySuccessResult)
            Mockito.`when`(gitTrendApi.fetchTrendingRepos())
                .thenReturn(listOf())

            viewModel.fetchTRendingList(true)
        }
        Assert.assertTrue(viewModel.trendingRepoList.getTestValue() is List<CommonItemHolder<*>>)
        Assert.assertTrue(viewModel.pageState.getTestValue() is PageState.Success)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test fetch trending list failed should set page state to error`() {
        //Test fetch repository and observer is updated with error
        val repositoryErrorResult = ResultStatus.Error(IOException())
        coroutineTestRule.testDispatcher.runBlockingTest {
            Mockito.`when`(useCase.getTrendingList(true)).thenReturn(repositoryErrorResult)
            Mockito.`when`(gitTrendApi.fetchTrendingRepos())
                .thenReturn(listOf())
            viewModel.fetchTRendingList(true)
        }
        Assert.assertTrue(viewModel.pageState.getTestValue() is PageState.Error)
    }

}