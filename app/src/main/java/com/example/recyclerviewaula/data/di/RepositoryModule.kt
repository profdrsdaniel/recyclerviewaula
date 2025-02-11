package com.example.recyclerviewaula.data.di

import com.example.recyclerviewaula.data.TodoRepository
import com.example.recyclerviewaula.data.TodoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideTodoRepository(todoRepositoryImpl: TodoRepositoryImpl) : TodoRepository
}