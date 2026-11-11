package com.group.pockit.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity representing an in-app & system notification alert.
 * Type: "WARNING" (Over budget), "INFO" (General alert), "SUCCESS" (Transaction/Transfer).
 */
@Entity(tableName = "app_notifications")
data class AppNotification(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val title: String,
    val message: String,
    val type: String = "INFO",
    val timestamp: Long = System.currentTimeMillis(),
    val isRead: Boolean = false
)
