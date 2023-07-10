package com.bignerdranch.android.blognerdranch.controller.post

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bignerdranch.android.blognerdranch.databinding.ActivityPostBinding
import com.bignerdranch.android.blognerdranch.model.Post
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PostActivity : AppCompatActivity() {

    private var postId: Post? = null
    private var postMetaDataViewModel: PostViewModel? = null
    private var _binding: ActivityPostBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Binding is null!"
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_POST_ID,Post::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_POST_ID)
        }

        postMetaDataViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        postMetaDataViewModel?.displayPost(postId)
        lifecycleScope.launch{
            postMetaDataViewModel?.uiState?.collect {
                binding.apply {
                    titleTextview.text = it.post?.metadata?.title
                    authorTextView.text = it.post?.metadata?.author?.name
                    bodyTextView.text = it.post?.body
                }
            }
        }
    }


    companion object {
        const val TAG = "PostActivity"
        const val EXTRA_POST_ID = "postID"

        fun newIntent(context: Context, post: Post): Intent {
            val intent = Intent(context, PostActivity::class.java)
            intent.putExtra(EXTRA_POST_ID, post)
            return intent
        }
    }
}
