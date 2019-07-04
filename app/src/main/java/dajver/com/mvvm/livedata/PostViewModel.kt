package dajver.com.mvvm.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dajver.com.mvvm.api.RestClient
import dajver.com.mvvm.api.model.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<List<PostModel>>? = null

    fun getPosts() : MutableLiveData<List<PostModel>>? {
        if(mutableLiveData == null) {
            mutableLiveData = MutableLiveData()
            loadPosts();
        }
        return mutableLiveData
    }

    private fun loadPosts() {
        RestClient.instance().posts.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                if(response.code() < 400) {
                    mutableLiveData!!.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
