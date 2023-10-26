package com.valoy.microfeat.ui.common.foo

import com.valoy.microfeat.ui.dto.FooDto

sealed class FooUiState {
    data object Unavailable : FooUiState()
    data object Loading : FooUiState()
    data class Available(val fooDto: FooDto) : FooUiState()
}
