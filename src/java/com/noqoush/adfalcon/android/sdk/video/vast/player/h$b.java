package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class h$b implements OnPreparedListener {
   // $FF: synthetic field
   final h a;

   h$b(h var1) {
      this.a = var1;
   }

   public void onPrepared(MediaPlayer var1) {
      try {
         this.a.getVideoPlayer().setBackgroundColor(0);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }
}
