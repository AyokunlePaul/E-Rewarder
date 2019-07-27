package com.ayokunlepaul.erewarder.di.modules.presentation

import com.ayokunlepaul.erewarder.di.scopes.PerFragment
import com.ayokunlepaul.erewarder.presentation.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        ERewarderFragmentViewModelModule::class
    ]
)
abstract class ERewarderFragmentBinding {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideLoginFragment(): LoginFragment
}