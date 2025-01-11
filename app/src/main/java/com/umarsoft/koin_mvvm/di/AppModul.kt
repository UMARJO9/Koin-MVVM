package com.umarsoft.koin_mvvm.di

import com.umarsoft.koin_mvvm.UserStateHolder
import com.umarsoft.koin_mvvm.UserViewModul
import com.umarsoft.koin_mvvm.data.UserRepository
import com.umarsoft.koin_mvvm.data.UserRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val appModul = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    singleOf(::UserStateHolder)
    viewModelOf(::UserViewModul)
}