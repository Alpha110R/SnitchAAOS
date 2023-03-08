package com.example.snitchaaoskotlin

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*
import androidx.car.app.model.Action.*
import androidx.core.graphics.drawable.IconCompat
import com.example.snitchaaoskotlin.utils.MyCharSequence

class MainScreen (carContext: CarContext) : Screen(carContext) {

    // Icon for Car
    //val mGridIcon = IconCompat.createWithResource(carContext,R.drawable.ic_car_icon)
    // Icon for Alerts
    private val mGridAlertIcon = IconCompat.createWithResource(carContext,R.drawable.ic_alert_icon)
    // Icon for Search
    //val mGridSearchIcon = IconCompat.createWithResource(carContext,R.drawable.ic_search_icon)

    //Grid Item no.2
    val gridItemAlerts = GridItem.Builder()
        .setTitle(MyCharSequence("Alerts"))
    .setImage(CarIcon.Builder(mGridAlertIcon).build(),
    GridItem.IMAGE_TYPE_LARGE)
    .setOnClickListener {
        screenManager.push(AlertsScreen(carContext))
    }.build()

    val gridList = ItemList.Builder()
        .addItem(gridItemAlerts)
        .build()

    override fun onGetTemplate(): Template {
        val row = Row.Builder().setTitle("Hello world!").build()
        val pane = Pane.Builder().addRow(row).build()
        return GridTemplate.Builder()
            .setTitle(MyCharSequence("Car Information App"))
        .setSingleList(gridList)
            .build()
        /*return PaneTemplate.Builder(pane)
            .setHeaderAction(APP_ICON)
            .build()*/
    }
}