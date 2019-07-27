package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.utils.RxExecutionThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

abstract class ObservableUseCase<in P, R>(
    private val executionThread: RxExecutionThread
) {
    private val disposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(param: P?): Observable<R>

    fun executeUseCase(param: P?, observer: DisposableObserver<R>) {
        disposable.add(
            buildUseCaseObservable(param).observeOn(executionThread.observerThread).subscribeWith(observer)
        )
    }

    fun executeUseCaseAndPerformAction(param: P?, action: (R) -> Unit, errorHandler: (Throwable) -> Unit) {
        disposable.add(
            buildUseCaseObservable(param).doOnError {
                errorHandler.invoke(it)
            }.doOnNext {
                action.invoke(it)
            }.doFinally {
                disposable.dispose()
            }.observeOn(executionThread.observerThread).subscribe()
        )
    }

    fun dispose() = disposable.dispose()
}