package com.valoy.microfeat.ui.common.foo

sealed class FooAction {
    data object Idle: FooAction()
    data object GoToBar : FooAction()
    data class ShowToast(val message: String) : FooAction()
}
