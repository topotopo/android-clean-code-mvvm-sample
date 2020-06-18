package com.example.githubtrending

import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.usecase.GetTrendingDetailsUseCase
import com.example.githubtrending.domain.usecase.UpdateTrendingDetailUseCase
import com.example.githubtrending.helper.getTestValue
import com.example.githubtrending.presentation.edit.TrendEditViewModel
import com.example.githubtrending.presentation.util.PageState
import com.example.githubtrending.presentation.util.PageStateHelper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class TrendEditViewModelTest : BaseTest() {

    private lateinit var viewModel: TrendEditViewModel

    @Mock
    lateinit var gitTrendingModel: GitTrendingModel

    @Mock
    lateinit var getUseCase: GetTrendingDetailsUseCase

    @Mock
    lateinit var updateUseCase: UpdateTrendingDetailUseCase

    @Before
    fun setUp() {
        viewModel =
            TrendEditViewModel(
                getUseCase,
                updateUseCase,
                PageStateHelper()
            )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test fetch git trending details successfully should return a data and set page to success`() {
        val repositorySuccessResult = ResultStatus.Success(gitTrendingModel)
        coroutineTestRule.testDispatcher.runBlockingTest {
            Mockito.`when`(getUseCase.getTrendingDetails("")).thenReturn(repositorySuccessResult)
            viewModel.getTrendingDetails("")
        }
        Assert.assertTrue(viewModel.trendingModel.getTestValue() is GitTrendingModel)
        Assert.assertTrue(viewModel.pageState.getTestValue() is PageState.Success)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test update git trending details successfully should return an updated data and set page to success`() {
        val updatedGitModel =
            GitTrendingModel("url1", "", "new_name", "", "new_description", "", "", "", "", "")

        val repositorySuccessResult = ResultStatus.Success(updatedGitModel)
        coroutineTestRule.testDispatcher.runBlockingTest {
            Mockito.`when`(updateUseCase.updateTrendingDetailsUseCase("", gitTrendingModel))
                .thenReturn(repositorySuccessResult)
            viewModel.updateTrendingDetails("", gitTrendingModel)
        }
        Assert.assertEquals(updatedGitModel, viewModel.trendingModel.getTestValue())
        Assert.assertTrue(viewModel.pageState.getTestValue() is PageState.Success)
    }

}