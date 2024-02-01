package com.rahatshah.mediaplayerdemo.ui.screens


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rahatshah.mediaplayerdemo.PlayerService
import com.rahatshah.mediaplayerdemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicListScreen(
    viewModel: MediaListViewModel = hiltViewModel()
) {
    val tempContext = LocalContext.current
    val mediaList = viewModel.mediaList


    var currentPlayingTrack by remember {
        mutableStateOf("")
    }


    Scaffold() {
        LazyColumn(contentPadding = it) {


            items(mediaList) { media ->


                var isMediaPlaying by remember { mutableStateOf(false) }


                DisposableEffect(tempContext) {
                    val intentFilter = IntentFilter("ACTION_MEDIA_PLAYBACK_STATE_CHANGED")
                    val broadcast = object : BroadcastReceiver() {
                        override fun onReceive(context: Context?, intent: Intent?) {
                            if (intent?.action == "ACTION_MEDIA_PLAYBACK_STATE_CHANGED") {
                                isMediaPlaying = intent.getBooleanExtra(
                                    "isPlaying", false
                                )

                                currentPlayingTrack =
                                    intent.getStringExtra("currentTrack").toString()
                            }
                        }
                    }

                    tempContext.registerReceiver(broadcast, intentFilter)

                    // When the effect leaves the Composition, remove the callback
                    onDispose {
                        tempContext.unregisterReceiver(broadcast)
                    }
                }


                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = media.label,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        IconButton(
                            enabled = (isMediaPlaying && currentPlayingTrack == media.data) || !isMediaPlaying,
                            onClick = {

                                val intent =
                                    Intent(tempContext, PlayerService::class.java).apply {
                                        putExtra("mediaFile", media.data)
                                    }

                                if (isMediaPlaying) {
                                    // Pause the media playback
                                    intent.action = PlayerService.ACTION_PAUSE
                                } else {
                                    // Resume or start the media playback
                                    intent.action = PlayerService.ACTION_RESUME
                                }

                                tempContext.startService(intent)

                            }) {

                            if (isMediaPlaying && currentPlayingTrack == media.data) {
                                Icon(
                                    painter = painterResource(id = R.drawable.stop_icon),
                                    contentDescription = "Stop"
                                )
                            } else {
                                Icon(
                                    painter = painterResource(id = R.drawable.play_icon),
                                    contentDescription = "Play"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
