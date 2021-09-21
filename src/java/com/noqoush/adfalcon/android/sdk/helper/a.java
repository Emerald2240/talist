package com.noqoush.adfalcon.android.sdk.helper;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.LinearLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.ADFBrowser;
import com.noqoush.adfalcon.android.sdk.e;
import com.noqoush.adfalcon.android.sdk.k;
import com.noqoush.adfalcon.android.sdk.y;
import com.noqoush.adfalcon.android.sdk.z;
import com.noqoush.adfalcon.android.sdk.urlactions.g;
import com.noqoush.adfalcon.android.sdk.util.f;

public class a implements OnClickListener {
   private final int a = 100;
   private final int b = 101;
   private final int c = 102;
   private final int d = 103;
   private final int e = 104;
   private final int f = 105;
   private final int g = 106;
   private Context h;
   private com.noqoush.adfalcon.android.sdk.images.b i;
   private b j;
   private g k;
   private String l;
   private z m;
   private y n;
   private ImageButton o;
   private ImageButton p;
   private ImageButton q;
   private ImageButton r;
   private ImageButton s;
   private RelativeLayout t;

   public a(Context var1, b var2, String var3, g var4) {
      this.a(var1);
      this.a(var2);
      this.a(var3);
      this.a(var4);
      this.a(new com.noqoush.adfalcon.android.sdk.images.b());
   }

   private void a(WebView var1) throws Exception {
      this.o.setEnabled(var1.canGoBack());
      this.p.setEnabled(var1.canGoForward());
      ImageButton var2 = this.o;
      com.noqoush.adfalcon.android.sdk.images.b var3 = this.e();
      com.noqoush.adfalcon.android.sdk.images.a var4;
      if (!var1.canGoBack()) {
         var4 = com.noqoush.adfalcon.android.sdk.images.a.b;
      } else {
         var4 = com.noqoush.adfalcon.android.sdk.images.a.a;
      }

      var2.setImageBitmap(var3.a(var4, this.d()));
      ImageButton var5 = this.p;
      com.noqoush.adfalcon.android.sdk.images.b var6 = this.e();
      com.noqoush.adfalcon.android.sdk.images.a var7;
      if (!var1.canGoForward()) {
         var7 = com.noqoush.adfalcon.android.sdk.images.a.b;
      } else {
         var7 = com.noqoush.adfalcon.android.sdk.images.a.a;
      }

      var5.setImageBitmap(var6.d(var7, this.d()));
   }

   private void a(LinearLayout var1) throws Exception {
      ImageButton var2 = this.k();
      this.o = var2;
      var2.setId(103);
      this.o.setEnabled(false);

      try {
         this.o.setImageBitmap(this.e().a(com.noqoush.adfalcon.android.sdk.images.a.b, this.d()));
      } catch (Exception var4) {
      }

      var1.addView(this.o);
   }

   private boolean a(Context var1, String var2, boolean var3, boolean var4, WebView var5, boolean var6) {
      return (new com.noqoush.adfalcon.android.sdk.handler.c()).a(var1, var2, var3, var4, this.h(), var5);
   }

   private void b(LinearLayout var1) throws Exception {
      ImageButton var2 = this.k();
      this.r = var2;
      var2.setId(106);

      try {
         this.r.setImageBitmap(this.e().b(com.noqoush.adfalcon.android.sdk.images.a.a, this.d()));
      } catch (Exception var4) {
      }

      var1.addView(this.r);
   }

   private void c(LinearLayout var1) throws Exception {
      ImageButton var2 = this.k();
      this.s = var2;
      var2.setId(106);

      try {
         this.s.setImageBitmap(this.e().c(com.noqoush.adfalcon.android.sdk.images.a.a, this.d()));
      } catch (Exception var4) {
      }

      var1.addView(this.s);
   }

   private void d(LinearLayout var1) throws Exception {
      ImageButton var2 = this.k();
      this.p = var2;
      var2.setId(104);
      this.p.setEnabled(false);

      try {
         this.p.setImageBitmap(this.e().d(com.noqoush.adfalcon.android.sdk.images.a.b, this.d()));
      } catch (Exception var4) {
      }

      var1.addView(this.p);
   }

   private void e(LinearLayout var1) throws Exception {
      ImageButton var2 = this.k();
      this.q = var2;
      var2.setId(105);

      try {
         this.q.setImageBitmap(this.e().e(com.noqoush.adfalcon.android.sdk.images.a.a, this.d()));
      } catch (Exception var4) {
      }

      var1.addView(this.q);
   }

   private ImageButton k() throws Exception {
      ImageButton var1 = new ImageButton(this.d());
      var1.setBackgroundColor(0);
      var1.setOnClickListener(this);
      var1.setLayoutParams(new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), -2, 0.25F));
      return var1;
   }

   public LinearLayout a(boolean var1) throws Exception {
      LinearLayout var2 = new LinearLayout(this.d());
      if (var1) {
         var2.setBackgroundColor(-16777216);
      }

      var2.setId(102);
      android.widget.RelativeLayout.LayoutParams var3 = new android.widget.RelativeLayout.LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), -2);
      var2.setLayoutParams(var3);
      var3.addRule(12, -1);
      this.a(var2);
      this.d(var2);
      this.e(var2);
      this.b(var2);
      this.c(var2);
      this.f().addView(var2);
      return var2;
   }

   public ProgressBar a() throws Exception {
      ProgressBar var1 = com.noqoush.adfalcon.android.sdk.util.f.a(this.d(), 16843399);
      var1.setId(101);
      com.noqoush.adfalcon.android.sdk.util.f.a(this.d(), var1, com.noqoush.adfalcon.android.sdk.util.f.b());
      this.f().addView(var1);
      return var1;
   }

   public z a(ProgressBar var1, boolean var2) throws Exception {
      this.a(new y(this.d(), this.f(), var1));
      e var3 = new e(this.d(), var2, true, this.h(), this);
      z var4 = new z(this.d());
      this.m = var4;
      var4.setWebViewClient(var3);
      this.m.setWebChromeClient(this.c());
      this.m.setId(100);
      android.widget.RelativeLayout.LayoutParams var5 = new android.widget.RelativeLayout.LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
      var5.addRule(10, -1);
      var5.addRule(2, 102);
      com.noqoush.adfalcon.android.sdk.util.e.c(this.m);
      this.f().addView(this.m, var5);
      var1.bringToFront();
      return this.m;
   }

   public void a(Context var1) {
      this.h = var1;
   }

   public void a(WebView var1, String var2) {
      try {
         this.q.setImageBitmap(this.e().e(com.noqoush.adfalcon.android.sdk.images.a.a, this.d()));
         this.a(var1);
         if (var1.getTitle() != null && var1.getTitle().length() > 0) {
            this.b().a(var1.getTitle());
            return;
         }
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFBrowserHelper->onPageFinished: ");
         var4.append(var5.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }

   }

   public void a(b var1) {
      this.j = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.images.b var1) {
      this.i = var1;
   }

   public void a(g var1) {
      this.k = var1;
   }

   public void a(y var1) {
      this.n = var1;
   }

   public void a(z var1) {
      this.m = var1;
   }

   public void a(String var1) {
      this.l = var1;
   }

   public b b() {
      return this.j;
   }

   public void b(WebView var1, String var2) {
      try {
         this.b().a(var2);
         this.q.setImageBitmap(this.e().f(com.noqoush.adfalcon.android.sdk.images.a.a, this.d()));
         this.a(var1);
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFBrowserHelper->onPageStarted: ");
         var4.append(var5.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   public y c() {
      return this.n;
   }

   public Context d() {
      return this.h;
   }

   public com.noqoush.adfalcon.android.sdk.images.b e() {
      return this.i;
   }

   public RelativeLayout f() {
      RelativeLayout var1 = this.t;
      if (var1 != null) {
         return var1;
      } else {
         this.t = new RelativeLayout(this.d());
         android.widget.RelativeLayout.LayoutParams var2 = new android.widget.RelativeLayout.LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), -2);
         this.t.setLayoutParams(var2);
         return this.t;
      }
   }

   public String g() {
      return this.l;
   }

   public g h() {
      return this.k;
   }

   public z i() {
      return this.m;
   }

   public void j() {
      // $FF: Couldn't be decompiled
   }

   public void onClick(View var1) {
      boolean var10001;
      try {
         if (var1 == this.o) {
            if (this.i().canGoBack()) {
               this.i().goBack();
               return;
            }

            return;
         }
      } catch (Exception var20) {
         var10001 = false;
         return;
      }

      try {
         if (var1 == this.p) {
            if (this.i().canGoForward()) {
               this.i().goForward();
               return;
            }

            return;
         }
      } catch (Exception var16) {
         var10001 = false;
         return;
      }

      label123: {
         try {
            if (var1 != this.q) {
               break label123;
            }

            if (this.i().getProgress() < 100) {
               this.i().stopLoading();
               return;
            }
         } catch (Exception var19) {
            var10001 = false;
            return;
         }

         try {
            if (this.i().getUrl() == null) {
               this.j();
               return;
            }
         } catch (Exception var17) {
            var10001 = false;
            return;
         }

         try {
            this.i().reload();
            return;
         } catch (Exception var11) {
            var10001 = false;
            return;
         }
      }

      try {
         if (var1 == this.s) {
            this.b().b();
            return;
         }
      } catch (Exception var18) {
         var10001 = false;
         return;
      }

      ImageButton var3;
      try {
         var3 = this.r;
      } catch (Exception var15) {
         var10001 = false;
         return;
      }

      if (var1 == var3) {
         Exception var10000;
         label124: {
            String var8;
            label86: {
               try {
                  if (this.i().getUrl() == null) {
                     var8 = this.g();
                     break label86;
                  }
               } catch (Exception var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label124;
               }

               try {
                  var8 = this.i().getUrl();
               } catch (Exception var13) {
                  var10000 = var13;
                  var10001 = false;
                  break label124;
               }
            }

            String var9 = var8;

            try {
               this.a(this.d(), var9, false, false, this.i(), true);
               if (!(this.d() instanceof ADFBrowser)) {
                  this.b().b();
                  return;
               }

               return;
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
            }
         }

         Exception var4 = var10000;

         try {
            StringBuilder var5 = new StringBuilder();
            var5.append("ADFBrowserHelper->onViewabilityClick: ");
            var5.append(var4.toString());
            com.noqoush.adfalcon.android.sdk.k.b(var5.toString());
            return;
         } catch (Exception var10) {
            var10001 = false;
         }
      }

   }
}
