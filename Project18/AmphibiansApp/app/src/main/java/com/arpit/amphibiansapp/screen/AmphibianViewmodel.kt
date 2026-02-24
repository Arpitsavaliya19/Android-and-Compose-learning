package com.arpit.amphibiansapp.screen

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.arpit.amphibiansapp.AmphibianApplication
import com.arpit.amphibiansapp.data.AmphibianRepository
import com.arpit.amphibiansapp.model.Amphibian
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AmphibianUIState {
    data class Success(val Detail: List<Amphibian>) : AmphibianUIState
    object Error : AmphibianUIState
    object Loading : AmphibianUIState
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class AmphibianViewmodel(
     val repository: AmphibianRepository
) : ViewModel(), AmphibianUIState {
     var amphibianUiState: AmphibianUIState by mutableStateOf(AmphibianUIState.Loading)
        private set

    init {
        getAmphibians()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
     fun getAmphibians() {
        viewModelScope.launch {
            amphibianUiState = AmphibianUIState.Loading
            amphibianUiState = try {
                AmphibianUIState.Success(
                    repository.getAmphibiansDetail()
                )
            } catch (e: IOException) {
                AmphibianUIState.Error
            } catch (e: HttpException) {
                AmphibianUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                val amphibianRepository = application.container.amphibiansRepository
                AmphibianViewmodel(repository = amphibianRepository)
            }
        }
    }
}
