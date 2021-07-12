package ru.cft.shift2021summer.countries.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.cft.shift2021summer.countries.domain.model.CountryModel

interface CountryApi {
    @GET("all")
    fun getAll(): Single<Response<List<CountryModel>>>

    @GET("name/{name}")
    fun get(@Path("name") name: String): Single<Response<List<CountryModel>>>
}