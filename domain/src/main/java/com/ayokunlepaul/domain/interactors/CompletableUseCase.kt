package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.utils.RxExecutionThread
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.disposables.CompositeDisposable

abstract class CompletableUseCase<in P>(
    private val executionThread: RxExecutionThread
) {
    private val disposable = CompositeDisposable()

    abstract fun buildUseCaseCompletable(param: P?): Completable

    fun executeCompletableUseCase(param: P?, observer: CompletableObserver) {
        disposable.add(buildUseCaseCompletable(param).observeOn(executionThread.observerThread).subscribe())
    }

    fun executeUseCaseAndPerformAction(param: P?, action: () -> Unit, errorHandler: (Throwable) -> Unit) {
        disposable.add(
            buildUseCaseCompletable(param).doOnError {
                errorHandler.invoke(it)
            }.doOnComplete {
                action.invoke()
            }.doFinally {
                disposable.dispose()
            }.observeOn(executionThread.observerThread).subscribe()
        )
    }

    fun dispose() = disposable.dispose()
}