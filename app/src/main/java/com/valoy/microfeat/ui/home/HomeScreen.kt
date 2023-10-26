package com.valoy.microfeat.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.valoy.microfeat.ui.common.foo.FooComposableFactory

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    fooComposableFactory: FooComposableFactory
) {
    val fooComposable = remember {
        fooComposableFactory.create()
    }

    fooComposable(viewModel.fooUiModel)
}