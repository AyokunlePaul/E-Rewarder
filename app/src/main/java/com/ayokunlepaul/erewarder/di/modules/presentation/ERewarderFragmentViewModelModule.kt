package com.ayokunlepaul.erewarder.di.modules.presentation

import com.ayokunlepaul.erewarder.base.BaseViewModel
import com.ayokunlepaul.erewarder.di.keys.ERewarderViewModelKey
import com.ayokunlepaul.erewarder.di.scopes.PerFragment
import com.ayokunlepaul.erewarder.presentation.login.LoginFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ERewarderFragmentViewModelModule {

    @Binds
    @IntoMap
    @ERewarderViewModelKey(LoginFragmentViewModel::class)
    @PerFragment
    abstract fun bindLoginFragmentViewModel(
        viewModel: LoginFragmentViewModel
    ): BaseViewModel
}