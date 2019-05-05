package edu.rvc.student.weatherapp_v1.domain.model

import edu.rvc.student.weatherapp_v1.data.Forecast

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)
