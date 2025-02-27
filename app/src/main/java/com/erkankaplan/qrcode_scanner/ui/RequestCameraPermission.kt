package com.erkankaplan.qrcode_scanner.ui

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class RequestCameraPermission(private val activity: Activity) {

    companion object {
        private const val REQUEST_CAMERA = 1
        private val PERMISSIONS = arrayOf(android.Manifest.permission.CAMERA)
    }


    fun verifyCameraPermission(): Boolean {
        val permission =
            ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.CAMERA)

        return if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS, REQUEST_CAMERA)
            false
        } else {
            true
        }
    }
}