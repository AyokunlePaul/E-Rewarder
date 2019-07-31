package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.utils.RxExecutionThread
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver

abstract class SingleUseCase<in P, R>(
    private val executionThread: RxExecutionThread
) {
    private val disposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(param: P?): Single<R>

    fun executeUseCase(param: P?, observer: DisposableSingleObserver<R>) {
        disposable.add(
            buildUseCaseObservable(param).observeOn(executionThread.observerThread).subscribeWith(observer)
        )
    }

    fun executeUseCaseAndPerformAction(param: P?, action: (R) -> Unit, errorHandler: (Throwable) -> Unit) {
        disposable.add(
            buildUseCaseObservable(param).doOnError {
                errorHandler.invoke(it)
            }.doOnSuccess {
                action.invoke(it)
            }.doFinally {
                disposable.dispose()
            }.observeOn(executionThread.observerThread).subscribe()
        )
    }

    fun dispose() = disposable.dispose()
}