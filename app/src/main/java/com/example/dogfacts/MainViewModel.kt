package com.example.dogfacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    var dogFactResponse: MutableLiveData<List<DogFact>> = MutableLiveData()

    fun getDogFact() {
        viewModelScope.launch {
            val response = repository.getDogFact()
            dogFactResponse.value = response
        }
    }

}