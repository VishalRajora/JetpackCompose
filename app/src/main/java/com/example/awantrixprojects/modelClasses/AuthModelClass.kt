package com.example.awantrixprojects.modelClasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AuthTable")
data class AuthModelClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val password: String,
    val address: String,
    val phoneNum: String
)
