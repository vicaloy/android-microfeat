package com.valoy.microfeat.di

import com.valoy.microfeat.ui.common.foo.FooComposableFactory
import com.valoy.microfeat.ui.common.foo.FooComposableFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ComposableFactoryModule {

    @Binds
    abstract fun bindFooComposableFactory(
        fooComposableFactoryImpl: FooComposableFactoryImpl
    ): FooComposableFactory

}
