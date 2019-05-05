package edu.rvc.student.weatherapp_v1.domain.commands

import edu.rvc.student.weatherapp_v1.data.ForecastRequest
import edu.rvc.student.weatherapp_v1.domain.mappers.ForecastDataMapper
import edu.rvc.student.weatherapp_v1.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) :
    Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
            forecastRequest.execute())
    }
}