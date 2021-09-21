package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import android.webkit.WebView;

public class z extends WebView {
   public z(Context var1) {
      super(var1);
   }

   public void a() {
      try {
         super.onPause();
         Class var2 = Class.forName("android.webkit.WebView");
         var2.getMethod("onPause", (Class[])null).invoke(this, (Object[])null);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }

      super.onPause();
   }

   public void b() {
      try {
         super.onResume();
         Class var2 = Class.forName("android.webkit.WebView");
         var2.getMethod("onResume", (Class[])null).invoke(this, (Object[])null);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }

      super.onResume();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.b();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.a();
   }
}
