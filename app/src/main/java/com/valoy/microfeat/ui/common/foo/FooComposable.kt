package com.valoy.microfeat.ui.common.foo

import androidx.compose.runtime.Composable
import com.valoy.microfeat.ui.common.composable.Foo
import javax.inject.Inject

interface FooComposableFactory {
    fun create(): FooComposable
}

class FooComposableFactoryImpl @Inject constructor() :
    FooComposableFactory {

    override fun create(): FooComposable = { uiModel ->
        Foo(uiModel = uiModel)
    }
}

typealias FooComposable = @Composable (uiModel: FooUiModel) -> Unit