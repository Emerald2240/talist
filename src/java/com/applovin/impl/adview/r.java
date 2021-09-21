package com.applovin.impl.adview;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class r extends m {
   private final Set a = new HashSet();

   private void a() {
      if (this.isFullyWatched() && !this.a.isEmpty()) {
         com.applovin.impl.sdk.p var1 = this.logger;
         StringBuilder var2 = new StringBuilder();
         var2.append("Firing ");
         var2.append(this.a.size());
         var2.append(" un-fired video progress trackers when video was completed.");
         var1.d("InterstitialActivity", var2.toString());
         this.a(this.a);
      }

   }

   private void a(com.applovin.impl.a.a.c var1) {
      this.a(var1, com.applovin.impl.a.d.a);
   }

   private void a(com.applovin.impl.a.a.c var1, com.applovin.impl.a.d var2) {
      this.a(var1, "", var2);
   }

   private void a(com.applovin.impl.a.a.c var1, String var2) {
      this.a(var1, var2, com.applovin.impl.a.d.a);
   }

   private void a(com.applovin.impl.a.a.c var1, String var2, com.applovin.impl.a.d var3) {
      if (this.isVastAd()) {
         this.a(((com.applovin.impl.a.a)this.currentAd).a(var1, var2), var3);
      }

   }

   private void a(Set var1) {
      this.a(var1, com.applovin.impl.a.d.a);
   }

   private void a(Set var1, com.applovin.impl.a.d var2) {
      if (this.isVastAd() && var1 != null && !var1.isEmpty()) {
         long var3 = TimeUnit.MILLISECONDS.toSeconds((long)this.videoView.getCurrentPosition());
         com.applovin.impl.a.k var5 = this.b().i();
         Uri var6;
         if (var5 != null) {
            var6 = var5.a();
         } else {
            var6 = null;
         }

         com.applovin.impl.sdk.p var8 = this.logger;
         StringBuilder var9 = new StringBuilder();
         var9.append("Firing ");
         var9.append(var1.size());
         var9.append(" tracker(s): ");
         var9.append(var1);
         var8.b("InterstitialActivity", var9.toString());
         com.applovin.impl.a.i.a(var1, var3, var6, var2, this.sdk);
      }

   }

   private com.applovin.impl.a.a b() {
      return this.currentAd instanceof com.applovin.impl.a.a ? (com.applovin.impl.a.a)this.currentAd : null;
   }

   public void clickThroughFromVideo(PointF var1) {
      super.clickThroughFromVideo(var1);
      this.a(com.applovin.impl.a.a.c.b);
   }

   public void dismiss() {
      if (this.isVastAd()) {
         this.a(com.applovin.impl.a.a.c.d, "close");
         this.a(com.applovin.impl.a.a.c.e, "close");
      }

      super.dismiss();
   }

   public void handleCountdownStep() {
      if (this.isVastAd()) {
         long var1 = TimeUnit.MILLISECONDS.toSeconds((long)(this.videoView.getDuration() - this.videoView.getCurrentPosition()));
         long var3 = (long)this.computedLengthSeconds - var1;
         HashSet var5 = new HashSet();
         Iterator var6 = (new HashSet(this.a)).iterator();

         while(var6.hasNext()) {
            com.applovin.impl.a.g var7 = (com.applovin.impl.a.g)var6.next();
            if (var7.a(var3, this.getVideoPercentViewed())) {
               var5.add(var7);
               this.a.remove(var7);
            }
         }

         this.a((Set)var5);
      }

   }

   public void handleMediaError(String var1) {
      this.a(com.applovin.impl.a.a.c.f, com.applovin.impl.a.d.j);
      super.handleMediaError(var1);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (this.isVastAd()) {
         Set var2 = this.b().a(com.applovin.impl.a.a.c.d, com.applovin.impl.a.h.a);
         this.a.addAll(var2);
         this.a(com.applovin.impl.a.a.c.a);
         this.a(com.applovin.impl.a.a.c.d, "creativeView");
      }

   }

   protected void onPause() {
      super.onPause();
      com.applovin.impl.a.a.c var1;
      if (this.postitialWasDisplayed) {
         var1 = com.applovin.impl.a.a.c.e;
      } else {
         var1 = com.applovin.impl.a.a.c.d;
      }

      this.a(var1, "pause");
   }

   protected void onResume() {
      super.onResume();
      com.applovin.impl.a.a.c var1;
      if (this.postitialWasDisplayed) {
         var1 = com.applovin.impl.a.a.c.e;
      } else {
         var1 = com.applovin.impl.a.a.c.d;
      }

      this.a(var1, "resume");
   }

   public void playVideo() {
      this.countdownManager.a("PROGRESS_TRACKING", (Long)this.sdk.a(com.applovin.impl.sdk.b.d.eK), new r$1(this));
      super.playVideo();
   }

   public void showPostitial() {
      if (this.isVastAd()) {
         this.a();
         if (!com.applovin.impl.a.i.c(this.b())) {
            this.dismiss();
            return;
         }

         if (this.postitialWasDisplayed) {
            return;
         }

         this.a(com.applovin.impl.a.a.c.e, "creativeView");
      }

      super.showPostitial();
   }

   public void skipVideo() {
      this.a(com.applovin.impl.a.a.c.d, "skip");
      super.skipVideo();
   }

   public void toggleMute() {
      super.toggleMute();
      com.applovin.impl.a.a.c var1 = com.applovin.impl.a.a.c.d;
      String var2;
      if (this.videoMuted) {
         var2 = "mute";
      } else {
         var2 = "unmute";
      }

      this.a(var1, var2);
   }
}
