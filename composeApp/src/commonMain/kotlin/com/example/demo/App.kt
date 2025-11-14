package com.example.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demo.viewmodel.OrderViewModel
import com.example.demo.viewmodel.RocketLaunchViewModel
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.app_name
import kmpproject.composeapp.generated.resources.compose_multiplatform
import kmpproject.composeapp.generated.resources.str_template
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject


@Composable
@Preview
fun HelloWorldApp(viewModel: OrderViewModel = viewModel(){
    OrderViewModel()
}) {
    val value by viewModel.uiState.collectAsStateWithLifecycle()
   Text(text = value.toString(), modifier =  Modifier.background(Color.White), color = Color.White)
}
@Composable
@Preview
fun App() {

    var list by remember {
        mutableStateOf(mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14))
    }
    Column (Modifier.padding(80.dp)){
        Button(onClick = {
           list = list.filter { it >5 } as MutableList<Int>
            for(i in list.indices){
                print(list[i])
            }
        }) {
            Text(text = "Hello World")
        }
        LazyColumn {
            items(list.size) { index ->
                Text("Item #$index")
            }
        }

    }




}
