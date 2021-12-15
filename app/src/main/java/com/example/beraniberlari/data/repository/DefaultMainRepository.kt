package com.example.beraniberlari.data.repository

import androidx.lifecycle.LiveData
import com.example.beraniberlari.utils.Resource
import com.example.beraniberlari.data.AppCustomDao
import com.example.beraniberlari.data.RunDao
import com.example.beraniberlari.data.TokenDao
import com.example.beraniberlari.data.api.ChuckApi
import com.example.beraniberlari.data.model.ChuckResponse
import com.example.beraniberlari.data.model.Run
import com.example.beraniberlari.data.model.UserToken
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: ChuckApi,
    private val tokenDao: TokenDao,
    private val appCustomDao: AppCustomDao,
    private val runDao: RunDao
) : MainRepository {
    override suspend fun getChuck(): Resource<ChuckResponse> {
        return try {
            val response = api.getChuck()
            val result = response.body()
            if (response.isSuccessful && result != null) {
               Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occured")
        }
    }

    override suspend fun testDatabase() {
        tokenDao.insertAll(UserToken("1", "test", "test"))
    }

    override suspend fun testRead() {
        tokenDao.getToken("1").collect {

        }
    }

    override suspend fun insertRun(run: Run) {
        runDao.insertRun(run)
    }

    override suspend fun deleteRun(run: Run){
        runDao.deleteRun(run)
    }

    override fun getRunDataByDate(): LiveData<List<Run>> {

        return runDao.getRunDataByDate()
    }

    override fun getRunDataBySpeed(): LiveData<List<Run>> {
        return runDao.getRunDataBySpeed()
    }

    override fun getRunDataByDistance(): LiveData<List<Run>> {
        return runDao.getRunDataByDistance()
    }

    override fun getRunDataByTimes(): LiveData<List<Run>> {
        return runDao.getRunDataByTimes()
    }

    override fun getRunDataByCalories(): LiveData<List<Run>> {
        return runDao.getRunDataByCalories()
    }

    override fun getTotalTimes(): LiveData<Long> {
        return runDao.getTotalTimes()
    }

    override fun getTotalSpeed(): LiveData<Float> {
        return runDao.getTotalSpeed()
    }

    override fun getTotalDistance(): LiveData<Int> {
        return runDao.getTotalDistance()
    }

    override fun getTotalCalories(): LiveData<Int> {
        return runDao.getTotalCalories()
    }

}