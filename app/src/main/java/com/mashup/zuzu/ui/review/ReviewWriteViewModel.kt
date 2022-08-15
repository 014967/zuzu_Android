package com.mashup.zuzu.ui.review

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.zuzu.data.request.ReviewWriteRequest
import com.mashup.zuzu.domain.usecase.ReviewWriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewWriteViewModel @Inject constructor(
    private val reviewWriteUseCase: ReviewWriteUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel() {
    private var request = ReviewWriteRequest()
    private val page: MutableStateFlow<Int> = MutableStateFlow(0)

    private val wineId: Long = savedStateHandle[WINE_ID] ?: 0L
    private val wineImageUrl: String = savedStateHandle[WINE_IMAGE_URL] ?: ""
    private val wineName: String = savedStateHandle[WINE_NAME] ?: ""

    val uiState: StateFlow<ReviewWriteUiState> =
        page.map {
            ReviewWriteUiState(
                page = it,
                wineImageUrl = wineImageUrl,
                wineName = wineName
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ReviewWriteUiState(
                page = 0,
                wineImageUrl = "",
                wineName = ""
            )
        )


    fun navigatePreviousWritePage() = viewModelScope.launch {
        val currentPage = page.value
        page.value =
            if (currentPage == 0) {
                0
            } else {
                currentPage - 1
            }
    }

    fun navigateDateSelectPage(selectOption: String) = viewModelScope.launch {
        request = request.copy(weather = selectOption)
        page.value = 1
    }

    fun navigatePartnerPage(selectOption: String) = viewModelScope.launch {
        request = request.copy(time = selectOption)
        page.value = 2
    }

    fun navigateGroupPage(selectOption: String) = viewModelScope.launch {
        request = request.copy(companion = selectOption)
        page.value = 3
    }

    fun navigateSoloPage(selectOption: String) = viewModelScope.launch {
        request = request.copy(companion = selectOption)
        page.value = 4
    }

    fun navigateTastePage(selectOption: Pair<String, Int?>) = viewModelScope.launch {
        request = request.copy(mood = selectOption.first, spot = selectOption.second)
        page.value = 5
    }

    fun navigateSummaryPage(selectOptionList: List<Int>) = viewModelScope.launch {
        request = request.copy(
            is_heavy = selectOptionList[0],
            is_bitter = selectOptionList[1],
            is_strong = selectOptionList[2],
            is_burning = selectOptionList[3]
        )
        page.value = 6
    }

    fun navigateSecondarySummaryPage(selectOption: String) = viewModelScope.launch {
        request = request.copy(
            taste = selectOption
        )
        page.value = 7
    }

    fun navigateReviewShareCard(place: String, pairing: List<String>) = viewModelScope.launch {
        request = request.copy(
            place = place,
            pairing = pairing
        )
    }

    fun finishReviewWrite() = viewModelScope.launch {
        //request 객체로 Api 요청
        reviewWriteUseCase(request)
    }

    companion object {
        const val WINE_ID = "wineId"
        const val WINE_IMAGE_URL = "wineImageUrl"
        const val WINE_NAME = "wineName"
    }
}