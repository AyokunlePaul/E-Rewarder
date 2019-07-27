package com.ayokunlepaul.erewarder.di.modules

import android.content.Context
import com.ayokunlepaul.erewarder.ERewarderApplication
import dagger.Binds
import dagger.Module

@Module
abstract class ERewarderUtilityModule {

    @Binds
    internal abstract fun bindERewarderApplicationContext(eRewarderApplication: ERewarderApplication): Context
}