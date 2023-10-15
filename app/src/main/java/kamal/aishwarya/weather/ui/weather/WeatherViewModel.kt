package kamal.aishwarya.weather.ui.weather

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kamal.aishwarya.weather.data.repository.WeatherRepository
import kamal.aishwarya.weather.utils.DEFAULT_WEATHER_DESTINATION
import kamal.aishwarya.weather.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<WeatherUiState> =
        MutableStateFlow(WeatherUiState(isLoading = true))
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    init {
        getWeather()
    }

    fun getWeather(city: String = DEFAULT_WEATHER_DESTINATION) {
        repository.getWeatherForecast(city).map { result ->
            when (result) {
                is Result.Success -> {
                    _uiState.value = WeatherUiState(weather = result.data)
                }

                is Result.Error -> {
                    _uiState.value = WeatherUiState(errorMessage = result.errorMessage)
                }

                Result.Loading -> {
                    _uiState.value = WeatherUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}