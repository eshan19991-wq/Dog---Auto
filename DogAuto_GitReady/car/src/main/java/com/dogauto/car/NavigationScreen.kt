
package com.dogauto.car

import android.content.Intent
import android.net.Uri
import androidx.car.app.Screen
import androidx.car.app.model.*

class NavigationScreen(carContext: androidx.car.app.CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val items = ItemList.Builder()
            .addItem(Row.Builder().setTitle("Home").addText("Navigate to Home").build())
            .addItem(Row.Builder().setTitle("Work").addText("Navigate to Work").build())
            .build()

        return ListTemplate.Builder()
            .setTitle("Navigate")
            .setSingleList(items)
            .build()
    }

    private fun openMaps(query: String) {
        val uri = Uri.parse("geo:0,0?q=" + Uri.encode(query))
        val intent = Intent(Intent.ACTION_VIEW, uri).apply { setPackage("com.google.android.apps.maps") }
        carContext.startCarApp(intent)
    }
}
