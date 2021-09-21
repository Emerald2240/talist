package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MaxRewardedAd implements <undefinedtype> {
   private static final Map a = new HashMap();
   private static final Object b = new Object();
   private static WeakReference c = new WeakReference((Object)null);
   private final MaxFullscreenAdImpl d;

   private MaxRewardedAd(String var1, AppLovinSdk var2) {
      MaxFullscreenAdImpl var3 = new MaxFullscreenAdImpl(var1, MaxAdFormat.REWARDED, this, "MaxRewardedAd", q.a(var2));
      this.d = var3;
   }

   public static MaxRewardedAd getInstance(String var0, Activity var1) {
      return getInstance(var0, AppLovinSdk.getInstance(var1), var1);
   }

   public static MaxRewardedAd getInstance(String var0, AppLovinSdk var1, Activity var2) {
      if (var0 == null) {
         throw new IllegalArgumentException("No ad unit ID specified");
      } else if (!TextUtils.isEmpty(var0)) {
         if (var2 == null) {
            throw new IllegalArgumentException("No activity specified");
         } else if (var1 != null) {
            updateActivity(var2);
            Object var3 = b;
            synchronized(var3){}

            boolean var10001;
            Throwable var10000;
            label246: {
               MaxRewardedAd var5;
               try {
                  var5 = (MaxRewardedAd)a.get(var0);
               } catch (Throwable var28) {
                  var10000 = var28;
                  var10001 = false;
                  break label246;
               }

               if (var5 != null) {
                  label240:
                  try {
                     return var5;
                  } catch (Throwable var26) {
                     var10000 = var26;
                     var10001 = false;
                     break label240;
                  }
               } else {
                  label242:
                  try {
                     MaxRewardedAd var6 = new MaxRewardedAd(var0, var1);
                     a.put(var0, var6);
                     return var6;
                  } catch (Throwable var27) {
                     var10000 = var27;
                     var10001 = false;
                     break label242;
                  }
               }
            }

            while(true) {
               Throwable var4 = var10000;

               try {
                  throw var4;
               } catch (Throwable var25) {
                  var10000 = var25;
                  var10001 = false;
                  continue;
               }
            }
         } else {
            throw new IllegalArgumentException("No sdk specified");
         }
      } else {
         throw new IllegalArgumentException("Empty ad unit ID specified");
      }
   }

   public static void updateActivity(Activity var0) {
      if (var0 != null) {
         c = new WeakReference(var0);
      }

   }

   public void destroy() {
      // $FF: Couldn't be decompiled
   }

   public Activity getActivity() {
      return (Activity)c.get();
   }

   public boolean isReady() {
      return this.d.isReady();
   }

   public void loadAd() {
      this.d.loadAd(this.getActivity());
   }

   public void setExtraParameter(String var1, String var2) {
      this.d.setExtraParameter(var1, var2);
   }

   public void setListener(MaxRewardedAdListener var1) {
      this.d.setListener(var1);
   }

   public void showAd() {
      this.showAd((String)null);
   }

   public void showAd(String var1) {
      this.d.showAd(var1, this.getActivity());
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("");
      var1.append(this.d);
      return var1.toString();
   }
}
