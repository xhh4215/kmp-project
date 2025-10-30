package com.example.demo.di

 import com.example.demo.network.SpaceXApi
import com.example.demo.network.createSpaceXSDK
  import com.example.demo.viewmodel.RocketLaunchViewModel
import org.koin.dsl.module

 val commonModule = module {
    //只创建一个对象
    single<SpaceXApi> { createSpaceXSDK() } // 各平台实际实现注入
    //每次请求创建新的对象
    factory { RocketLaunchViewModel(get()) } // 跨平台 ViewModel
}
