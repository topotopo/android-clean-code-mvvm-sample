package com.example.githubtrending

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.mockito.MockitoAnnotations

open class BaseTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initialSetup() {
        MockitoAnnotations.initMocks(this)
    }

    @After
    fun tearDown() {

    }
}