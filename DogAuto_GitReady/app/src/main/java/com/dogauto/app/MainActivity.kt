
package com.dogauto.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { DogAutoApp() }
    }
}

@Composable
fun DogAutoApp() {
    val ctx = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF2E3192), Color(0xFF1BFFFF))))
            .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Dog Auto", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
            Text("Drive-friendly dashboard", color = Color.White, fontSize = 14.sp)

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                BigTile(title = "Navigate", subtitle = "Maps", onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="))
                    intent.setPackage("com.google.android.apps.maps")
                    ctx.startActivity(intent)
                })
                BigTile(title = "Music", subtitle = "Player", onClick = {
                    val spotify = ctx.packageManager.getLaunchIntentForPackage("com.spotify.music")
                    if (spotify != null) ctx.startActivity(spotify)
                    else ctx.startActivity(Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_APP_MUSIC))
                })
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                BigTile(title = "Call", subtitle = "Quick dial", onClick = {
                    ctx.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:")))
                })
                BigTile(title = "Voice", subtitle = "Hands-free", onClick = {
                    ctx.startActivity(Intent("android.service.voice.VOICE_INTERACTION"))
                })
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text("Tips for safe driving", color = Color.White, fontWeight = FontWeight.SemiBold)
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("• Mount your phone at eye level", color = Color.White)
                Text("• Use voice commands", color = Color.White)
                Text("• Enable Do Not Disturb while driving", color = Color.White)
            }
        }
    }
}

@Composable
fun BigTile(title: String, subtitle: String, onClick: () -> Unit) {
    Card(modifier = Modifier
        .weight(1f)
        .height(120.dp)
        .clickable { onClick() },
        shape = MaterialTheme.shapes.medium) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(subtitle, fontSize = 14.sp)
            }
        }
    }
}
