package ru.maluginp.navigation

import android.content.Context
import android.content.Intent

data class DetailsTransitionResult(val type: String)

class DetailsTransition(
    private val type: Int
) : ActivityTransition<DetailsTransitionResult>() {

    override fun create(context: Context): Intent {
        return DetailsActivity.getCallingIntent(context, type)
    }

    override fun map(intent: Intent?): DetailsTransitionResult {
        return DetailsTransitionResult(DetailsActivity.getResult(intent))
    }
}