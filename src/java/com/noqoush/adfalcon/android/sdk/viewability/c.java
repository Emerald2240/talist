package com.noqoush.adfalcon.android.sdk.viewability;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.noqoush.adfalcon.android.sdk.response.k;
import java.util.Vector;

public class c extends RelativeLayout {
   private a a;
   boolean b = false;
   boolean c = false;

   public c(Activity var1, AttributeSet var2) {
      super(var1, var2);
   }

   public c(Activity var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public c(Context var1) {
      super(var1);
   }

   private a getNativeAnalytic() {
      if (this.a == null) {
         this.a = new com.noqoush.adfalcon.android.sdk.viewability.omsdk.a();
      }

      return this.a;
   }

   public void initViewability(Vector var1) {
      this.getNativeAnalytic().a(this.getContext());
   }

   protected void onAttachedToWindow() {
      this.c = false;
      this.startViewabilityTracking();
      super.onAttachedToWindow();
   }

   protected void onDetachedFromWindow() {
      this.c = false;
      this.stopViewabilityTracking();
      super.onDetachedFromWindow();
   }

   public void onImpressionOccurred() {
      try {
         if (!this.b) {
            this.b = true;
            this.getNativeAnalytic().b();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onViewabilityClick() {
      this.getNativeAnalytic().c();
   }

   public void onViewabilityTouch() {
      this.getNativeAnalytic().d();
   }

   public void setViewabilityResponse(k var1) {
      this.initViewability(var1.e());
      this.getNativeAnalytic().a(this.getContext(), var1);
      if (this.c) {
         this.startViewabilityTracking();
      }

   }

   public void startViewabilityTracking() {
      this.getNativeAnalytic().a((Object)this);
      this.onImpressionOccurred();
   }

   public void stopViewabilityTracking() {
      this.getNativeAnalytic().a();
   }
}
