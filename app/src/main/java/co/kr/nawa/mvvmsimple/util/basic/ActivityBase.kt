package co.kr.nawa.mvvmsimple.util.basic

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar



abstract class ActivityBase<T : ViewDataBinding,VM: ViewModelBasic>: AppCompatActivity() {


    abstract val layoutResourceId: Int
    lateinit var viewDataBinding: T
    abstract val viewModel : VM

    protected abstract fun init()

    protected abstract fun initListener()
    protected abstract fun initDatabinding()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
//        viewDataBinding.setVariable(BR.viewModel,viewModel)
        viewDataBinding.lifecycleOwner=this

        initDefault()

        init()
        initListener()
        initDatabinding()
    }

    private fun initDefault(){


        viewModel.msg.observe(this,{
            showToast(it)
        })


    }


    fun snackbarShow(str:String){
        Snackbar.make(window.decorView.rootView,str, Snackbar.LENGTH_LONG).show()
    }

    fun showToast(str:String){
        Toast.makeText(applicationContext,str, Toast.LENGTH_LONG).show()
    }

}