package com.test.apod.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Util {

    private val errorMsg =
        "We are not connected to the internet, showing you the last image we have."

    fun showError(context: Context) {
        AlertDialog.Builder(context)
            .setTitle("Error")
            .setMessage(errorMsg)
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }

    fun checkTodayDate(): String {
        try {
            val df = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return df.format(Calendar.getInstance().time)
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }
}