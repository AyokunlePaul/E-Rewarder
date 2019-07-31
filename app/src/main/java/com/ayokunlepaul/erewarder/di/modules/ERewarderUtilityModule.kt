package com.ayokunlepaul.erewarder.di.modules

import android.content.Context
import com.ayokunlepaul.domain.utils.RxExecutionThread
import com.ayokunlepaul.erewarder.ERewarderApplication
import com.ayokunlepaul.erewarder.di.scopes.ERewarderAppScope
import com.ayokunlepaul.erewarder.utils.ERewarderExecutionThread
import dagger.Binds
import dagger.Module

@Module
abstract class ERewarderUtilityModule {

    @Binds
    @ERewarderAppScope
    internal abstract fun bindERewarderApplicationContext(
        eRewarderApplication: ERewarderApplication
    ): Context

    @Binds
    @ERewarderAppScope
    internal abstract fun bindExecutionThread(
        executionThread: ERewarderExecutionThread
    ): RxExecutionThread
}