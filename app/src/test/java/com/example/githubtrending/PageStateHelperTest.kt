package com.example.githubtrending

import com.example.githubtrending.helper.getTestValue
import com.example.githubtrending.presentation.util.PageState
import com.example.githubtrending.presentation.util.PageStateHelper
import org.junit.Assert
import org.junit.Test

class PageStateHelperTest : BaseTest() {

    var pageStateHelper = PageStateHelper()

    @Test
    fun `test set error state should set page state to error`() {
        pageStateHelper.setErrorState("")
        Assert.assertTrue(pageStateHelper.pageState.getTestValue() is PageState.Error)
    }

    @Test
    fun `test set success state should set page state to success`() {
        pageStateHelper.setSuccessState()
        Assert.assertTrue(pageStateHelper.pageState.getTestValue() is PageState.Success)
    }

    @Test
    fun `test set loading state should set page state to loading`() {
        pageStateHelper.setLoadingState()
        Assert.assertTrue(pageStateHelper.pageState.getTestValue() is PageState.Loading)
    }
}