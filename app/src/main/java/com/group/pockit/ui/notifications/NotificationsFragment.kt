package com.group.pockit.ui.notifications

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.group.pockit.R

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    private val viewModel: NotificationsViewModel by viewModels()
    private lateinit var adapter: NotificationAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBack = view.findViewById<TextView>(R.id.btnBack)
        val btnClear = view.findViewById<TextView>(R.id.btnClearNotifications)
        val tvEmpty = view.findViewById<TextView>(R.id.tvEmptyNotifications)
        val rvNotifications = view.findViewById<RecyclerView>(R.id.rvNotifications)

        adapter = NotificationAdapter()
        rvNotifications.layoutManager = LinearLayoutManager(requireContext())
        rvNotifications.adapter = adapter

        btnBack.setOnClickListener {
            try {
                findNavController().popBackStack()
            } catch (_: Exception) {
                activity?.onBackPressedDispatcher?.onBackPressed()
            }
        }

        btnClear.setOnClickListener {
            viewModel.clearAll()
        }

        viewModel.notifications.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            if (list.isEmpty()) {
                tvEmpty.visibility = View.VISIBLE
                rvNotifications.visibility = View.GONE
            } else {
                tvEmpty.visibility = View.GONE
                rvNotifications.visibility = View.VISIBLE
                // Mark all read when user views screen
                viewModel.markAllRead()
            }
        }
    }
}
