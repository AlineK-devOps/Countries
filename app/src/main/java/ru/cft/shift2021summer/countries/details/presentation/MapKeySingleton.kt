package ru.cft.shift2021summer.countries.details.presentation

import com.yandex.mapkit.MapKitFactory

class MapKeySingleton private constructor() {

    companion object{
        private var mapKeySingleton: MapKeySingleton? = null

        fun initKey() {
            if (mapKeySingleton == null){
                mapKeySingleton = MapKeySingleton()
                MapKitFactory.setApiKey("82fdd0ae-41b4-4ad4-9233-c349aec5a3b7")
            }
        }
    }
}