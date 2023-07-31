package com.example.kotlin_singelactivityexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.kotlin_singelactivityexample.databinding.ActivityMainBinding
import com.example.kotlin_singelactivityexample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var viewModel: ItemViewModel
    private var binding: FragmentFirstBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding?.apply {
            textView.text = "First Fragment"

            // Управление перехода через экшен графа навигации
            root.setOnClickListener { Navigation.findNavController(binding!!.root).navigate(R.id.action_firstFragment_to_secondFragment) }

            // Получение данных через ViewModel
            viewModel.getSelectedItem().observe(this@FirstFragment) {
                fieldText.text = it
            }
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}