package com.ayokunlepaul.erewarder

import com.ayokunlepaul.erewarder.di.DaggerERewarderComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ERewarderApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerERewarderComponent.builder().bindERewarderInstance(
            this
        ).buildERewarderComponent()
    }
}