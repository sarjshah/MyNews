package com.practice.mynews.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyNewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(newsList: List<NewsEntity>)

    @Query("select * from `news_table` order by webPublicationDate desc")
    suspend fun getNewsData():List<NewsEntity>
}