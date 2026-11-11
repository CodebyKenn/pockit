package com.group.pockit.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.group.pockit.data.model.AppNotification
import kotlinx.coroutines.flow.Flow

@Dao
interface NotificationDao {

    @Insert
    suspend fun insert(notification: AppNotification): Long

    @Query("SELECT * FROM app_notifications WHERE userId = :userId ORDER BY timestamp DESC, id DESC")
    fun observeAll(userId: String): Flow<List<AppNotification>>

    @Query("SELECT COUNT(*) FROM app_notifications WHERE userId = :userId AND isRead = 0")
    fun observeUnreadCount(userId: String): Flow<Int>

    @Query("UPDATE app_notifications SET isRead = 1 WHERE userId = :userId")
    suspend fun markAllAsRead(userId: String): Int

    @Query("DELETE FROM app_notifications WHERE userId = :userId")
    suspend fun clearAll(userId: String): Int
}
