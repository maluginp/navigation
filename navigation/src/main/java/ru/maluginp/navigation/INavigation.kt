package ru.maluginp.navigation

import android.content.Context
import android.content.Intent

interface INavigationOnActivityResult {
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}

interface INavigation : INavigationOnActivityResult {
    fun <T> transit(transition: ActivityTransition<T>, completion: Completion<T>)
}

typealias Completion<T> = (result: TransitionResult<T>) -> Unit


abstract class ActivityTransition<out T> {
    abstract fun create(context: Context): Intent
    abstract fun map(intent: Intent?): T
}