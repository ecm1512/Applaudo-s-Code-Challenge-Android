package com.educode.applaudocodechallengeandroid.module

import android.app.Application
import com.educode.applaudocodechallengeandroid.R
import com.educode.applaudocodechallengeandroid.data.database.MovieDatabase
import com.educode.applaudocodechallengeandroid.data.database.MovieDbDataSource
import com.educode.applaudocodechallengeandroid.data.repository.MovieRepository
import com.educode.applaudocodechallengeandroid.data.repository.SeasonRepository
import com.educode.applaudocodechallengeandroid.data.service.MovieServiceDataSource
import com.educode.applaudocodechallengeandroid.data.source.LocalDataSource
import com.educode.applaudocodechallengeandroid.data.source.RemoteDataSource
import com.educode.applaudocodechallengeandroid.domain.usecases.GetPopularShows
import com.educode.applaudocodechallengeandroid.domain.usecases.GetSeasonsByShow
import com.educode.applaudocodechallengeandroid.domain.usecases.GetTopRatedShows
import com.educode.applaudocodechallengeandroid.domain.usecases.GetTvAiringTodayShows
import com.educode.applaudocodechallengeandroid.domain.usecases.GetTvOnTheAirShows
import com.educode.applaudocodechallengeandroid.presentation.home.detail.DetailFragment
import com.educode.applaudocodechallengeandroid.presentation.home.detail.DetailViewModel
import com.educode.applaudocodechallengeandroid.presentation.home.home.HomeFragment
import com.educode.applaudocodechallengeandroid.presentation.home.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI(){
    startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    single(named("apiKey")) { androidApplication().getString(R.string.api_key) }
    single { MovieDatabase.build(get()) }
    factory<RemoteDataSource> { MovieServiceDataSource() }
    factory<LocalDataSource> { MovieDbDataSource(get()) }
}

private val dataModule = module {
    factory { MovieRepository(get(),get(), get(named("apiKey"))) }
    factory { SeasonRepository(get(),get(), get(named("apiKey"))) }
}

private val scopesModule = module {
    scope(named<HomeFragment>()){
        viewModel { HomeViewModel(get(), get(), get(), get()) }
        scoped { GetTvAiringTodayShows(get()) }
        scoped { GetPopularShows(get()) }
        scoped { GetTopRatedShows(get()) }
        scoped { GetTvOnTheAirShows(get()) }
    }

    scope(named<DetailFragment>()){
        viewModel { DetailViewModel(get()) }
        scoped { GetSeasonsByShow(get()) }
    }
}