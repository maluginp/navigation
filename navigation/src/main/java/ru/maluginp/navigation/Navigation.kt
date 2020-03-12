package ru.maluginp.navigation

import android.app.Activity
import android.content.Intent
import kotlin.random.Random

class Navigation(
    private val activity: Activity
) : INavigation {

    init {
        if (activity !is INavigationOnActivityResult) {
            throw IllegalArgumentException("Activity must implement INavigationOnActivityResult interface")
        }
    }

    private val activityKeys: MutableMap<INavigationKey, ActivityNavigationCompletion> = mutableMapOf()

    override fun <T> transit(transition: ActivityTransition<T>, completion: Completion<T>) {
        val requestCode = Random(100).nextInt() and 0xFFFF

        activityKeys[ActivityNavigationKey(requestCode)] = { resultCode, data ->
            completion(
                ActivityTransitionResult(
                    resultCode,
                    transition.map(data)
                )
            )
        }
        activity.startActivityForResult(transition.create(activity), requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val key: INavigationKey =
            ActivityNavigationKey(requestCode)

        activityKeys[key]?.let { it(resultCode, data) }
        activityKeys.remove(key)
    }
}

typealias ActivityNavigationCompletion = (resultCode: Int, data: Intent?) -> Unit

