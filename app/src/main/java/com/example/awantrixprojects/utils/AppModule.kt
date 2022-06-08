package com.example.awantrixprojects.utils

import android.app.Application
import androidx.room.Room
import com.example.awantrixprojects.database.AuthDatabase
import com.example.awantrixprojects.database.MyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataBase(application: Application): AuthDatabase {
        return Room.databaseBuilder(
            application,
            AuthDatabase::class.java,
            "MyDatabase"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideDao(authDatabase: AuthDatabase): MyDao {
        return authDatabase.authDao()
    }

}