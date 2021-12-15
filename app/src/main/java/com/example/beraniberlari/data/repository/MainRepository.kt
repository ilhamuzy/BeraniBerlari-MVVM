package com.example.beraniberlari.data.repository

import androidx.lifecycle.LiveData
import com.example.beraniberlari.data.model.ChuckResponse
import com.example.beraniberlari.data.model.Run
import com.example.beraniberlari.utils.Resource

interface MainRepository {

    suspend fun getChuck(): com.example.beraniberlari.utils.Resource<ChuckResponse>

    suspend fun testDatabase()

    suspend fun testRead()

    suspend fun insertRun(run: Run)

    suspend fun deleteRun(run: Run)

    fun getRunDataByDate() : LiveData<List<Run>>

    fun getRunDataBySpeed() : LiveData<List<Run>>

    fun getRunDataByDistance(): LiveData<List<Run>>

    fun getRunDataByTimes() : LiveData<List<Run>>

    fun getRunDataByCalories() : LiveData<List<Run>>

    fun getTotalTimes() : LiveData<Long>

    fun getTotalSpeed() : LiveData<Float>

    fun getTotalDistance() : LiveData<Int>

    fun getTotalCalories() : LiveData<Int>
}