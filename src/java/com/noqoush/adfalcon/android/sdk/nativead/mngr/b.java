package com.noqoush.adfalcon.android.sdk.nativead.mngr;

import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.nativead.ADFNativeAdStatus;
import java.lang.ref.WeakReference;

public class b {
   WeakReference a;
   ADFNativeAdStatus b;
   String c;
   ADFErrorCode d;

   public b(com.noqoush.adfalcon.android.sdk.nativead.data.a var1) {
      this.a = new WeakReference(var1);
      this.d = ADFErrorCode.NONE;
   }

   private void a(String var1, ADFErrorCode var2) throws Exception {
      if (this.a != null) {
         StringBuilder var3 = new StringBuilder();
         var3.append("status changed: ");
         var3.append(this.b());
         String var6 = "";
         var3.append(var6);
         if (this.b() == ADFNativeAdStatus.failed) {
            StringBuilder var8 = new StringBuilder();
            var8.append(", Error: ");
            var8.append(var1);
            var6 = var8.toString();
         }

         var3.append(var6);
         com.noqoush.adfalcon.android.sdk.util.a.c(var3.toString());
         com.noqoush.adfalcon.android.sdk.nativead.a var12 = this.a().c();
         if (var12 != null) {
            if (this.b() == ADFNativeAdStatus.failed) {
               var12.a(var1, var2);
               return;
            }

            if (this.b() == ADFNativeAdStatus.loaded) {
               var12.b();
               return;
            }

            if (this.b() == ADFNativeAdStatus.clicked) {
               var12.c();
               return;
            }
         } else {
            com.noqoush.adfalcon.android.sdk.util.a.c("listenerController is null");
         }

      }
   }

   public com.noqoush.adfalcon.android.sdk.nativead.data.a a() {
      return (com.noqoush.adfalcon.android.sdk.nativead.data.a)this.a.get();
   }

   public void a(ADFErrorCode var1) {
      this.d = var1;
   }

   public void a(ADFNativeAdStatus var1, String var2, ADFErrorCode var3) throws Exception {
      this.b = var1;
      if (var3 == null) {
         this.a(ADFErrorCode.NONE);
      } else {
         this.a(var3);
      }

      if (var1 == ADFNativeAdStatus.failed) {
         this.a(var2);
      } else {
         this.a("");
      }

      this.a(var2, var3);
   }

   public void a(com.noqoush.adfalcon.android.sdk.nativead.data.a var1) {
      this.a = new WeakReference(var1);
   }

   public void a(String var1) {
      this.c = var1;
   }

   public ADFNativeAdStatus b() {
      return this.b;
   }

   public ADFErrorCode c() {
      return this.d;
   }

   public String d() {
      return this.c;
   }
}
