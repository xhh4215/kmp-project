package com.example.demo.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp

@Composable
fun SoundSettingTopComponent(defaultValue: Int = 10, maxValue: Int = 100, action: (value: Int) -> Unit) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(Color.Red, shape = RoundedCornerShape(10.dp))
    ) {
        Spacer(modifier = Modifier.size(20.dp))

        CommonSlider(
            maxValue = maxValue,
            Color.Blue,
            Color.Green,
            modifier = Modifier.weight(1f),
            step = 9,
            defaultValue = defaultValue,

            ) {
            action.invoke(it)
        }

    }
}
