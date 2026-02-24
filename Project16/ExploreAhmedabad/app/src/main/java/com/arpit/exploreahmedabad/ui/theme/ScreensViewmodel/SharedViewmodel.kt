package com.arpit.exploreahmedabad.ui.theme.ScreensViewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.arpit.exploreahmedabad.data.dataSource.AhmedabadDataProvider
import com.arpit.exploreahmedabad.data.dataSource.Place
import com.arpit.exploreahmedabad.data.dataSource.PlaceCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShareedViewmodel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoryUiState())
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()

    fun updatePlace(place: Place) {
        _uiState.update {
            it.copy(place = place)
        }
    }

    fun updateCategory(category: PlaceCategory) {
        val places = AhmedabadDataProvider.place.filter { it.category == category }
        _uiState.update {
            it.copy(
                places = places,
                place = it.place ?: places.firstOrNull()
            )
        }
    }
}

data class CategoryUiState(
    val places: List<Place> = emptyList(),
    val place: Place? = null
)