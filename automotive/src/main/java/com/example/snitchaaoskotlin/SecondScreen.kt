package com.example.snitchaaoskotlin

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*

class SecondScreen (carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val row = Row.Builder().setTitle("Second screen!").build()
        val pane = Pane.Builder().addRow(row).build()
        return PaneTemplate.Builder(pane)
            .setHeaderAction(Action.APP_ICON)
            .build()
    }
}