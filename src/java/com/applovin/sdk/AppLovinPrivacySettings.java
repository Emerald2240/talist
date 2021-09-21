package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.g;

public class AppLovinPrivacySettings {
   public static boolean hasUserConsent(Context var0) {
      Boolean var1 = g.a(var0);
      return var1 != null ? var1 : false;
   }

   public static boolean isAgeRestrictedUser(Context var0) {
      Boolean var1 = g.b(var0);
      return var1 != null ? var1 : false;
   }

   public static boolean isDoNotSell(Context var0) {
      Boolean var1 = g.c(var0);
      return var1 != null ? var1 : false;
   }

   public static void setDoNotSell(boolean var0, Context var1) {
      if (g.c(var0, var1)) {
         AppLovinSdk.reinitializeAll((Boolean)null, var0);
      }

   }

   public static void setHasUserConsent(boolean var0, Context var1) {
      if (g.a(var0, var1)) {
         AppLovinSdk.reinitializeAll(var0, (Boolean)null);
      }

   }

   public static void setIsAgeRestrictedUser(boolean var0, Context var1) {
      if (g.b(var0, var1)) {
         AppLovinSdk.reinitializeAll();
      }

   }
}
