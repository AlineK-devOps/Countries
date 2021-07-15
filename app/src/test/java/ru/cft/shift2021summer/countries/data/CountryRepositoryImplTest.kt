package ru.cft.shift2021summer.countries.data

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import ru.cft.shift2021summer.countries.TestEntities.COUNTRY_1
import ru.cft.shift2021summer.countries.TestEntities.COUNTRY_ID

@RunWith(MockitoJUnitRunner::class)
class CountryRepositoryImplTest {
    private  val repository = CountryRepositoryImpl.getInstance()

    @Test
    fun `get country EXPECT get country from datasource`() = run{
        assertEquals(listOf(COUNTRY_1), repository.get(COUNTRY_ID))
    }
}