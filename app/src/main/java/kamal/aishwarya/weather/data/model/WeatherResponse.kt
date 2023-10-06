package kamal.aishwarya.weather.data.model


import com.google.gson.annotations.SerializedName
import kamal.aishwarya.weather.model.Weather

data class WeatherResponse(
    @SerializedName("current") val current: NetworkCurrentWeather,
    @SerializedName("location") val location: Location
) {
    data class NetworkCurrentWeather(
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

fun WeatherResponse.toWeather() : Weather = Weather(
    temperature = current.tempC.toInt(),
    wind = current.windKph.toInt(),
    humidity = current.humidity,
    feelsLike = current.feelslikeC.toInt(),
    condition = current.condition,
    uv = current.uv.toInt(),
    name = location.name,
)