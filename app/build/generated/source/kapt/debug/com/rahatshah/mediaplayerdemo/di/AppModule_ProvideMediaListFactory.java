package com.rahatshah.mediaplayerdemo.di;

import android.app.Application;
import com.rahatshah.mediaplayerdemo.data.MediaRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideMediaListFactory implements Factory<MediaRepository> {
  private final Provider<Application> contextProvider;

  public AppModule_ProvideMediaListFactory(Provider<Application> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MediaRepository get() {
    return provideMediaList(contextProvider.get());
  }

  public static AppModule_ProvideMediaListFactory create(Provider<Application> contextProvider) {
    return new AppModule_ProvideMediaListFactory(contextProvider);
  }

  public static MediaRepository provideMediaList(Application context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMediaList(context));
  }
}
