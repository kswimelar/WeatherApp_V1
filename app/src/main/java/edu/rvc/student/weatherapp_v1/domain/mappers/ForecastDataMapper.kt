package edu.rvc.student.weatherapp_v1.domain.mappers

import edu.rvc.student.weatherapp_v1.data.ForecastResult
import edu.rvc.student.weatherapp_v1.domain.model.ForecastList as ModelForecast
import java.text.DateFormat
import java.util.concurrent.TimeUnit
import java.util.*

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): edu.rvc.student.weatherapp_v1.domain.model.ForecastList =
        edu.rvc.student.weatherapp_v1.domain.model.ForecastList(
            forecast.city.name,
            forecast.city.country,
            convertForecastListToDomain(forecast.list)
        )

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
            forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}