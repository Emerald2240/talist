package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import android.view.View;
import com.noqoush.adfalcon.android.sdk.nativead.ADFNativeAdStatus;

class w$d implements com.noqoush.adfalcon.android.sdk.handler.b {
   // $FF: synthetic field
   final w a;

   w$d(w var1) {
      this.a = var1;
   }

   public void a(ADFNativeAdStatus var1) {
   }

   public void a(w.e var1) {
      x var2 = w.a(this.a);
      synchronized(var2){}

      label219: {
         boolean var10001;
         Throwable var10000;
         label220: {
            label212: {
               try {
                  this.a.a(var1);
                  if (var1 == w.e.i) {
                     this.a.e();
                     break label212;
                  }
               } catch (Throwable var24) {
                  var10000 = var24;
                  var10001 = false;
                  break label220;
               }

               try {
                  if (var1 == w.e.l) {
                     this.a.f();
                  }
               } catch (Throwable var23) {
                  var10000 = var23;
                  var10001 = false;
                  break label220;
               }
            }

            label203:
            try {
               break label219;
            } catch (Throwable var22) {
               var10000 = var22;
               var10001 = false;
               break label203;
            }
         }

         while(true) {
            Throwable var3 = var10000;

            try {
               throw var3;
            } catch (Throwable var21) {
               var10000 = var21;
               var10001 = false;
               continue;
            }
         }
      }

      w.b(this.a);
   }

   public boolean a() {
      return w.a(this.a).e() != null && w.a(this.a).l() != null && this.a.i() != w.e.b && this.a.i() != w.e.i && this.a.i() != w.e.a;
   }

   public com.noqoush.adfalcon.android.sdk.response.k b() {
      return this.a.g().l();
   }

   public com.noqoush.adfalcon.android.sdk.nativead.a c() {
      return null;
   }

   public Context d() {
      return this.a.g().f();
   }

   public boolean e() {
      return false;
   }

   public View f() {
      return null;
   }
}
