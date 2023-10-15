package kamal.aishwarya.weather.ui.weather.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kamal.aishwarya.weather.R

@Composable
fun WeatherComponent(
    modifier: Modifier = Modifier,
    weatherLabel: String,
    weatherValue: String,
    weatherUnit: String,
    iconId: Int,
) {
    ElevatedCard(
        modifier = modifier
            .padding(end = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = weatherLabel,
                style = MaterialTheme.typography.bodySmall,
            )
            Image(
                painter = painterResource(id = iconId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = weatherValue,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = weatherUnit,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WeatherComponentPreview() {
    WeatherComponent(
        weatherLabel = "wind speed",
        weatherValue = "22",
        weatherUnit = "km/h",
        iconId = R.drawable.ic_wind
    )
}