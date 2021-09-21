package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinAdView extends RelativeLayout {
   public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";
   private AdViewController a;

   public AppLovinAdView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public AppLovinAdView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a((AppLovinAdSize)null, (String)null, (AppLovinSdk)null, var1, var2);
   }

   public AppLovinAdView(AppLovinAdSize var1, Context var2) {
      this((AppLovinAdSize)var1, (String)null, var2);
   }

   public AppLovinAdView(AppLovinAdSize var1, String var2, Context var3) {
      super(var3);
      this.a(var1, var2, (AppLovinSdk)null, var3, (AttributeSet)null);
   }

   public AppLovinAdView(AppLovinSdk var1, AppLovinAdSize var2, Context var3) {
      this(var1, var2, (String)null, var3);
   }

   public AppLovinAdView(AppLovinSdk var1, AppLovinAdSize var2, String var3, Context var4) {
      super(var4);
      this.a(var2, var3, var1, var4, (AttributeSet)null);
   }

   private void a(AttributeSet var1, Context var2) {
      DisplayMetrics var3 = var2.getResources().getDisplayMetrics();
      int var4 = var3.widthPixels;
      int var5 = (int)TypedValue.applyDimension(1, 50.0F, var3);
      TextView var6 = new TextView(var2);
      var6.setBackgroundColor(Color.rgb(220, 220, 220));
      var6.setTextColor(-16777216);
      var6.setText("AppLovin Ad");
      var6.setGravity(17);
      this.addView(var6, var4, var5);
   }

   private void a(AppLovinAdSize var1, String var2, AppLovinSdk var3, Context var4, AttributeSet var5) {
      if (!this.isInEditMode()) {
         AdViewControllerImpl var6 = new AdViewControllerImpl();
         var6.initializeAdView(this, var4, var1, var2, var3, var5);
         this.a = var6;
      } else {
         this.a(var5, var4);
      }
   }

   public void destroy() {
      AdViewController var1 = this.a;
      if (var1 != null) {
         var1.destroy();
      }

   }

   @Deprecated
   public AdViewController getAdViewController() {
      return this.a;
   }

   public AppLovinAdSize getSize() {
      AdViewController var1 = this.a;
      return var1 != null ? var1.getSize() : null;
   }

   public String getZoneId() {
      AdViewController var1 = this.a;
      return var1 != null ? var1.getZoneId() : null;
   }

   @Deprecated
   public boolean isAdReadyToDisplay() {
      AdViewController var1 = this.a;
      return var1 != null && var1.isAdReadyToDisplay();
   }

   public void loadNextAd() {
      AdViewController var1 = this.a;
      if (var1 != null) {
         var1.loadNextAd();
      } else {
         p.h("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
      }
   }

   protected void onDetachedFromWindow() {
      AdViewController var1 = this.a;
      if (var1 != null) {
         var1.onDetachedFromWindow();
      }

      super.onDetachedFromWindow();
   }

   protected void onVisibilityChanged(View var1, int var2) {
      super.onVisibilityChanged(var1, var2);
      AdViewController var3 = this.a;
      if (var3 != null) {
         var3.onVisibilityChanged(var2);
      }

   }

   public void pause() {
      AdViewController var1 = this.a;
      if (var1 != null) {
         var1.pause();
      }

   }

   public void renderAd(AppLovinAd var1) {
      this.renderAd(var1, (String)null);
   }

   @Deprecated
   public void renderAd(AppLovinAd var1, String var2) {
      AdViewController var3 = this.a;
      if (var3 != null) {
         var3.renderAd(var1, var2);
      }

   }

   public void resume() {
      AdViewController var1 = this.a;
      if (var1 != null) {
         var1.resume();
      }

   }

   public void setAdClickListener(AppLovinAdClickListener var1) {
      AdViewController var2 = this.a;
      if (var2 != null) {
         var2.setAdClickListener(var1);
      }

   }

   public void setAdDisplayListener(AppLovinAdDisplayListener var1) {
      AdViewController var2 = this.a;
      if (var2 != null) {
         var2.setAdDisplayListener(var1);
      }

   }

   public void setAdLoadListener(AppLovinAdLoadListener var1) {
      AdViewController var2 = this.a;
      if (var2 != null) {
         var2.setAdLoadListener(var1);
      }

   }

   @Deprecated
   public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener var1) {
      AdViewController var2 = this.a;
      if (var2 != null) {
         var2.setAdVideoPlaybackListener(var1);
      }

   }

   public void setAdViewEventListener(AppLovinAdViewEventListener var1) {
      AdViewController var2 = this.a;
      if (var2 != null) {
         var2.setAdViewEventListener(var1);
      }

   }

   public void setAutoDestroy(boolean var1) {
      AdViewController var2 = this.a;
      if (var2 != null) {
         var2.setAutoDestroy(var1);
      }

   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinAdView{zoneId='");
      var1.append(this.getZoneId());
      var1.append("', size=");
      var1.append(this.getSize());
      var1.append('}');
      return var1.toString();
   }
}
