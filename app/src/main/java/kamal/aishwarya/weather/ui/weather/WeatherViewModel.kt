package kamal.aishwarya.weather.ui.weather

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kamal.aishwarya.weather.data.repository.WeatherRepository
import kamal.aishwarya.weather.utils.Result
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
) : ViewModel() {

    private val _uiState: MutableState<WeatherUiState> = mutableStateOf(WeatherUiState())
    val uiState: State<WeatherUiState> = _uiState

    init {
        getWeather()
    }

    private fun getWeather() {
        repository.getWeatherForecast().map { result ->
            when (result) {
                is Result.Success -> {
                    _uiState.value = WeatherUiState(weather = result.data)
                }
                is Result.Error -> {
                    _uiState.value = WeatherUiState(errorMessage = result.exception.toString())
                }
                Result.Loading -> {
                    _uiState.value = WeatherUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}