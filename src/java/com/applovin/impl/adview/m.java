package com.applovin.impl.adview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.StrictMode.ThreadPolicy;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.impl.sdk.d.ac;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class m extends Activity implements j, com.applovin.impl.sdk.e.a {
   public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
   public static volatile n lastKnownWrapper = null;
   private boolean A;
   private final Handler B;
   private final Handler C;
   private FrameLayout D;
   private h E;
   private View F;
   private h G;
   private View H;
   private f I;
   private ImageView J;
   private WeakReference K;
   private com.applovin.impl.sdk.a.b L;
   private u M;
   private ProgressBar N;
   private v.a O;
   private a P;
   private com.applovin.impl.sdk.utils.o Q;
   private com.applovin.impl.sdk.utils.a R;
   private BroadcastReceiver S;
   private l a;
   private n b;
   private volatile boolean c = false;
   protected int computedLengthSeconds = 0;
   protected i countdownManager;
   public volatile com.applovin.impl.sdk.ad.f currentAd;
   private com.applovin.impl.sdk.c.d d;
   private volatile boolean e = false;
   private volatile boolean f = false;
   private volatile boolean g = false;
   private volatile boolean h = false;
   private volatile boolean i = false;
   private volatile boolean j = false;
   private volatile boolean k = false;
   private boolean l = false;
   public com.applovin.impl.sdk.p logger;
   private volatile boolean m = false;
   private boolean n = true;
   private boolean o = false;
   private long p = 0L;
   protected volatile boolean postitialWasDisplayed = false;
   private long q = 0L;
   private long r = 0L;
   private long s = 0L;
   public com.applovin.impl.sdk.j sdk;
   private long t = -2L;
   private int u = 0;
   private int v = Integer.MIN_VALUE;
   protected volatile boolean videoMuted = false;
   public t videoView;
   private AtomicBoolean w = new AtomicBoolean(false);
   private AtomicBoolean x = new AtomicBoolean(false);
   private AtomicBoolean y = new AtomicBoolean(false);
   private int z;

   public m() {
      this.z = com.applovin.impl.sdk.e.a;
      this.B = new Handler(Looper.getMainLooper());
      this.C = new Handler(Looper.getMainLooper());
      this.K = new WeakReference((Object)null);
   }

   private void A() {
      if (this.C()) {
         this.M();
         this.pauseReportRewardTask();
         this.logger.b("InterActivity", "Prompting incentivized ad close warning");
         this.L.b();
      } else {
         this.skipVideo();
      }
   }

   private void B() {
      if (this.currentAd.X()) {
         c var1 = ((AdViewControllerImpl)this.a.getAdViewController()).getAdWebView();
         if (var1 != null) {
            var1.a("javascript:al_onCloseButtonTapped();");
         }
      }

      if (this.D()) {
         this.logger.b("InterActivity", "Prompting incentivized non-video ad close warning");
         this.L.c();
      } else {
         this.dismiss();
      }
   }

   // $FF: synthetic method
   static u C(m var0) {
      return var0.M;
   }

   private boolean C() {
      return this.G() && !this.isFullyWatched() && (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.bQ) && this.L != null;
   }

   private boolean D() {
      return this.H() && !this.F() && (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.bV) && this.L != null;
   }

   private int E() {
      if (this.currentAd instanceof com.applovin.impl.sdk.ad.a) {
         float var1 = ((com.applovin.impl.sdk.ad.a)this.currentAd).h();
         if (var1 <= 0.0F) {
            var1 = this.currentAd.n();
         }

         double var2 = com.applovin.impl.sdk.utils.q.a(System.currentTimeMillis() - this.p);
         double var4 = (double)var1;
         Double.isNaN(var4);
         return (int)Math.min(100.0D * (var2 / var4), 100.0D);
      } else {
         return 0;
      }
   }

   // $FF: synthetic method
   static void F(m var0) {
      var0.O();
   }

   private boolean F() {
      return this.E() >= this.currentAd.T();
   }

   // $FF: synthetic method
   static l G(m var0) {
      return var0.a;
   }

   private boolean G() {
      return AppLovinAdType.INCENTIVIZED.equals(this.currentAd.getType());
   }

   private boolean H() {
      return !this.currentAd.hasVideoUrl() && this.G();
   }

   private void I() {
      if (this.currentAd != null) {
         long var1 = this.currentAd.ah();
         long var3 = 0L;
         if ((var1 >= var3 || this.currentAd.ai() >= 0) && this.Q == null) {
            long var13;
            if (this.currentAd.ah() >= var3) {
               var13 = this.currentAd.ah();
            } else {
               label55: {
                  long var24;
                  label54: {
                     int var23;
                     if (this.isVastAd()) {
                        com.applovin.impl.a.a var26 = (com.applovin.impl.a.a)this.currentAd;
                        com.applovin.impl.a.j var27 = var26.h();
                        if (var27 != null && var27.b() > 0) {
                           var3 += TimeUnit.SECONDS.toMillis((long)var27.b());
                        } else {
                           int var28 = this.videoView.getDuration();
                           if (var28 > 0) {
                              var3 += (long)var28;
                           }
                        }

                        if (!var26.aj()) {
                           break label55;
                        }

                        var23 = (int)var26.n();
                        if (var23 <= 0) {
                           break label55;
                        }
                     } else {
                        if (!(this.currentAd instanceof com.applovin.impl.sdk.ad.a)) {
                           break label55;
                        }

                        com.applovin.impl.sdk.ad.a var20 = (com.applovin.impl.sdk.ad.a)this.currentAd;
                        int var21 = this.videoView.getDuration();
                        if (var21 > 0) {
                           var3 += (long)var21;
                        }

                        if (!var20.aj()) {
                           break label55;
                        }

                        int var22 = (int)var20.h();
                        if (var22 > 0) {
                           var24 = TimeUnit.SECONDS.toMillis((long)var22);
                           break label54;
                        }

                        var23 = (int)var20.n();
                        if (var23 <= 0) {
                           break label55;
                        }
                     }

                     var24 = TimeUnit.SECONDS.toMillis((long)var23);
                  }

                  var3 += var24;
               }

               double var5 = (double)var3;
               double var7 = (double)this.currentAd.ai();
               Double.isNaN(var7);
               double var10 = var7 / 100.0D;
               Double.isNaN(var5);
               var13 = (long)(var5 * var10);
            }

            com.applovin.impl.sdk.p var15 = this.logger;
            StringBuilder var16 = new StringBuilder();
            var16.append("Scheduling report reward in ");
            var16.append(TimeUnit.MILLISECONDS.toSeconds(var13));
            var16.append(" seconds...");
            var15.b("InterActivity", var16.toString());
            this.Q = com.applovin.impl.sdk.utils.o.a(var13, this.sdk, new m$17(this));
         }
      }

   }

   private void J() {
      l var1 = this.a;
      if (var1 != null) {
         var1.setAdDisplayListener(new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd var1) {
               if (!m.this.f) {
                  m.this.a(var1);
               }

            }

            public void adHidden(AppLovinAd var1) {
               m.this.b(var1);
            }
         });
         this.a.setAdClickListener(new AppLovinAdClickListener() {
            public void adClicked(AppLovinAd var1) {
               com.applovin.impl.sdk.utils.j.a(m.this.b.e(), var1);
            }
         });
         this.currentAd = (com.applovin.impl.sdk.ad.f)this.b.b();
         if (this.x.compareAndSet(false, true)) {
            this.sdk.o().trackImpression(this.currentAd);
            this.currentAd.setHasShown(true);
         }

         LayoutParams var2 = new LayoutParams(-1, -1);
         this.D = new FrameLayout(this);
         this.D.setLayoutParams(var2);
         this.D.setBackgroundColor(this.currentAd.C());
         this.countdownManager = new i(this.B, this.sdk);
         this.j();
         if (this.currentAd.isVideoAd()) {
            this.m = this.currentAd.b();
            String var8;
            StringBuilder var7;
            com.applovin.impl.sdk.p var6;
            if (this.m) {
               var6 = this.logger;
               var7 = new StringBuilder();
               var8 = "Preparing stream for ";
            } else {
               var6 = this.logger;
               var7 = new StringBuilder();
               var8 = "Preparing cached video playback for ";
            }

            var7.append(var8);
            var7.append(this.currentAd.d());
            var6.b("InterActivity", var7.toString());
            com.applovin.impl.sdk.c.d var11 = this.d;
            if (var11 != null) {
               long var12;
               if (this.m) {
                  var12 = 1L;
               } else {
                  var12 = 0L;
               }

               var11.b(var12);
            }
         }

         this.videoMuted = this.i();
         Uri var3 = this.currentAd.d();
         this.a(var3);
         if (var3 == null) {
            this.I();
         }

         this.E.bringToFront();
         if (this.n()) {
            View var5 = this.F;
            if (var5 != null) {
               var5.bringToFront();
            }
         }

         h var4 = this.G;
         if (var4 != null) {
            var4.bringToFront();
         }

         if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.fg)) {
            this.D.addView(this.a);
            this.a.setVisibility(4);
         }

         this.a.renderAd(this.currentAd);
         this.b.a(true);
         if (!this.currentAd.hasVideoUrl()) {
            if (this.H() && (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.ca)) {
               this.d((AppLovinAd)this.currentAd);
            }

            this.showPostitial();
            return;
         }
      } else {
         this.exitWithError("AdView was null");
      }

   }

   private void K() {
      if (this.videoView != null) {
         this.u = this.getVideoPercentViewed();
         this.videoView.stopPlayback();
      }

   }

   private boolean L() {
      return this.videoMuted;
   }

   private void M() {
      t var1 = this.videoView;
      int var2;
      if (var1 != null) {
         var2 = var1.getCurrentPosition();
      } else {
         var2 = 0;
      }

      this.sdk.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.v, (Object)var2);
      this.sdk.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.w, (Object)true);

      label42:
      try {
         this.countdownManager.c();
      } catch (Throwable var6) {
         this.logger.b("InterActivity", "Unable to pause countdown timers", var6);
         break label42;
      }

      t var4 = this.videoView;
      if (var4 != null) {
         var4.pause();
      }

   }

   private void N() {
      long var1 = Math.max(0L, (Long)this.sdk.a(com.applovin.impl.sdk.b.d.dl));
      if (var1 > 0L) {
         com.applovin.impl.sdk.p var3 = this.sdk.v();
         StringBuilder var4 = new StringBuilder();
         var4.append("Resuming video with delay of ");
         var4.append(var1);
         var3.b("InterActivity", var4.toString());
         this.C.postDelayed(new m$20(this), var1);
      } else {
         this.sdk.v().b("InterActivity", "Resuming video immediately");
         this.O();
      }
   }

   private void O() {
      if (!this.postitialWasDisplayed) {
         t var1 = this.videoView;
         if (var1 != null && !var1.isPlaying()) {
            int var2 = this.videoView.getDuration();
            int var3 = (Integer)this.sdk.b(com.applovin.impl.sdk.b.f.v, var2);
            this.videoView.seekTo(var3);
            this.videoView.start();
            this.countdownManager.a();
         }
      }

   }

   private void P() {
      if (!this.i) {
         Throwable var10000;
         label411: {
            boolean var10001;
            int var3;
            label419: {
               try {
                  var3 = this.getVideoPercentViewed();
                  if (this.currentAd.hasVideoUrl()) {
                     this.a(this.currentAd, (double)var3, this.isFullyWatched());
                     if (this.d != null) {
                        this.d.c((long)var3);
                     }
                     break label419;
                  }
               } catch (Throwable var45) {
                  var10000 = var45;
                  var10001 = false;
                  break label411;
               }

               int var6;
               com.applovin.impl.sdk.ad.f var12;
               try {
                  if (!(this.currentAd instanceof com.applovin.impl.sdk.ad.a) || !this.H() || !(Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.ca)) {
                     break label419;
                  }

                  var6 = this.E();
                  com.applovin.impl.sdk.p var7 = this.logger;
                  StringBuilder var8 = new StringBuilder();
                  var8.append("Rewarded playable engaged at ");
                  var8.append(var6);
                  var8.append(" percent");
                  var7.b("InterActivity", var8.toString());
                  var12 = this.currentAd;
               } catch (Throwable var43) {
                  var10000 = var43;
                  var10001 = false;
                  break label411;
               }

               double var13 = (double)var6;

               boolean var15;
               label402: {
                  label401: {
                     try {
                        if (var6 < this.currentAd.T()) {
                           break label401;
                        }
                     } catch (Throwable var44) {
                        var10000 = var44;
                        var10001 = false;
                        break label411;
                     }

                     var15 = true;
                     break label402;
                  }

                  var15 = false;
               }

               try {
                  this.a(var12, var13, var15);
               } catch (Throwable var42) {
                  var10000 = var42;
                  var10001 = false;
                  break label411;
               }
            }

            label382:
            try {
               long var4 = System.currentTimeMillis() - this.p;
               this.sdk.o().trackVideoEnd(this.currentAd, TimeUnit.MILLISECONDS.toSeconds(var4), var3, this.m);
               this.sdk.o().trackFullScreenAdClosed(this.currentAd, SystemClock.elapsedRealtime() - this.r, this.t, this.A, this.z);
               return;
            } catch (Throwable var41) {
               var10000 = var41;
               var10001 = false;
               break label382;
            }
         }

         Throwable var1 = var10000;
         com.applovin.impl.sdk.p var2 = this.logger;
         if (var2 != null) {
            var2.b("InterActivity", "Failed to notify end listener.", var1);
         }

      }
   }

   private int a(int var1) {
      return AppLovinSdkUtils.dpToPx(this, var1);
   }

   private int a(int var1, boolean var2) {
      if (var2) {
         if (var1 == 0) {
            return 0;
         }

         if (var1 == 1) {
            return 9;
         }

         if (var1 == 2) {
            return 8;
         }

         if (var1 == 3) {
            return 1;
         }
      } else {
         if (var1 == 0) {
            return 1;
         }

         if (var1 == 1) {
            return 0;
         }

         if (var1 == 2) {
            return 9;
         }

         if (var1 == 3) {
            return 8;
         }
      }

      return -1;
   }

   // $FF: synthetic method
   static long a(m var0, long var1) {
      var0.r = var1;
      return var1;
   }

   // $FF: synthetic method
   static WeakReference a(m var0, WeakReference var1) {
      var0.K = var1;
      return var1;
   }

   private void a(long var1, h var3) {
      this.C.postDelayed(new m$10(this, var3), var1);
   }

   private void a(PointF var1) {
      if (this.currentAd.u() && this.currentAd.g() != null) {
         this.sdk.v().b("InterActivity", "Clicking through video...");
         this.clickThroughFromVideo(var1);
      } else {
         this.e();
         this.f();
      }
   }

   private void a(Uri var1) {
      Object var2;
      if (this.currentAd.aC()) {
         var2 = new p(this.sdk, this, new p.a() {
            public void a(String var1) {
               m.this.handleMediaError(var1);
            }
         });
      } else {
         var2 = new AppLovinVideoView(this, this.sdk);
      }

      this.videoView = (t)var2;
      if (var1 != null) {
         this.videoView.setOnPreparedListener(new m$27(this));
         this.videoView.setOnCompletionListener(new m$28(this));
         this.videoView.setOnErrorListener(new m$29(this));
         ThreadPolicy var3 = StrictMode.allowThreadDiskReads();
         this.videoView.setVideoURI(var1);
         StrictMode.setThreadPolicy(var3);
      }

      this.videoView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
      this.videoView.setOnTouchListener(new AppLovinTouchToClickListener(this.sdk, this, new AppLovinTouchToClickListener.OnClickListener() {
         public void onClick(View var1, PointF var2) {
            m.this.a(var2);
         }
      }));
      this.D.addView((View)this.videoView);
      this.setContentView(this.D);
      this.p();
      this.x();
   }

   private void a(View var1, boolean var2, long var3) {
      float var5;
      if (var2) {
         var5 = 0.0F;
      } else {
         var5 = 1.0F;
      }

      float var6 = 0.0F;
      if (var2) {
         var6 = 1.0F;
      }

      AlphaAnimation var7 = new AlphaAnimation(var5, var6);
      var7.setDuration(var3);
      var7.setAnimationListener(new m$24(this, var1, var2));
      var1.startAnimation(var7);
   }

   // $FF: synthetic method
   static void a(m var0, View var1, boolean var2, long var3) {
      var0.a(var1, var2, var3);
   }

   private void a(AppLovinAd var1) {
      com.applovin.impl.sdk.utils.j.a(this.b.d(), var1);
      this.f = true;
      this.sdk.Z().c();
      AppLovinSdkUtils.runOnUiThreadDelayed(new m$21(this), (Long)this.sdk.a(com.applovin.impl.sdk.b.d.dp));
   }

   private void a(AppLovinAd var1, double var2, boolean var4) {
      this.i = true;
      com.applovin.impl.sdk.utils.j.a(this.b.c(), var1, var2, var4);
   }

   private void a(String var1) {
      n var2 = this.b;
      if (var2 != null) {
         AppLovinAdDisplayListener var3 = var2.d();
         if (var3 instanceof com.applovin.impl.sdk.ad.i && this.y.compareAndSet(false, true)) {
            this.runOnUiThread(new m$25(this, var3, var1));
         }
      }

   }

   private void a(String var1, long var2) {
      if (var2 >= 0L) {
         this.C.postDelayed(new m$22(this, var1), var2);
      }

   }

   private void a(boolean var1) {
      if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cY) && com.applovin.impl.sdk.utils.g.d()) {
         int var5;
         if (var1) {
            var5 = R.drawable.unmute_to_mute;
         } else {
            var5 = R.drawable.mute_to_unmute;
         }

         AnimatedVectorDrawable var6 = (AnimatedVectorDrawable)this.getDrawable(var5);
         if (var6 != null) {
            this.J.setScaleType(ScaleType.FIT_XY);
            this.J.setImageDrawable(var6);
            var6.start();
            return;
         }
      }

      Uri var2;
      if (var1) {
         var2 = this.currentAd.aF();
      } else {
         var2 = this.currentAd.aG();
      }

      int var3 = this.a((Integer)this.sdk.a(com.applovin.impl.sdk.b.d.de));
      ThreadPolicy var4 = StrictMode.allowThreadDiskReads();
      AppLovinSdkUtils.safePopulateImageView(this.J, var2, var3);
      StrictMode.setThreadPolicy(var4);
   }

   private boolean a() {
      int var1 = this.getResources().getIdentifier((String)this.sdk.a(com.applovin.impl.sdk.b.d.cV), "bool", "android");
      return var1 > 0 && this.getResources().getBoolean(var1);
   }

   // $FF: synthetic method
   static boolean a(m var0, boolean var1) {
      var0.j = var1;
      return var1;
   }

   // $FF: synthetic method
   static long b(m var0, long var1) {
      var0.t = var1;
      return var1;
   }

   private void b() {
      this.getWindow().getDecorView().setSystemUiVisibility(5894);
   }

   private void b(int var1) {
      try {
         this.setRequestedOrientation(var1);
      } catch (Throwable var4) {
         this.sdk.v().b("InterActivity", "Failed to set requested orientation", var4);
         return;
      }
   }

   private void b(int var1, boolean var2) {
      label97: {
         boolean var3 = (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cT);
         byte var4;
         if (this.b.f() == com.applovin.impl.sdk.ad.f.b.b) {
            label85: {
               var4 = 9;
               if (var2) {
                  if (var1 == 1 || var1 == 3) {
                     if (var3) {
                        if (var1 != 1) {
                           break label97;
                        }
                        break label85;
                     }

                     return;
                  }
               } else if (var1 == 0 || var1 == 2) {
                  if (var3) {
                     if (var1 == 0) {
                        var4 = 1;
                     }
                     break label85;
                  }

                  return;
               }

               this.c = true;
               break label97;
            }
         } else {
            label96: {
               if (this.b.f() == com.applovin.impl.sdk.ad.f.b.c) {
                  label69: {
                     var4 = 8;
                     if (var2) {
                        if (var1 != 0 && var1 != 2) {
                           break label69;
                        }

                        if (!var3) {
                           return;
                        }

                        if (var1 == 2) {
                           break label96;
                        }
                     } else {
                        if (var1 != 1 && var1 != 3) {
                           break label69;
                        }

                        if (!var3) {
                           return;
                        }

                        if (var1 != 1) {
                           break label96;
                        }
                     }

                     var4 = 0;
                     break label96;
                  }

                  this.c = true;
                  this.b(0);
                  return;
               }

               return;
            }
         }

         this.b(var4);
         return;
      }

      this.b(1);
   }

   // $FF: synthetic method
   static void b(m var0) {
      var0.b();
   }

   private void b(AppLovinAd var1) {
      this.dismiss();
      this.c(var1);
   }

   private void b(String var1) {
      com.applovin.impl.sdk.ad.f var2 = this.currentAd;
      if (var2 != null && var2.Z()) {
         this.a(var1, 0L);
      }

   }

   private void b(boolean var1) {
      if (this.currentAd.W()) {
         c var2 = ((AdViewControllerImpl)this.a.getAdViewController()).getAdWebView();
         if (var2 != null) {
            String var3;
            if (var1) {
               var3 = "javascript:al_mute();";
            } else {
               var3 = "javascript:al_unmute();";
            }

            try {
               var2.a(var3);
               return;
            } catch (Throwable var6) {
               this.logger.b("InterActivity", "Unable to forward mute setting to template.", var6);
               return;
            }
         }
      }

   }

   // $FF: synthetic method
   static boolean b(m var0, boolean var1) {
      var0.k = var1;
      return var1;
   }

   // $FF: synthetic method
   static long c(m var0, long var1) {
      var0.s = var1;
      return var1;
   }

   private void c(AppLovinAd var1) {
      if (!this.g) {
         this.g = true;
         n var2 = this.b;
         if (var2 != null) {
            com.applovin.impl.sdk.utils.j.b(var2.d(), var1);
         }

         this.sdk.Z().d();
      }

   }

   private void c(boolean var1) {
      this.videoMuted = var1;
      MediaPlayer var2 = (MediaPlayer)this.K.get();
      if (var2 != null) {
         byte var3;
         if (var1) {
            var3 = 0;
         } else {
            var3 = 1;
         }

         float var4 = (float)var3;

         try {
            var2.setVolume(var4, var4);
            return;
         } catch (IllegalStateException var8) {
            com.applovin.impl.sdk.p var6 = this.logger;
            StringBuilder var7 = new StringBuilder();
            var7.append("Failed to set MediaPlayer muted: ");
            var7.append(var1);
            var6.b("InterActivity", var7.toString(), var8);
         }
      }

   }

   private boolean c() {
      n var1 = this.b;
      boolean var2 = true;
      if (var1 != null) {
         com.applovin.impl.sdk.j var3 = this.sdk;
         if (var3 == null) {
            return var2;
         }

         if ((Boolean)var3.a(com.applovin.impl.sdk.b.d.cN)) {
            return var2;
         }

         if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cO) && this.j) {
            return var2;
         }

         if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cP) && this.postitialWasDisplayed) {
            return var2;
         }

         var2 = false;
      }

      return var2;
   }

   // $FF: synthetic method
   static boolean c(m var0) {
      return var0.i();
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.c.d d(m var0) {
      return var0.d;
   }

   private void d() {
      if (this.sdk == null || !this.isFinishing()) {
         if (this.currentAd != null) {
            int var1 = this.v;
            if (var1 != Integer.MIN_VALUE) {
               this.b(var1);
            }
         }

         this.finish();
      }
   }

   // $FF: synthetic method
   static void d(m var0, boolean var1) {
      var0.b(var1);
   }

   private void d(AppLovinAd var1) {
      if (!this.h) {
         this.h = true;
         com.applovin.impl.sdk.utils.j.a(this.b.c(), var1);
      }

   }

   // $FF: synthetic method
   static Handler e(m var0) {
      return var0.C;
   }

   private void e() {
      if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cW)) {
         f var1 = this.I;
         if (var1 != null && var1.getVisibility() != 8) {
            boolean var2;
            if (this.I.getVisibility() == 4) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.a(this.I, var2, 750L);
         }
      }

   }

   private void f() {
      s var1 = this.currentAd.t();
      if (var1 != null && var1.e() && !this.postitialWasDisplayed) {
         u var2 = this.M;
         if (var2 != null) {
            boolean var3;
            if (var2.getVisibility() == 4) {
               var3 = true;
            } else {
               var3 = false;
            }

            this.a(this.M, var3, var1.f());
         }
      }

   }

   // $FF: synthetic method
   static void f(m var0) {
      var0.z();
   }

   private void g() {
      com.applovin.impl.sdk.j var1 = this.sdk;
      if (var1 != null) {
         var1.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.w, (Object)false);
         this.sdk.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.v, (int)0);
      }

   }

   // $FF: synthetic method
   static void g(m var0) {
      var0.y();
   }

   // $FF: synthetic method
   static long h(m var0) {
      return var0.q;
   }

   private void h() {
      this.e = true;
      this.showPostitial();
   }

   // $FF: synthetic method
   static void i(m var0) {
      var0.q();
   }

   private boolean i() {
      if ((Integer)this.sdk.b(com.applovin.impl.sdk.b.f.v, 0) > 0) {
         return this.videoMuted;
      } else {
         return (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.dd) ? this.sdk.l().isMuted() : (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.db);
      }
   }

   private void j() {
      this.E = com.applovin.impl.adview.h.a(this.sdk, this, this.currentAd.o());
      this.E.setVisibility(8);
      this.E.setOnClickListener(new m$3(this));
      int var1 = this.a(this.currentAd.aa());
      boolean var2 = this.currentAd.ad();
      byte var3 = 3;
      byte var4;
      if (var2) {
         var4 = 3;
      } else {
         var4 = 5;
      }

      int var5 = var4 | 48;
      if (!this.currentAd.ae()) {
         var3 = 5;
      }

      int var6 = var3 | 48;
      android.widget.FrameLayout.LayoutParams var7 = new android.widget.FrameLayout.LayoutParams(var1, var1, var5 | 48);
      this.E.a(var1);
      int var8 = this.a(this.currentAd.ab());
      int var9 = this.a(this.currentAd.ac());
      var7.setMargins(var9, var8, var9, var8);
      this.D.addView(this.E, var7);
      this.G = com.applovin.impl.adview.h.a(this.sdk, this, this.currentAd.p());
      this.G.setVisibility(8);
      this.G.setOnClickListener(new m$4(this));
      android.widget.FrameLayout.LayoutParams var10 = new android.widget.FrameLayout.LayoutParams(var1, var1, var6);
      var10.setMargins(var9, var8, var9, var8);
      this.G.a(var1);
      this.D.addView(this.G, var10);
      this.G.bringToFront();
      if (this.n()) {
         int var11 = this.a((Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cc));
         this.F = new View(this);
         this.F.setBackgroundColor(0);
         this.F.setVisibility(8);
         this.H = new View(this);
         this.H.setBackgroundColor(0);
         this.H.setVisibility(8);
         int var12 = var1 + var11;
         int var13 = var8 - this.a(5);
         android.widget.FrameLayout.LayoutParams var14 = new android.widget.FrameLayout.LayoutParams(var12, var12, var5);
         var14.setMargins(var13, var13, var13, var13);
         android.widget.FrameLayout.LayoutParams var15 = new android.widget.FrameLayout.LayoutParams(var12, var12, var6);
         var15.setMargins(var13, var13, var13, var13);
         this.F.setOnClickListener(new m$5(this));
         this.H.setOnClickListener(new m$6(this));
         this.D.addView(this.F, var14);
         this.F.bringToFront();
         this.D.addView(this.H, var15);
         this.H.bringToFront();
      }

   }

   // $FF: synthetic method
   static void j(m var0) {
      var0.k();
   }

   private void k() {
      if (this.J == null) {
         Exception var10000;
         label50: {
            Uri var5;
            boolean var10001;
            android.widget.FrameLayout.LayoutParams var3;
            label49: {
               label48: {
                  try {
                     this.videoMuted = this.i();
                     this.J = new ImageView(this);
                     if (this.l()) {
                        break label48;
                     }

                     int var2 = this.a((Integer)this.sdk.a(com.applovin.impl.sdk.b.d.de));
                     var3 = new android.widget.FrameLayout.LayoutParams(var2, var2, (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.dg));
                     this.J.setScaleType(ScaleType.FIT_CENTER);
                     int var4 = this.a((Integer)this.sdk.a(com.applovin.impl.sdk.b.d.df));
                     var3.setMargins(var4, var4, var4, var4);
                     if (this.videoMuted) {
                        var5 = this.currentAd.aF();
                        break label49;
                     }
                  } catch (Exception var12) {
                     var10000 = var12;
                     var10001 = false;
                     break label50;
                  }

                  try {
                     var5 = this.currentAd.aG();
                     break label49;
                  } catch (Exception var11) {
                     var10000 = var11;
                     var10001 = false;
                     break label50;
                  }
               }

               try {
                  this.sdk.v().b("InterActivity", "Mute button should be hidden");
                  return;
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label50;
               }
            }

            if (var5 != null) {
               try {
                  com.applovin.impl.sdk.p var6 = this.sdk.v();
                  StringBuilder var7 = new StringBuilder();
                  var7.append("Added mute button with params: ");
                  var7.append(var3);
                  var6.b("InterActivity", var7.toString());
                  this.a(this.videoMuted);
                  this.J.setClickable(true);
                  this.J.setOnClickListener(new m$7(this));
                  this.D.addView(this.J, var3);
                  this.J.bringToFront();
                  return;
               } catch (Exception var8) {
                  var10000 = var8;
                  var10001 = false;
               }
            } else {
               try {
                  this.sdk.v().e("InterActivity", "Attempting to add mute button but could not find uri");
                  return;
               } catch (Exception var10) {
                  var10000 = var10;
                  var10001 = false;
               }
            }
         }

         Exception var1 = var10000;
         this.sdk.v().a("InterActivity", (String)"Failed to attach mute button", (Throwable)var1);
      }

   }

   // $FF: synthetic method
   static void k(m var0) {
      var0.v();
   }

   // $FF: synthetic method
   static void l(m var0) {
      var0.u();
   }

   private boolean l() {
      if (!(Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cZ)) {
         return true;
      } else if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.da)) {
         return this.i() ? false : true ^ (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.dc);
      } else {
         return false;
      }
   }

   private void m() {
      this.runOnUiThread(new m$8(this));
   }

   // $FF: synthetic method
   static void m(m var0) {
      var0.I();
   }

   // $FF: synthetic method
   static void n(m var0) {
      var0.h();
   }

   private boolean n() {
      return (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cc) > 0;
   }

   private void o() {
      this.runOnUiThread(new m$9(this));
   }

   // $FF: synthetic method
   static void o(m var0) {
      var0.B();
   }

   private void p() {
      if (this.currentAd.m() >= 0.0F) {
         h var1;
         label14: {
            if (this.l) {
               var1 = this.G;
               if (var1 != null) {
                  break label14;
               }
            }

            var1 = this.E;
         }

         this.a(com.applovin.impl.sdk.utils.q.b(this.currentAd.m()), var1);
      }

   }

   // $FF: synthetic method
   static void p(m var0) {
      var0.A();
   }

   // $FF: synthetic method
   static h q(m var0) {
      return var0.E;
   }

   private void q() {
      boolean var1;
      if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cM) && this.t() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (this.I == null && var1) {
         this.I = new f(this);
         int var2 = this.currentAd.B();
         this.I.setTextColor(var2);
         this.I.setTextSize((float)(Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cL));
         this.I.setFinishedStrokeColor(var2);
         this.I.setFinishedStrokeWidth((float)(Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cK));
         this.I.setMax(this.t());
         this.I.setProgress(this.t());
         android.widget.FrameLayout.LayoutParams var3 = new android.widget.FrameLayout.LayoutParams(this.a((Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cJ)), this.a((Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cJ)), (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cI));
         int var4 = this.a((Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cH));
         var3.setMargins(var4, var4, var4, var4);
         this.D.addView(this.I, var3);
         this.I.bringToFront();
         this.I.setVisibility(0);
         final long var5 = this.s();
         this.countdownManager.a("COUNTDOWN_CLOCK", 1000L, new i.a() {
            public void a() {
               if (m.this.I != null) {
                  long var1 = TimeUnit.MILLISECONDS.toSeconds(var5 - (long)m.this.videoView.getCurrentPosition());
                  if (var1 <= 0L) {
                     m.this.I.setVisibility(8);
                     m.this.o = true;
                     return;
                  }

                  if (m.this.r()) {
                     m.this.I.setProgress((int)var1);
                  }
               }

            }

            public boolean b() {
               return m.this.r();
            }
         });
      }

   }

   // $FF: synthetic method
   static h r(m var0) {
      return var0.G;
   }

   private boolean r() {
      return !this.o && !this.postitialWasDisplayed && this.videoView.isPlaying();
   }

   private long s() {
      return TimeUnit.SECONDS.toMillis((long)this.t());
   }

   // $FF: synthetic method
   static boolean s(m var0) {
      return var0.j;
   }

   private int t() {
      int var1 = this.currentAd.A();
      if (var1 > 0) {
         return var1;
      } else {
         if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.do)) {
            var1 = 1 + this.computedLengthSeconds;
         }

         return var1;
      }
   }

   // $FF: synthetic method
   static boolean t(m var0) {
      return var0.n();
   }

   // $FF: synthetic method
   static View u(m var0) {
      return var0.F;
   }

   private void u() {
      if (this.N == null && this.currentAd.L()) {
         this.logger.c("InterActivity", "Attaching video progress bar...");
         this.N = new ProgressBar(this, (AttributeSet)null, 16842872);
         this.N.setMax((Integer)this.sdk.a(com.applovin.impl.sdk.b.d.dj));
         this.N.setPadding(0, 0, 0, 0);
         if (com.applovin.impl.sdk.utils.g.d()) {
            label33:
            try {
               ColorStateList var5 = ColorStateList.valueOf(this.currentAd.M());
               this.N.setProgressTintList(var5);
            } catch (Throwable var7) {
               this.logger.b("InterActivity", "Unable to update progress bar color.", var7);
               break label33;
            }
         }

         android.widget.FrameLayout.LayoutParams var1 = new android.widget.FrameLayout.LayoutParams(this.videoView.getWidth(), 20, 80);
         var1.setMargins(0, 0, 0, (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.dk));
         this.D.addView(this.N, var1);
         this.N.bringToFront();
         long var2 = (Long)this.sdk.a(com.applovin.impl.sdk.b.d.di);
         this.countdownManager.a("PROGRESS_BAR", var2, new i.a() {
            public void a() {
               if (m.this.N != null) {
                  if (m.this.shouldContinueFullLengthVideoCountdown()) {
                     int var1 = (Integer)m.this.sdk.a(com.applovin.impl.sdk.b.d.dj);
                     int var2 = (int)((float)m.this.videoView.getCurrentPosition() / (float)m.this.videoView.getDuration() * (float)var1);
                     m.this.N.setProgress(var2);
                     return;
                  }

                  m.this.N.setVisibility(8);
               }

            }

            public boolean b() {
               return m.this.shouldContinueFullLengthVideoCountdown();
            }
         });
      }

   }

   private void v() {
      s var1 = this.currentAd.t();
      if (com.applovin.impl.sdk.utils.n.b(this.currentAd.s()) && var1 != null && this.M == null) {
         this.logger.c("InterActivity", "Attaching video button...");
         this.M = this.w();
         double var2 = (double)var1.a();
         Double.isNaN(var2);
         double var5 = var2 / 100.0D;
         double var7 = (double)var1.b();
         Double.isNaN(var7);
         double var10 = var7 / 100.0D;
         int var12 = this.videoView.getWidth();
         int var13 = this.videoView.getHeight();
         double var14 = (double)var12;
         Double.isNaN(var14);
         int var17 = (int)(var5 * var14);
         double var18 = (double)var13;
         Double.isNaN(var18);
         android.widget.FrameLayout.LayoutParams var21 = new android.widget.FrameLayout.LayoutParams(var17, (int)(var10 * var18), var1.d());
         int var22 = this.a(var1.c());
         var21.setMargins(var22, var22, var22, var22);
         this.D.addView(this.M, var21);
         this.M.bringToFront();
         if (var1.i() > 0.0F) {
            this.M.setVisibility(4);
            long var26 = com.applovin.impl.sdk.utils.q.b(var1.i());
            this.C.postDelayed(new m$14(this, var1), var26);
         }

         if (var1.j() > 0.0F) {
            long var23 = com.applovin.impl.sdk.utils.q.b(var1.j());
            this.C.postDelayed(new m$15(this, var1), var23);
         }
      }

   }

   // $FF: synthetic method
   static boolean v(m var0) {
      return var0.k;
   }

   // $FF: synthetic method
   static View w(m var0) {
      return var0.H;
   }

   private u w() {
      com.applovin.impl.sdk.p var1 = this.logger;
      StringBuilder var2 = new StringBuilder();
      var2.append("Create video button with HTML = ");
      var2.append(this.currentAd.s());
      var1.b("InterActivity", var2.toString());
      v var5 = new v(this.sdk);
      this.O = new v.a() {
         public void a(u var1) {
            m.this.logger.b("InterActivity", "Clicking through from video button...");
            m.this.clickThroughFromVideo(var1.getAndClearLastClickLocation());
         }

         public void b(u var1) {
            m.this.logger.b("InterActivity", "Closing ad from video button...");
            m.this.dismiss();
         }

         public void c(u var1) {
            m.this.logger.b("InterActivity", "Skipping video from video button...");
            m.this.skipVideo();
         }
      };
      var5.a(new WeakReference(this.O));
      u var6 = com.applovin.impl.adview.u.a(this.sdk, var5, this.getApplicationContext());
      var6.a(this.currentAd.s());
      return var6;
   }

   private void x() {
      if (this.m && this.currentAd.N()) {
         int var1 = this.currentAd.P();
         this.P = new a(this, (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.dn), var1);
         this.P.setColor(this.currentAd.Q());
         this.P.setBackgroundColor(this.currentAd.R());
         this.P.setVisibility(8);
         android.widget.FrameLayout.LayoutParams var2 = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
         this.D.addView(this.P, var2);
         this.D.bringChildToFront(this.P);
      }

   }

   // $FF: synthetic method
   static void x(m var0) {
      var0.m();
   }

   private void y() {
      a var1 = this.P;
      if (var1 != null) {
         var1.a();
      }

   }

   // $FF: synthetic method
   static void y(m var0) {
      var0.o();
   }

   private void z() {
      a var1 = this.P;
      if (var1 != null) {
         var1.b();
      }

   }

   public void clickThroughFromVideo(PointF var1) {
      try {
         if (this.currentAd.al() && this.l) {
            this.o();
         }

         this.sdk.o().trackAndLaunchVideoClick(this.currentAd, this.a, this.currentAd.g(), var1);
         com.applovin.impl.sdk.utils.j.a((AppLovinAdClickListener)this.b.e(), (AppLovinAd)this.currentAd);
         if (this.d != null) {
            this.d.b();
            return;
         }
      } catch (Throwable var4) {
         this.sdk.v().b("InterActivity", "Encountered error while clicking through video.", var4);
         return;
      }

   }

   public void continueVideo() {
      this.O();
   }

   public void dismiss() {
      long var1 = System.currentTimeMillis() - this.p;
      StringBuilder var3 = new StringBuilder();
      var3.append("Dismissing ad after ");
      var3.append(var1);
      var3.append(" milliseconds elapsed");
      com.applovin.impl.sdk.p.g("InterActivity", var3.toString());
      com.applovin.impl.sdk.j var7 = this.sdk;
      if (var7 != null) {
         if ((Boolean)var7.a(com.applovin.impl.sdk.b.d.cX)) {
            this.stopService(new Intent(this.getBaseContext(), AppKilledService.class));
            this.sdk.af().unregisterReceiver(this.S);
         }

         this.sdk.ae().b(this);
      }

      this.g();
      this.P();
      if (this.b != null) {
         if (this.currentAd != null) {
            this.c((AppLovinAd)this.currentAd);
            com.applovin.impl.sdk.c.d var8 = this.d;
            if (var8 != null) {
               var8.c();
               this.d = null;
            }

            this.a("javascript:al_onPoststitialDismiss();", (long)this.currentAd.V());
         }

         this.b.a(false);
         this.b.g();
      }

      lastKnownWrapper = null;
      this.d();
   }

   public void exitWithError(String var1) {
      this.a(var1);

      try {
         StringBuilder var2 = new StringBuilder();
         var2.append("Initialized = ");
         var2.append(com.applovin.impl.adview.n.b);
         var2.append("; CleanedUp = ");
         var2.append(com.applovin.impl.adview.n.c);
         String var8 = var2.toString();
         StringBuilder var9 = new StringBuilder();
         var9.append("Failed to properly render an Interstitial Activity, due to error: ");
         var9.append(var1);
         com.applovin.impl.sdk.p.c("InterActivity", var9.toString(), new Throwable(var8));
         this.c((AppLovinAd)(new com.applovin.impl.sdk.ad.h()));
      } catch (Exception var10) {
         com.applovin.impl.sdk.p.c("InterActivity", "Failed to show a video ad due to error:", var10);
      }

      this.dismiss();
   }

   public boolean getPostitialWasDisplayed() {
      return this.postitialWasDisplayed;
   }

   public int getVideoPercentViewed() {
      if (this.e) {
         return 100;
      } else {
         t var1 = this.videoView;
         if (var1 != null) {
            int var2 = var1.getDuration();
            if (var2 > 0) {
               double var3 = (double)this.videoView.getCurrentPosition();
               double var5 = (double)var2;
               Double.isNaN(var3);
               Double.isNaN(var5);
               return (int)(100.0D * (var3 / var5));
            } else {
               return this.u;
            }
         } else {
            this.logger.e("InterActivity", "No video view detected on video end");
            return 0;
         }
      }
   }

   public void handleMediaError(String var1) {
      this.logger.e("InterActivity", var1);
      if (this.w.compareAndSet(false, true) && this.currentAd.H()) {
         this.a(var1);
         this.dismiss();
      }

   }

   protected boolean isFullyWatched() {
      return this.getVideoPercentViewed() >= this.currentAd.T();
   }

   protected boolean isVastAd() {
      return this.currentAd instanceof com.applovin.impl.a.a;
   }

   public void onBackPressed() {
      if (this.currentAd != null) {
         if (this.currentAd.aD() && !this.postitialWasDisplayed) {
            return;
         }

         if (this.currentAd.aE() && this.postitialWasDisplayed) {
            return;
         }
      }

      if (this.c()) {
         this.logger.b("InterActivity", "Back button was pressed; forwarding to Android for handling...");
      } else {
         label77: {
            boolean var10001;
            label83: {
               h var2;
               label86: {
                  try {
                     if (!this.postitialWasDisplayed && this.l && this.G != null && this.G.getVisibility() == 0 && this.G.getAlpha() > 0.0F) {
                        this.logger.b("InterActivity", "Back button was pressed; forwarding as a click to skip button.");
                        var2 = this.G;
                        break label86;
                     }
                  } catch (Exception var6) {
                     var10001 = false;
                     break label77;
                  }

                  try {
                     if (this.E != null && this.E.getVisibility() == 0 && this.E.getAlpha() > 0.0F) {
                        this.logger.b("InterActivity", "Back button was pressed; forwarding as a click to close button.");
                        var2 = this.E;
                        break label86;
                     }
                  } catch (Exception var7) {
                     var10001 = false;
                     break label77;
                  }

                  try {
                     this.logger.b("InterActivity", "Back button was pressed, but was not eligible for dismissal.");
                     break label83;
                  } catch (Exception var4) {
                     var10001 = false;
                     break label77;
                  }
               }

               try {
                  var2.performClick();
               } catch (Exception var5) {
                  var10001 = false;
                  break label77;
               }
            }

            try {
               this.b("javascript:al_onBackPressed();");
               return;
            } catch (Exception var3) {
               var10001 = false;
            }
         }
      }

      super.onBackPressed();
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      if (var1.orientation != 0 && this.videoView instanceof p && this.K.get() != null) {
         MediaPlayer var2 = (MediaPlayer)this.K.get();
         this.videoView.setVideoSize(var2.getVideoWidth(), var2.getVideoHeight());
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         boolean var24 = var1.getBoolean("instance_impression_tracked");
         this.x.set(var24);
      }

      this.requestWindowFeature(1);
      ThreadPolicy var3 = StrictMode.allowThreadDiskReads();

      label4921: {
         boolean var10001;
         Throwable var10000;
         label4922: {
            String var7;
            try {
               var7 = this.getIntent().getStringExtra("com.applovin.interstitial.wrapper_id");
            } catch (Throwable var576) {
               var10000 = var576;
               var10001 = false;
               break label4922;
            }

            String var8;
            label4932: {
               if (var7 != null) {
                  label4931: {
                     try {
                        if (var7.isEmpty()) {
                           break label4931;
                        }

                        this.b = com.applovin.impl.adview.n.a(var7);
                        if (this.b == null && lastKnownWrapper != null) {
                           this.b = lastKnownWrapper;
                        }
                     } catch (Throwable var575) {
                        var10000 = var575;
                        var10001 = false;
                        break label4922;
                     }

                     AppLovinAd var12;
                     label4924: {
                        try {
                           if (this.b != null) {
                              var12 = this.b.b();
                              this.sdk = this.b.a();
                              this.logger = this.b.a().v();
                              if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cX)) {
                                 this.S = new m$1(this, var12);
                                 this.sdk.af().registerReceiver(this.S, new IntentFilter("com.applovin.app_killed"));
                                 this.startService(new Intent(this.getBaseContext(), AppKilledService.class));
                              }
                              break label4924;
                           }
                        } catch (Throwable var574) {
                           var10000 = var574;
                           var10001 = false;
                           break label4922;
                        }

                        try {
                           StringBuilder var9 = new StringBuilder();
                           var9.append("Wrapper is null; initialized state: ");
                           var9.append(com.applovin.impl.adview.n.b);
                           var8 = var9.toString();
                           break label4932;
                        } catch (Throwable var573) {
                           var10000 = var573;
                           var10001 = false;
                           break label4922;
                        }
                     }

                     if (var12 != null) {
                        com.applovin.impl.sdk.ad.f var13;
                        try {
                           var13 = (com.applovin.impl.sdk.ad.f)var12;
                           this.d = new com.applovin.impl.sdk.c.d(var13, this.sdk);
                           if (var13.aq()) {
                              this.sdk.ae().a(this);
                           }
                        } catch (Throwable var571) {
                           var10000 = var571;
                           var10001 = false;
                           break label4922;
                        }

                        View var14;
                        try {
                           var14 = this.findViewById(16908290);
                        } catch (Throwable var570) {
                           var10000 = var570;
                           var10001 = false;
                           break label4922;
                        }

                        if (var14 != null) {
                           int var15;
                           label4927: {
                              try {
                                 if (var13.hasVideoUrl()) {
                                    var15 = var13.C();
                                    break label4927;
                                 }
                              } catch (Throwable var569) {
                                 var10000 = var569;
                                 var10001 = false;
                                 break label4922;
                              }

                              try {
                                 var15 = var13.D();
                              } catch (Throwable var568) {
                                 var10000 = var568;
                                 var10001 = false;
                                 break label4922;
                              }
                           }

                           try {
                              var14.setBackgroundColor(var15);
                           } catch (Throwable var567) {
                              var10000 = var567;
                              var10001 = false;
                              break label4922;
                           }
                        }

                        try {
                           this.p = System.currentTimeMillis();
                           if (var13.v()) {
                              this.getWindow().setFlags(16777216, 16777216);
                           }
                        } catch (Throwable var566) {
                           var10000 = var566;
                           var10001 = false;
                           break label4922;
                        }

                        try {
                           if (var13.w()) {
                              this.getWindow().addFlags(128);
                           }
                        } catch (Throwable var565) {
                           var10000 = var565;
                           var10001 = false;
                           break label4922;
                        }

                        boolean var17;
                        int var16;
                        int var18;
                        try {
                           var16 = com.applovin.impl.sdk.utils.q.e((Context)this);
                           var17 = AppLovinSdkUtils.isTablet(this);
                           var18 = this.a(var16, var17);
                        } catch (Throwable var564) {
                           var10000 = var564;
                           var10001 = false;
                           break label4922;
                        }

                        if (var1 == null) {
                           try {
                              this.v = var18;
                           } catch (Throwable var563) {
                              var10000 = var563;
                              var10001 = false;
                              break label4922;
                           }
                        } else {
                           try {
                              this.v = var1.getInt("original_orientation", var18);
                           } catch (Throwable var562) {
                              var10000 = var562;
                              var10001 = false;
                              break label4922;
                           }
                        }

                        label4928: {
                           label4929: {
                              label4930: {
                                 try {
                                    if (var13.z()) {
                                       break label4930;
                                    }
                                 } catch (Throwable var561) {
                                    var10000 = var561;
                                    var10001 = false;
                                    break label4922;
                                 }

                                 try {
                                    this.logger.b("InterActivity", "Locking activity orientation to targeted orientation...");
                                    break label4929;
                                 } catch (Throwable var558) {
                                    var10000 = var558;
                                    var10001 = false;
                                    break label4922;
                                 }
                              }

                              if (var18 != -1) {
                                 try {
                                    com.applovin.impl.sdk.p var19 = this.logger;
                                    StringBuilder var20 = new StringBuilder();
                                    var20.append("Locking activity orientation to current orientation: ");
                                    var20.append(var18);
                                    var19.b("InterActivity", var20.toString());
                                    this.b(var18);
                                    break label4928;
                                 } catch (Throwable var560) {
                                    var10000 = var560;
                                    var10001 = false;
                                    break label4922;
                                 }
                              }

                              try {
                                 this.logger.e("InterActivity", "Unable to detect current orientation. Locking to targeted orientation...");
                              } catch (Throwable var559) {
                                 var10000 = var559;
                                 var10001 = false;
                                 break label4922;
                              }
                           }

                           try {
                              this.b(var16, var17);
                           } catch (Throwable var557) {
                              var10000 = var557;
                              var10001 = false;
                              break label4922;
                           }
                        }

                        try {
                           this.a = new l(this.sdk.S(), AppLovinAdSize.INTERSTITIAL, this);
                           this.a.setAutoDestroy(false);
                           ((AdViewControllerImpl)this.a.getAdViewController()).setStatsManagerHelper(this.d);
                           this.b.a((j)this);
                           this.l = (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.dm);
                           this.L = new com.applovin.impl.sdk.a.b(this, this.sdk);
                           this.R = new com.applovin.impl.sdk.utils.a() {
                              public void onActivityCreated(Activity var1, Bundle var2) {
                                 if (m.this.sdk != null && (Boolean)m.this.sdk.a(com.applovin.impl.sdk.b.d.fb) && !m.this.g) {
                                    String var3 = com.applovin.impl.sdk.utils.q.d(m.this.getApplicationContext());
                                    if (var1.getClass().getName().equals(var3)) {
                                       ac var4 = new ac(m.this.sdk, new m$12$1(this));
                                       m.this.sdk.K().a((com.applovin.impl.sdk.d.a)var4, com.applovin.impl.sdk.d.r.a.a);
                                    }
                                 }

                              }
                           };
                           this.sdk.aa().a(this.R);
                           break label4921;
                        } catch (Throwable var556) {
                           var10000 = var556;
                           var10001 = false;
                           break label4922;
                        }
                     }

                     var8 = "No current ad found.";
                     break label4932;
                  }
               }

               var8 = "Wrapper ID is null";
            }

            label4888:
            try {
               this.exitWithError(var8);
               break label4921;
            } catch (Throwable var572) {
               var10000 = var572;
               var10001 = false;
               break label4888;
            }
         }

         Throwable var4 = var10000;

         label4822: {
            try {
               if (this.logger != null) {
                  this.logger.b("InterActivity", "Encountered error during onCreate.", var4);
               }
            } catch (Throwable var555) {
               var10000 = var555;
               var10001 = false;
               break label4822;
            }

            label4819:
            try {
               this.exitWithError("An error was encountered during interstitial ad creation.");
               break label4921;
            } catch (Throwable var554) {
               var10000 = var554;
               var10001 = false;
               break label4819;
            }
         }

         Throwable var5 = var10000;
         StrictMode.setThreadPolicy(var3);
         throw var5;
      }

      StrictMode.setThreadPolicy(var3);
      this.g();
      com.applovin.impl.sdk.c.d var6 = this.d;
      if (var6 != null) {
         var6.a();
      }

      this.J();
   }

   protected void onDestroy() {
      // $FF: Couldn't be decompiled
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if ((var1 == 25 || var1 == 24) && this.currentAd.Y() && this.L()) {
         this.toggleMute();
      }

      return super.onKeyDown(var1, var2);
   }

   protected void onPause() {
      super.onPause();
      this.logger.b("InterActivity", "App paused...");
      this.q = System.currentTimeMillis();
      if (this.postitialWasDisplayed) {
         this.M();
      }

      this.b.a(false);
      this.L.a();
      this.pauseReportRewardTask();
      this.b("javascript:al_onAppPaused();");
   }

   protected void onResume() {
      super.onResume();
      this.logger.b("InterActivity", "App resumed...");
      n var1 = this.b;
      boolean var2 = true;
      var1.a(var2);
      if (!this.n) {
         com.applovin.impl.sdk.c.d var3 = this.d;
         if (var3 != null) {
            var3.d(System.currentTimeMillis() - this.q);
         }

         label82: {
            h var4;
            if ((Boolean)this.sdk.b(com.applovin.impl.sdk.b.f.w, false) && !this.L.d() && !this.postitialWasDisplayed) {
               this.N();
               this.y();
               if (this.currentAd == null || !(Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cG) || this.currentAd.y() || this.postitialWasDisplayed || !this.l) {
                  break label82;
               }

               var4 = this.G;
               if (var4 == null) {
                  break label82;
               }
            } else {
               if (!(this.currentAd instanceof com.applovin.impl.sdk.ad.a) || !((com.applovin.impl.sdk.ad.a)this.currentAd).i()) {
                  var2 = false;
               }

               if (this.currentAd == null || !(Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cG) || this.currentAd.x() || !this.postitialWasDisplayed) {
                  break label82;
               }

               var4 = this.E;
               if (var4 == null || var2) {
                  break label82;
               }
            }

            this.a(0L, var4);
         }

         this.resumeReportRewardTask();
      } else if (!this.L.d() && !this.postitialWasDisplayed && this.currentAd != null && this.currentAd.O()) {
         this.y();
      }

      this.b("javascript:al_onAppResumed();");
   }

   public void onRingerModeChanged(int var1) {
      if (this.z != com.applovin.impl.sdk.e.a) {
         this.A = true;
      }

      c var2 = ((AdViewControllerImpl)this.a.getAdViewController()).getAdWebView();
      if (var2 != null) {
         label29: {
            String var3;
            if (com.applovin.impl.sdk.e.a(var1) && !com.applovin.impl.sdk.e.a(this.z)) {
               var3 = "javascript:al_muteSwitchOn();";
            } else {
               if (var1 != 2) {
                  break label29;
               }

               var3 = "javascript:al_muteSwitchOff();";
            }

            var2.a(var3);
         }
      }

      this.z = var1;
   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBoolean("instance_impression_tracked", this.x.get());
      var1.putInt("original_orientation", this.v);
   }

   public void onWindowFocusChanged(boolean var1) {
      label251: {
         super.onWindowFocusChanged(var1);
         com.applovin.impl.sdk.j var2 = this.sdk;
         String var3;
         if (var1) {
            if (var2 != null) {
               this.logger.b("InterActivity", "Window gained focus");

               Throwable var10000;
               label254: {
                  boolean var10001;
                  label240: {
                     try {
                        if (com.applovin.impl.sdk.utils.g.c() && (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.dh) && this.a()) {
                           this.b();
                           if ((Long)this.sdk.a(com.applovin.impl.sdk.b.d.cQ) > 0L) {
                              this.C.postDelayed(new m$23(this), (Long)this.sdk.a(com.applovin.impl.sdk.b.d.cQ));
                           }
                           break label240;
                        }
                     } catch (Throwable var20) {
                        var10000 = var20;
                        var10001 = false;
                        break label254;
                     }

                     try {
                        this.getWindow().setFlags(1024, 1024);
                     } catch (Throwable var19) {
                        var10000 = var19;
                        var10001 = false;
                        break label254;
                     }
                  }

                  label227:
                  try {
                     if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cR) && !this.postitialWasDisplayed) {
                        this.N();
                        this.resumeReportRewardTask();
                     }
                     break label251;
                  } catch (Throwable var18) {
                     var10000 = var18;
                     var10001 = false;
                     break label227;
                  }
               }

               Throwable var8 = var10000;
               this.logger.b("InterActivity", "Setting window flags failed.", var8);
               break label251;
            }

            var3 = "Window gained focus. SDK is null.";
         } else {
            if (var2 != null) {
               this.logger.b("InterActivity", "Window lost focus");
               if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cR) && !this.postitialWasDisplayed) {
                  this.M();
                  this.pauseReportRewardTask();
               }
               break label251;
            }

            var3 = "Window lost focus. SDK is null.";
         }

         com.applovin.impl.sdk.p.g("InterActivity", var3);
      }

      this.n = false;
      StringBuilder var4 = new StringBuilder();
      var4.append("javascript:al_onWindowFocusChanged( ");
      var4.append(var1);
      var4.append(" );");
      this.b(var4.toString());
   }

   public void pauseReportRewardTask() {
      com.applovin.impl.sdk.utils.o var1 = this.Q;
      if (var1 != null) {
         var1.b();
      }

   }

   protected void playVideo() {
      this.d((AppLovinAd)this.currentAd);
      this.videoView.start();
      this.countdownManager.a();
   }

   public void resumeReportRewardTask() {
      com.applovin.impl.sdk.utils.o var1 = this.Q;
      if (var1 != null) {
         var1.c();
      }

   }

   protected boolean shouldContinueFullLengthVideoCountdown() {
      return !this.e && !this.postitialWasDisplayed;
   }

   public void showPostitial() {
      Throwable var10000;
      label5727: {
         boolean var10001;
         try {
            if (this.d != null) {
               this.d.g();
            }
         } catch (Throwable var658) {
            var10000 = var658;
            var10001 = false;
            break label5727;
         }

         try {
            if (!this.currentAd.af()) {
               this.K();
            }
         } catch (Throwable var657) {
            var10000 = var657;
            var10001 = false;
            break label5727;
         }

         label5735: {
            label5717: {
               ViewParent var6;
               try {
                  if (this.a == null) {
                     break label5735;
                  }

                  var6 = this.a.getParent();
                  if (!(var6 instanceof ViewGroup) || (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.fg) && var6 == this.D) {
                     break label5717;
                  }
               } catch (Throwable var656) {
                  var10000 = var656;
                  var10001 = false;
                  break label5727;
               }

               try {
                  ((ViewGroup)var6).removeView(this.a);
               } catch (Throwable var649) {
                  var10000 = var649;
                  var10001 = false;
                  break label5727;
               }
            }

            FrameLayout var7;
            label5703: {
               try {
                  if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.fg)) {
                     var7 = this.D;
                     break label5703;
                  }
               } catch (Throwable var655) {
                  var10000 = var655;
                  var10001 = false;
                  break label5727;
               }

               try {
                  var7 = new FrameLayout(this);
               } catch (Throwable var648) {
                  var10000 = var648;
                  var10001 = false;
                  break label5727;
               }
            }

            label5694: {
               try {
                  var7.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
                  var7.setBackgroundColor(this.currentAd.D());
                  if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.fg)) {
                     this.a.setVisibility(0);
                     break label5694;
                  }
               } catch (Throwable var654) {
                  var10000 = var654;
                  var10001 = false;
                  break label5727;
               }

               try {
                  var7.addView(this.a);
               } catch (Throwable var647) {
                  var10000 = var647;
                  var10001 = false;
                  break label5727;
               }
            }

            try {
               if (this.currentAd.af()) {
                  this.K();
               }
            } catch (Throwable var646) {
               var10000 = var646;
               var10001 = false;
               break label5727;
            }

            label5737: {
               label5683:
               try {
                  if (this.D != null) {
                     if (!(Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.fg)) {
                        break label5683;
                     }

                     com.applovin.impl.sdk.utils.b.a(this.D, this.a);
                  }
                  break label5737;
               } catch (Throwable var653) {
                  var10000 = var653;
                  var10001 = false;
                  break label5727;
               }

               try {
                  this.D.removeAllViewsInLayout();
               } catch (Throwable var645) {
                  var10000 = var645;
                  var10001 = false;
                  break label5727;
               }
            }

            label5675: {
               try {
                  if (!this.n() || this.F == null) {
                     break label5675;
                  }

                  if (this.F.getParent() instanceof ViewGroup) {
                     ((ViewGroup)this.F.getParent()).removeView(this.F);
                  }
               } catch (Throwable var652) {
                  var10000 = var652;
                  var10001 = false;
                  break label5727;
               }

               try {
                  var7.addView(this.F);
                  this.F.bringToFront();
               } catch (Throwable var644) {
                  var10000 = var644;
                  var10001 = false;
                  break label5727;
               }
            }

            label5667: {
               try {
                  if (this.E == null) {
                     break label5667;
                  }

                  ViewParent var8 = this.E.getParent();
                  if (var8 instanceof ViewGroup) {
                     ((ViewGroup)var8).removeView(this.E);
                  }
               } catch (Throwable var651) {
                  var10000 = var651;
                  var10001 = false;
                  break label5727;
               }

               try {
                  var7.addView(this.E);
                  this.E.bringToFront();
               } catch (Throwable var643) {
                  var10000 = var643;
                  var10001 = false;
                  break label5727;
               }
            }

            try {
               if (!(Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.fg)) {
                  this.setContentView(var7);
               }
            } catch (Throwable var642) {
               var10000 = var642;
               var10001 = false;
               break label5727;
            }

            try {
               if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.eY)) {
                  this.a.setVisibility(4);
                  this.a.setVisibility(0);
               }
            } catch (Throwable var650) {
               var10000 = var650;
               var10001 = false;
               break label5727;
            }

            try {
               this.a("javascript:al_onPoststitialShow();", (long)this.currentAd.U());
            } catch (Throwable var641) {
               var10000 = var641;
               var10001 = false;
               break label5727;
            }
         }

         boolean var2;
         label5645: {
            label5644: {
               try {
                  if (!(this.currentAd instanceof com.applovin.impl.sdk.ad.a) || !((com.applovin.impl.sdk.ad.a)this.currentAd).i()) {
                     break label5644;
                  }
               } catch (Throwable var640) {
                  var10000 = var640;
                  var10001 = false;
                  break label5727;
               }

               var2 = true;
               break label5645;
            }

            var2 = false;
         }

         if (!var2) {
            label5733: {
               h var5;
               long var3;
               label5734: {
                  try {
                     if (this.currentAd.n() >= 0.0F) {
                        var3 = com.applovin.impl.sdk.utils.q.b(this.currentAd.n());
                        var5 = this.E;
                        break label5734;
                     }
                  } catch (Throwable var638) {
                     var10000 = var638;
                     var10001 = false;
                     break label5727;
                  }

                  try {
                     if (this.currentAd.n() == -2.0F) {
                        this.E.setVisibility(0);
                        break label5733;
                     }
                  } catch (Throwable var639) {
                     var10000 = var639;
                     var10001 = false;
                     break label5727;
                  }

                  var3 = 0L;

                  try {
                     var5 = this.E;
                  } catch (Throwable var637) {
                     var10000 = var637;
                     var10001 = false;
                     break label5727;
                  }
               }

               try {
                  this.a(var3, var5);
               } catch (Throwable var636) {
                  var10000 = var636;
                  var10001 = false;
                  break label5727;
               }
            }
         } else {
            try {
               this.logger.b("InterActivity", "Skip showing of close button");
            } catch (Throwable var635) {
               var10000 = var635;
               var10001 = false;
               break label5727;
            }
         }

         label5613:
         try {
            this.postitialWasDisplayed = true;
            return;
         } catch (Throwable var634) {
            var10000 = var634;
            var10001 = false;
            break label5613;
         }
      }

      Throwable var1 = var10000;
      this.logger.b("InterActivity", "Encountered error while showing postitial. Dismissing...", var1);
      this.dismiss();
   }

   public void skipVideo() {
      this.t = SystemClock.elapsedRealtime() - this.s;
      com.applovin.impl.sdk.c.d var1 = this.d;
      if (var1 != null) {
         var1.f();
      }

      if (this.currentAd.q()) {
         this.dismiss();
      } else {
         this.showPostitial();
      }
   }

   public void toggleMute() {
      boolean var1 = true ^ this.L();
      com.applovin.impl.sdk.c.d var2 = this.d;
      if (var2 != null) {
         var2.i();
      }

      try {
         this.c(var1);
         this.a(var1);
         this.b(var1);
      } catch (Throwable var7) {
         com.applovin.impl.sdk.p var4 = this.logger;
         StringBuilder var5 = new StringBuilder();
         var5.append("Unable to set volume to ");
         var5.append(var1);
         var4.b("InterActivity", var5.toString(), var7);
         return;
      }
   }
}
