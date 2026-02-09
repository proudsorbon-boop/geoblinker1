package org.example.geoblinker.di

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.example.geoblinker.db.AppDatabase
import org.koin.dsl.module

actual val platformModule = module {
    single {
        val driver = NativeSqliteDriver(AppDatabase.Schema, "geoblinker.db")
        AppDatabase(driver)
    }
}