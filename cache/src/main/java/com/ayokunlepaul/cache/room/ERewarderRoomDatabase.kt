package com.ayokunlepaul.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayokunlepaul.cache.BuildConfig
import com.ayokunlepaul.cache.models.CustomerCacheModel
import com.ayokunlepaul.cache.room.daos.CustomerDao

@Database(
    entities = [
        CustomerCacheModel::class
    ],
    exportSchema = false,
    version = BuildConfig.VERSION_CODE
)
abstract class ERewarderRoomDatabase: RoomDatabase() {
    abstract fun getCustomerDao(): CustomerDao
}