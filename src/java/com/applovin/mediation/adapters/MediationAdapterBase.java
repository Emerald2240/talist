package com.applovin.mediation.adapters;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinSdk;

public abstract class MediationAdapterBase implements MaxAdapter {
   private boolean alwaysRewardUser;
   private final p mLogger;
   private final j mSdk;
   private final String mTag;
   private final AppLovinSdk mWrappingSdk;
   private MaxReward reward;

   public MediationAdapterBase(AppLovinSdk var1) {
      this.mWrappingSdk = var1;
      this.mSdk = q.a(var1);
      this.mLogger = this.mSdk.v();
      this.mTag = this.getClass().getSimpleName();
   }

   protected static String mediationTag() {
      StringBuilder var0 = new StringBuilder();
      var0.append("AppLovinSdk_");
      var0.append(AppLovinSdk.VERSION);
      return var0.toString();
   }

   protected void checkActivities(Context var1, Class... var2) {
   }

   protected void checkExistence(Class... var1) {
      if (var1 != null && var1.length > 0) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            Class var4 = var1[var3];
            StringBuilder var5 = new StringBuilder();
            var5.append("Found: ");
            var5.append(var4.getName());
            this.log(var5.toString());
         }
      }

   }

   protected void configureReward(MaxAdapterResponseParameters var1) {
      Bundle var2 = var1.getServerParameters();
      this.alwaysRewardUser = BundleUtils.getBoolean("always_reward_user", var1.isTesting(), var2);
      int var3 = BundleUtils.getInt("amount", 0, var2);
      String var4 = BundleUtils.getString("currency", "", var2);
      StringBuilder var5 = new StringBuilder();
      var5.append("Creating reward: ");
      var5.append(var3);
      var5.append(" ");
      var5.append(var4);
      this.log(var5.toString());
      this.reward = MaxReward.create(var3, var4);
   }

   protected void d(String var1) {
      this.mLogger.b(this.mTag, var1);
   }

   protected void e(String var1) {
      this.mLogger.e(this.mTag, var1);
   }

   protected void e(String var1, Throwable var2) {
      this.mLogger.b(this.mTag, var1, var2);
   }

   protected MaxReward getReward() {
      MaxReward var1 = this.reward;
      return var1 != null ? var1 : MaxReward.createDefault();
   }

   String getVersionString(Class var1, String var2) {
      String var3 = q.b(var1, var2);
      if (var3 == null) {
         this.log("Failed to retrieve version string.");
      }

      return var3;
   }

   protected AppLovinSdk getWrappingSdk() {
      return this.mWrappingSdk;
   }

   protected void i(String var1) {
      this.mLogger.c(this.mTag, var1);
   }

   protected void log(String var1) {
      this.mLogger.c(this.mTag, var1);
   }

   protected void log(String var1, Throwable var2) {
      this.mLogger.b(this.mTag, var1, var2);
   }

   protected boolean shouldAlwaysRewardUser() {
      return this.alwaysRewardUser;
   }

   protected void w(String var1) {
      this.mLogger.d(this.mTag, var1);
   }
}
