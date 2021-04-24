package co.kr.nawa.mvvmsimple.util.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


open class ViewModelBasic :ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected var _msg = MutableLiveData<String>()
    val msg: LiveData<String> get() = _msg

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}