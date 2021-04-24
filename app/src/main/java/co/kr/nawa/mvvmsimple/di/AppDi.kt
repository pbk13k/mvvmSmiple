package co.kr.nawa.mvvmsimple.di

import co.kr.nawa.mvvmsimple.util.async.Repository
import co.kr.nawa.mvvmsimple.util.async.RetrofitHelper
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val app= module {

    factory {
            (type: RetrofitHelper.Type)-> RetrofitHelper(type)
    }

    factory {
            (type: RetrofitHelper.Type)->
        Repository(get { parametersOf(type) })
    }


}

val viewModels= module {

//    viewModel {
////        IntroViewModel(get{ parametersOf(RestHelper.Type.SUB) })
//    }




}

val appModule= listOf(app,viewModels)