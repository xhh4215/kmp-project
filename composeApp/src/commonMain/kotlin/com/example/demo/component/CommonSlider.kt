package com.example.demo.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonSlider(
    maxValue: Int = 100,
    activeColor: Color = Color.Red,
    inActiveColor: Color = Color.Gray,
    step: Int = 0,
    enable: Boolean = true,
    modifier: Modifier = Modifier,
    defaultValue: Int = 8,
    valueChangeAction: (value: Int) -> Unit = {},
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Slider(
            modifier= Modifier.weight(1f),
            value = defaultValue.toFloat(),
            colors = SliderDefaults.colors(
                activeTrackColor = activeColor,
                inactiveTrackColor = inActiveColor,
                activeTickColor = activeColor,
                inactiveTickColor = inActiveColor,
                disabledActiveTrackColor = inActiveColor,
                disabledActiveTickColor = inActiveColor,
                thumbColor = inActiveColor
            ),
            enabled = enable,
            thumb = {
                CircleThumb(color = Color.DarkGray)
            },
            track = { sliderState ->
                SliderDefaults.Track(
                    modifier = modifier.height(5.dp),
                    drawStopIndicator = null,
                    colors = SliderDefaults.colors(
                        activeTrackColor = activeColor,
                        inactiveTrackColor = inActiveColor,
                        activeTickColor = activeColor,
                        inactiveTickColor = inActiveColor,
                        disabledActiveTrackColor = inActiveColor,
                        disabledActiveTickColor = inActiveColor,
                        thumbColor = inActiveColor
                    ),
                    enabled = true,
                    sliderState = sliderState,
                    trackInsideCornerSize = 0.dp
                )
            },
            valueRange = 0f..maxValue.toFloat(),
            steps = step,
            onValueChange = {
                valueChangeAction.invoke(it.toInt())

            },
        )

    }

}


@Composable
fun CircleThumb(radius: Dp = 6.dp, color: Color = Color.Cyan) {
    Canvas(modifier = Modifier.size(radius * 2)) {
        drawCircle(
            color = color,
            radius = radius.toPx() + 3
        )
        drawCircle(
            color = Color.White,
            radius = radius.toPx()
        )


    }
}
