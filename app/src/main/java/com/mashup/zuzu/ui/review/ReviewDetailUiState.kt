package com.mashup.zuzu.ui.review

import com.mashup.zuzu.data.model.ReviewDetailResponse
import com.mashup.zuzu.data.model.Wine

sealed interface ReviewDetailUiState {
    object Loading : ReviewDetailUiState

    data class Normal(
        val wine: Wine,
        val dummyWorldCupData: DummyWorldCupData,
        val reviewDetailResponse: ReviewDetailResponse
    ) : ReviewDetailUiState
}