package com.ayokunlepaul.domain.utils

import io.reactivex.Scheduler

interface RxExecutionThread {

    val observerThread: Scheduler
}