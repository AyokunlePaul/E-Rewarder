package com.ayokunlepaul.erewarder.di.modules.repository

import com.ayokunlepaul.domain.repository.ICustomerRepository
import com.ayokunlepaul.erewarder.di.scopes.ERewarderAppScope
import com.ayokunlepaul.repository.impl.CustomerRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    @ERewarderAppScope
    internal abstract fun bindCustomerRepository(repository: CustomerRepositoryImpl): ICustomerRepository
}