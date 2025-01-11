package com.umarsoft.koin_mvvm

import android.app.Application
import com.umarsoft.koin_mvvm.data.User
import com.umarsoft.koin_mvvm.data.UserRepository
import com.umarsoft.koin_mvvm.di.appModul
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(appModul)
        }

        val userRepository: UserRepository = get()
        userRepository.addUsers(
            listOf(
                User("Umar"),
                User("Koin")
            )
        )

    }


}