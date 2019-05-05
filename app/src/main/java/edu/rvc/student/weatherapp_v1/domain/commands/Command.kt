package edu.rvc.student.weatherapp_v1.domain.commands

public interface Command<out T> {
    fun execute(): T
}