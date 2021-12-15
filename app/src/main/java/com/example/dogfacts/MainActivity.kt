package com.example.dogfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.dogfacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.btnGetDogFact.setOnClickListener {
            viewModel.getDogFact()
        }

        viewModel.dogFactResponse.observe(this, { list ->
            binding.tvSetDogFact.text = ""
            list.forEach {
                binding.tvSetDogFact.append(it.fact)
            }
        })
    }
}