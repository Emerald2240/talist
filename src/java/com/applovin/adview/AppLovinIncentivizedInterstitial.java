package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.a.a;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.Iterator;

public class AppLovinIncentivizedInterstitial {
   private final a a;

   public AppLovinIncentivizedInterstitial(Context var1) {
      this(AppLovinSdk.getInstance(var1));
   }

   public AppLovinIncentivizedInterstitial(AppLovinSdk var1) {
      this((String)null, var1);
   }

   public AppLovinIncentivizedInterstitial(String var1, AppLovinSdk var2) {
      if (var2 != null) {
         this.a = this.createIncentivizedAdController(var1, var2);
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   public static AppLovinIncentivizedInterstitial create(Context var0) {
      return create(AppLovinSdk.getInstance(var0));
   }

   public static AppLovinIncentivizedInterstitial create(AppLovinSdk var0) {
      return create((String)null, var0);
   }

   public static AppLovinIncentivizedInterstitial create(String var0, AppLovinSdk var1) {
      return new AppLovinIncentivizedInterstitial(var0, var1);
   }

   protected a createIncentivizedAdController(String var1, AppLovinSdk var2) {
      return new a(var1, var2);
   }

   @Deprecated
   public void dismiss() {
      this.a.c();
   }

   public String getUserIdentifier() {
      p.j("AppLovinIncentivizedInterstitial", "Please use AppLovinSdk.getUserIdentifier() instead to properly identify your users in our system. This property is now deprecated and will be removed in a future SDK version.");
      return ((AppLovinSdk)AppLovinSdk.a().get(0)).getUserIdentifier();
   }

   public String getZoneId() {
      return this.a.b();
   }

   public boolean isAdReadyToDisplay() {
      return this.a.a();
   }

   public void preload(AppLovinAdLoadListener var1) {
      if (var1 == null) {
         p.h("AppLovinIncentivizedInterstitial", "AppLovinAdLoadListener was null when preloading incentivized interstitials; using a listener is highly recommended.");
      }

      this.a.a(var1);
   }

   public void setUserIdentifier(String var1) {
      Iterator var2 = AppLovinSdk.a().iterator();

      while(var2.hasNext()) {
         ((AppLovinSdk)var2.next()).setUserIdentifier(var1);
      }

      StringBuilder var3 = new StringBuilder();
      var3.append("Please use AppLovinSdk.setUserIdentifier(\"");
      var3.append(var1);
      var3.append("\") instead to properly identify your users in our system. This property is now deprecated and will be removed in a future SDK version.");
      p.j("AppLovinIncentivizedInterstitial", var3.toString());
   }

   public void show(Context var1) {
      this.show(var1, (AppLovinAdRewardListener)null, (AppLovinAdVideoPlaybackListener)null);
   }

   public void show(Context var1, AppLovinAdRewardListener var2) {
      this.show(var1, var2, (AppLovinAdVideoPlaybackListener)null);
   }

   public void show(Context var1, AppLovinAdRewardListener var2, AppLovinAdVideoPlaybackListener var3) {
      this.show(var1, var2, var3, (AppLovinAdDisplayListener)null);
   }

   public void show(Context var1, AppLovinAdRewardListener var2, AppLovinAdVideoPlaybackListener var3, AppLovinAdDisplayListener var4) {
      this.show(var1, var2, var3, var4, (AppLovinAdClickListener)null);
   }

   public void show(Context var1, AppLovinAdRewardListener var2, AppLovinAdVideoPlaybackListener var3, AppLovinAdDisplayListener var4, AppLovinAdClickListener var5) {
      this.show((Context)var1, (String)null, var2, var3, var4, var5);
   }

   @Deprecated
   public void show(Context var1, String var2, AppLovinAdRewardListener var3, AppLovinAdVideoPlaybackListener var4, AppLovinAdDisplayListener var5, AppLovinAdClickListener var6) {
      this.a.a((AppLovinAd)null, var1, "", var3, var4, var5, var6);
   }

   public void show(AppLovinAd var1, Context var2, AppLovinAdRewardListener var3, AppLovinAdVideoPlaybackListener var4, AppLovinAdDisplayListener var5, AppLovinAdClickListener var6) {
      this.a.a(var1, var2, (String)null, var3, var4, var5, var6);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinIncentivizedInterstitial{zoneId='");
      var1.append(this.getZoneId());
      var1.append("', isAdReadyToDisplay=");
      var1.append(this.isAdReadyToDisplay());
      var1.append('}');
      return var1.toString();
   }
}
