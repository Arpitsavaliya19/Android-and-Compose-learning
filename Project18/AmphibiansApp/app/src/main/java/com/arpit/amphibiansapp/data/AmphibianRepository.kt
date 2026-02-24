package com.arpit.amphibiansapp.data

import com.arpit.amphibiansapp.model.Amphibian
import com.arpit.amphibiansapp.network.AmphibianApiService


// we make the Repository
// don't know how data is created and where the data is.
//only work of Repository is get the data from the network
interface AmphibianRepository {
    suspend fun getAmphibiansDetail(): List<Amphibian>
}

class NetworkAmphibianRepository(
    private val amphibianApiService: AmphibianApiService
) : AmphibianRepository {
    // fetched list from the Amphibian api service
    override suspend fun getAmphibiansDetail(): List<Amphibian> = amphibianApiService.getAmphibians()
}
