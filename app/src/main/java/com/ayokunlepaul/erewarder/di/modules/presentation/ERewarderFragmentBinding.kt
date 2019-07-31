package com.ayokunlepaul.erewarder.di.modules.presentation

import com.ayokunlepaul.erewarder.di.scopes.PerFragment
import com.ayokunlepaul.erewarder.presentation.birthday.NotBirthdayFragment
import com.ayokunlepaul.erewarder.presentation.login.LoginFragment
import com.ayokunlepaul.erewarder.presentation.reward.RewardFragment
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
    internal abstract fun bindLoginFragment(): LoginFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindRewardFragment(): RewardFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindNotBirthdayFragment(): NotBirthdayFragment
}