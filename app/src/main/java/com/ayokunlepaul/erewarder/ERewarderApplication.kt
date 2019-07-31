package com.ayokunlepaul.erewarder

import android.content.Context
import com.ayokunlepaul.erewarder.di.DaggerERewarderComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import java.util.*

class ERewarderApplication: DaggerApplication() {

    var currentDate = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    var currentMonth = Calendar.getInstance().get(Calendar.MONTH)

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerERewarderComponent.builder().bindERewarderInstance(
            this
        ).buildERewarderComponent()
    }

    fun setDate(date: Int) {
        currentDate = date
    }

    fun setMonth(month: Int) {
        currentMonth = month
    }

    companion object {
        @JvmStatic
        fun getInstance(context: Context) = context.applicationContext as ERewarderApplication
    }
}