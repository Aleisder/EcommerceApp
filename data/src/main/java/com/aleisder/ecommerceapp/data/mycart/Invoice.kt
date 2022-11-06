package com.aleisder.ecommerceapp.data.mycart

data class Invoice(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)