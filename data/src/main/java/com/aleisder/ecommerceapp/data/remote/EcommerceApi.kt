package com.aleisder.ecommerceapp.data.remote

import com.aleisder.ecommerceapp.models.mainscreen.PhonesOnMain
import com.aleisder.ecommerceapp.models.mycart.Invoice
import com.aleisder.ecommerceapp.models.productdetails.DetailedPhone
import retrofit2.http.GET

interface EcommerceApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHotSales(): PhonesOnMain

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetailedPhone(): DetailedPhone

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getInvoice(): Invoice

}