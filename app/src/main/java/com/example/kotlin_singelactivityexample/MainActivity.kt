package com.example.kotlin_singelactivityexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlin_singelactivityexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Помещение значения во вьюМодель
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        binding.btnField.setOnClickListener { viewModel.setData(binding.editTextField.text.toString()) }

        // Навигация и фрагменты при помощи транзакций
        // -----------------------------------------------------------------------------------------
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.firstFragment -> supportFragmentManager.beginTransaction().replace(R.id.fragment, firstFragment).commit()
                R.id.secondFragment -> supportFragmentManager.beginTransaction().replace(R.id.fragment, secondFragment).commit()
                R.id.thirdFragment -> supportFragmentManager.beginTransaction().replace(R.id.fragment, thirdFragment).commit()
            }
            true
        }
        // -----------------------------------------------------------------------------------------

//        // Навигация и фрагменты при помощи AppBarConfiguration и setOf()
//        // -----------------------------------------------------------------------------------------
//        // Получаем ссылку на view-элемент фрагмента (контейнера) для NavController
//        // NavController - управляет фрагментами
//        val navController = findNavController(R.id.fragment)
//
//        // AppBarConfiguration принимает список фрагментов для переключения или нав-граф
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment))
//
//        // setupActionBarWithNavController устанавливает взаимосвязь между NavController-ом и AppBarConfiguration
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        // устанавливаем нав-контроллер в нижнее меню навигации
//        binding.bottomNavigationView.setupWithNavController(navController)
//        // -----------------------------------------------------------------------------------------


    }
}