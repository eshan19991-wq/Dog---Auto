
package com.dogauto.car

import android.content.Intent
import androidx.car.app.CarAppService
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.model.*
import androidx.car.app.validation.HostValidator

class CarService : CarAppService() {
    override fun createHostValidator(): HostValidator = HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    override fun onCreateSession(): Session = DriveSession()
}

class DriveSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen = MainMenuScreen(carContext)
}

class MainMenuScreen(carContext: androidx.car.app.CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val list = ItemList.Builder()
            .addItem(Row.Builder().setTitle("Navigate").setBrowsable(true).addText("Maps destinations").build())
            .addItem(Row.Builder().setTitle("Messages").setBrowsable(true).addText("Conversations").build())
            .addItem(Row.Builder().setTitle("Music").setBrowsable(true).addText("Play music").build())
            .build()

        return ListTemplate.Builder()
            .setTitle("Dog Auto")
            .setSingleList(list)
            .build()
    }
}
