package ru.cft.shift2021summer.countries.test

import android.view.KeyEvent
import androidx.test.rule.ActivityTestRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import ru.cft.shift2021summer.countries.main.presentation.MainActivity
import ru.cft.shift2021summer.countries.screen.CountryDetailsScreen.flag
import ru.cft.shift2021summer.countries.screen.CountryDetailsScreen.nameText
import ru.cft.shift2021summer.countries.screen.CountryDetailsScreen.pressKey
import ru.cft.shift2021summer.countries.screen.FilterScreen
import ru.cft.shift2021summer.countries.screen.FilterScreen.americasCheckbox
import ru.cft.shift2021summer.countries.screen.FilterScreen.euCheckBox
import ru.cft.shift2021summer.countries.screen.FilterScreen.showButton
import ru.cft.shift2021summer.countries.screen.MainScreen

class MainScreenTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun checkCountriesListScreen() =
        run {
            step("Проверяем отображение списка стран") {
                activityTestRule.launchActivity(null)

                MainScreen {
                    countriesList {
                        childAt<MainScreen.CountryItem>(0) {
                            nameText {
                                isDisplayed()
                                hasText("AFGHANISTAN")
                            }
                        }

                        childAt<MainScreen.CountryItem>(5) {
                            nameText {
                                isDisplayed()
                                hasText("ANDORRA")
                            }
                        }

                        childAt<MainScreen.CountryItem>(10) {
                            nameText {
                                isDisplayed()
                                hasText("ARGENTINA")
                            }
                        }
                    }
                }
            }
        }

    @Test
    fun checkOpenDetailsScreen() =
        run {
            step("Проверяем что при клике в списке стран открываются её детали") {
                activityTestRule.launchActivity(null)

                MainScreen {
                    countriesList {
                        childAt<MainScreen.CountryItem>(0) {
                            click()
                        }
                    }
                }

                MainScreen {
                    flag {
                        isVisible()
                    }

                    nameText {
                        hasText("AFGHANISTAN \n" +
                                "CAPITAL: KABUL")
                    }
                }
            }
        }

    @Test
    fun checkOpenFilterScreen() =
        run {
            step("Проверяем что при клике на кнопку фильтра открывается окно фильтров") {
                activityTestRule.launchActivity(null)

                MainScreen {
                    filterButton.click()
                }

                MainScreen {
                    americasCheckbox {
                        isVisible()
                    }

                    euCheckBox {
                        isVisible()
                    }

                    showButton {
                        isVisible()
                    }
                }
            }
        }

    @Test
    fun checkSearch() =
        run {
            step("Проверяем работу поисковой строки") {
                activityTestRule.launchActivity(null)

                MainScreen {
                    countriesList {
                        childAt<MainScreen.CountryItem>(0) {
                            nameText {
                                isDisplayed()
                                hasText("AFGHANISTAN")
                            }
                        }
                    }
                }

                MainScreen {
                    searchView.click()
                    searchView.perform { typeQuery("russian federation") }
                }

                MainScreen {
                    countriesList {
                        childAt<MainScreen.CountryItem>(0) {
                            nameText {
                                isDisplayed()
                                hasText("RUSSIAN FEDERATION")
                            }
                        }
                    }
                }
            }
        }
}