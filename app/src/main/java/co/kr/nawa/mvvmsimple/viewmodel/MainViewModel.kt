package co.kr.nawa.mvvmsimple.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.kr.nawa.mvvmsimple.item.Item
import co.kr.nawa.mvvmsimple.util.async.Repository
import co.kr.nawa.mvvmsimple.util.basic.ViewModelBasic
import co.kr.nawa.mvvmsimple.util.common.logD
import co.kr.nawa.mvvmsimple.util.common.logE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private var repository: Repository) : ViewModelBasic() {

    var _items = MutableLiveData(ArrayList<Item>())
    val item: LiveData<ArrayList<Item>> get() = _items

    init {

        itemsGet(1)
    }

    private fun itemsGet(page: Int) {
        var data = HashMap<String, Any>()
        data.put("page", page)
        data.put("per_page", "30")

        addDisposable(
            repository.getTojson("beers", data, Item::class.java)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    _items.postValue(it)
                }, {
                    logE("error=${it.localizedMessage}")
                })
        )
    }


}