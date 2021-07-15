package ru.cft.shift2021summer.countries.screen

import android.view.KeyCharacterMap
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.countries.details.presentation.CountryDetailsActivity

object CountryDetailsScreen : KScreen<CountryDetailsScreen>() {

    override val layoutId: Int = R.layout.activity_country_details
    override val viewClass: Class<*> = CountryDetailsActivity::class.java

    val flag = KImageView { withId(R.id.flag) }
    val nameText = KTextView { withId(R.id.nameText) }
}