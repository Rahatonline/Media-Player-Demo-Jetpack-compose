package com.rahatshah.mediaplayerdemo.ui.screens;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/rahatshah/mediaplayerdemo/ui/screens/MediaListViewModel;", "Landroidx/lifecycle/ViewModel;", "mediaRepository", "Lcom/rahatshah/mediaplayerdemo/data/MediaRepository;", "(Lcom/rahatshah/mediaplayerdemo/data/MediaRepository;)V", "mediaList", "", "Lcom/rahatshah/mediaplayerdemo/data/model/MediaFile;", "getMediaList", "()Ljava/util/List;", "app_debug"})
public final class MediaListViewModel extends androidx.lifecycle.ViewModel {
    private final com.rahatshah.mediaplayerdemo.data.MediaRepository mediaRepository = null;
    
    @javax.inject.Inject
    public MediaListViewModel(@org.jetbrains.annotations.NotNull
    com.rahatshah.mediaplayerdemo.data.MediaRepository mediaRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.rahatshah.mediaplayerdemo.data.model.MediaFile> getMediaList() {
        return null;
    }
}