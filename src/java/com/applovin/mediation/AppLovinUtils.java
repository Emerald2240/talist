package com.applovin.mediation;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.Iterator;

public class AppLovinUtils {
   private static final String DEFAULT_ZONE = "";

   public static boolean androidManifestHasValidSdkKey(Context var0) {
      Bundle var1 = retrieveMetadata(var0);
      return var1 != null ? true ^ TextUtils.isEmpty(var1.getString("applovin.sdk.key")) : false;
   }

   public static AppLovinAdSize appLovinAdSizeFromAdMobAdSize(Context var0, AdSize var1) {
      ArrayList var2 = new ArrayList(3);
      var2.add(0, AdSize.BANNER);
      var2.add(1, AdSize.LEADERBOARD);
      var2.add(2, AdSize.MEDIUM_RECTANGLE);
      AdSize var3 = findClosestSize(var0, var1, var2);
      if (var3 == null) {
         return null;
      } else if (AdSize.BANNER.equals(var3)) {
         return AppLovinAdSize.BANNER;
      } else if (AdSize.MEDIUM_RECTANGLE.equals(var3)) {
         return AppLovinAdSize.MREC;
      } else {
         return AdSize.LEADERBOARD.equals(var3) ? AppLovinAdSize.LEADER : null;
      }
   }

   public static AdSize findClosestSize(Context var0, AdSize var1, ArrayList var2) {
      if (var2 != null && var1 != null) {
         float var3 = var0.getResources().getDisplayMetrics().density;
         AdSize var4 = new AdSize(Math.round((float)var1.getWidthInPixels(var0) / var3), Math.round((float)var1.getHeightInPixels(var0) / var3));
         AdSize var5 = null;
         Iterator var6 = var2.iterator();

         while(var6.hasNext()) {
            AdSize var7 = (AdSize)var6.next();
            if (isSizeInRange(var4, var7)) {
               if (var5 == null) {
                  var5 = var7;
               } else {
                  var5 = getLargerByArea(var5, var7);
               }
            }
         }

         return var5;
      } else {
         return null;
      }
   }

   private static AdSize getLargerByArea(AdSize var0, AdSize var1) {
      return var0.getWidth() * var0.getHeight() > var1.getWidth() * var1.getHeight() ? var0 : var1;
   }

   private static boolean isSizeInRange(AdSize var0, AdSize var1) {
      if (var1 == null) {
         return false;
      } else {
         int var2 = var0.getWidth();
         int var3 = var1.getWidth();
         int var4 = var0.getHeight();
         int var5 = var1.getHeight();
         double var6 = (double)var2;
         Double.isNaN(var6);
         if (var6 * 0.5D <= (double)var3) {
            if (var2 < var3) {
               return false;
            } else {
               double var9 = (double)var4;
               Double.isNaN(var9);
               if (var9 * 0.7D <= (double)var5) {
                  return var4 >= var5;
               } else {
                  return false;
               }
            }
         } else {
            return false;
         }
      }
   }

   private static Bundle retrieveMetadata(Context var0) {
      try {
         Bundle var2 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128).metaData;
         return var2;
      } catch (NameNotFoundException var3) {
         return null;
      }
   }

   public static AppLovinSdk retrieveSdk(Bundle var0, Context var1) {
      String var2;
      if (var0 != null) {
         var2 = var0.getString("sdkKey");
      } else {
         var2 = null;
      }

      AppLovinSdk var3;
      if (!TextUtils.isEmpty(var2)) {
         var3 = AppLovinSdk.getInstance(var2, new AppLovinSdkSettings(), var1);
      } else {
         var3 = AppLovinSdk.getInstance(var1);
      }

      var3.setPluginVersion("9.11.4.0");
      var3.setMediationProvider("admob");
      return var3;
   }

   public static String retrieveZoneId(Bundle var0) {
      return var0.containsKey("zone_id") ? var0.getString("zone_id") : "";
   }

   public static boolean shouldMuteAudio(Bundle var0) {
      return var0 != null && var0.getBoolean("mute_audio");
   }

   public static int toAdMobErrorCode(int var0) {
      if (var0 == 204) {
         return 3;
      } else {
         return var0 == -102 ? 2 : 0;
      }
   }

   private static class ServerParameterKeys {
      private static final String SDK_KEY = "sdkKey";
      private static final String ZONE_ID = "zone_id";
   }
}
