package com.example.snitchaaoskotlin

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*
import androidx.car.app.model.Action.*

class MainScreen (carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val row = Row.Builder().setTitle("Hello world!").build()
        val pane = Pane.Builder().addRow(row).build()
        return PaneTemplate.Builder(pane)
            .setHeaderAction(APP_ICON)
            .build()
    }
    val template = MessageTemplate.Builder("Second screen Hello world!")
        .setHeaderAction(Action.BACK)
        .addAction(
            Action.Builder()
                .setTitle("Next screen")
                .setOnClickListener { screenManager.push(SecondScreen(carContext)) }
                .build())
        .build()
}