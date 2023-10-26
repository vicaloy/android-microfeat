package com.valoy.microfeat.ui.common.foo

import com.valoy.microfeat.domain.action.GetFoo
import com.valoy.microfeat.ui.dto.FooDto
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class FooUiModelImpl @AssistedInject constructor(
    private val getFoo: GetFoo,
    @Assisted private val coroutineScope: CoroutineScope,
) : FooUiModel {

    private val _uiState: MutableStateFlow<FooUiState> = MutableStateFlow(FooUiState.Unavailable)
    override val uiState: StateFlow<FooUiState> = _uiState.asStateFlow()

    private val _action: Channel<FooAction> = Channel(Channel.BUFFERED)
    override val action: Flow<FooAction> = _action.receiveAsFlow()

    init {
        coroutineScope.launch {
            getFoo().collect {
                _uiState.value = FooUiState.Available(FooDto.fooToFooDto(it))
            }
        }
    }

    override fun onGoToBarClicked() {
        coroutineScope.launch {
            _action.send(FooAction.ShowToast("Message"))
        }
    }

}