package com.bignerdranch.android.blognerdranch.controller.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.blognerdranch.repository.PostRepository
import com.bignerdranch.android.blognerdranch.model.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostMetaDataViewModel @Inject constructor(private val postRepository: PostRepository): ViewModel() {

    private val _uiState:MutableStateFlow<UiState> =MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(postMetadata = postRepository.fetchMetaData(),
                posts = postRepository.fetchPost())
            }
        }
    }
}