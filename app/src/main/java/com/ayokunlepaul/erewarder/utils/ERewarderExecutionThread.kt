package com.ayokunlepaul.erewarder.utils

import com.ayokunlepaul.domain.utils.RxExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class ERewarderExecutionThread @Inject constructor(

): RxExecutionThread {

    override val observerThread: Scheduler
        get() = AndroidSchedulers.mainThread()
}