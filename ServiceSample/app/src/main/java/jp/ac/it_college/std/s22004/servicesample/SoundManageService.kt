package jp.ac.it_college.std.s22004.servicesample

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder

class SoundManageService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder {
        TODO("a")
    }

    override fun onCreate() {
        super.onCreate()

        mediaPlayer = MediaPlayer()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val mediaFileUri = Uri.parse(
            "android.resource://${packageName}/${R.raw.miti}"
        )
        mediaPlayer?.run {
            setDataSource(this@SoundManageService, mediaFileUri)
            setOnPreparedListener { onMediaPlayerPreared() }
            setOnCompletionListener { onPlaybackEnd() }
            prepareAsync()
        }
        return START_NOT_STICKY
    }
    override fun onDestroy() {
        mediaPlayer?.run {
            if (isPlaying) {
                stop()
            }
        }
        super.onDestroy()
    }
    private fun onMediaPlayerPreared() {
        mediaPlayer?.start()
    }

    private fun onPlaybackEnd() {
        stopSelf()
    }
}