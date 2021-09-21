package com.applovin.impl.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

class m$27 implements OnPreparedListener {
   // $FF: synthetic field
   final m a;

   m$27(m var1) {
      this.a = var1;
   }

   public void onPrepared(MediaPlayer var1) {
      m.a(this.a, new WeakReference(var1));
      byte var3 = m.c(this.a);
      float var4 = (float)(var3 ^ 1);
      var1.setVolume(var4, var4);
      if (m.d(this.a) != null) {
         com.applovin.impl.sdk.c.d var8 = m.d(this.a);
         long var9;
         if (var3 != 0) {
            var9 = 1L;
         } else {
            var9 = 0L;
         }

         var8.e(var9);
      }

      int var5 = var1.getVideoWidth();
      int var6 = var1.getVideoHeight();
      this.a.computedLengthSeconds = (int)TimeUnit.MILLISECONDS.toSeconds((long)var1.getDuration());
      this.a.videoView.setVideoSize(var5, var6);
      if (this.a.videoView instanceof AppLovinVideoView) {
         SurfaceHolder var7 = ((AppLovinVideoView)this.a.videoView).getHolder();
         if (var7.getSurface() != null) {
            var1.setDisplay(var7);
         }
      }

      var1.setOnErrorListener(new m$27$1(this));
      var1.setOnInfoListener(new m$27$2(this));
      if (m.h(this.a) == 0L) {
         m.i(this.a);
         m.j(this.a);
         m.k(this.a);
         m.l(this.a);
         this.a.playVideo();
         m.m(this.a);
      }

   }
}
