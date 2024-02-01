package com.rahatshah.mediaplayerdemo.ui.screens;

import com.rahatshah.mediaplayerdemo.data.MediaRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MediaListViewModel_Factory implements Factory<MediaListViewModel> {
  private final Provider<MediaRepository> mediaRepositoryProvider;

  public MediaListViewModel_Factory(Provider<MediaRepository> mediaRepositoryProvider) {
    this.mediaRepositoryProvider = mediaRepositoryProvider;
  }

  @Override
  public MediaListViewModel get() {
    return newInstance(mediaRepositoryProvider.get());
  }

  public static MediaListViewModel_Factory create(
      Provider<MediaRepository> mediaRepositoryProvider) {
    return new MediaListViewModel_Factory(mediaRepositoryProvider);
  }

  public static MediaListViewModel newInstance(MediaRepository mediaRepository) {
    return new MediaListViewModel(mediaRepository);
  }
}
