package com.noqoush.adfalcon.android.sdk.handler;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.PowerManager;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class d extends Thread {
   private static final int i = 250;
   private static final int j = 900000;
   private com.noqoush.adfalcon.android.sdk.helper.c a;
   double b = 0.5D;
   int c = 1000;
   WeakReference d;
   WeakReference e;
   long f = 0L;
   boolean g = false;
   private b h;

   public d(b var1) {
      try {
         this.a(var1);
         this.b(var1.d());
         this.a(var1.f());
         this.a(new com.noqoush.adfalcon.android.sdk.helper.c(this.e(), var1.b().g()));
         this.a(var1.b().q().f());
         this.a(var1.b().q().e());
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   private int a(int var1, int var2) {
      if (var1 < 0) {
         return 0;
      } else {
         return var1 > var2 ? var2 : var1;
      }
   }

   private void a(double var1) {
      if (var1 > 1.0D) {
         var1 = 1.0D;
      }

      this.b = var1;
   }

   private void a(int var1) {
      if (var1 > 2000) {
         var1 = 2000;
      }

      this.c = var1;
   }

   private void a(View var1) {
      this.d = new WeakReference(var1);
   }

   private void a(b var1) {
      this.h = var1;
   }

   private boolean a(Context var1) throws Exception {
      boolean var2;
      if (VERSION.SDK_INT >= 20) {
         Display[] var3 = ((DisplayManager)var1.getSystemService("display")).getDisplays();
         int var4 = var3.length;
         int var5 = 0;

         for(var2 = false; var5 < var4; ++var5) {
            if (var3[var5].getState() != 1) {
               var2 = true;
            }
         }
      } else {
         var2 = ((PowerManager)var1.getSystemService("power")).isScreenOn();
      }

      return var2;
   }

   private void b(Context var1) {
      this.e = new WeakReference(var1);
   }

   private boolean d() throws Exception {
      long var4;
      int var6;
      try {
         if (this.i() < 250) {
            return true;
         }

         long var2 = Calendar.getInstance().getTimeInMillis();
         var4 = var2 - this.f;
         if (this.f <= 0L) {
            this.f = var2;
            return false;
         }

         var6 = this.i();
      } catch (Exception var7) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var7);
         return true;
      }

      return var4 > (long)var6;
   }

   private Context e() {
      return (Context)this.e.get();
   }

   private b f() {
      return this.h;
   }

   private View g() {
      return (View)this.d.get();
   }

   private double h() {
      return 100.0D * this.b;
   }

   private int i() {
      return this.c;
   }

   void a(com.noqoush.adfalcon.android.sdk.helper.c var1) {
      this.a = var1;
   }

   public boolean a() throws Exception {
      Exception var10000;
      label76: {
         boolean var10001;
         try {
            if (this.e() == null) {
               return false;
            }

            if (this.g() == null) {
               return false;
            }
         } catch (Exception var34) {
            var10000 = var34;
            var10001 = false;
            break label76;
         }

         try {
            if (this.h() < 20.0D) {
               return true;
            }
         } catch (Exception var33) {
            var10000 = var33;
            var10001 = false;
            break label76;
         }

         int var11;
         int var6;
         int var5;
         int var3;
         int var4;
         int var12;
         label63: {
            int var9;
            int var10;
            label62: {
               Display var7;
               try {
                  int[] var2 = new int[2];
                  this.g().getLocationInWindow(var2);
                  var3 = var2[0];
                  var4 = var2[1];
                  var5 = this.g().getWidth();
                  var6 = this.g().getHeight();
                  var7 = ((WindowManager)this.e().getSystemService("window")).getDefaultDisplay();
                  if (VERSION.SDK_INT >= 13) {
                     Point var8 = new Point();
                     var7.getSize(var8);
                     var9 = var8.x;
                     var10 = var8.y;
                     break label62;
                  }
               } catch (Exception var32) {
                  var10000 = var32;
                  var10001 = false;
                  break label76;
               }

               try {
                  var11 = var7.getWidth();
                  var12 = var7.getHeight();
                  break label63;
               } catch (Exception var31) {
                  var10000 = var31;
                  var10001 = false;
                  break label76;
               }
            }

            var11 = var9;
            var12 = var10;
         }

         if (var3 > var11) {
            return false;
         }

         if (var4 > var12) {
            return false;
         }

         int var15;
         int var14;
         int var16;
         int var13;
         try {
            var13 = this.a(var3, var11);
            var14 = this.a(var4, var12);
            var15 = this.a(var13 + var5, var11);
            var16 = this.a(var14 + var6, var12);
         } catch (Exception var30) {
            var10000 = var30;
            var10001 = false;
            break label76;
         }

         int var17 = var15 - var13;
         int var18 = var16 - var14;
         double var19 = (double)(var5 * var6);
         double var21 = (double)(var17 * var18);
         Double.isNaN(var21);
         Double.isNaN(var19);
         double var25 = 100.0D * (var21 / var19);

         double var27;
         try {
            var27 = this.h();
         } catch (Exception var29) {
            var10000 = var29;
            var10001 = false;
            break label76;
         }

         if (var25 >= var27) {
            return true;
         }

         return false;
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
      return true;
   }

   com.noqoush.adfalcon.android.sdk.helper.c b() {
      return this.a;
   }

   public boolean c() {
      return this.g;
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }

   public void start() {
      // $FF: Couldn't be decompiled
   }
}
