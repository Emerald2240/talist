package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class e extends WebViewClient {
   private Context a;
   private boolean b;
   private boolean c;
   private com.noqoush.adfalcon.android.sdk.urlactions.g d;
   private com.noqoush.adfalcon.android.sdk.helper.a e;

   public e(Context var1, boolean var2, boolean var3, com.noqoush.adfalcon.android.sdk.urlactions.g var4, com.noqoush.adfalcon.android.sdk.helper.a var5) {
      this.a(var1);
      this.a(var2);
      this.b(var3);
      this.a(var4);
      this.a(var5);
   }

   public com.noqoush.adfalcon.android.sdk.urlactions.g a() {
      return this.d;
   }

   public void a(Context var1) {
      this.a = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.helper.a var1) {
      this.e = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.urlactions.g var1) {
      this.d = var1;
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public com.noqoush.adfalcon.android.sdk.helper.a b() {
      return this.e;
   }

   public void b(boolean var1) {
      this.c = var1;
   }

   public Context c() {
      return this.a;
   }

   public boolean d() {
      return this.b;
   }

   public boolean e() {
      return this.c;
   }

   public void onPageFinished(WebView var1, String var2) {
      this.b().a(var1, var2);
      super.onPageFinished(var1, var2);
   }

   public void onPageStarted(WebView var1, String var2, Bitmap var3) {
      this.b().b(var1, var2);
      super.onPageStarted(var1, var2, var3);
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      try {
         boolean var7 = (new com.noqoush.adfalcon.android.sdk.handler.c()).a(this.c(), var2, this.d(), this.e(), this.a(), var1);
         return var7;
      } catch (Exception var8) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFBrowserWebViewClient->shouldOverrideUrlLoading->");
         var4.append(var8.toString());
         k.b(var4.toString());
         return false;
      }
   }
}
