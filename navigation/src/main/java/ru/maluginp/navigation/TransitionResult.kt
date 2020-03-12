package ru.maluginp.navigation

import android.app.Activity

interface TransitionResult<T> {
    fun isSuccess(): Boolean
    val data: T
}

class ActivityTransitionResult<T>(
    private val resultCode: Int,
    override val data: T
) : TransitionResult<T> {
    override fun isSuccess(): Boolean {
        return resultCode == Activity.RESULT_OK
    }
}