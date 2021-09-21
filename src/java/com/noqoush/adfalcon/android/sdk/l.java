package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicInteger;

public class l implements a {
   private String a;
   private RelativeLayout b;
   private Intent c;
   private Activity d;
   private v e;
   private final AtomicInteger f = new AtomicInteger(1);

   private int j() {
      int var1;
      int var2;
      do {
         var1 = this.f.get();
         var2 = var1 + 1;
         if (var2 > 16777215) {
            var2 = 1;
         }
      } while(!this.f.compareAndSet(var1, var2));

      return var1;
   }

   private int k() {
      return VERSION.SDK_INT >= 17 ? View.generateViewId() : this.j();
   }

   private RelativeLayout l() throws Exception {
      if (this.b == null) {
         RelativeLayout var1 = new RelativeLayout(this.h());
         this.b = var1;
         var1.setId(this.k());
         LayoutParams var2 = new LayoutParams(-1, -1);
         this.b.setLayoutParams(var2);
         this.b.setBackgroundColor(-16777216);
      }

      return this.b;
   }

   public void a() {
   }

   public void a(Activity var1) {
      this.d = var1;
   }

   public void a(Intent var1) {
      this.c = var1;
   }

   public void a(Bundle var1) {
   }

   public void a(Bundle var1, Activity var2, Window var3, Intent var4) {
      try {
         this.a(var4);
         this.a(var2);
         var2.requestWindowFeature(1);
         var2.setContentView(this.l());
         this.a = this.i().getStringExtra("url");
         v var10 = new v(var2, this.a, this.l(), (w)null, (ImageView)null, (ADFMraidIVideoOutInterface)null);
         this.e = var10;
      } catch (Exception var11) {
         StringBuilder var6 = new StringBuilder();
         var6.append("ADFMediaPlayerActivityImp->onCreate: ");
         var6.append(var11.toString());
         k.b(var6.toString());
      }
   }

   public void a(m var1) {
   }

   public void b() {
   }

   public void b(Bundle var1) {
   }

   public void b(Bundle var1, Activity var2, Window var3, Intent var4) {
      var2.setTheme(16974065);
   }

   public void c() {
   }

   public void d() {
   }

   public void e() {
      try {
         if (this.e.b()) {
            this.g();
            return;
         }
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMediaPlayerActivityImp->onBackPressed: ");
         var2.append(var3.toString());
         k.b(var2.toString());
      }

   }

   public void f() {
      v var1 = this.e;
      if (var1 != null) {
         var1.g();
      }

   }

   public void g() {
      this.h().finish();
   }

   public Activity h() {
      return this.d;
   }

   public Intent i() {
      return this.c;
   }
}
