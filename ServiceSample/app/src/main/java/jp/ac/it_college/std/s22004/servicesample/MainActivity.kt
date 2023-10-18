package jp.ac.it_college.std.s22004.servicesample

import android.Manifest
import android.content.pm.PackageManager
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import jp.ac.it_college.std.s22004.servicesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Log.i("SERVICE_SAMPLE", "通知の権限もらえた")
            } else {
                Log.i("SERVICE_SAMPLE", "通知の権限がもらえなかった")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPlay.setOnClickListener { startSoundManagerService() }
        binding.btStop.setOnClickListener { stopSoundManagerService() }
        notificationParmissionRequest()
        val fromNotification = intent.getBooleanExtra("fromNotification", false)
        if (fromNotification) {
            binding.btPlay.isEnabled = false
            binding.btStop.isEnabled = false

        }
    }
    private fun startSoundManagerService() {
        val intent = Intent(this, SoundManageService::class.java)
        startService(intent)
        binding.btPlay.isEnabled = false
        binding.btStop.isEnabled = true
    }

    private fun stopSoundManagerService() {
        val intent = Intent(this, SoundManageService::class.java)
        stopService(intent)
        binding.btPlay.isEnabled = true
        binding.btStop.isEnabled = false
    }
    private fun notificationParmissionRequest() : Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return true
        return when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED -> {
                true
            }

            shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS) -> {
                true
            }
            else -> {
                requestPermissionLauncher.launch(
                    Manifest.permission.POST_NOTIFICATIONS
                )
                false
            }
        }
    }
}

