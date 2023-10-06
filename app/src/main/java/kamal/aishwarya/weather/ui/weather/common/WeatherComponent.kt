package kamal.aishwarya.weather.ui.weather.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kamal.aishwarya.weather.R

@Composable
fun WeatherComponent(
    modifier: Modifier = Modifier,
    text: String,
    icon: String?,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 8.dp)
    ) {
        Column {
            AsyncImage(
                modifier = Modifier.fillMaxWidth().height(64.dp),
                model = "https:$icon",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground)
            )
            Text(
                modifier = Modifier
                    .padding(18.dp)
                    .align(Alignment.CenterHorizontally),
                text = text,
            )
        }
    }
}

@Preview
@Composable
fun WeatherComponentPreview() {
    WeatherComponent(text = "22", icon = "https://cdn.weatherapi.com/weather/64x64/day/116.png")
}