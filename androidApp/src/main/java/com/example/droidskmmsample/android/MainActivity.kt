package com.example.droidskmmsample.android

import android.os.Bundle
import com.example.droidskmmsample.Greeting
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.droidskmmsample.Api

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout(MainViewModel())
        }
    }
}

@Composable
fun MainLayout(mainViewModel: MainViewModel = viewModel()) {
    val name: String by mainViewModel.text.observeAsState("")
    MainViewStuff(name = name, onResponseChange = { mainViewModel.onResponseChange(it)} )
    mainViewModel.start()
}

@Composable
fun MainViewStuff(name: String, onResponseChange: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = greet())
        Text(text = "sup Denver Droids")
        Text(text = name)
    }
}

class MainViewModel : ViewModel() {
    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text

    fun onResponseChange(newText: String) {
        _text.value = newText
    }

    fun start() {
        Api().about { onResponseChange(it) }
    }
}