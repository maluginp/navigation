package ru.maluginp.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity :
    AppCompatActivity(), INavigationOnActivityResult, IMainView {

    private val navigation: INavigation =
        Navigation(this)
    private val presenter: IMainPresenter = MainPresenter(this, navigation)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openDetails(v: View) {
        presenter.openDetails()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        navigation.onActivityResult(requestCode, resultCode, data)
    }

}
