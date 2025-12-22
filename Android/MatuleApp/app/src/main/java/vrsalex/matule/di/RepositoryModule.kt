package vrsalex.matule.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vrsalex.matule.data.repository.AppSettingRepositoryImpl
import vrsalex.matule.data.repository.AuthRepositoryImpl
import vrsalex.matule.data.repository.HomeRepositoryImpl
import vrsalex.matule.domain.repository.AppSettingRepository
import vrsalex.matule.domain.repository.AuthRepository
import vrsalex.matule.domain.repository.HomeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    fun provideAppSettingRepository(
        appSettingRepositoryImpl: AppSettingRepositoryImpl
    ): AppSettingRepository

    @Binds
    @Singleton
    fun provideHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}