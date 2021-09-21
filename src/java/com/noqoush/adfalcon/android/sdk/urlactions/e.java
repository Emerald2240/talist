package com.noqoush.adfalcon.android.sdk.urlactions;

import android.content.Context;
import android.webkit.WebView;

public class e {
   private String a;
   private Context b;
   private boolean c;
   private boolean d;
   private g e;
   private WebView f;

   public e(String var1, Context var2, boolean var3, boolean var4, g var5, WebView var6) {
      this.a(var1);
      this.a(var2);
      this.a(var3);
      this.b(var4);
      this.a(var5);
      this.a(var6);
   }

   public Context a() {
      return this.b;
   }

   public void a(Context var1) {
      this.b = var1;
   }

   public void a(WebView var1) {
      this.f = var1;
   }

   public void a(g var1) {
      this.e = var1;
   }

   public void a(String var1) {
      this.a = var1;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public String b() {
      return this.a;
   }

   public void b(boolean var1) {
      this.d = var1;
   }

   public g c() {
      return this.e;
   }

   public WebView d() {
      return this.f;
   }

   public boolean e() {
      return this.c;
   }

   public boolean f() {
      return this.d;
   }
}
