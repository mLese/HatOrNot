package com.commissionsinc.hatornot.data.source.local

class WeatherPersistenceContract {
    companion object WeatherEntry {
        val TABLE_NAME = "task"
        val COLUMN_NAME_ENTRY_ID = "weatherid"
        val COLUMN_NAME_ENTRY_TEMPERATURE = "temperature"
        val COLUMN_NAME_ENTRY_CLOUDY = "cloudy"
        val _ID = "_id"
        val _COUNT = "_count"
    }
}
