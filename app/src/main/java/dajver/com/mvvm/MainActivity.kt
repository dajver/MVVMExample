package dajver.com.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dajver.com.mvvm.adapter.PostRecyclerAdapter
import dajver.com.mvvm.api.model.PostModel
import dajver.com.mvvm.livedata.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(PostViewModel::class.java!!)
        model.getPosts()!!.observe(this,
            Observer<List<PostModel>> {
                val adapter = PostRecyclerAdapter(it)
                recyclerView.adapter = adapter
            })
    }
}
