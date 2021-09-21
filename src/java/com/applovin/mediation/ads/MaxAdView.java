package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.sdk.utils.q;
import com.applovin.impl.sdk.utils.r;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;

public class MaxAdView extends RelativeLayout {
   private MaxAdViewImpl a;
   private View b;
   private int c;

   public MaxAdView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public MaxAdView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      String var4 = var2.getAttributeValue("http://schemas.applovin.com/android/1.0", "adUnitId");
      int var5 = var2.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
      if (var4 != null) {
         if (!TextUtils.isEmpty(var4)) {
            if (var1 instanceof Activity) {
               Activity var6 = (Activity)var1;
               this.a(var4, var5, AppLovinSdk.getInstance(var6), var6);
            } else {
               throw new IllegalArgumentException("Max ad view context is not an activity");
            }
         } else {
            throw new IllegalArgumentException("Empty ad unit ID specified");
         }
      } else {
         throw new IllegalArgumentException("No ad unit ID specified");
      }
   }

   public MaxAdView(String var1, Activity var2) {
      this(var1, AppLovinSdk.getInstance(var2), var2);
   }

   public MaxAdView(String var1, AppLovinSdk var2, Activity var3) {
      super(var3);
      this.a(var1, 49, var2, var3);
   }

   private void a(Context var1) {
      DisplayMetrics var2 = var1.getResources().getDisplayMetrics();
      int var3 = var2.widthPixels;
      int var4 = (int)TypedValue.applyDimension(1, 50.0F, var2);
      TextView var5 = new TextView(var1);
      var5.setBackgroundColor(Color.rgb(220, 220, 220));
      var5.setTextColor(-16777216);
      var5.setText("AppLovin MAX Ad");
      var5.setGravity(17);
      this.addView(var5, var3, var4);
   }

   private void a(String var1, int var2, AppLovinSdk var3, Activity var4) {
      if (!this.isInEditMode()) {
         this.b = new View(var4);
         this.b.setBackgroundColor(0);
         this.addView(this.b);
         this.b.setLayoutParams(new LayoutParams(-1, -1));
         this.c = this.getVisibility();
         MaxAdViewImpl var5 = new MaxAdViewImpl(var1, this, this.b, q.a(var3), var4);
         this.a = var5;
         this.setGravity(var2);
         if (this.getBackground() instanceof ColorDrawable) {
            this.setBackgroundColor(((ColorDrawable)this.getBackground()).getColor());
         }

         super.setBackgroundColor(0);
      } else {
         this.a(var4);
      }
   }

   public void destroy() {
      this.a.destroy();
   }

   public String getPlacement() {
      return this.a.getPlacement();
   }

   public void loadAd() {
      this.a.loadAd();
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      if (this.a != null && r.a(this.c, var1)) {
         this.a.onWindowVisibilityChanged(var1);
      }

      this.c = var1;
   }

   public void setAlpha(float var1) {
      View var2 = this.b;
      if (var2 != null) {
         var2.setAlpha(var1);
      }

   }

   public void setBackgroundColor(int var1) {
      MaxAdViewImpl var2 = this.a;
      if (var2 != null) {
         var2.setPublisherBackgroundColor(var1);
      }

      View var3 = this.b;
      if (var3 != null) {
         var3.setBackgroundColor(var1);
      }

   }

   public void setExtraParameter(String var1, String var2) {
      this.a.setExtraParameter(var1, var2);
   }

   public void setListener(MaxAdViewAdListener var1) {
      this.a.setListener(var1);
   }

   public void setPlacement(String var1) {
      this.a.setPlacement(var1);
   }

   public void startAutoRefresh() {
      this.a.startAutoRefresh();
   }

   public void stopAutoRefresh() {
      this.a.stopAutoRefresh();
   }

   public String toString() {
      MaxAdViewImpl var1 = this.a;
      return var1 != null ? var1.toString() : "MaxAdView";
   }
}
