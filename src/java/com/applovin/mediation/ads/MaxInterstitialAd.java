package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class MaxInterstitialAd implements <undefinedtype> {
   private static WeakReference a = new WeakReference((Object)null);
   private final MaxFullscreenAdImpl b;

   public MaxInterstitialAd(String var1, Activity var2) {
      this(var1, AppLovinSdk.getInstance(var2), var2);
   }

   public MaxInterstitialAd(String var1, AppLovinSdk var2, Activity var3) {
      if (var1 != null) {
         if (!TextUtils.isEmpty(var1)) {
            if (var3 != null) {
               if (var2 != null) {
                  a = new WeakReference(var3);
                  MaxFullscreenAdImpl var4 = new MaxFullscreenAdImpl(var1, MaxAdFormat.INTERSTITIAL, this, "MaxInterstitialAd", q.a(var2));
                  this.b = var4;
               } else {
                  throw new IllegalArgumentException("No sdk specified");
               }
            } else {
               throw new IllegalArgumentException("No activity specified");
            }
         } else {
            throw new IllegalArgumentException("Empty ad unit ID specified");
         }
      } else {
         throw new IllegalArgumentException("No ad unit ID specified");
      }
   }

   public void destroy() {
      this.b.destroy();
   }

   public Activity getActivity() {
      return (Activity)a.get();
   }

   public boolean isReady() {
      return this.b.isReady();
   }

   public void loadAd() {
      this.b.loadAd(this.getActivity());
   }

   public void setExtraParameter(String var1, String var2) {
      this.b.setExtraParameter(var1, var2);
   }

   public void setListener(MaxAdListener var1) {
      this.b.setListener(var1);
   }

   public void showAd() {
      this.showAd((String)null);
   }

   public void showAd(String var1) {
      this.b.showAd(var1, this.getActivity());
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("");
      var1.append(this.b);
      return var1.toString();
   }
}
