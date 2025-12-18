package vrsalex.matule.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import vrsalex.matule.data.repository.AuthRepositoryImpl
import vrsalex.matule.data.repository.AuthSessionRepositoryImpl
import vrsalex.matule.domain.repository.AuthRepository
import vrsalex.matule.domain.repository.AuthSessionRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindAuthSessionRepository(
        authSessionRepositoryImpl: AuthSessionRepositoryImpl
    ): AuthSessionRepository

    @Binds
    @Singleton
    fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository


}