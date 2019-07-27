package com.ayokunlepaul.erewarder.di.modules.cache

import dagger.Module

@Module(
    includes = [
        ERewarderRoomDatabaseModule::class
    ]
)
abstract class CacheModule {
}