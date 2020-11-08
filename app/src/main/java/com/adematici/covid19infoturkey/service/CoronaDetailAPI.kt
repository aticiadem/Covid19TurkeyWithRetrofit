package com.adematici.covid19infoturkey.service

import com.adematici.covid19infoturkey.model.CoronaModel
import retrofit2.Call
import retrofit2.http.GET

interface CoronaDetailAPI {

    // https://covid19.saglik.gov.tr/covid19api?getir=liste
    @GET("covid19api?getir=liste")
    fun getData():Call<List<CoronaModel>>

}