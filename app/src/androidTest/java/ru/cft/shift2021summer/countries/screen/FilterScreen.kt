package ru.cft.shift2021summer.countries.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.text.KButton
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.countries.filter.presentation.FilterActivity

object FilterScreen : KScreen<FilterScreen>() {

    override val layoutId: Int = R.layout.activity_filter
    override val viewClass: Class<*> = FilterActivity::class.java

    val americasCheckbox = KCheckBox { withId(R.id.americasBox) }
    val euCheckBox = KCheckBox { withId(R.id.euBox) }
    val showButton = KButton {withId(R.id.showButton)}
}