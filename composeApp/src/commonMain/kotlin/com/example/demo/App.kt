package com.example.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.demo.component.CommonSlider
import com.example.demo.component.SoundSettingScreen
import com.example.demo.component.SoundSettingTopComponent
import com.example.demo.viewmodel.RocketLaunchViewModel
import com.example.demo.viewmodel.VolumeViewModel
import io.ktor.websocket.FrameType.Companion.get
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.getKoin
import org.koin.compose.koinInject

@Composable
@Preview
fun App( ) {
    val viewModel: RocketLaunchViewModel = koinInject()
    val stable by viewModel.state.collectAsState()
    LaunchedEffect(true) {
       viewModel.loadLaunches()
    }


    var value by remember {
        mutableStateOf(0f)
    }
    Column {
        Text(stable.launches.size.toString(), modifier = Modifier.wrapContentSize().background(Color.Red).padding(40.dp))
        Slider(value = value, onValueChange = { value = it },valueRange = 0f..100f)

        Button(onClick = {
            value+=10;
        }){
            Text("change")
        }
    }

 }

@Composable
fun VolumeSlider(viewModel: VolumeViewModel) {
    var volume by remember {
        mutableStateOf(0f)
    }
    volume =  MediaVolumeObserver(viewModel)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("系统音量：${(volume*100).toInt()}.%")
        SoundSettingTopComponent(defaultValue = (volume*100).toInt(),){

        }
    }
}

@Composable
fun MediaVolumeObserver(viewModel: VolumeViewModel): Float {


    var volume by remember { mutableStateOf(0f) }

    // 启动协程定时检测音量变化
    LaunchedEffect(Unit) {
        var lastVolume = volume
        while (true) {
            val current = viewModel.volume.value
            if (current != lastVolume) {
                lastVolume = current
                volume = current

            }
            delay(200) // 每200ms检测一次，可以改为50~500ms
        }
    }

    return volume


}
