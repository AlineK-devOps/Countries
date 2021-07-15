package ru.cft.shift2021summer.countries.test

import androidx.test.rule.ActivityTestRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import ru.cft.shift2021summer.countries.filter.presentation.FilterActivity
import ru.cft.shift2021summer.countries.screen.FilterScreen
import ru.cft.shift2021summer.countries.screen.MainScreen

class FilterScreenTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(FilterActivity::class.java, true, false)

    @Test
    fun checkFilter() =
        run {
            step("Проверяем отображение списка стран") {
                activityTestRule.launchActivity(null)

                FilterScreen{
                    americasCheckbox{
                        setChecked(true)
                    }

                    euCheckBox{
                        setChecked(true)
                    }

                    showButton{
                        click()
                    }
                }

                MainScreen {
                    countriesList {
                        childAt<MainScreen.CountryItem>(0) {
                            nameText {
                                isDisplayed()
                                hasText("FRENCH GUIANA")
                            }
                        }
                    }
                }
            }
        }
}