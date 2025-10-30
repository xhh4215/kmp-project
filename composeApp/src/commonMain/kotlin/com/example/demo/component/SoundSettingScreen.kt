package com.example.demo.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SoundSettingScreen(
    currentMaxVoiceValue: Int,
    defaultNotifyValue: Int,
    defaultSystemValue: Int,
    onSliderChangeAction: (value: Int) -> Unit = {},
    onSliderSystemChangeAction: (value: Int) -> Unit = {}
) {


    var defaultStateSystemValue by remember {
        mutableStateOf(defaultSystemValue)
    }

    defaultStateSystemValue = defaultSystemValue

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(23.dp))
        Spacer(modifier = Modifier.size(15.dp))
        Text(
            "系统音量",
            fontSize = 14.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        SoundSettingTopComponent(maxValue = currentMaxVoiceValue, defaultValue = defaultStateSystemValue) {
            onSliderSystemChangeAction.invoke(it)
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        Text(
            "通知音量",
            fontSize = 14.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        SoundSettingTopComponent(maxValue = currentMaxVoiceValue, defaultValue = defaultNotifyValue) {
            onSliderChangeAction.invoke(it)
        }
    }
}
