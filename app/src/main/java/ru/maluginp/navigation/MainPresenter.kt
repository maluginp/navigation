package ru.maluginp.navigation

interface IMainPresenter {
    fun openDetails()
}

interface IMainView {
    fun showMessage(message: String)
}

class MainPresenter(
    private val view: IMainView,
    private val navigation: INavigation
) : IMainPresenter {

    override fun openDetails() {
        navigation.transit(DetailsTransition(1)) {
            if (it.isSuccess()) {
                view.showMessage("Completion success: ${it.data.type}")
            } else {
                view.showMessage("Completion cancelled")
            }
        }
    }
}