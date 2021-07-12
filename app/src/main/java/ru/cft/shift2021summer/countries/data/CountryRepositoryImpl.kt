package ru.cft.shift2021summer.countries.data

import com.google.gson.GsonBuilder
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.cft.shift2021summer.countries.domain.CountryRepository
import ru.cft.shift2021summer.countries.domain.model.*

/** Репозиторий стран **/

class CountryRepositoryImpl private constructor( //Singleton
    private val countriesDatasource: CountriesDatasource
): CountryRepository {

    companion object{
        var BASE_URL = "https://restcountries.eu/rest/v2/"

        private var repository: CountryRepositoryImpl? = null
        private var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

        fun getInstance(): CountryRepositoryImpl{
            if (repository == null)
                repository = CountryRepositoryImpl(CountriesDatasourceImpl(retrofit.create()))

            return repository as CountryRepositoryImpl
        }
    }

    override fun getAll(): Single<List<CountryModel>> =
        countriesDatasource.getAll()

    override fun get(name: String): Single<CountryModel> =
        countriesDatasource.get(name)
}