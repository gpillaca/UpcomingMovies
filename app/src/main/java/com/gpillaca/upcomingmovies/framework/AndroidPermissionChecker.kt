package com.gpillaca.upcomingmovies.framework

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.gpillaca.upcomingmovies.data.PermissionChecker

class AndroidPermissionChecker(private val application: Application) : PermissionChecker {

    override fun check(permission: PermissionChecker.Permission): Boolean =
        ContextCompat.checkSelfPermission(
            application,
            permission.toAndroidId()
        ) == PackageManager.PERMISSION_GRANTED
}

private fun PermissionChecker.Permission.toAndroidId() = when (this) {
    PermissionChecker.Permission.COARSE_LOCATION -> Manifest.permission.ACCESS_COARSE_LOCATION
}
