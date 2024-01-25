package com.example.finalmovie.model

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/now_playing")
    @Headers(
        "accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MDM3YTAwN2ZhMmE5MzM1NTdmNWYyMzBlMGYyZTYwZiIsInN1YiI6IjY0OTkzOGVkNmY0M2VjMDBjNWM3MmY4NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Rx-ZZRTbVM_ZeG4dP60TI56W8kUOt5v1pAJNwRaoQaY"
    )
    suspend fun getNowPlayingMovies(
        @Query("language") language: String = "ko-KR",
        @Query("page") page: Int = 1,
        @Query("region") region: String = "kr",
    ): MovieResponse
}