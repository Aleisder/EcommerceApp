package com.aleisder.ecommerceapp.presentation.store

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleisder.ecommerceapp.models.mainscreen.PhonesOnMain
import com.aleisder.ecommerceapp.repository.EcommerceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: EcommerceRepository
) : ViewModel() {

    private var _phonesOnMain = MutableLiveData<PhonesOnMain>()
    val phonesOnMain: LiveData<PhonesOnMain> = _phonesOnMain

    init {
        getPhonesOnMain()
    }

    private fun getPhonesOnMain() {
        viewModelScope.launch {
            _phonesOnMain.value = try {
                repository.getHotSales()
            } catch (E: Exception) {
                Log.e(TAG, E.message!!)
                return@launch
            }
        }
    }
}