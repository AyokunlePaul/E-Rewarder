package com.ayokunlepaul.erewarder.di.modules.cache

import com.ayokunlepaul.cache.impl.CustomerCacheImpl
import com.ayokunlepaul.erewarder.di.scopes.ERewarderAppScope
import com.ayokunlepaul.repository.cache.ICustomerCache
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        ERewarderRoomDatabaseModule::class
    ]
)
abstract class CacheModule {

    @Binds
    @ERewarderAppScope
    internal abstract fun bindCustomerCache(cache: CustomerCacheImpl): ICustomerCache
}