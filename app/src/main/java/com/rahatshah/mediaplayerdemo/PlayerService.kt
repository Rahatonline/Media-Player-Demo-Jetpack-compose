package com.rahatshah.mediaplayerdemo


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class PlayerService @Inject constructor() : Service() {


    private lateinit var mediaPlayer: MediaPlayer


    private val binder = MusicBinder()
    private val notificationId = 1

    inner class MusicBinder : Binder() {
        fun getService(): PlayerService = this@PlayerService
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val mediaFile = intent?.getStringExtra("mediaFile")
        val action = intent?.action

        if (action == ACTION_STOP) {
            stopMedia()
        } else if (action == ACTION_PAUSE) {
            pauseMedia()
        } else {

            if (mediaFile != null) {
                try {
                    mediaPlayer = MediaPlayer.create(this, Uri.parse(mediaFile))
                    mediaPlayer.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        if (mediaFile != null) {
            updatePlaybackState(mediaFile)
        }

        showNotification()

        // Keep the service running
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
    }

    // Function to pause the media playback
    private fun pauseMedia() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    // Function to stop the media playback
    private fun stopMedia() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.prepareAsync()
        }
    }

    // Function to update the playback state in the broadcast
    private fun updatePlaybackState(currentTrack: String) {
        val playbackStateIntent =
            Intent("ACTION_MEDIA_PLAYBACK_STATE_CHANGED").apply {
                putExtra(
                    "isPlaying",
                    mediaPlayer.isPlaying
                )

                putExtra(
                    "currentTrack",
                    currentTrack
                )

            }
        sendBroadcast(playbackStateIntent)
    }

    private fun showNotification() {
        createNotificationChannel()

        val notificationIntent = Intent(this, MainActivity::class.java)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pendingIntent = PendingIntent.getActivity(
            this, 0,
            notificationIntent, PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Music Player")
            .setContentText("Now Playing")
            .setSmallIcon(R.drawable.play_icon)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(notificationId, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Media Playback",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val ACTION_PAUSE = "com.rahatshah.mediaplayerdemo.ACTION_PAUSE"
        const val ACTION_STOP = "com.rahatshah.mediaplayerdemo.ACTION_STOP"
        const val ACTION_RESUME = "com.rahatshah.mediaplayerdemo.ACTION_RESUME"
        private const val CHANNEL_ID = "com.rahatshah.mediaplayerdemo.channel_id"

    }

}
