package com.bignerdranch.android.blognerdranch.controller.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bignerdranch.android.blognerdranch.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostListActivity : AppCompatActivity() {

    private var postRecyclerView: RecyclerView? = null
    private var postMetaDataViewModel: PostMetaDataViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)
        postMetaDataViewModel =  ViewModelProvider(this).get(PostMetaDataViewModel::class.java)
        postRecyclerView = findViewById(R.id.post_recyclerview)
        postRecyclerView?.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch{
            postMetaDataViewModel?.uiState?.collect{
                postRecyclerView?.adapter = PostAdapter(it.posts)
            }
        }
    }

    companion object {
        const val TAG = "PostListActivity"
    }
}
