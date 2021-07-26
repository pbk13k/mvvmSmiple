package co.kr.nawa.mvvmsimple.holder

import android.view.View
import co.kr.nawa.mvvmsimple.databinding.ListItemBinding
import co.kr.nawa.mvvmsimple.item.Item
import co.kr.nawa.mvvmsimple.util.adapters.CustomViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import kotlinx.android.extensions.LayoutContainer


class ItemViewHolder(val binding: ListItemBinding, private var mListener: ((View, Int) -> Unit)?):
    CustomViewHolder(binding.root), View.OnClickListener, LayoutContainer {

    override val containerView: View?
        get() = binding.root

    override fun init(item: Any) {

        val i=item as Item
        val requestOptions = RequestOptions
            .skipMemoryCacheOf(false)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
        Glide.with(binding.root.context)
            .load(i.image_url)
            .apply(requestOptions)
            .override(100, 100)
            .into(binding.imageView)

        binding.textView.text=i.name

        binding.root.setOnClickListener(this)
    }



    override fun onClick(v: View) {
        mListener?.let {
            it(v, adapterPosition)
        }
    }




}