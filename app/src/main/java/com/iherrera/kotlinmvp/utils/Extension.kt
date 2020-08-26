package com.iherrera.kotlinmvp.utils

import android.app.Activity
import android.widget.Toast

/**
 * Muestra un Toast
 *
 * @param {CharSequence} message
 * @param {Int<Toast.LENGTH_SHORT | Toast.LENGTH_LONG>} duration
 */
fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()