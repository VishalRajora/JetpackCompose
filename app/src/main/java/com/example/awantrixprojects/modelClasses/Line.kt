package com.example.awantrixprojects.modelClasses

data class Line(
    val allocation_line_id: String,
    val barcode: String,
    val brand: String,
    val comment: String,
    val dept_name: String,
    val fulfilment_line_status: String,
    val height: String,
    val image_url: String,
    val is_po_pending: String,
    val item_size: String,
    val length: String,
    val line_nbr: Int,
    val po_qty: Double,
    val prod_nbr: String,
    val prod_qty: String,
    val product_descr: String,
    val serial_nbr: String,
    val sup_prod_nbr: String,
    val unit_of_measure: String,
    val volume: String,
    val weight: String,
    val width: String
)