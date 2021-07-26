package co.kr.nawa.mvvmsimple.di

import co.kr.nawa.mvvmsimple.util.async.Repository
import co.kr.nawa.mvvmsimple.util.async.RetrofitHelper
import co.kr.nawa.mvvmsimple.viewmodel.MainViewModel
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

    viewModel {
        MainViewModel(get{ parametersOf(RetrofitHelper.Type.MAIN) })
    }




}

val appModule= listOf(app,viewModels)