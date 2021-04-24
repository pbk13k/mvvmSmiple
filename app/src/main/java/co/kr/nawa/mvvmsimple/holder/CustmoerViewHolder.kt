package co.kr.nawa.mvvmsimple.holder

import android.view.View
import co.kr.nawa.mvvmsimple.util.adapters.CustomViewHolder

import kotlinx.android.extensions.LayoutContainer


class CustmoerViewHolder(val view: View, private var mListener: ((View, Int) -> Unit)?):
    CustomViewHolder(view), View.OnClickListener, LayoutContainer {

    override val containerView: View?
        get() = view



    override fun init(item: Any) {
//        val item=item as CustomerItem
//        tv_company.text="${item.company} / ${item.name}"

        view.setOnClickListener(this)
    }



    override fun onClick(v: View) {
        mListener?.let {
            it(v, adapterPosition)
        }
    }




}