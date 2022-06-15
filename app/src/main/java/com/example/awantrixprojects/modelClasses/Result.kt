package com.example.awantrixprojects.modelClasses

data class Result(
    val allocation_id: String,
    val customer_name: String,
    val cut_off_time: String,
    val order_date: String,
    val order_id: String,
    val order_notes: List<OrderNote>,
    val order_number: Int,
    val order_status: String,
    val package_wrap: Boolean,
    val packages: List<Package>,
    val partial_pick: Boolean,
    val pos_order_number: String,
    val shipping_address: String
)