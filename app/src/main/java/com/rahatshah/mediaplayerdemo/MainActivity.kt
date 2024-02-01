package com.rahatshah.mediaplayerdemo



import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.rahatshah.mediaplayerdemo.ui.theme.MediaPlayerDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val READ_REQUEST_CODE = 42

    @RequiresApi(Build.VERSION_CODES.M)
    private val storageActivityResultLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                if (Environment.isExternalStorageManager()) {
                    // User has granted MANAGE_EXTERNAL_STORAGE permission
                    // You can proceed with accessing external storage here
                } else {
                    showPermissionDeniedExplanation()
                }
            } else {
                // Below Android 11
                if (result?.resultCode == RESULT_OK) {
                    result.data?.data?.let { uri ->
                        // Handle the selected file URI
                        // You may want to use a ContentResolver to query information about the selected file
                        // or perform any other operations.
                    }
                } else {
                    // Permission denied by the user
                    if (!shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        // User has permanently denied the permission
                        showPermissionDeniedExplanation()
                    }
                }
            }
        }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaPlayerDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (isPermissionGranted()) {
                        Navigation()
                    } else {
                        requestForStoragePermissions()
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun isPermissionGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Environment.isExternalStorageManager()
        } else {
            val read = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            read == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun requestForStoragePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                val intent = Intent()
                intent.action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
                val uri = Uri.fromParts("package", this.packageName, null)
                intent.data = uri
                storageActivityResultLauncher.launch(intent)
            } catch (e: Exception) {
                val intent = Intent()
                intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                storageActivityResultLauncher.launch(intent)
            }
        } else {
            // Below android 11
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                ),
                READ_REQUEST_CODE
            )
        }
    }

    private fun showPermissionDeniedExplanation() {
        Toast.makeText(
            this@MainActivity,
            "Storage Permissions Denied. Please go to the app settings to enable it.",
            Toast.LENGTH_SHORT
        ).show()
    }

}
