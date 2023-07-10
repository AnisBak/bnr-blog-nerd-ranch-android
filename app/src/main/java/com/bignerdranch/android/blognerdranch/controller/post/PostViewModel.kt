package com.bignerdranch.android.blognerdranch.controller.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.repository.PostRepository
import com.bignerdranch.android.blognerdranch.model.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor (private val postRepository: PostRepository): ViewModel(){

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    var post:Post?=null

    fun displayPost(post: Post?){
        _uiState.update {
            it.copy(post = post)
        }
    }
}

