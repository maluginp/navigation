package ru.maluginp.navigation

interface INavigationKey
class ActivityNavigationKey(
    private val requestCode: Int
) : INavigationKey {
    override fun equals(other: Any?): Boolean {
        if (other is ActivityNavigationKey) {
            return requestCode == other.requestCode
        }

        return false
    }

    override fun hashCode(): Int {
        return requestCode
    }
}