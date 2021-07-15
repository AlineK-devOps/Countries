package ru.cft.shift2021summer.countries.screen

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.searchview.KSearchView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.countries.main.presentation.MainActivity

object MainScreen : KScreen<MainScreen>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewClass: Class<*> = MainActivity::class.java

    val filterButton = KButton {withId(R.id.filterButton)}
    val searchView = KSearchView {withId(R.id.searchView)}

    val countriesList = KRecyclerView(builder = {
        withId(R.id.countriesRecycler)
    }, itemTypeBuilder = {
        itemType(::CountryItem)
    })

    class CountryItem(parent: Matcher<View>) : KRecyclerItem<CountryItem>(parent) {
        val nameText = KTextView(parent) { withId(R.id.nameText) }
    }
}