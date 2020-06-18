package com.example.githubtrending

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.githubtrending.helper.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.mockito.MockitoAnnotations

open class BaseTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    @Before
    fun initialSetup() {
        MockitoAnnotations.initMocks(this)
    }

    @After
    fun tearDown() {

    }
}