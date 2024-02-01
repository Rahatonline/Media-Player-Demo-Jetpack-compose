package com.rahatshah.mediaplayerdemo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class PlayerService_Factory implements Factory<PlayerService> {
  @Override
  public PlayerService get() {
    return newInstance();
  }

  public static PlayerService_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PlayerService newInstance() {
    return new PlayerService();
  }

  private static final class InstanceHolder {
    private static final PlayerService_Factory INSTANCE = new PlayerService_Factory();
  }
}
