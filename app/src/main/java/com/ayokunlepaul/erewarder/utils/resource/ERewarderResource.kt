package com.ayokunlepaul.erewarder.utils.resource

class ERewarderResource <out D> constructor(
    val state: ERewarderState,
    val message: String?,
    val data: D?
){
    companion object {
        @JvmStatic
        fun <D> success(
            data: D,
            message: String? = null
        ): ERewarderResource<D> = ERewarderResource(
            state = ERewarderState.SUCCESS,
            data = data,
            message = message
        )

        @JvmStatic
        fun <D> failed(
            message: String?
        ): ERewarderResource<D> = ERewarderResource(
            state = ERewarderState.FAILED,
            data = null,
            message = message
        )

        @JvmStatic
        fun <D> loading(): ERewarderResource<D> = ERewarderResource(
            state = ERewarderState.LOADING,
            data = null,
            message = null
        )

        @JvmStatic
        fun <D> loadingMore(): ERewarderResource<D> = ERewarderResource(
            state = ERewarderState.LOADING_MORE,
            data = null,
            message = null
        )
    }
}