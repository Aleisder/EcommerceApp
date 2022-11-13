package com.aleisder.ecommerceapp.repository

import com.aleisder.ecommerceapp.models.mainscreen.PhonesOnMain
import com.aleisder.ecommerceapp.models.mycart.Invoice
import com.aleisder.ecommerceapp.models.productdetails.DetailedPhone

interface EcommerceRepository {

    suspend fun getHotSales(): PhonesOnMain

    suspend fun getDetailedPhone(): DetailedPhone

    suspend fun getInvoice(): Invoice

}