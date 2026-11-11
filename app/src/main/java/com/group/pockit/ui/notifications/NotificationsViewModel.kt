package com.group.pockit.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.group.pockit.data.PockitRepository
import com.group.pockit.data.model.AppNotification
import kotlinx.coroutines.launch

class NotificationsViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = PockitRepository.get(app)

    val notifications: LiveData<List<AppNotification>> = repo.observeNotifications().asLiveData()
    val unreadCount: LiveData<Int> = repo.observeUnreadNotificationCount().asLiveData()

    fun markAllRead() {
        viewModelScope.launch {
            repo.markNotificationsAsRead()
        }
    }

    fun clearAll() {
        viewModelScope.launch {
            repo.clearNotifications()
        }
    }
}
