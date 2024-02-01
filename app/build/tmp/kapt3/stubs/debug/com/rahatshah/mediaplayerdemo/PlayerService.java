package com.rahatshah.mediaplayerdemo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\"\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/rahatshah/mediaplayerdemo/PlayerService;", "Landroid/app/Service;", "()V", "binder", "Lcom/rahatshah/mediaplayerdemo/PlayerService$MusicBinder;", "mediaPlayer", "Landroid/media/MediaPlayer;", "notificationId", "", "createNotificationChannel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "onStartCommand", "flags", "startId", "pauseMedia", "showNotification", "stopMedia", "updatePlaybackState", "currentTrack", "", "Companion", "MusicBinder", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class PlayerService extends android.app.Service {
    private android.media.MediaPlayer mediaPlayer;
    private final com.rahatshah.mediaplayerdemo.PlayerService.MusicBinder binder = null;
    private final int notificationId = 1;
    @org.jetbrains.annotations.NotNull
    public static final com.rahatshah.mediaplayerdemo.PlayerService.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_PAUSE = "com.rahatshah.mediaplayerdemo.ACTION_PAUSE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_STOP = "com.rahatshah.mediaplayerdemo.ACTION_STOP";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_RESUME = "com.rahatshah.mediaplayerdemo.ACTION_RESUME";
    private static final java.lang.String CHANNEL_ID = "com.rahatshah.mediaplayerdemo.channel_id";
    
    @javax.inject.Inject
    public PlayerService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final void pauseMedia() {
    }
    
    private final void stopMedia() {
    }
    
    private final void updatePlaybackState(java.lang.String currentTrack) {
    }
    
    private final void showNotification() {
    }
    
    private final void createNotificationChannel() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/rahatshah/mediaplayerdemo/PlayerService$MusicBinder;", "Landroid/os/Binder;", "(Lcom/rahatshah/mediaplayerdemo/PlayerService;)V", "getService", "Lcom/rahatshah/mediaplayerdemo/PlayerService;", "app_debug"})
    public final class MusicBinder extends android.os.Binder {
        
        public MusicBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.rahatshah.mediaplayerdemo.PlayerService getService() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/rahatshah/mediaplayerdemo/PlayerService$Companion;", "", "()V", "ACTION_PAUSE", "", "ACTION_RESUME", "ACTION_STOP", "CHANNEL_ID", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}