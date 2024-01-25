package com.example.finalmovie.model

import android.util.Log
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 기능을 수행한다.
class MovieRepository {

    private val movieApi: MovieApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        Log.d("tag_movie", "retrofit instantiated")
        movieApi = retrofit.create(MovieApi::class.java)
        Log.d("tag_movie", "movieApi instantiated")
    }
    // 영화, 현재상영작 목록을 조회
    suspend fun getNowPlayingMovies(): MovieResponse {
        // 레트로핏 인터페이스를 호출하면서 구현
        Log.d("tag_movie", "MovieRepository::getNowPlayingMovies start")
        return movieApi.getNowPlayingMovies()
    }
}