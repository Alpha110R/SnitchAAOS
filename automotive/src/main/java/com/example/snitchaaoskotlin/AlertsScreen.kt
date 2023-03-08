package com.example.snitchaaoskotlin

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*
import com.example.snitchaaoskotlin.utils.MyCharSequence

class AlertsScreen(carContext: CarContext): Screen(carContext) {

    private val title = MyCharSequence("Alert");
    override fun onGetTemplate(): Template {
        val row = Row.Builder().setTitle(title).build()
        val pane = Pane.Builder()
            .addRow(row)
            .build()
        return PaneTemplate.Builder(pane)
            .setHeaderAction(Action.BACK)
            .build()
    }

}