package com.example.awantrixprojects.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.awantrixprojects.modelClasses.AuthModelClass

@Database(entities = [AuthModelClass::class], version = 1, exportSchema = true)
abstract class AuthDatabase : RoomDatabase() {
    abstract fun authDao(): MyDao
}