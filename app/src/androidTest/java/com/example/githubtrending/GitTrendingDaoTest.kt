package com.example.githubtrending

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.githubtrending.data.local.AppDatabase
import com.example.githubtrending.data.local.dao.GitTrendingDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class GitTrendingDaoTest {

    private lateinit var db: AppDatabase
    private lateinit var repoDao: GitTrendingDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().context
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        repoDao = db.getTrendingDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeRepoListAndReadAll() = runBlocking {
        val repoModelList = TestUtils.createRepoModelList()

        repoDao.insertAll(repoModelList)
        Assert.assertEquals(repoDao.getAll(), repoModelList)
    }

    @Test
    fun writeRepoListAndDeleteAllShouldReturnEmpty() = runBlocking {
        val repoModelList = TestUtils.createRepoModelList()
        repoDao.insertAll(repoModelList)
        repoDao.deleteAll()
        Assert.assertTrue(repoDao.getAll().isEmpty())
    }

    @Test
    fun replaceAllRepoListAndReadAllShouldReturnNewList() = runBlocking {
        val repoModelList = TestUtils.createRepoModelList()
        val newRepoList = TestUtils.createRepoModelList()
        repoDao.insertAll(repoModelList)

        //Validate initial list
        Assert.assertEquals(repoDao.getAll(), repoModelList)

        //Replace new list
        repoDao.replaceAll(newRepoList)
        Assert.assertEquals(repoDao.getAll(), newRepoList)
    }
}


