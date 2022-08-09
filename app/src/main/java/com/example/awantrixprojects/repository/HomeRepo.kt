package com.example.awantrixprojects.repository

import com.example.awantrixprojects.database.MyDao
import com.example.awantrixprojects.modelClasses.AuthModelClass
import timber.log.Timber
import javax.inject.Inject

class HomeRepo @Inject constructor(private val dao: MyDao) {

    suspend fun saveData(email: String, password: String) : Long {
        val data = AuthModelClass(0, email, password, "", "")
        return dao.InsertAuth(data)
    }

}