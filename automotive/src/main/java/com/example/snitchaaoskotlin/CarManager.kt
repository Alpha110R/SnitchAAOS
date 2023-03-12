package com.example.snitchaaoskotlin

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.util.Log
import androidx.car.app.CarAppService
import androidx.car.app.CarContext
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.hardware.info.CarInfo
import androidx.car.app.hardware.info.*
import androidx.car.app.hardware.common.CarUnit
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlin.coroutines.jvm.internal.CompletedContinuation.context


class CarManager : CarAppService() {
    //lateinit var carContext: CarContext
    lateinit var carInfo: ApplicationInfo
    lateinit var carHardwareManager: CarHardwareManager
    lateinit var carUnit: CarUnit


    @SuppressLint("PrivateResource")
    override fun createHostValidator(): HostValidator {
        Log.d("tagg", "createHostValidator: ")
        
        return if(applicationInfo.flags and  ApplicationInfo.FLAG_DEBUGGABLE !=0){
            HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
        }
        else{
            HostValidator.Builder(applicationContext)
                .addAllowedHosts(androidx.car.app.R.array.hosts_allowlist_sample)
                .build()
        }
    }
    // Create an instance of CarInfoManager
    val carInfoManager = CarInfo.getInstance(applicationContext)

    // Retrieve the HardwareInfo object
    val hardwareInfo = carInfoManager.hardwareInfo

// Initialize the Speed property
// Set the supported units for speed
    hardwareInfo.supportedSpeedUnits = Speed.SUPPORTED_UNITS

// Set the default unit for speed
    hardwareInfo.defaultSpeedUnit = Speed.getDefaultUnit()

// Set the minimum and maximum values for speed in the default unit
    hardwareInfo.speedRange = Range(Speed.getMinValue(hardwareInfo.defaultSpeedUnit),
    Speed.getMaxValue(hardwareInfo.defaultSpeedUnit))

    override fun onCreateSession(): Session {
        Log.d("tagg", "onCreateSession: ")
        Log.d("tagg", "CarContext: ${CarContext.CAR_SERVICE}")
        Log.d("tagg", "BIND_AUTO_CREATE: ${CarContext.BIND_AUTO_CREATE}")
        Log.d("tagg", "KILOMETER: ${CarUnit.KILOMETER}")

        var speed : Speed
        Speed.Builder()

        //speed.rawSpeedMetersPerSecond.runCatching {  }
        Log.d("tagg", "METERS_PER_SEC: ${speed.speedDisplayUnit}")

        carHardwareManager.carInfo.addSpeedListener(Log.d("tagg", "speed: $speed.speedDisplayUnit"))
        return MainSession()
    }

}

private fun CarInfo.addSpeedListener(executor: Int) {
    Log.d("tagg", "speed: $executor")

}
