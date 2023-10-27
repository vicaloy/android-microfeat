package com.valoy.microfeat.ui.common.composable

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.valoy.microfeat.ui.common.foo.FooAction
import com.valoy.microfeat.ui.common.foo.FooUiModel
import com.valoy.microfeat.ui.common.foo.FooUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

@Composable
fun Foo(uiModel: FooUiModel) {

    val uiState by uiModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val lifecycleScope = LocalLifecycleOwner.current.lifecycleScope

    when (uiState) {
        is FooUiState.Available -> {
            FooContent(
                uiState = uiState as FooUiState.Available,
                onGoToBarClicked = uiModel::onGoToBarClicked
            )
        }

        is FooUiState.Loading -> {}
        is FooUiState.Unavailable -> {}
    }

    LaunchedEffect(lifecycle) {
        withContext(Dispatchers.Main.immediate) {
            uiModel.action
                .flowWithLifecycle(
                    lifecycle = lifecycle,
                    minActiveState = Lifecycle.State.STARTED
                )
                .onEach {
                    when (it) {
                        is FooAction.ShowToast -> {
                            Toast.makeText(
                                context,
                                it.message,
                                Toast.LENGTH_LONG
                            ).show()

                            Log.d("Foo", "ShowToast")
                        }

                        else -> {}
                    }
                }
                .launchIn(lifecycleScope)
        }

    }
}

@Composable
fun FooContent(
    uiState: FooUiState.Available,
    onGoToBarClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(text = uiState.fooDto.title)
        Text(text = uiState.fooDto.description)
        Button(onClick = onGoToBarClicked) {
            Text(text = uiState.fooDto.buttonText)
        }
    }

}