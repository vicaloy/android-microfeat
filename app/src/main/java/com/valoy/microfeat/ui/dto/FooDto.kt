package com.valoy.microfeat.ui.dto

import com.valoy.microfeat.domain.model.Foo

data class FooDto(
    val title: String,
    val description: String,
    val buttonText: String
) {
    companion object {
        fun fooToFooDto(foo: Foo): FooDto {
            return FooDto(
                title = foo.title,
                description = foo.description,
                buttonText = foo.buttonText
            )
        }
    }
}