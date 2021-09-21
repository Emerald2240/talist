package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.sdk.AppLovinSdkUtils;

class k extends Dialog implements j {
   private final Activity a;
   private final com.applovin.impl.sdk.j b;
   private final com.applovin.impl.sdk.p c;
   private final c d;
   private final com.applovin.impl.sdk.ad.a e;
   private RelativeLayout f;
   private h g;

   k(com.applovin.impl.sdk.ad.a var1, c var2, Activity var3, com.applovin.impl.sdk.j var4) {
      super(var3, 16973840);
      if (var1 != null) {
         if (var2 != null) {
            if (var4 != null) {
               if (var3 != null) {
                  this.b = var4;
                  this.c = var4.v();
                  this.a = var3;
                  this.d = var2;
                  this.e = var1;
                  this.requestWindowFeature(1);
                  this.setCancelable(false);
               } else {
                  throw new IllegalArgumentException("No activity specified");
               }
            } else {
               throw new IllegalArgumentException("No sdk specified");
            }
         } else {
            throw new IllegalArgumentException("No main view specified");
         }
      } else {
         throw new IllegalArgumentException("No ad specified");
      }
   }

   private int a(int var1) {
      return AppLovinSdkUtils.dpToPx(this.a, var1);
   }

   // $FF: synthetic method
   static c a(k var0) {
      return var0.d;
   }

   private void a(h.a var1) {
      if (this.g != null) {
         this.c.d("ExpandedAdDialog", "Attempting to create duplicate close button");
      } else {
         this.g = h.a(this.b, this.getContext(), var1);
         this.g.setVisibility(8);
         this.g.setOnClickListener(new k$4(this));
         this.g.setClickable(false);
         int var2 = this.a((Integer)this.b.a(com.applovin.impl.sdk.b.d.cr));
         LayoutParams var3 = new LayoutParams(var2, var2);
         var3.addRule(10);
         boolean var4 = (Boolean)this.b.a(com.applovin.impl.sdk.b.d.cu);
         byte var5 = 9;
         byte var6;
         if (var4) {
            var6 = 9;
         } else {
            var6 = 11;
         }

         var3.addRule(var6);
         this.g.a(var2);
         int var7 = this.a((Integer)this.b.a(com.applovin.impl.sdk.b.d.ct));
         int var8 = this.a((Integer)this.b.a(com.applovin.impl.sdk.b.d.cs));
         var3.setMargins(var8, var7, var8, 0);
         this.f.addView(this.g, var3);
         this.g.bringToFront();
         int var9 = this.a((Integer)this.b.a(com.applovin.impl.sdk.b.d.cv));
         View var10 = new View(this.a);
         var10.setBackgroundColor(0);
         int var11 = var2 + var9;
         LayoutParams var12 = new LayoutParams(var11, var11);
         var12.addRule(10);
         if (!(Boolean)this.b.a(com.applovin.impl.sdk.b.d.cu)) {
            var5 = 11;
         }

         var12.addRule(var5);
         var12.setMargins(var8 - this.a(5), var7 - this.a(5), var8 - this.a(5), 0);
         var10.setOnClickListener(new k$5(this));
         this.f.addView(var10, var12);
         var10.bringToFront();
      }
   }

   // $FF: synthetic method
   static RelativeLayout b(k var0) {
      return var0.f;
   }

   private void b() {
      LayoutParams var1 = new LayoutParams(-1, -1);
      var1.addRule(13);
      this.d.setLayoutParams(var1);
      this.f = new RelativeLayout(this.a);
      this.f.setLayoutParams(new LayoutParams(-1, -1));
      this.f.setBackgroundColor(-1157627904);
      this.f.addView(this.d);
      if (!this.e.j()) {
         this.a(this.e.k());
         this.d();
      }

      this.setContentView(this.f);
   }

   private void c() {
      this.d.a("javascript:al_onCloseTapped();", (Runnable)(new k$1(this)));
   }

   // $FF: synthetic method
   static void c(k var0) {
      var0.dismiss();
   }

   private void d() {
      this.a.runOnUiThread(new k$6(this));
   }

   // $FF: synthetic method
   static void d(k var0) {
      var0.c();
   }

   // $FF: synthetic method
   static h e(k var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.j f(k var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.p g(k var0) {
      return var0.c;
   }

   public com.applovin.impl.sdk.ad.a a() {
      return this.e;
   }

   public void dismiss() {
      com.applovin.impl.sdk.c.d var1 = this.d.c();
      if (var1 != null) {
         var1.e();
      }

      this.a.runOnUiThread(new k$3(this));
   }

   public void onBackPressed() {
      this.d.a("javascript:al_onBackPressed();", (Runnable)(new k$2(this)));
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.b();
   }

   protected void onStart() {
      super.onStart();

      Throwable var10000;
      label118: {
         boolean var10001;
         Window var2;
         try {
            var2 = this.getWindow();
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            break label118;
         }

         if (var2 != null) {
            label114:
            try {
               var2.setFlags(this.a.getWindow().getAttributes().flags, this.a.getWindow().getAttributes().flags);
               if (this.e.v()) {
                  var2.addFlags(16777216);
                  return;
               }

               return;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label114;
            }
         } else {
            label111:
            try {
               this.c.e("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
               return;
            } catch (Throwable var12) {
               var10000 = var12;
               var10001 = false;
               break label111;
            }
         }
      }

      Throwable var1 = var10000;
      this.c.b("ExpandedAdDialog", "Setting window flags failed.", var1);
   }
}
