package com.example.droidskmmsample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.droidskmmsample.Api
import com.example.droidskmmsample.Greeting
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

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
    MainViewStuff(name = name, onResponseChange = { mainViewModel.onResponseChange(it) })
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
        Text(text = name)
    }
}

class MainViewModel : ViewModel() {
    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text
    private val api = Api()
    private val timer = Timer()

    fun onResponseChange(newText: String) {
        _text.postValue(newText)
    }

    fun start() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ -> }) {
            timer.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    api.about {
                        onResponseChange("${Date(System.currentTimeMillis())} $it")
                    }
                }
            }, 1000, 1000)
        }
    }
}