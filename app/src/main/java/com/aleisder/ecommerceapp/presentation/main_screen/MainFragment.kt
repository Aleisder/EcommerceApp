package com.aleisder.ecommerceapp.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aleisder.ecommerceapp.presentation.main_screen.adapters.HotSalesAdapter
import com.example.ecommerceapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainFragment"

@AndroidEntryPoint
class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.phonesOnMain.observe(viewLifecycleOwner) {
            binding.rvHotSalesList.apply {
                adapter = HotSalesAdapter(it.home_store)
                setHasFixedSize(true)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}