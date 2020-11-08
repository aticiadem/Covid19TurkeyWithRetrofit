package com.adematici.covid19infoturkey.service

import com.adematici.covid19infoturkey.model.CoronaModel
import retrofit2.Call
import retrofit2.http.GET

interface CoronaAPI {

    // https://covid19.saglik.gov.tr/covid19api?getir=sondurum
    @GET("covid19api?getir=sondurum")
    fun getData():Call<List<CoronaModel>>
}