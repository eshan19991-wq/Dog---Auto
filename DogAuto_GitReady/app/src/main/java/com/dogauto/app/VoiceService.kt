
package com.dogauto.app
import android.service.voice.VoiceInteractionService
import android.util.Log

class VoiceService : VoiceInteractionService() {
    override fun onReady() {
        super.onReady()
        Log.d("DogAutoVoice", "VoiceInteractionService ready (stub).")
    }
}
