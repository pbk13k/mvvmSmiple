package co.kr.nawa.mvvmsimple.view


import androidx.lifecycle.Observer
import co.kr.nawa.mvvmsimple.R
import co.kr.nawa.mvvmsimple.databinding.ActivityMainBinding
import co.kr.nawa.mvvmsimple.util.adapters.Adapters
import co.kr.nawa.mvvmsimple.util.basic.ActivityBase
import co.kr.nawa.mvvmsimple.util.common.logD
import co.kr.nawa.mvvmsimple.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ActivityBase<ActivityMainBinding, MainViewModel>() {


    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()
    var adapter= Adapters(R.layout.list_item, ArrayList())

    override fun init() {
        binding.list.adapter=adapter
    }

    override fun initListener() {

    }

    override fun initDatabinding() {
        viewModel.item.observe(this, Observer {
            logD("ItemVIewHolder-=${it.size}")

            adapter.setItems(it)
        })
    }
}