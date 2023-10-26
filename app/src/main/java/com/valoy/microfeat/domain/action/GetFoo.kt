package com.valoy.microfeat.domain.action

import com.valoy.microfeat.domain.model.Foo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFoo @Inject constructor() {

    operator fun invoke() = flow {
        emit(Foo())
    }
}