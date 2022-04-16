package com.example.seampaytt.utils

import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun SwipeRefreshLayout.hideLoading() {
    this.isRefreshing = false
}
