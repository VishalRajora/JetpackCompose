package com.example.awantrixprojects.modelClasses

data class Package(
    val address_id: String,
    val count: Int,
    val courier: String,
    val experience_code: String,
    val experience_id: Int,
    val experience_type: String,
    val is_editable: Boolean,
    val is_splitable: Boolean,
    val journey_id: String,
    val max_split_count: Int,
    val parcels: List<Parcel>,
    val pkg_id: String
)