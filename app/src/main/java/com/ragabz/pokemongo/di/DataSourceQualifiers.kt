package com.ragabz.data.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RemoteDataSource

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LocalDataSource