package ru.cft.shift2021summer.activity

/** Сплэшскрин - заставка приложения перед запуском **/

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import ru.cft.shift2021summer.R

class SplashScreenActivity : Activity() {
    companion object{
        private const val SPLASH_DISPLAY_LENGTH: Long = 3000 //отображение сплэшскрина 3 секунды
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({ //переключение экрана
            val mainIntent = Intent(this, MainActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}