package com.ayokunlepaul.erewarder.di.keys

import com.ayokunlepaul.erewarder.base.BaseViewModel
import dagger.MapKey
import kotlin.reflect.KClass


@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ERewarderViewModelKey (val value: KClass<out BaseViewModel>)