package com.aleisder.ecommerceapp.presentation.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aleisder.ecommerceapp.presentation.store.adapters.BestSellerAdapter
import com.aleisder.ecommerceapp.presentation.store.adapters.HotSalesAdapter
import com.example.ecommerceapp.databinding.FragmentStoreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreFragment: Fragment() {

    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.phonesOnMain.observe(viewLifecycleOwner) {

            binding.rvHotSalesList.apply {
                adapter = HotSalesAdapter(it.home_store)
                setHasFixedSize(true)
            }

            binding.rvBestSellerGrid.apply {
                adapter = BestSellerAdapter(it.best_seller, requireContext())
                setHasFixedSize(true)
            }
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}