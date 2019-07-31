package com.ayokunlepaul.erewarder.di.modules.presentation

import com.ayokunlepaul.erewarder.base.BaseViewModel
import com.ayokunlepaul.erewarder.di.keys.ERewarderViewModelKey
import com.ayokunlepaul.erewarder.di.scopes.PerFragment
import com.ayokunlepaul.erewarder.presentation.birthday.NotBirthdayFragmentViewModel
import com.ayokunlepaul.erewarder.presentation.login.LoginFragmentViewModel
import com.ayokunlepaul.erewarder.presentation.reward.RewardFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ERewarderFragmentViewModelModule {

    @Binds
    @IntoMap
    @PerFragment
    @ERewarderViewModelKey(LoginFragmentViewModel::class)
    abstract fun bindLoginFragmentViewModel(
        viewModel: LoginFragmentViewModel
    ): BaseViewModel

    @Binds
    @IntoMap
    @PerFragment
    @ERewarderViewModelKey(RewardFragmentViewModel::class)
    abstract fun bindRewardFragmentViewModel (
        viewModel: RewardFragmentViewModel
    ): BaseViewModel

    @Binds
    @IntoMap
    @PerFragment
    @ERewarderViewModelKey(NotBirthdayFragmentViewModel::class)
    abstract fun bindNotBirthdayFragmentViewModel(
        viewModel: NotBirthdayFragmentViewModel
    ): BaseViewModel
}