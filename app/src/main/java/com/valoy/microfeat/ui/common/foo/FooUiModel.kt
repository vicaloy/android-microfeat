package com.valoy.microfeat.ui.common.foo

import dagger.assisted.AssistedFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FooUiModel {
    val uiState: StateFlow<FooUiState>
    val action: Flow<FooAction>

    fun onGoToBarClicked()


    @AssistedFactory
    interface Factory {
        fun create(coroutineScope: CoroutineScope): FooUiModelImpl
    }
}