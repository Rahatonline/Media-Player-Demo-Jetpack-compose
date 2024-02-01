package com.rahatshah.mediaplayerdemo.ui.screens



import androidx.lifecycle.ViewModel
import com.rahatshah.mediaplayerdemo.data.MediaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MediaListViewModel @Inject constructor(
    private val mediaRepository: MediaRepository
) : ViewModel() {

    val mediaList get() = mediaRepository.getMedia()

}