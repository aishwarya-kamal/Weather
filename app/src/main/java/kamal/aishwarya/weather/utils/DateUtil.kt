package kamal.aishwarya.weather.utils

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateUtil {
    fun String.toFormattedDate(): String {
        val inputDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputDateFormat = SimpleDateFormat("MMM d", Locale.getDefault())

        try {
            val date = inputDateFormat.parse(this)
            if (date != null) {
                return outputDateFormat.format(date)
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
        return this
    }

    fun String.toFormattedDay(): String? {
        val dateComponents = this.split("-")
        return if (dateComponents.size == 3) {
            val year = dateComponents[0].toInt()
            val month = dateComponents[1].toInt() - 1
            val day = dateComponents[2].toInt()

            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)
            val outputDateFormat = SimpleDateFormat("EE", Locale.getDefault())
            return outputDateFormat.format(calendar.time)
        } else null
    }
}
