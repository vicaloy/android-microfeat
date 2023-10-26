package com.valoy.microfeat.ui.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.valoy.microfeat.ui.common.foo.FooComposableFactory

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    fooComposableFactory: FooComposableFactory
) {
    val fooComposable = remember {
        fooComposableFactory.create()
    }

    fooComposable(viewModel.fooUiModel)
}