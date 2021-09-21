package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff.Mode;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.constant.ADFIVideoTracking;

public class v extends RelativeLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener, ADFMraidIVideoInInterface {
   private static long u;
   private String a;
   private Activity b;
   private ViewGroup c;
   private VideoView d;
   private ProgressBar e;
   private MediaController f;
   private w g;
   private ImageView h;
   private ADFMraidIVideoOutInterface i;
   private ADFMraidInterface j;
   private v k;
   private <undefinedtype> l;
   private boolean m = false;
   private boolean n = false;
   private boolean o = true;
   private boolean p = false;
   private int q = -1;
   private int r = -1;
   private boolean s = false;
   long t = 0L;

   public v(Context var1, String var2, ViewGroup var3, w var4, ImageView var5, ADFMraidIVideoOutInterface var6) {
      super(var1);

      try {
         this.i = var6;
         this.h = var5;
         this.c = var3;
         this.a = var2;
         this.g = var4;
         this.b = com.noqoush.adfalcon.android.sdk.util.d.c(var1);
         this.q();
         this.setId(this.q);
         this.k();
         this.j();
         this.i();
         this.r();
         this.s();
         this.d.setVideoPath(this.a);
         this.d.start();
         this.e.bringToFront();
         this.e.requestLayout();
         this.e.invalidate();
         this.requestLayout();
         this.invalidate();
      } catch (Exception var8) {
         com.noqoush.adfalcon.android.sdk.k.b(var8.getMessage());
      }
   }

   // $FF: synthetic method
   static boolean a(v var0) {
      return var0.o;
   }

   // $FF: synthetic method
   static boolean b(v var0) {
      return var0.p;
   }

   // $FF: synthetic method
   static void d(v var0) throws Exception {
      var0.n();
   }

   // $FF: synthetic method
   static MediaController f(v var0) {
      return var0.f;
   }

   private ViewGroup getDecorView() throws Exception {
      if (this.c == null) {
         this.c = (ViewGroup)this.b.getWindow().getDecorView();
      }

      return this.c;
   }

   // $FF: synthetic method
   static ADFMraidIVideoOutInterface h(v var0) {
      return var0.i;
   }

   private void h() throws Exception {
      if (this.f == null) {
         this.f = new MediaController(this.getContext());
         if (this.d == null) {
            this.k();
         }

         this.d.setMediaController(this.f);
      }

   }

   private void i() throws Exception {
      if (this.e == null) {
         ProgressBar var1 = new ProgressBar(this.getContext(), (AttributeSet)null, 16843399);
         this.e = var1;
         com.noqoush.adfalcon.android.sdk.util.f.a(this.b, var1, com.noqoush.adfalcon.android.sdk.util.f.b());
         this.e.getIndeterminateDrawable().setColorFilter(-1, Mode.MULTIPLY);
         this.e.setId(this.r);
         LayoutParams var2 = new LayoutParams(-2, -2);
         var2.addRule(13);
         this.e.setLayoutParams(var2);
         this.addView(this.e);
      }

   }

   // $FF: synthetic method
   static void i(v var0) {
      var0.s();
   }

   private void j() throws Exception {
      this.setBackgroundColor(-16777216);
      if (this.getDecorView().findViewById(this.q) == null) {
         if (this.getDecorView() instanceof RelativeLayout) {
            LayoutParams var1 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
            var1.addRule(13);
            this.setLayoutParams(var1);
         } else if (this.getDecorView() instanceof LinearLayout) {
            this.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a()));
         }

         this.getDecorView().addView(this);
         if (VERSION.SDK_INT >= 11 && this.b.getActionBar() != null) {
            this.s = this.b.getActionBar().isShowing();
            this.b.getActionBar().hide();
         } else {
            boolean var10001;
            Class var3;
            try {
               var3 = this.b.getClass();
            } catch (Exception var11) {
               var10001 = false;
               return;
            }

            Object var4;
            try {
               var4 = var3.getMethod("getSupportActionBar", (Class[])null).invoke(this.b, new Object[0]);
            } catch (Exception var10) {
               var10001 = false;
               return;
            }

            if (var4 != null) {
               Class var5;
               try {
                  var5 = var4.getClass();
               } catch (Exception var9) {
                  var10001 = false;
                  return;
               }

               Class var6;
               try {
                  this.s = (Boolean)var5.getMethod("isShowing", (Class[])null).invoke(var4, new Object[0]);
                  var6 = var4.getClass();
               } catch (Exception var8) {
                  var10001 = false;
                  return;
               }

               try {
                  var6.getMethod("hide", (Class[])null).invoke(var4, new Object[0]);
                  return;
               } catch (Exception var7) {
                  var10001 = false;
               }
            }

         }
      } else {
         throw new Exception("The video view is already added");
      }
   }

   private void k() throws Exception {
      if (this.d == null) {
         this.d = new VideoView(this.getContext());
         LayoutParams var1 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
         var1.addRule(13);
         this.d.setLayoutParams(var1);
         this.d.setOnErrorListener(this);
         this.d.setOnCompletionListener(this);
         this.d.setOnPreparedListener(this);
         this.addView(this.d);
         this.h();
      }

   }

   private void l() throws Exception {
      VideoView var1 = this.d;
      if (var1 != null && var1.isPlaying()) {
         this.n();
         u = (long)this.d.getCurrentPosition();
         this.d.pause();
         if (this.i != null) {
            this.setTrakcing(ADFIVideoTracking.pause);
         }

         StringBuilder var2 = new StringBuilder();
         var2.append("pause: ");
         var2.append(u);
         com.noqoush.adfalcon.android.sdk.k.a(var2.toString());
      }

   }

   private void m() throws Exception {
      if (this.f != null) {
         this.d.setMediaController((MediaController)null);
         this.f = null;
      }

   }

   private void n() throws Exception {
      ProgressBar var1 = this.e;
      if (var1 != null) {
         this.removeView(var1);
         this.e = null;
      }

   }

   private void o() throws Exception {
      VideoView var1 = this.d;
      if (var1 != null && !var1.isPlaying()) {
         this.i();
         VideoView var2 = this.d;
         long var3 = u;
         if (var3 < 0L) {
            var3 = 0L;
         }

         var2.seekTo((int)var3);
         this.d.start();
         StringBuilder var5 = new StringBuilder();
         var5.append("resume");
         var5.append(u);
         com.noqoush.adfalcon.android.sdk.k.a(var5.toString());
         u = -1L;
         MediaController var8 = this.f;
         if (var8 != null) {
            var8.show();
         }
      }

   }

   private void p() {
      try {
         if (this.i != null) {
            this.i.setIVideoDuration((long)this.d.getDuration());
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.k.b(var2.getMessage());
      }

   }

   private void q() {
      for(int var1 = 1; var1 < 10000; ++var1) {
         try {
            if (this.getDecorView().findViewById(var1) == null) {
               if (this.q != -1) {
                  this.r = var1;
                  return;
               }

               this.q = var1;
            }
         } catch (Exception var3) {
            this.q = 1;
            this.r = 2;
            com.noqoush.adfalcon.android.sdk.k.b(var3.getMessage());
            break;
         }
      }

   }

   private void r() {
      try {
         IntentFilter var1 = new IntentFilter("android.intent.action.SCREEN_ON");
         var1.addAction("android.intent.action.SCREEN_OFF");
         this.l = new BroadcastReceiver((v$a)null) {
            public void onReceive(Context var1, Intent var2) {
               try {
                  StringBuilder var3 = new StringBuilder();
                  var3.append("Video ScreenReceiver: ");
                  var3.append(var2.getAction());
                  com.noqoush.adfalcon.android.sdk.k.e(var3.toString());
                  if (var2.getAction().equals("android.intent.action.SCREEN_OFF")) {
                     v.this.o = false;
                     v.this.p = true;
                     if (!v.this.m && v.this.d.isPlaying()) {
                        v.this.l();
                        return;
                     }
                  } else if (var2.getAction().equals("android.intent.action.SCREEN_ON")) {
                     v.this.o = true;
                     return;
                  }
               } catch (Exception var5) {
                  com.noqoush.adfalcon.android.sdk.k.b(var5.toString());
               }

            }
         };
         this.getContext().registerReceiver(this.l, var1);
      } catch (Exception var3) {
      }
   }

   private void s() {
      this.postDelayed(new v$a(this), 1000L);
   }

   private void setTrakcing(ADFIVideoTracking var1) {
      try {
         if (this.i != null) {
            this.i.setIVideoTracking(var1);
            return;
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.k.b(var3.getMessage());
      }

   }

   public void a() {
      this.d.setVisibility(4);
   }

   boolean b() {
      MediaController var1 = this.f;
      return var1 == null || !var1.isShowing();
   }

   public boolean c() {
      return this.d.isPlaying();
   }

   public void closeIVideo() throws Exception {
      com.noqoush.adfalcon.android.sdk.k.a("closeIVideo");
      this.d();
   }

   protected boolean d() throws Exception {
      if (VERSION.SDK_INT >= 11 && this.b.getActionBar() != null) {
         if (this.s) {
            this.b.getActionBar().show();
         }
      } else if (this.s) {
         label75: {
            Class var8;
            boolean var10001;
            try {
               var8 = this.b.getClass();
            } catch (Exception var15) {
               var10001 = false;
               break label75;
            }

            Object var9;
            try {
               var9 = var8.getMethod("getSupportActionBar", (Class[])null).invoke(this.b, new Object[0]);
            } catch (Exception var14) {
               var10001 = false;
               break label75;
            }

            if (var9 != null) {
               label78: {
                  Class var10;
                  try {
                     var10 = var9.getClass();
                  } catch (Exception var13) {
                     var10001 = false;
                     break label78;
                  }

                  try {
                     var10.getMethod("show", (Class[])null).invoke(var9, new Object[0]);
                  } catch (Exception var12) {
                     var10001 = false;
                  }
               }
            }
         }
      }

      this.g();
      ImageView var1 = this.h;
      if (var1 != null) {
         var1.bringToFront();
      }

      ViewGroup var2 = this.c;
      boolean var3 = false;
      if (var2 != null) {
         try {
            if (this.d != null && this.d.canPause()) {
               this.d.stopPlayback();
            }
         } catch (Exception var11) {
         }

         this.removeAllViews();
         this.getDecorView().removeView(this);
         w var5 = this.g;
         if (var5 != null) {
            var5.c();
         }

         this.c = null;
         this.a = null;
         this.g = null;
         this.b = null;
         this.d = null;
         this.f = null;
         this.unMuteIVideo();
         this.setTrakcing(ADFIVideoTracking.closed);
         this.i = null;
         ADFMraidInterface var6 = this.getMraidInterface();
         var3 = true;
         if (var6 != null) {
            this.getMraidInterface().setViewableChange(var3);
            if (this.getVideoView() != null) {
               this.getVideoView().f();
            }
         }
      }

      return var3;
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      if (var1.getKeyCode() == 4) {
         try {
            if (!this.m) {
               return super.dispatchKeyEvent(var1);
            }

            if (var1.getAction() == 1 && this.b()) {
               this.d();
               return true;
            }
         } catch (Exception var3) {
            com.noqoush.adfalcon.android.sdk.k.b(var3.getMessage());
         }

         return true;
      } else {
         return super.dispatchKeyEvent(var1);
      }
   }

   protected void e() {
      try {
         com.noqoush.adfalcon.android.sdk.images.b var1 = new com.noqoush.adfalcon.android.sdk.images.b();
         ImageView var2 = new ImageView(this.getContext());
         LayoutParams var3 = new LayoutParams(-2, -2);
         var3.addRule(13);
         var2.setLayoutParams(var3);
         this.addView(var2);
         com.noqoush.adfalcon.android.sdk.util.f.a(this.getContext(), var2, var1.a(this.getContext()));
         this.f.show(0);
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.k.b(var5.getMessage());
      }
   }

   public void f() {
      this.d.setVisibility(0);
   }

   void g() {
      try {
         u = -1L;
         this.getContext().unregisterReceiver(this.l);
         this.l.clearAbortBroadcast();
         this.l = null;
      } catch (Exception var2) {
      }
   }

   protected ADFMraidInterface getMraidInterface() {
      return this.j;
   }

   protected v getVideoView() {
      return this.k;
   }

   public void muteIVideo() throws Exception {
      com.noqoush.adfalcon.android.sdk.k.a("muteIVideo");
      AudioManager var1 = (AudioManager)this.getContext().getSystemService("audio");
      if (VERSION.SDK_INT >= 23) {
         var1.adjustStreamVolume(3, -100, 0);
      } else {
         var1.setStreamMute(3, true);
      }
   }

   public void onCompletion(MediaPlayer var1) {
      try {
         this.n = true;
         if (this.m) {
            this.setTrakcing(ADFIVideoTracking.ended);
            this.t = (long)this.d.getDuration();
            u = (long)this.d.getDuration();
         } else {
            this.f.show(5000);
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.k.b(var3.getMessage());
      }
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      try {
         if (!this.m) {
            this.d();
         } else if (this.i != null) {
            this.i.firePlayIVideoError("Failed to open connection to the server.");
         }
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.k.b(var5.getMessage());
      }

      return true;
   }

   public void onPrepared(MediaPlayer var1) {
      try {
         this.n = false;
         this.n();
         this.d.setBackgroundColor(0);
         this.p();
         if (u == -1L || this.d.isPlaying()) {
            this.setTrakcing(ADFIVideoTracking.playing);
            return;
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.k.b(var3.getMessage());
      }

   }

   public void onRestoreInstanceState(Parcelable var1) {
      if (var1 instanceof Bundle) {
         Bundle var2 = (Bundle)var1;
         u = (long)var2.getInt("length");
         super.onRestoreInstanceState(var2.getParcelable("instanceState"));
      } else {
         super.onRestoreInstanceState(var1);
      }
   }

   public Parcelable onSaveInstanceState() {
      Bundle var1 = new Bundle();
      var1.putParcelable("instanceState", super.onSaveInstanceState());
      var1.putLong("length", u);
      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return true;
   }

   public void onWindowFocusChanged(boolean var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("onWindowFocusChanged(");
      var2.append(var1);
      var2.append(")");
      com.noqoush.adfalcon.android.sdk.k.e(var2.toString());

      label64: {
         Exception var10000;
         label68: {
            boolean var10001;
            label62: {
               try {
                  if (!this.p) {
                     break label62;
                  }
               } catch (Exception var19) {
                  var10000 = var19;
                  var10001 = false;
                  break label68;
               }

               if (var1) {
                  try {
                     this.p = false;
                  } catch (Exception var18) {
                     var10000 = var18;
                     var10001 = false;
                     break label68;
                  }
               }
            }

            boolean var7;
            try {
               var7 = this.m;
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
               break label68;
            }

            if (var7) {
               break label64;
            }

            if (!var1) {
               label48: {
                  try {
                     if (this.f.isShowing() && this.f.isFocused()) {
                        break label64;
                     }
                  } catch (Exception var15) {
                     var10000 = var15;
                     var10001 = false;
                     break label48;
                  }

                  try {
                     if (this.d.isPlaying()) {
                        StringBuilder var13 = new StringBuilder();
                        var13.append("pause-onWindowFocusChanged(");
                        var13.append(var1);
                        var13.append(") mLength: ");
                        var13.append(u);
                        com.noqoush.adfalcon.android.sdk.k.e(var13.toString());
                        this.l();
                     }
                     break label64;
                  } catch (Exception var14) {
                     var10000 = var14;
                     var10001 = false;
                  }
               }
            } else {
               try {
                  if (u > 0L && !this.d.isPlaying()) {
                     StringBuilder var8 = new StringBuilder();
                     var8.append("resume-onWindowFocusChanged(");
                     var8.append(var1);
                     var8.append(") mLength: ");
                     var8.append(u);
                     com.noqoush.adfalcon.android.sdk.k.e(var8.toString());
                     this.o();
                  }
                  break label64;
               } catch (Exception var16) {
                  var10000 = var16;
                  var10001 = false;
               }
            }
         }

         Exception var6 = var10000;
         com.noqoush.adfalcon.android.sdk.k.b(var6.getMessage());
      }

      super.onWindowFocusChanged(var1);
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      StringBuilder var2 = new StringBuilder();
      var2.append("Video: visibility: ");
      var2.append(var1);
      com.noqoush.adfalcon.android.sdk.k.a(var2.toString());

      Exception var10000;
      label30: {
         boolean var10001;
         try {
            if (this.m) {
               return;
            }
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
            break label30;
         }

         if (var1 == 0) {
            try {
               this.o();
               return;
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
            }
         } else {
            try {
               this.l();
               return;
            } catch (Exception var6) {
               var10000 = var6;
               var10001 = false;
            }
         }
      }

      Exception var5 = var10000;
      com.noqoush.adfalcon.android.sdk.k.b(var5.toString());
   }

   public void pauseIVideo() throws Exception {
      VideoView var1 = this.d;
      long var2 = 0L;
      if (var1 != null && var1.isPlaying()) {
         this.l();
      } else if (!this.n) {
         this.setTrakcing(ADFIVideoTracking.pause);
         if (u <= var2) {
            u = (long)this.d.getCurrentPosition();
         }
      }

      if (u <= var2) {
         long var7 = this.t;
         if (var7 >= var2) {
            var2 = var7;
         }

         u = var2;
      }

      StringBuilder var4 = new StringBuilder();
      var4.append("pauseIVideo: ");
      var4.append(u);
      com.noqoush.adfalcon.android.sdk.k.a(var4.toString());
   }

   public void playIVideo(String var1) throws Exception {
      com.noqoush.adfalcon.android.sdk.k.a("playIVideo");
      u = -1L;
      this.t = 0L;
      this.a = var1;
      this.setTrakcing(ADFIVideoTracking.loading);
      this.setBackgroundColor(-16777216);
      if (!this.m) {
         this.m = true;
         this.d.start();
      } else {
         this.removeView(this.d);
         this.d = null;
         this.k();
         this.d.setVideoPath(this.a);
         this.d.start();
      }

      this.setFocusable(false);
      this.d.setFocusable(false);
      this.m();
   }

   public void replayIVideo() throws Exception {
      com.noqoush.adfalcon.android.sdk.k.a("replayIVideo");
      u = -1L;
      if (this.d == null) {
         this.k();
         this.d.setVideoPath(this.a);
      }

      this.d.seekTo(0);
      this.d.start();
      this.setTrakcing(ADFIVideoTracking.playing);
      this.m();
   }

   public void resumeIVideo() throws Exception {
      StringBuilder var1 = new StringBuilder();
      var1.append("resumeIVideo: ");
      var1.append(u);
      com.noqoush.adfalcon.android.sdk.k.e(var1.toString());
      VideoView var4 = this.d;
      if (var4 != null && u > -1L && !var4.isPlaying()) {
         this.o();
         this.setTrakcing(ADFIVideoTracking.playing);
      } else if (!this.n) {
         this.setTrakcing(ADFIVideoTracking.playing);
      }

      u = -1L;
      if (!this.d.isPlaying()) {
         this.i();
      }

   }

   public void seekIVideo(long var1) throws Exception {
      StringBuilder var3 = new StringBuilder();
      var3.append("seekIVideo: ");
      var3.append(var1);
      com.noqoush.adfalcon.android.sdk.k.a(var3.toString());
      VideoView var6 = this.d;
      if (var6 != null) {
         var6.seekTo((int)var1);
         this.d.start();
      }

   }

   protected void setMraidInterface(ADFMraidInterface var1) {
      this.j = var1;
   }

   protected void setVideoView(v var1) {
      this.k = var1;
   }

   public void unMuteIVideo() throws Exception {
      com.noqoush.adfalcon.android.sdk.k.a("unMuteIVideo");
      AudioManager var1 = (AudioManager)this.getContext().getSystemService("audio");
      if (VERSION.SDK_INT >= 23) {
         var1.adjustStreamVolume(3, 100, 0);
      } else {
         var1.setStreamMute(3, false);
      }
   }
}
