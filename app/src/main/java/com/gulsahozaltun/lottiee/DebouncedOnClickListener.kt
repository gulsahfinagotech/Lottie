package com.gulsahozaltun.lottiee

import android.content.Context
import android.os.SystemClock
import android.view.View
import java.util.*


abstract class DebouncedOnClickListener : View.OnClickListener {

    private val minimumInterval: Long = 1000
    private lateinit var lastClickMap: MutableMap<View, Long>

    /**
     * Implement this in your subclass instead of onClick
     * @param view The view that was clicked
     */
    abstract fun onDebouncedClick(v: View)

    init {
        this.lastClickMap = WeakHashMap<View, Long>()
    }

    override fun onClick(clickedView: View) {
        val previousClickTimestamp = lastClickMap[clickedView]
        val currentTimestamp = SystemClock.uptimeMillis()

        lastClickMap.put(clickedView, currentTimestamp)
        if (previousClickTimestamp == null || currentTimestamp - previousClickTimestamp.toLong() > minimumInterval) {
            onDebouncedClick(clickedView)
        }
    }
}