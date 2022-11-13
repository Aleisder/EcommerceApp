package com.aleisder.ecommerceapp.data.remote

import com.aleisder.ecommerceapp.models.mainscreen.PhonesOnMain
import com.aleisder.ecommerceapp.models.mycart.Invoice
import com.aleisder.ecommerceapp.models.productdetails.DetailedPhone
import com.aleisder.ecommerceapp.repository.EcommerceRepository
import javax.inject.Inject

class EcommerceRepositoryImpl @Inject constructor(
    private val api: EcommerceApi
) : EcommerceRepository {

    override suspend fun getHotSales(): PhonesOnMain {
        return api.getHotSales()
    }

    override suspend fun getDetailedPhone(): DetailedPhone {
        return api.getDetailedPhone()
    }

    override suspend fun getInvoice(): Invoice {
        return api.getInvoice()
    }

}