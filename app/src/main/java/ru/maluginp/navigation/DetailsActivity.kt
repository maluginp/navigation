package ru.maluginp.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    fun finishSuccess(v: View) {
        val intent = Intent()
        intent.putExtra("ARG_RESULT", "Test")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }


    companion object {
        fun getCallingIntent(context: Context, type: Int): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("ARG_EXTRA", type)
            return intent
        }

        fun getResult(intent: Intent?): String {
            return intent?.getStringExtra("ARG_RESULT") ?: ""
        }
    }
}
