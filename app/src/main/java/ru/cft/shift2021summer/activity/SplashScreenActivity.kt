package ru.cft.shift2021summer.activity

/** Сплэшскрин - заставка приложения перед запуском **/

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import ru.cft.shift2021summer.*
import ru.cft.shift2021summer.model.CountryRepository

class SplashScreenActivity : Activity(), SplashScreenView {
    companion object{
        private const val SPLASH_DISPLAY_LENGTH: Long = 3000 //отображение сплэшскрина 3 секунды
    }

    private val presenter by lazy { SplashScreenPresenter() }

    private lateinit var textView: TextView
    private lateinit var spans: Spannable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        textView = findViewById<View>(R.id.textView) as TextView
        spans = SpannableString("WORLDWIDE")

        presenter.attachView(this)
    }

    override fun bindSplashScreen() {
        spans.setSpan(ForegroundColorSpan(Color.parseColor("#304d71")), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spans.setSpan(ForegroundColorSpan(Color.parseColor("#5baee4")), 5, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spans

        closeScreen()
    }

    override fun closeScreen() {
        Handler().postDelayed({ //переключение экрана
            val mainIntent = Intent(this, MainActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, SPLASH_DISPLAY_LENGTH)
    }


}