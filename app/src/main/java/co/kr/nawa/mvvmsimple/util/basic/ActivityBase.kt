package co.kr.nawa.mvvmsimple.util.basic

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import co.kr.nawa.mvvmsimple.BR


abstract class ActivityBase<T : ViewDataBinding,VM: ViewModelBasic>: AppCompatActivity() {


    abstract val layoutResourceId: Int
    lateinit var binding: T
    abstract val viewModel : VM

    protected abstract fun init()

    protected abstract fun initListener()
    protected abstract fun initDatabinding()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResourceId)
        binding.setVariable(BR.viewModel,viewModel)
        binding.lifecycleOwner=this

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


    fun showToast(str:String){
        Toast.makeText(applicationContext,str, Toast.LENGTH_LONG).show()
    }

}