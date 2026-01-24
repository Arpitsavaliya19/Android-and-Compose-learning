package com.example.dessertclicker.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Data class to represent the state of the Dessert Clicker app.
 */
data class DessertClickerUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = Datasource.dessertList[0].price,
    val currentDessertImageId: Int = Datasource.dessertList[0].imageId,
)

/**
 * ViewModel for the Dessert Clicker app.
 */
class DessertClickerViewmodel : ViewModel() {

    private val desserts: List<Dessert> = Datasource.dessertList

    // Private mutable state flow
    private val _uiState = MutableStateFlow(DessertClickerUiState())
    // Public immutable state flow
    val uiState: StateFlow<DessertClickerUiState> = _uiState.asStateFlow()

    /**
     * Updates the revenue, desserts sold, and the current dessert.
     */
    fun onDessertClicked() {
        _uiState.update { currentState ->
            val newRevenue = currentState.revenue + currentState.currentDessertPrice
            val newDessertsSold = currentState.dessertsSold + 1

            // Determine the next dessert
            val nextDessertIndex = determineNextDessertIndex(newDessertsSold)
            val nextDessert = desserts[nextDessertIndex]

            currentState.copy(
                revenue = newRevenue,
                dessertsSold = newDessertsSold,
                currentDessertIndex = nextDessertIndex,
                currentDessertPrice = nextDessert.price,
                currentDessertImageId = nextDessert.imageId
            )
        }
    }

    /**
     *  Determine which dessert to show.
     */
    private fun determineNextDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (i in desserts.indices) {
            if (dessertsSold >= desserts[i].startProductionAmount) {
                dessertIndex = i
            } else {
                // The list of desserts is sorted by startProductionAmount. As soon as we find a
                // dessert that we haven't produced enough for, we stop searching.
                break
            }
        }
        return dessertIndex
    }
}
