
package com.dogauto.car

import androidx.car.app.Screen
import androidx.car.app.model.*

class MessagingScreen(carContext: androidx.car.app.CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val convList = ItemList.Builder()
            .addItem(Row.Builder().setTitle("Mom").addText("Last: See you at 7").build())
            .addItem(Row.Builder().setTitle("Alex").addText("Last: On my way").build())
            .build()

        return ListTemplate.Builder()
            .setTitle("Messages")
            .setSingleList(convList)
            .setHeaderAction(Action.BACK)
            .build()
    }
}
