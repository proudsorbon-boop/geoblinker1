package org.example.geoblinker

import android.app.Application
import org.example.geoblinker.di.allModules
import org.example.geoblinker.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GeoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GeoApp)

            // Загружаем общие модули
            modules(allModules)
            // Загружаем андроид-модуль (базу данных) отдельно
            modules(platformModule)
        }
    }
}