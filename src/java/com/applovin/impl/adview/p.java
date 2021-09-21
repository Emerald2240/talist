package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.applovin.sdk.AppLovinSdkUtils;

class p extends FrameLayout implements SurfaceTextureListener, t {
   private final com.applovin.impl.sdk.p a;
   private final TextureView b;
   private final MediaPlayer c;
   private final p.a d;
   private int e;
   private int f;
   private int g;

   p(com.applovin.impl.sdk.j var1, Context var2, p.a var3) {
      super(var2);
      this.a = var1.v();
      this.c = new MediaPlayer();
      this.d = var3;
      this.b = new TextureView(var2);
      this.b.setLayoutParams(new LayoutParams(-1, -1, 17));
      this.b.setSurfaceTextureListener(this);
      this.addView(this.b);
   }

   // $FF: synthetic method
   static p.a a(p var0) {
      return var0.d;
   }

   private void a(String var1) {
      this.a.e("TextureVideoView", var1);
      AppLovinSdkUtils.runOnUiThreadDelayed(new p$1(this, var1), 250L);
   }

   public int getCurrentPosition() {
      return this.c.getCurrentPosition();
   }

   public int getDuration() {
      return this.c.getDuration();
   }

   public boolean isPlaying() {
      return this.c.isPlaying();
   }

   public void onSurfaceTextureAvailable(SurfaceTexture var1, int var2, int var3) {
      Surface var4 = new Surface(var1);

      try {
         this.c.setSurface(var4);
         this.c.setAudioStreamType(3);
         this.c.prepareAsync();
      } finally {
         var4.release();
         this.a("Failed to prepare media player");
         return;
      }
   }

   public boolean onSurfaceTextureDestroyed(SurfaceTexture var1) {
      return true;
   }

   public void onSurfaceTextureSizeChanged(SurfaceTexture var1, int var2, int var3) {
   }

   public void onSurfaceTextureUpdated(SurfaceTexture var1) {
   }

   public void pause() {
      this.c.pause();
   }

   public void seekTo(int var1) {
      this.c.seekTo(var1);
   }

   public void setOnCompletionListener(OnCompletionListener var1) {
      this.c.setOnCompletionListener(var1);
   }

   public void setOnErrorListener(OnErrorListener var1) {
      this.c.setOnErrorListener(var1);
   }

   public void setOnPreparedListener(OnPreparedListener var1) {
      this.c.setOnPreparedListener(var1);
   }

   public void setVideoSize(int var1, int var2) {
      int var3 = com.applovin.impl.sdk.utils.q.b(this.getContext());
      int var4 = this.e;
      int var5;
      int var6;
      if (var4 == 0) {
         var5 = this.b.getWidth();
         var6 = this.b.getHeight();
         this.e = var3;
         this.f = var5;
         this.g = var6;
      } else if (var3 == var4) {
         var5 = this.f;
         var6 = this.g;
      } else {
         var5 = this.g;
         var6 = this.f;
      }

      float var7 = (float)var2 / (float)var1;
      float var8 = (float)var5;
      int var9 = (int)(var8 * var7);
      int var10;
      if (var6 >= var9) {
         var10 = var5;
      } else {
         var10 = (int)((float)var6 / var7);
         var9 = var6;
      }

      int var11 = var5 - var10;

      try {
         int var18 = var11 / 2;
         int var19 = (var6 - var9) / 2;
         Matrix var20 = new Matrix();
         this.b.getTransform(var20);
         var20.setScale((float)var10 / var8, (float)var9 / (float)var6);
         var20.postTranslate((float)var18, (float)var19);
         this.b.setTransform(var20);
         this.invalidate();
         this.requestLayout();
      } finally {
         StringBuilder var13 = new StringBuilder();
         var13.append("Failed to set video size to width: ");
         var13.append(var1);
         var13.append(" height: ");
         var13.append(var2);
         this.a(var13.toString());
         return;
      }
   }

   public void setVideoURI(Uri var1) {
      try {
         this.c.setDataSource(var1.toString());
      } catch (Throwable var5) {
         StringBuilder var3 = new StringBuilder();
         var3.append("Failed to set video URI: ");
         var3.append(var1);
         var3.append(" at ");
         var3.append(var5);
         this.a(var3.toString());
         return;
      }
   }

   public void start() {
      this.c.start();
   }

   public void stopPlayback() {
      this.c.stop();
   }

   interface a {
      void a(String var1);
   }
}
