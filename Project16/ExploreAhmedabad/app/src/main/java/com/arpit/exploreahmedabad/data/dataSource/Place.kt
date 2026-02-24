package com.arpit.exploreahmedabad.data.dataSource

data class Place(
    val id: Int,
    val imageResourceId: Int,
    val nameResourceId: Int,
    val locationResourceId: Int,
    val descriptionResourceId: Int,
    val category: PlaceCategory
)
