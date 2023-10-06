package kamal.aishwarya.weather.ui.weather

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kamal.aishwarya.weather.data.model.WeatherResponse
import kamal.aishwarya.weather.model.Weather
import kamal.aishwarya.weather.ui.weather.common.WeatherComponent

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val uiState: WeatherUiState by viewModel.uiState
    WeatherScreenContent(uiState.weather, modifier)
}

@Composable
fun WeatherScreenContent(
    weather: Weather?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = weather?.name.orEmpty(),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = weather?.temperature.toString(),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            WeatherComponent(
                modifier = Modifier.weight(1f),
                text = weather?.wind.toString(),
                icon = weather?.condition?.icon,
            )
            WeatherComponent(
                modifier = Modifier.weight(1f),
                text = weather?.uv.toString(),
                icon = weather?.condition?.icon,
            )
            WeatherComponent(
                modifier = Modifier.weight(1f),
                text = weather?.humidity.toString(),
                icon = weather?.condition?.icon,
            )

        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WeatherScreenContentPreview() {
    WeatherScreenContent(
        Weather(
            25.0,
            22.22,
            35,
            23.0,
            WeatherResponse.NetworkCurrentWeather.Condition(10, "", ""),
            3.0,
            "Munich"
        )
    )
}