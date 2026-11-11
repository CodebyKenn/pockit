package com.group.pockit.ui.notifications

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.group.pockit.R
import com.group.pockit.data.model.AppNotification
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NotificationAdapter(
    private var items: List<AppNotification> = emptyList()
) : RecyclerView.Adapter<NotificationAdapter.VH>() {

    fun submitList(newItems: List<AppNotification>) {
        items = newItems
        notifyDataSetChanged()
    }

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val card: View = v.findViewById(R.id.cardNotification)
        val icon: TextView = v.findViewById(R.id.tvNotificationIcon)
        val title: TextView = v.findViewById(R.id.tvNotificationTitle)
        val time: TextView = v.findViewById(R.id.tvNotificationTime)
        val message: TextView = v.findViewById(R.id.tvNotificationMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]

        holder.title.text = item.title
        holder.message.text = item.message
        holder.time.text = SimpleDateFormat("dd MMM, HH:mm", Locale.getDefault()).format(Date(item.timestamp))

        val (iconSymbol, iconBgColor) = when (item.type) {
            "WARNING" -> "⚠️" to 0xFFE8112D.toInt()
            "SUCCESS" -> "✓" to 0xFF6E8F5A.toInt()
            else -> "🔔" to 0xFF46044B.toInt()
        }

        holder.icon.text = iconSymbol
        holder.icon.backgroundTintList = ColorStateList.valueOf(iconBgColor)

        if (!item.isRead) {
            holder.card.setBackgroundColor(0xFFF3E8FB.toInt())
        } else {
            holder.card.setBackgroundColor(Color.WHITE)
        }
    }

    override fun getItemCount() = items.size
}
