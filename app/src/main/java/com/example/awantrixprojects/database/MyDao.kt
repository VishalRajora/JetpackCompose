package com.example.awantrixprojects.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.awantrixprojects.modelClasses.AuthModelClass

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertAuth(auth: AuthModelClass): Long

}
