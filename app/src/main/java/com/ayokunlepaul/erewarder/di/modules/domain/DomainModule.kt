package com.ayokunlepaul.erewarder.di.modules.domain

import com.ayokunlepaul.domain.utils.RxExecutionThread
import com.ayokunlepaul.erewarder.di.scopes.ERewarderAppScope
import com.ayokunlepaul.erewarder.utils.ERewarderExecutionThread
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    @ERewarderAppScope
    internal abstract fun bindExecutionThread(executionThread: ERewarderExecutionThread): RxExecutionThread
}