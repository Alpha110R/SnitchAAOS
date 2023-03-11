package com.example.snitchaaoskotlin

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.util.Log
import androidx.car.app.CarAppService
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator


class CarManager : CarAppService() {
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

    override fun onCreateSession(): Session {
        Log.d("tagg", "onCreateSession: ")
        return MainSession()
    }

}