package dajver.com.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dajver.com.mvvm.R
import dajver.com.mvvm.adapter.holder.PostViewHolder
import dajver.com.mvvm.api.model.PostModel

class PostRecyclerAdapter(private val postList: List<PostModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_posts, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as PostViewHolder
        viewHolder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}