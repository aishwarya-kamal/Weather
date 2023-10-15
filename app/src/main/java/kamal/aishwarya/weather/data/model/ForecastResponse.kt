package kamal.aishwarya.weather.data.model


import com.google.gson.annotations.SerializedName
import kamal.aishwarya.weather.data.model.ForecastResponse.NetworkForecast.NetworkForecastday
import kamal.aishwarya.weather.model.Forecast
import kamal.aishwarya.weather.model.Hour
import kamal.aishwarya.weather.model.Weather

data class ForecastResponse(
    @SerializedName("current") val current: Current,
    @SerializedName("forecast") val forecast: NetworkForecast,
    @SerializedName("location") val location: Location
) {
    data class Current(
        @SerializedName("cloud") val cloud: Int,
        @SerializedName("condition") val condition: Condition,
        @SerializedName("feelslike_c") val feelslikeC: Double,
        @SerializedName("feelslike_f") val feelslikeF: Double,
        @SerializedName("gust_kph") val gustKph: Double,
        @SerializedName("gust_mph") val gustMph: Double,
        @SerializedName("humidity") val humidity: Int,
        @SerializedName("is_day") val isDay: Int,
        @SerializedName("last_updated") val lastUpdated: String,
        @SerializedName("last_updated_epoch") val lastUpdatedEpoch: Int,
        @SerializedName("precip_in") val precipIn: Double,
        @SerializedName("precip_mm") val precipMm: Double,
        @SerializedName("pressure_in") val pressureIn: Double,
        @SerializedName("pressure_mb") val pressureMb: Double,
        @SerializedName("temp_c") val tempC: Double,
        @SerializedName("temp_f") val tempF: Double,
        @SerializedName("uv") val uv: Double,
        @SerializedName("vis_km") val visKm: Double,
        @SerializedName("vis_miles") val visMiles: Double,
        @SerializedName("wind_degree") val windDegree: Int,
        @SerializedName("wind_dir") val windDir: String,
        @SerializedName("wind_kph") val windKph: Double,
        @SerializedName("wind_mph") val windMph: Double
    ) {
        data class Condition(
            @SerializedName("code") val code: Int,
            @SerializedName("icon") val icon: String,
            @SerializedName("text") val text: String
        )
    }

    data class NetworkForecast(
        @SerializedName("forecastday") val forecastday: List<NetworkForecastday>
    ) {
        data class NetworkForecastday(
            @SerializedName("astro") val astro: Astro,
            @SerializedName("date") val date: String,
            @SerializedName("date_epoch") val dateEpoch: Int,
            @SerializedName("day") val day: Day,
            @SerializedName("hour") val hour: List<NetworkHour>
        ) {
            data class Astro(
                @SerializedName("is_moon_up") val isMoonUp: Int,
                @SerializedName("is_sun_up") val isSunUp: Int,
                @SerializedName("moon_illumination") val moonIllumination: String,
                @SerializedName("moon_phase") val moonPhase: String,
                @SerializedName("moonrise") val moonrise: String,
                @SerializedName("moonset") val moonset: String,
                @SerializedName("sunrise") val sunrise: String,
                @SerializedName("sunset") val sunset: String
            )

            data class Day(
                @SerializedName("avghumidity") val avghumidity: Double,
                @SerializedName("avgtemp_c") val avgtempC: Double,
                @SerializedName("avgtemp_f") val avgtempF: Double,
                @SerializedName("avgvis_km") val avgvisKm: Double,
                @SerializedName("avgvis_miles") val avgvisMiles: Double,
                @SerializedName("condition") val condition: Condition,
                @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
                @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int,
                @SerializedName("daily_will_it_rain") val dailyWillItRain: Int,
                @SerializedName("daily_will_it_snow") val dailyWillItSnow: Int,
                @SerializedName("maxtemp_c") val maxtempC: Double,
                @SerializedName("maxtemp_f") val maxtempF: Double,
                @SerializedName("maxwind_kph") val maxwindKph: Double,
                @SerializedName("maxwind_mph") val maxwindMph: Double,
                @SerializedName("mintemp_c") val mintempC: Double,
                @SerializedName("mintemp_f") val mintempF: Double,
                @SerializedName("totalprecip_in") val totalprecipIn: Double,
                @SerializedName("totalprecip_mm") val totalprecipMm: Double,
                @SerializedName("totalsnow_cm") val totalsnowCm: Double,
                @SerializedName("uv") val uv: Double
            ) {
                data class Condition(
                    @SerializedName("code") val code: Int,
                    @SerializedName("icon") val icon: String,
                    @SerializedName("text") val text: String
                )
            }

            data class NetworkHour(
                @SerializedName("chance_of_rain") val chanceOfRain: Int,
                @SerializedName("chance_of_snow") val chanceOfSnow: Int,
                @SerializedName("cloud") val cloud: Int,
                @SerializedName("condition") val condition: Condition,
                @SerializedName("dewpoint_c") val dewpointC: Double,
                @SerializedName("dewpoint_f") val dewpointF: Double,
                @SerializedName("feelslike_c") val feelslikeC: Double,
                @SerializedName("feelslike_f") val feelslikeF: Double,
                @SerializedName("gust_kph") val gustKph: Double,
                @SerializedName("gust_mph") val gustMph: Double,
                @SerializedName("heatindex_c") val heatindexC: Double,
                @SerializedName("heatindex_f") val heatindexF: Double,
                @SerializedName("humidity") val humidity: Int,
                @SerializedName("is_day") val isDay: Int,
                @SerializedName("precip_in") val precipIn: Double,
                @SerializedName("precip_mm") val precipMm: Double,
                @SerializedName("pressure_in") val pressureIn: Double,
                @SerializedName("pressure_mb") val pressureMb: Double,
                @SerializedName("temp_c") val tempC: Double,
                @SerializedName("temp_f") val tempF: Double,
                @SerializedName("time") val time: String,
                @SerializedName("time_epoch") val timeEpoch: Int,
                @SerializedName("uv") val uv: Double,
                @SerializedName("vis_km") val visKm: Double,
                @SerializedName("vis_miles") val visMiles: Double,
                @SerializedName("will_it_rain") val willItRain: Int,
                @SerializedName("will_it_snow") val willItSnow: Int,
                @SerializedName("wind_degree") val windDegree: Int,
                @SerializedName("wind_dir") val windDir: String,
                @SerializedName("wind_kph") val windKph: Double,
                @SerializedName("wind_mph") val windMph: Double,
                @SerializedName("windchill_c") val windchillC: Double,
                @SerializedName("windchill_f") val windchillF: Double
            ) {
                data class Condition(
                    @SerializedName("code") val code: Int,
                    @SerializedName("icon") val icon: String,
                    @SerializedName("text") val text: String
                )
            }
        }
    }

    data class Location(
        @SerializedName("country") val country: String,
        @SerializedName("lat") val lat: Double,
        @SerializedName("localtime") val localtime: String,
        @SerializedName("localtime_epoch") val localtimeEpoch: Int,
        @SerializedName("lon") val lon: Double,
        @SerializedName("name") val name: String,
        @SerializedName("region") val region: String,
        @SerializedName("tz_id") val tzId: String
    )
}

fun ForecastResponse.toWeather(): Weather = Weather(
    temperature = current.tempC.toInt(),
    date = forecast.forecastday[0].date,
    wind = current.windKph.toInt(),
    humidity = current.humidity,
    feelsLike = current.feelslikeC.toInt(),
    condition = current.condition,
    uv = current.uv.toInt(),
    name = location.name,
    forecasts = forecast.forecastday.map { networkForecastday ->
        networkForecastday.toWeatherForecast()
    }
)

fun NetworkForecastday.toWeatherForecast(): Forecast = Forecast(
    date = date,
    maxTemp = day.maxtempC.toInt().toString(),
    minTemp = day.mintempC.toInt().toString(),
    sunrise = astro.sunrise,
    sunset = astro.sunset,
    icon = day.condition.icon,
    hour = hour.map { networkHour ->
        networkHour.toHour()
    }
)

fun NetworkForecastday.NetworkHour.toHour(): Hour = Hour(
    time = time,
    icon = condition.icon,
    temperature = tempC.toInt().toString(),
)