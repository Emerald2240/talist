package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.R;
import com.noqoush.adfalcon.android.sdk.z;
import com.noqoush.adfalcon.android.sdk.urlactions.i;
import com.noqoush.adfalcon.android.sdk.urlactions.m;
import com.noqoush.adfalcon.android.sdk.video.vast.model.n;
import com.noqoush.adfalcon.android.sdk.video.vast.model.p;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;
import com.noqoush.adfalcon.android.sdk.video.vast.model.v;
import com.noqoush.adfalcon.android.sdk.video.vast.model.w;
import com.noqoush.adfalcon.android.sdk.viewability.ViewabilityVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Timer;

public class h extends RelativeLayout implements g, com.noqoush.adfalcon.android.sdk.video.vast.model.c, w, OnClickListener {
   public static final int y = 4;
   private p a;
   private ViewabilityVideoView b;
   private Queue c;
   private r d;
   private String e;
   private a f;
   private e g;
   private f h;
   private b i;
   private ArrayList j;
   private WeakReference k;
   private boolean l;
   private int m = -1;
   private int n = -1;
   private <undefinedtype> o;
   private <undefinedtype> p;
   private z q;
   private Timer r;
   private AudioManager s;
   private Activity t;
   private int u;
   private Timer v;
   private int w = 0;
   int x = 0;

   public h(Context var1) {
      super(var1);
      this.setMuted(false);
      LayoutParams var2 = new LayoutParams(-1, -1);
      this.addView(LayoutInflater.from(this.getContext()).inflate(R.layout.vast_player_container, (ViewGroup)null), var2);
      View var3 = this.findViewById(R.id.dummy_click_view);
      var3.setSoundEffectsEnabled(false);
      var3.setOnClickListener(this);
      this.setPlayerStatus(null.a);
      this.setPlayerProgress(null.a);
   }

   private void A() {
      com.noqoush.adfalcon.android.sdk.util.a.a("onCompleted");
      if (this.getVastControllerListener() != null) {
         this.getVastControllerListener().onComplete(this);
      }

      this.Q();
      this.a("complete");
      this.setPlayerStatus(null.f);
      this.setPlayerProgress(null.f);
      this.I();
   }

   private void B() {
      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("onFirstQuartile");
         if (this.getVastControllerListener() != null) {
            this.getVastControllerListener().onFirstQurtile(this);
         }

         this.a("firstQuartile");
         this.setPlayerProgress(null.c);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   private void C() {
      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("onMidPoint");
         if (this.getVastControllerListener() != null) {
            this.getVastControllerListener().onMidpoint(this);
         }

         this.a("midpoint");
         this.setPlayerProgress(null.d);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   private void D() {
      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("onStart");
         if (this.getVastControllerListener() != null) {
            this.getVastControllerListener().onStart(this);
         }

         this.p();
         this.getCurrentScene().b(this.getContext(), "creativeView");
         this.a("start");
         this.setPlayerProgress(null.b);
         this.J();
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);

         try {
            this.M();
         } catch (Exception var3) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         }
      }
   }

   private void E() {
      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("onThirdQuartile");
         if (this.getVastControllerListener() != null) {
            this.getVastControllerListener().onThirdQurtile(this);
         }

         this.a("thirdQuartile");
         this.setPlayerProgress(null.e);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   private boolean F() throws Exception {
      com.noqoush.adfalcon.android.sdk.util.a.a("playNextScene");
      if (this.j()) {
         this.setCurrentScene((r)this.getScenes().poll());
         this.m();
         return true;
      } else {
         return false;
      }
   }

   private boolean G() throws Exception {
      if (this.F()) {
         return true;
      } else {
         this.getTopContainer().a(true, true, -1);
         this.getBottomContainer().a(true, true, -1);
         return false;
      }
   }

   private void H() {
      this.s();
      this.w = 0;
      ArrayList var1 = this.j;
      if (var1 != null && var1.size() > 0) {
         Iterator var17 = this.j.iterator();

         while(var17.hasNext()) {
            ((d)var17.next()).b();
         }
      }

      if (this.getCurrentScene() != null && this.getCurrentScene().c() != null && this.getCurrentScene().c().length() > 30) {
         r var13 = this.getCurrentScene();
         StringBuilder var14 = new StringBuilder();
         var14.append(this.getCurrentScene().c().substring(0, 30));
         var14.append("...");
         var13.b(var14.toString());
      }

      this.v();

      try {
         this.t();
      } catch (Exception var21) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var21);
      }

      try {
         this.w();
      } catch (Exception var20) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var20);
      }

      try {
         this.x();
      } catch (Exception var19) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var19);
      }

      try {
         this.u();
      } catch (Exception var18) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var18);
      }

      Exception var10000;
      label120: {
         boolean var10001;
         try {
            this.j = new ArrayList();
            if (this.getBannerContainer() != null) {
               this.j.add(this.getBannerContainer());
            }
         } catch (Exception var28) {
            var10000 = var28;
            var10001 = false;
            break label120;
         }

         try {
            if (this.getEndCardContainer() != null) {
               this.j.add(this.getEndCardContainer());
            }
         } catch (Exception var27) {
            var10000 = var27;
            var10001 = false;
            break label120;
         }

         try {
            if (this.getTopContainer() != null) {
               this.j.add(this.getTopContainer());
            }
         } catch (Exception var26) {
            var10000 = var26;
            var10001 = false;
            break label120;
         }

         try {
            if (this.getBottomContainer() != null) {
               this.j.add(this.getBottomContainer());
            }
         } catch (Exception var25) {
            var10000 = var25;
            var10001 = false;
            break label120;
         }

         Iterator var7;
         try {
            this.setPlayerStatus(null.b);
            this.setPlayerProgress(null.a);
            var7 = this.j.iterator();
         } catch (Exception var23) {
            var10000 = var23;
            var10001 = false;
            break label120;
         }

         while(true) {
            try {
               if (!var7.hasNext()) {
                  break;
               }

               d var8 = (d)var7.next();
               var8.b();
               var8.a();
               var8.a(this.getCurrentScene());
            } catch (Exception var24) {
               var10000 = var24;
               var10001 = false;
               break label120;
            }
         }

         try {
            if (this.getDaaView() != null) {
               this.getDaaView().bringToFront();
               return;
            }

            return;
         } catch (Exception var22) {
            var10000 = var22;
            var10001 = false;
         }
      }

      Exception var6 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var6);
   }

   private void I() {
      Exception var10000;
      label93: {
         boolean var10001;
         Iterator var3;
         try {
            com.noqoush.adfalcon.android.sdk.util.a.a("display views of end");
            var3 = this.j.iterator();
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
            break label93;
         }

         while(true) {
            try {
               if (var3.hasNext()) {
                  ((d)var3.next()).a(this.getCurrentScene());
                  continue;
               }
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break;
            }

            label97: {
               label99: {
                  try {
                     this.getVideoPlayer().setBackgroundColor(-16777216);
                     if (this.getEndCardContainer() != null && this.getCurrentScene().k() != null) {
                        this.L();
                        if (this.getBannerContainer() != null) {
                           this.getBannerContainer().a(false, false, -1);
                        }
                        break label99;
                     }
                  } catch (Exception var10) {
                     var10000 = var10;
                     var10001 = false;
                     break;
                  }

                  try {
                     if (this.G()) {
                        return;
                     }
                  } catch (Exception var8) {
                     var10000 = var8;
                     var10001 = false;
                     break;
                  }

                  try {
                     if (this.getPlayerProgress() == null.f && this.getPlayerStatus() != null.e) {
                        break label97;
                     }
                  } catch (Exception var9) {
                     var10000 = var9;
                     var10001 = false;
                     break;
                  }

                  try {
                     this.y();
                     return;
                  } catch (Exception var5) {
                     var10000 = var5;
                     var10001 = false;
                     break;
                  }
               }

               try {
                  this.getBottomContainer().a(false, false, -1);
                  this.getEndCardContainer().a(true, true, -1);
                  this.getTopContainer().a(true, true, -1);
                  this.getVideoPlayer().setVisibility(8);
                  this.getCurrentScene().a(this.getCurrentScene().k(), this.getContext(), "creativeView");
               } catch (Exception var7) {
                  var10000 = var7;
                  var10001 = false;
                  break;
               }
            }

            try {
               this.getTopContainer().a(true, true, -1);
               this.getTopContainer().a(this.getCurrentScene());
               if (this.getDaaView() != null) {
                  this.getDaaView().bringToFront();
                  return;
               }

               return;
            } catch (Exception var6) {
               var10000 = var6;
               var10001 = false;
               break;
            }
         }
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
      if (this.getTopContainer() != null) {
         try {
            this.getTopContainer().a(true, true, -1);
            this.getTopContainer().a(this.getCurrentScene());
            return;
         } catch (Exception var4) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var4);
            this.y();
         }
      }

   }

   private void J() {
      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("display views of start");
         this.getTopContainer().a(true, true, 4);
         this.getBottomContainer().a(true, true, 4);
         if (this.getBannerContainer() != null) {
            this.getBannerContainer().a(true, true, 4);
            this.getCurrentScene().a(this.getCurrentScene().f(), this.getContext(), "creativeView");
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   private void K() {
      try {
         if (this.getVastActivity() != null) {
            if (this.getCurrentScene().o().a((Context)this.getVastActivity()).m()) {
               this.getVastActivity().setRequestedOrientation(6);
            } else {
               this.getVastActivity().setRequestedOrientation(1);
            }
         }
      } catch (Exception var2) {
         this.getVastActivity().setRequestedOrientation(6);
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   private void L() {
      try {
         if (this.j() || !this.j() && this.getCurrentScene().l() > 0) {
            this.P();
            Timer var2 = new Timer();
            this.v = var2;
            var2.scheduleAtFixedRate(new h$d(this), 100L, 1000L);
            return;
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }

   }

   private void M() {
      com.noqoush.adfalcon.android.sdk.util.a.a("stop");
      this.setPlayerStatus(null.f);

      try {
         this.getVideoPlayer().stopPlayback();
         this.getVideoPlayer().suspend();
      } catch (Exception var2) {
      }

      this.Q();
      this.P();
      if (!this.j() && this.getEndCardContainer() == null) {
         this.y();
      } else {
         this.I();
      }
   }

   private void N() {
      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("trackPlayer");
         this.Q();
         this.x = 0;
         Timer var2 = new Timer();
         this.r = var2;
         var2.scheduleAtFixedRate(new h$a(this), 100L, 500L);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   private void O() {
      Exception var10000;
      label41: {
         boolean var10001;
         try {
            com.noqoush.adfalcon.android.sdk.util.a.a("unMuteVolume");
            this.m = this.s.getStreamMaxVolume(3) / 2;
         } catch (Exception var6) {
            var10000 = var6;
            var10001 = false;
            break label41;
         }

         int var2 = 100;

         while(true) {
            try {
               if (this.s.getStreamVolume(3) >= this.m) {
                  break;
               }
            } catch (Exception var5) {
               var10000 = var5;
               var10001 = false;
               break label41;
            }

            --var2;
            if (var2 <= 0) {
               break;
            }

            try {
               this.s.adjustStreamVolume(3, 1, 0);
            } catch (Exception var4) {
               var10000 = var4;
               var10001 = false;
               break label41;
            }
         }

         try {
            this.n = this.m;
            this.setMuted(false);
            this.a("unmute");
            return;
         } catch (Exception var3) {
            var10000 = var3;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
   }

   private void P() {
      try {
         if (this.v != null) {
            this.v.cancel();
         }

         this.v = null;
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   private void Q() {
      try {
         if (this.r != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("untrackPlayer");
            this.r.cancel();
         }

         this.r = null;
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   // $FF: synthetic method
   static ArrayList a(h var0) {
      return var0.j;
   }

   private void a(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void a(h var0, int var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static void a(h var0, String var1) {
      var0.b(var1);
   }

   private void a(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("callLinearEventTrackers: ");
      var2.append(var1);
      com.noqoush.adfalcon.android.sdk.util.a.a(var2.toString());
      this.getCurrentScene().b(this.getContext(), var1);

      try {
         if (!var1.equalsIgnoreCase("creativeView")) {
            if (!var1.equalsIgnoreCase("start")) {
               if (!var1.equalsIgnoreCase("firstQuartile")) {
                  if (!var1.equalsIgnoreCase("midpoint")) {
                     if (!var1.equalsIgnoreCase("thirdQuartile")) {
                        if (!var1.equalsIgnoreCase("complete")) {
                           if (!var1.equalsIgnoreCase("mute")) {
                              if (!var1.equalsIgnoreCase("unmute")) {
                                 if (!var1.equalsIgnoreCase("pause")) {
                                    if (!var1.equalsIgnoreCase("rewind")) {
                                       if (!var1.equalsIgnoreCase("resume")) {
                                          if (!var1.equalsIgnoreCase("close")) {
                                             if (!var1.equalsIgnoreCase("skip")) {
                                                if (!var1.equalsIgnoreCase("closeLinear")) {
                                                   var1.equalsIgnoreCase("progress");
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } catch (Exception var6) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var6);
      }
   }

   private void a(boolean var1, boolean var2) {
      if (this.getCurrentScene().t() != null) {
         StringBuilder var3 = new StringBuilder();
         var3.append("callViewableImpressions:");
         var3.append(var1);
         var3.append(",");
         var3.append(var2);
         com.noqoush.adfalcon.android.sdk.util.a.a(var3.toString());
         this.getCurrentScene().a(this.getContext(), var1, var2);
         this.getCurrentScene().t().clear();
         Iterator var8 = this.getScenes().iterator();

         while(var8.hasNext()) {
            r var9 = (r)var8.next();
            if (var9.a() == this.getCurrentScene().a()) {
               var9.t().clear();
            }
         }

      }
   }

   // $FF: synthetic method
   static void b(h var0) {
      var0.A();
   }

   private void b(String var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("onFailed");
      this.setPlayerStatus(null.e);
      this.setPlayerProgress(null.a);
      this.a(false, true);
      if (this.getVastControllerListener() != null) {
         this.getVastControllerListener().onFailedToPlayAd(this);
      }

      label24: {
         try {
            this.Q();
            this.getCurrentScene().a(this.getContext(), var1);
         } catch (Exception var5) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var5);
            break label24;
         }

         try {
            this.getVideoPlayer().stopPlayback();
            this.getVideoPlayer().suspend();
         } catch (Exception var4) {
         }
      }

      if (!this.j() && this.getEndCardContainer() == null) {
         this.y();
      } else {
         this.I();
      }
   }

   // $FF: synthetic method
   static int c(h var0) {
      return var0.w;
   }

   // $FF: synthetic method
   static int d(h var0) {
      int var1 = var0.w++;
      return var1;
   }

   private void p() {
      com.noqoush.adfalcon.android.sdk.util.a.a("callImpressions");
      this.getCurrentScene().a(this.getContext());
      if (this.getCurrentScene().n() != null) {
         this.getCurrentScene().n().clear();
         Iterator var1 = this.getScenes().iterator();

         while(var1.hasNext()) {
            r var2 = (r)var1.next();
            if (var2.a() == this.getCurrentScene().a()) {
               var2.n().clear();
            }
         }

      }
   }

   private void q() {
      this.a("progress");
   }

   private void r() {
      Exception var10000;
      label48: {
         boolean var10001;
         int var2;
         try {
            var2 = this.s.getStreamVolume(3);
         } catch (Exception var7) {
            var10000 = var7;
            var10001 = false;
            break label48;
         }

         label39: {
            if (var2 == 0) {
               try {
                  if (!this.k()) {
                     com.noqoush.adfalcon.android.sdk.util.a.a("onTimeChanged->Mute");
                     this.setMuted(true);
                     this.a("mute");
                     this.getTopContainer().a(this.getCurrentScene());
                     break label39;
                  }
               } catch (Exception var6) {
                  var10000 = var6;
                  var10001 = false;
                  break label48;
               }
            }

            if (var2 > 0) {
               try {
                  if (this.k()) {
                     StringBuilder var3 = new StringBuilder();
                     var3.append("onTimeChanged->UNMute: ");
                     var3.append(var2);
                     com.noqoush.adfalcon.android.sdk.util.a.a(var3.toString());
                     this.setMuted(false);
                     this.a("unmute");
                     this.getTopContainer().a(this.getCurrentScene());
                  }
               } catch (Exception var5) {
                  var10000 = var5;
                  var10001 = false;
                  break label48;
               }
            }
         }

         try {
            if (this.n != var2) {
               this.n = var2;
               return;
            }

            return;
         } catch (Exception var4) {
            var10000 = var4;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
   }

   private void s() {
      com.noqoush.adfalcon.android.sdk.util.a.a("cleanVideoPlayer");

      try {
         this.Q();
         if (this.getVideoPlayer() != null) {
            this.getVideoPlayer().setOnPreparedListener((OnPreparedListener)null);
            this.getVideoPlayer().setOnErrorListener((OnErrorListener)null);
            this.getVideoPlayer().stopPlayback();
            this.setVideoPlayer((ViewabilityVideoView)null);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   private void t() throws Exception {
      if (this.getBannerContainer() != null) {
         this.removeView(this.getBannerContainer());
      }

      this.setBannerContainer((a)null);
      if (this.getCurrentScene().f() != null) {
         if (this.getCurrentScene().f().k() == null && this.getCurrentScene().f().i() == null && this.getCurrentScene().f().h() == null) {
            return;
         }

         int var1 = com.noqoush.adfalcon.android.sdk.g.c(this.getContext()).u();
         this.setBannerContainer(new a(this.getContext(), this));
         LayoutParams var2 = new LayoutParams(-2, -2);
         var2.addRule(11);
         var2.addRule(12);
         var2.setMargins(0, 0, 0, var1 / 6);
         this.addView(this.getBannerContainer(), var2);
      }

   }

   private void u() throws Exception {
      if (this.getBottomContainer() != null) {
         this.removeView(this.getBottomContainer());
      }

      this.setBottomContainer((b)null);
      this.setBottomContainer(new b(this.getContext(), this));
      LayoutParams var1 = new LayoutParams(-1, com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), 50));
      var1.addRule(12);
      this.addView(this.getBottomContainer(), var1);
   }

   private void v() {
      // $FF: Couldn't be decompiled
   }

   private void w() throws Exception {
      if (this.getEndCardContainer() != null) {
         this.removeView(this.getEndCardContainer());
      }

      this.setEndCardContainer((e)null);
      if (this.getCurrentScene().k() != null) {
         if (this.getCurrentScene().k().k() == null && this.getCurrentScene().k().i() == null && this.getCurrentScene().k().h() == null) {
            return;
         }

         this.setEndCardContainer(new e(this.getContext(), this));
         LayoutParams var1 = new LayoutParams(-1, -1);
         var1.addRule(13);
         this.addView(this.getEndCardContainer(), var1);
      }

   }

   private void x() throws Exception {
      if (this.getTopContainer() != null) {
         this.removeView(this.getTopContainer());
      }

      this.setTopContainer((f)null);
      this.setTopContainer(new f(this.getContext(), this, this));
      LayoutParams var1 = new LayoutParams(-1, com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), 40));
      var1.addRule(10);
      this.addView(this.getTopContainer(), var1);
   }

   private void y() {
      try {
         if (this.getVastActivity() != null) {
            this.getVastActivity().setRequestedOrientation(this.u);
            this.getVastActivity().finish();
            if (this.getVastControllerListener() != null) {
               this.getVastControllerListener().onDismissed(this);
               return;
            }
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   private void z() {
      Exception var10000;
      label41: {
         boolean var10001;
         try {
            com.noqoush.adfalcon.android.sdk.util.a.a("muteVolume");
            this.m = this.s.getStreamVolume(3);
         } catch (Exception var6) {
            var10000 = var6;
            var10001 = false;
            break label41;
         }

         int var2 = 100;

         while(true) {
            try {
               if (this.s.getStreamVolume(3) <= 0) {
                  break;
               }
            } catch (Exception var5) {
               var10000 = var5;
               var10001 = false;
               break label41;
            }

            --var2;
            if (var2 <= 0) {
               break;
            }

            try {
               this.s.adjustStreamVolume(3, -1, 0);
            } catch (Exception var4) {
               var10000 = var4;
               var10001 = false;
               break label41;
            }
         }

         try {
            this.n = 0;
            this.setMuted(true);
            this.a("mute");
            return;
         } catch (Exception var3) {
            var10000 = var3;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
   }

   public void a() {
      try {
         this.a("skip");
         this.M();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void a(com.noqoush.adfalcon.android.sdk.video.vast.model.b var1) {
   }

   public void a(com.noqoush.adfalcon.android.sdk.video.vast.model.b var1, i var2, m var3) {
      com.noqoush.adfalcon.android.sdk.util.a.a("onCompanionAdClicked");

      try {
         this.getCurrentScene().a(var1, this.getContext());
         if (this.getVastControllerListener() != null) {
            this.getVastControllerListener().onCompanionAdClicked(var1, this);
         }

         if (var2 == com.noqoush.adfalcon.android.sdk.urlactions.i.b && this.getVastControllerListener() != null) {
            this.getVastControllerListener().onApplicationLeft(this);
            return;
         }
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }

   }

   public void a(p var1) throws Exception {
      this.setVastResponse(var1);
      Queue var2 = com.noqoush.adfalcon.android.sdk.video.vast.model.r.a(this.getContext(), this.getVastResponse());
      AudioManager var3 = (AudioManager)this.getContext().getSystemService("audio");
      this.s = var3;
      this.m = var3.getStreamVolume(3);
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         r var5 = (r)var4.next();
         if (var5.f() != null) {
            try {
               var5.f().a((Context)this.getContext(), (RelativeLayout)null);
               var5.f().a((com.noqoush.adfalcon.android.sdk.video.vast.model.c)this);
            } catch (Exception var9) {
               var5.a((com.noqoush.adfalcon.android.sdk.video.vast.model.b)null);
            }
         }

         if (var5.k() != null) {
            try {
               var5.k().a((Context)this.getContext(), (RelativeLayout)null);
               var5.k().a((com.noqoush.adfalcon.android.sdk.video.vast.model.c)this);
            } catch (Exception var10) {
               var5.b((com.noqoush.adfalcon.android.sdk.video.vast.model.b)null);
            }
         }
      }

      this.setScenes(var2);
      this.setCurrentScene((r)this.getScenes().poll());
      this.K();
   }

   public void a(v var1) {
   }

   public void a(v var1, i var2, m var3) {
      com.noqoush.adfalcon.android.sdk.util.a.a("onVideoClicksClicked");

      try {
         this.getCurrentScene().b(this.getContext());
         if (var2 == com.noqoush.adfalcon.android.sdk.urlactions.i.b && this.getVastControllerListener() != null) {
            this.getVastControllerListener().onApplicationLeft(this);
            return;
         }
      } catch (Exception var5) {
      }

   }

   public void b() {
      this.P();
      this.o();
   }

   public void b(com.noqoush.adfalcon.android.sdk.video.vast.model.b var1) {
   }

   public void b(v var1) {
   }

   public void c() {
      this.P();
      this.w = -1;
   }

   public void d() {
      this.P();
      this.setPlayerStatus(null.f);

      try {
         if (!this.F()) {
            this.y();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void e() {
      if (this.getCurrentScene() != null) {
         this.getCurrentScene().f(0);
      }

      this.getTopContainer().a(true, true, 4);
      this.getBottomContainer().a(true, true, 4);
   }

   public void f() {
      this.O();
   }

   public void g() {
      this.a("closeLinear");
      this.M();
   }

   public a getBannerContainer() {
      return this.f;
   }

   public b getBottomContainer() {
      return this.i;
   }

   public String getContentVideoUrl() {
      return this.e;
   }

   public r getCurrentScene() {
      return this.d;
   }

   public z getDaaView() {
      return this.q;
   }

   public int getDuration() {
      // $FF: Couldn't be decompiled
   }

   public e getEndCardContainer() {
      return this.g;
   }

   public <undefinedtype> getPlayerProgress() {
      return this.p;
   }

   public <undefinedtype> getPlayerStatus() {
      return this.o;
   }

   public Queue getScenes() {
      return this.c;
   }

   public f getTopContainer() {
      return this.h;
   }

   public Activity getVastActivity() {
      return this.t;
   }

   public com.noqoush.adfalcon.android.sdk.video.vast.manager.f getVastControllerListener() {
      WeakReference var1 = this.k;
      return var1 == null ? null : (com.noqoush.adfalcon.android.sdk.video.vast.manager.f)var1.get();
   }

   public p getVastResponse() {
      return this.a;
   }

   public ViewabilityVideoView getVideoPlayer() throws Exception {
      if (this.b == null) {
         ViewabilityVideoView var1 = (ViewabilityVideoView)this.findViewById(R.id.vast_video_view);
         this.b = var1;
         var1.setBackgroundColor(-16777216);
         this.b.setOnPreparedListener(new h$b(this));
         this.b.setOnErrorListener(new h$c(this));
      }

      return this.b;
   }

   public void h() {
      this.z();
   }

   public void i() {
      com.noqoush.adfalcon.android.sdk.util.a.a("destroy");

      try {
         this.a(false, false);
         this.s();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   boolean j() {
      return this.getScenes() != null && this.getScenes().size() > 0;
   }

   public boolean k() {
      return this.l;
   }

   public void l() {
      com.noqoush.adfalcon.android.sdk.util.a.a("pause");

      try {
         this.getVideoPlayer().setBackgroundColor(-16777216);
         if (this.getCurrentScene().k() != null && this.getEndCardContainer() != null && this.getEndCardContainer().getVisibility() == 0) {
            this.getCurrentScene().k().p();
         }

         if (this.getCurrentScene().f() != null && this.getBannerContainer() != null && this.getBannerContainer().c()) {
            this.getCurrentScene().f().p();
         }

         this.P();
         this.Q();
         if (this.getPlayerStatus() == null.c) {
            this.a("pause");
            this.setPlayerStatus(null.d);
            this.getVideoPlayer().pause();
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void m() {
      this.H();

      Exception var10000;
      label71: {
         boolean var10001;
         label70: {
            label75: {
               n var3;
               try {
                  if (this.getCurrentScene().o() == null) {
                     break label75;
                  }

                  var3 = this.getCurrentScene().o().a(this.getContext());
               } catch (Exception var12) {
                  var10000 = var12;
                  var10001 = false;
                  break label71;
               }

               if (var3 != null) {
                  label54: {
                     try {
                        StringBuilder var4 = new StringBuilder();
                        var4.append("PlayVAST scene: ");
                        var4.append(var3.k());
                        com.noqoush.adfalcon.android.sdk.util.a.a(var4.toString());
                        this.getVideoPlayer().setVisibility(0);
                        this.getVideoPlayer().setVastScene(this.getCurrentScene());
                        if (com.noqoush.adfalcon.android.sdk.video.vast.manager.c.b(this.getContext(), var3.k())) {
                           this.setContentVideoUrl(com.noqoush.adfalcon.android.sdk.video.vast.manager.c.a(this.getContext(), var3.k()).getAbsolutePath());
                           this.getVideoPlayer().setVideoURI(Uri.parse(this.getContentVideoUrl()));
                           break label54;
                        }
                     } catch (Exception var8) {
                        var10000 = var8;
                        var10001 = false;
                        break label71;
                     }

                     try {
                        this.setContentVideoUrl(var3.k());
                        this.getVideoPlayer().setVideoPath(this.getContentVideoUrl());
                     } catch (Exception var7) {
                        var10000 = var7;
                        var10001 = false;
                        break label71;
                     }
                  }

                  try {
                     if (this.k()) {
                        this.z();
                     }
                  } catch (Exception var6) {
                     var10000 = var6;
                     var10001 = false;
                     break label71;
                  }

                  try {
                     this.getCurrentScene().d(0);
                     this.getVideoPlayer().setExpectedCuration(this.getCurrentScene().i());
                     this.getVideoPlayer().start();
                     this.N();
                     return;
                  } catch (Exception var5) {
                     var10000 = var5;
                     var10001 = false;
                     break label71;
                  }
               }

               try {
                  this.G();
                  break label70;
               } catch (Exception var11) {
                  var10000 = var11;
                  var10001 = false;
                  break label71;
               }
            }

            try {
               this.G();
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break label71;
            }
         }

         try {
            return;
         } catch (Exception var9) {
            var10000 = var9;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
      this.b("400");
   }

   public void n() {
      com.noqoush.adfalcon.android.sdk.util.a.a("resume");

      try {
         if (this.getCurrentScene() != null && this.getCurrentScene().k() != null && this.getEndCardContainer() != null && this.getEndCardContainer().getVisibility() == 0) {
            this.getCurrentScene().k().q();
         }

         if (this.getCurrentScene() != null && this.getCurrentScene().f() != null && this.getBannerContainer() != null && this.getBannerContainer().c()) {
            this.getCurrentScene().f().q();
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

      try {
         if (this.getEndCardContainer() != null && this.getCurrentScene().k() != null && this.getEndCardContainer().getVisibility() == 0 && this.w >= 0) {
            this.w += -1;
            this.L();
         }

         this.getVideoPlayer().setBackgroundColor(-16777216);
         if (this.getPlayerStatus() == null.d) {
            this.N();
            this.a("resume");
            this.getVideoPlayer().seekTo(1000 * this.getCurrentScene().j());
            this.getVideoPlayer().start();
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         this.b("400");
      }
   }

   public void o() {
      com.noqoush.adfalcon.android.sdk.util.a.a("rewind");

      try {
         if (this.getCurrentScene() != null) {
            this.getCurrentScene().f(0);
         }

         this.a("rewind");
         this.m();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void onClick(View param1) {
      // $FF: Couldn't be decompiled
   }

   public void setBannerContainer(a var1) {
      this.f = var1;
   }

   public void setBottomContainer(b var1) {
      this.i = var1;
   }

   public void setContentVideoUrl(String var1) {
      this.e = var1;
   }

   public void setCurrentScene(r var1) {
      this.d = var1;
   }

   public void setDaaView(z var1) {
      this.q = var1;
   }

   public void setEndCardContainer(e var1) {
      this.g = var1;
   }

   public void setMuted(boolean var1) {
      this.l = var1;
   }

   public void setPlayerProgress(Object var1) {
      this.p = var1;
   }

   public void setPlayerStatus(Object var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("State: ");
      var2.append(var1);
      com.noqoush.adfalcon.android.sdk.util.a.a(var2.toString());
      this.o = var1;
   }

   public void setScenes(Queue var1) {
      this.c = var1;
   }

   public void setTopContainer(f var1) {
      this.h = var1;
   }

   public void setVastActivity(Activity var1) {
      try {
         this.t = var1;
         if (this.getVastControllerListener() != null) {
            this.getVastControllerListener().onPresented(this);
         }

         this.u = var1.getRequestedOrientation();
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public void setVastControllerListener(com.noqoush.adfalcon.android.sdk.video.vast.manager.f var1) {
      this.k = new WeakReference(var1);
   }

   public void setVastResponse(p var1) {
      this.a = var1;
   }

   public void setVideoPlayer(ViewabilityVideoView var1) {
      this.b = var1;
   }
}
