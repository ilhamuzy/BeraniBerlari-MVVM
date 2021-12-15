package com.example.beraniberlari.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.beraniberlari.data.model.Run
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {

    @Query("SELECT * FROM run ORDER BY timestamp DESC")
    fun getRunDataByDate():LiveData<List<Run>>

    @Query("SELECT * FROM run ORDER BY avgSpeedInKm DESC")
    fun getRunDataBySpeed():LiveData<List<Run>>

    @Query("SELECT * FROM run ORDER BY distance DESC")
    fun getRunDataByDistance():LiveData<List<Run>>

    @Query("SELECT * FROM run ORDER BY timeInMillis DESC")
    fun getRunDataByTimes():LiveData<List<Run>>

    @Query("SELECT * FROM run ORDER BY caloriesBurned DESC")
    fun getRunDataByCalories():LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM run")
    fun getTotalTimes() : LiveData<Long>

    @Query("SELECT SUM(avgSpeedInKm) FROM run")
    fun getTotalSpeed() : LiveData<Float>

    @Query("SELECT SUM(distance) FROM run")
    fun getTotalDistance() : LiveData<Int>

    @Query("SELECT SUM(caloriesBurned) FROM run")
    fun getTotalCalories() : LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)
}