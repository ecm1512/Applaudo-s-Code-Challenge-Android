package com.educode.applaudocodechallengeandroid.presentation.home.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.educode.applaudocodechallengeandroid.domain.entities.Popular
import com.educode.applaudocodechallengeandroid.domain.entities.Season
import com.educode.applaudocodechallengeandroid.domain.usecases.GetSeasonsByShow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getSeasonsByShow: GetSeasonsByShow
): ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _dataSeason = MutableLiveData<List<Season>>(listOf())
    val dataSeason: LiveData<List<Season>> get() = _dataSeason

    fun loadSeasons(id: Int){
        viewModelScope.launch {
            try{
                _isLoading.value = true
                val response = withContext(Dispatchers.IO){
                    getSeasonsByShow.invoke(id)
                }
                _dataSeason.value = response
                _isLoading.value = false
            }catch (e: Exception){
                Log.e("Detail Fragment","Error retrieving seasons $e")
                _isLoading.value = false
            }
        }
    }
}