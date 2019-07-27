package com.ayokunlepaul.erewarder.di

import com.ayokunlepaul.erewarder.ERewarderApplication
import com.ayokunlepaul.erewarder.di.modules.ERewarderUtilityModule
import com.ayokunlepaul.erewarder.di.modules.cache.CacheModule
import com.ayokunlepaul.erewarder.di.modules.domain.DomainModule
import com.ayokunlepaul.erewarder.di.scopes.ERewarderAppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ERewarderUtilityModule::class,
        DomainModule::class,
        CacheModule::class
    ]
)
@ERewarderAppScope
interface ERewarderComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance fun bindERewarderInstance(eRewarderApplication: ERewarderApplication): Builder
        fun buildERewarderComponent(): ERewarderComponent
    }
}