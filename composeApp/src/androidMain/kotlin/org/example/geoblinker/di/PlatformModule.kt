package org.example.geoblinker.di

import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.example.geoblinker.db.AppDatabase
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

actual val platformModule = module {
    single {
        val driver = AndroidSqliteDriver(AppDatabase.Schema, androidContext(), "geoblinker.db")
        AppDatabase(driver)
    }
}