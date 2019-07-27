package com.ayokunlepaul.erewarder.di.modules.cache

import android.content.Context
import androidx.room.Room
import com.ayokunlepaul.cache.room.ERewarderRoomDatabase
import com.ayokunlepaul.cache.room.daos.CustomerDao
import com.ayokunlepaul.cache.utils.ERewarderCacheConstants
import com.ayokunlepaul.erewarder.di.scopes.ERewarderAppScope
import dagger.Module
import dagger.Provides

@Module
class ERewarderRoomDatabaseModule {

    @Provides
    @ERewarderAppScope
    internal fun provideERewarderDatabase(context: Context): ERewarderRoomDatabase {
        return Room.databaseBuilder(
            context,
            ERewarderRoomDatabase::class.java,
            ERewarderCacheConstants.EREWARDER_ROOM_DATABASE
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    @Provides
    @ERewarderAppScope
    internal fun provideCustomerDao(database: ERewarderRoomDatabase): CustomerDao = database.getCustomerDao()
}