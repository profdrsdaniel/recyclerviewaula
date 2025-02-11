package com.example.recyclerviewaula.data.di

import com.example.recyclerviewaula.data.local.TodoLocalDataSource
import com.example.recyclerviewaula.data.local.dao.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideTodoLocalDataSource(dao: TodoDao) : TodoLocalDataSource {
        return TodoLocalDataSource(dao)
    }
}