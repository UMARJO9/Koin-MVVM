@file:Suppress("INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_WARNING")

package com.umarsoft.koin_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinContext {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val userName = "Umar"
        FactoryInject(userName)
        ViewModelInject(userName)
    }
}

@Composable
fun FactoryInject(userName: String, presenter: UserStateHolder = koinInject()) {
    Text(text = presenter.sayhello(userName), modifier = Modifier.padding(8.dp))
}

@Composable
fun ViewModelInject(userName: String, viewModel: UserViewModul = koinViewModel()) {
    Text(text = viewModel.sayhello(userName), modifier = Modifier.padding(8.dp))
}