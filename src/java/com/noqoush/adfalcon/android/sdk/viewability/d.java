package com.noqoush.adfalcon.android.sdk.viewability;

import android.content.Context;
import android.webkit.WebView;
import com.noqoush.adfalcon.android.sdk.z;
import java.util.Map;
import java.util.Vector;

public class d extends z {
   private e a;
   boolean b = false;

   public d(Context var1, Vector var2, boolean var3) {
      super(var1);
      String var4 = "moat";
      if (var2 == null || !var2.contains(var4) || var2.contains("omid1")) {
         var4 = "omid1";
      }

      this.a(var4, var3);
   }

   // $FF: synthetic method
   static void a(d var0) {
      var0.destroy();
   }

   private void a(String var1, boolean var2) {
      this.getWebViewAnalytic().a(this.getContext());
      this.getWebViewAnalytic().a(var2);
   }

   private boolean b(String var1) {
      return var1.toLowerCase().startsWith("http") && !var1.toLowerCase().startsWith("javascript");
   }

   private void e() {
      this.getWebViewAnalytic().a((Object)this);
   }

   private e getWebViewAnalytic() {
      if (this.a == null) {
         this.a = new com.noqoush.adfalcon.android.sdk.viewability.omsdk.d();
      }

      return this.a;
   }

   public void a(String var1) {
      try {
         this.getWebViewAnalytic().a(this, var1);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public void c() {
      try {
         this.getWebViewAnalytic().b();
         if (!this.b) {
            this.b = true;
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   protected void d() {
      this.getWebViewAnalytic().a();
   }

   public void destroy() {
      this.d();
      this.postDelayed(new d$b(this), 1000L);
   }

   public void loadData(String var1, String var2, String var3) {
      this.getWebViewAnalytic().a((WebView)this);
      super.loadData(this.getWebViewAnalytic().a(var1), var2, var3);
      this.setWebViewClient(new d$a(this));
   }

   public void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5) {
      this.getWebViewAnalytic().a((WebView)this);
      super.loadDataWithBaseURL(var1, this.getWebViewAnalytic().a(var2), var3, var4, var5);
   }

   public void loadUrl(String var1) {
      if (this.b(var1)) {
         this.getWebViewAnalytic().a((WebView)this);
      }

      super.loadUrl(var1);
   }

   public void loadUrl(String var1, Map var2) {
      if (this.b(var1)) {
         this.getWebViewAnalytic().a((WebView)this);
      }

      super.loadUrl(var1, var2);
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.e();
   }

   protected void onDetachedFromWindow() {
      this.d();
      super.onDetachedFromWindow();
   }
}
