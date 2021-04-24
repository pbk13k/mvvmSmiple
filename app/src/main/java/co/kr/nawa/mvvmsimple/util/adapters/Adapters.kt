package co.kr.nawa.mvvmsimple.util.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import co.kr.nawa.mvvmsimple.holder.*


class Adapters(var layout: Int,private var items: ArrayList<out Any>) : RecyclerView.Adapter<CustomViewHolder>() {


    private var onClickListener: ((View, Int) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(layout, parent, false)

        return when(layout){
//            R.layout.item_name_card2->  CustmoerViewHolder(view, onClickListener,onPositionCallbackListener)

            else -> CustmoerViewHolder(view, onClickListener)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(@NonNull holderCustom: CustomViewHolder, position: Int) {

        holderCustom.init(items[position])

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        }else{
            holder.init(items[position])
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun onListClickListener (onClickListener: (view:View, position:Int) -> Unit){
        this.onClickListener = onClickListener
        notifyDataSetChanged()
    }


    fun setItems(items: ArrayList<out Any>) {
        this.items = items
        notifyDataSetChanged()
    }







}