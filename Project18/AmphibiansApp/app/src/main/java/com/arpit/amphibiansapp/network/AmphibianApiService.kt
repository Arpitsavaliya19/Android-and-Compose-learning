package com.arpit.amphibiansapp.network

import com.arpit.amphibiansapp.model.Amphibian
import retrofit2.http.GET


//base url
//https://android-kotlin-fun-mars-server.appspot.com/amphibians
// here this method is return our data from the api service
interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}