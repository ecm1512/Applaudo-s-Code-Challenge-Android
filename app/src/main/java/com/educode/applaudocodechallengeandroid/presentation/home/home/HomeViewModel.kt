package com.educode.applaudocodechallengeandroid.presentation.home.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.educode.applaudocodechallengeandroid.domain.entities.AiringToday
import com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir
import com.educode.applaudocodechallengeandroid.domain.entities.Popular
import com.educode.applaudocodechallengeandroid.domain.entities.TopRated
import com.educode.applaudocodechallengeandroid.domain.usecases.GetPopularShows
import com.educode.applaudocodechallengeandroid.domain.usecases.GetTopRatedShows
import com.educode.applaudocodechallengeandroid.domain.usecases.GetTvAiringTodayShows
import com.educode.applaudocodechallengeandroid.domain.usecases.GetTvOnTheAirShows
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getPopularShows: GetPopularShows,
    private val getTopRatedShows: GetTopRatedShows,
    private val getTvAiringTodayShows: GetTvAiringTodayShows,
    private val getTvOnTheAirShows: GetTvOnTheAirShows
) : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _dataPopularShows = MutableLiveData<List<Popular>>(listOf())
    val dataPopularShows: LiveData<List<Popular>> get() = _dataPopularShows

    private val _dataTopRatedShows = MutableLiveData<List<TopRated>>(listOf())
    val dataTopRatedShows: LiveData<List<TopRated>> get() = _dataTopRatedShows

    private val _dataTvAiringTodayShows = MutableLiveData<List<AiringToday>>(listOf())
    val dataTvAiringTodayShows: LiveData<List<AiringToday>> get() = _dataTvAiringTodayShows

    private val _dataTvOnTheAirShows = MutableLiveData<List<OnTheAir>>(listOf())
    val dataTvOnTheAirShows: LiveData<List<OnTheAir>> get() = _dataTvOnTheAirShows

    fun loadPopularShows(){
        viewModelScope.launch {
            try{
                _isLoading.value = true
                val response = withContext(Dispatchers.IO){
                    getPopularShows.invoke()
                }
                _dataPopularShows.value = response
                _isLoading.value = false
            }catch (e: Exception){
                Log.e("Home Fragment","Error retrieving PopularShows $e")
                _isLoading.value = false
            }
        }
    }

    fun loadTopRatedShows(){
        viewModelScope.launch {
            try{
                val response = withContext(Dispatchers.IO){
                    getTopRatedShows.invoke()
                }

                _dataTopRatedShows.value = response
            }catch (e: Exception){
                Log.e("Home Fragment","Error retrieving topRatedShows")
            }
        }
    }

    fun loadAiringTodayShows(){
        viewModelScope.launch {
            try{
                val response = withContext(Dispatchers.IO){
                    getTvAiringTodayShows.invoke()
                }

                _dataTvAiringTodayShows.value = response
            }catch (e: Exception){
                Log.e("Home Fragment","Error retrieving AiringTodayShows")
            }
        }
    }

    fun loadOnTheAirShows(){
        viewModelScope.launch {
            try{
                val response = withContext(Dispatchers.IO){
                    getTvOnTheAirShows.invoke()
                }

                _dataTvOnTheAirShows.value = response
            }catch (e: Exception){
                Log.e("Home Fragment","Error retrieving OnTheAirShows")
            }
        }
    }
}