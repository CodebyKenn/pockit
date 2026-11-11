package com.group.pockit.util

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.group.pockit.R

object NotificationHelper {

    private const val CHANNEL_ID = "pockit_alerts_channel"
    private const val CHANNEL_NAME = "Pockit Alerts & Notifications"

    @SuppressLint("MissingPermission")
    fun sendSystemNotification(context: Context, title: String, message: String) {
        try {
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager ?: return

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = "Pockit budget warnings, transaction, and account alerts."
                }
                notificationManager.createNotificationChannel(channel)
            }

            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_pockit)
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(NotificationCompat.BigTextStyle().bigText(message))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)

            val notificationId = System.currentTimeMillis().toInt()
            notificationManager.notify(notificationId, builder.build())
        } catch (_: Exception) {
            // Ignore permission or System UI posting restrictions
        }
    }
}
