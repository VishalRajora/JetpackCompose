package com.example.awantrixprojects.repository

import com.example.awantrixprojects.database.MyDao
import com.example.awantrixprojects.modelClasses.AuthModelClass
import timber.log.Timber
import javax.inject.Inject

class HomeRepo @Inject constructor(private val dao: MyDao) {



    suspend fun saveData(email: String, password: String) {
        val data = AuthModelClass(0, email, password, "", "")
        val result = dao.InsertAuth(data)
        Timber.i("Save $result")
    }

}