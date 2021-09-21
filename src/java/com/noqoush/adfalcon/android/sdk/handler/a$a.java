package com.noqoush.adfalcon.android.sdk.handler;

import com.noqoush.adfalcon.android.sdk.w;
import com.noqoush.adfalcon.android.sdk.nativead.ADFNativeAdStatus;
import com.noqoush.adfalcon.android.sdk.urlactions.g;
import com.noqoush.adfalcon.android.sdk.urlactions.i;
import com.noqoush.adfalcon.android.sdk.urlactions.m;

class a$a implements g {
   // $FF: synthetic field
   final a a;

   a$a(a var1) {
      this.a = var1;
   }

   public void a() {
   }

   public void a(i var1, m var2) {
      try {
         if (var1 != i.a || var2 != m.b && var2 != m.a) {
            this.a.b().a(ADFNativeAdStatus.clicked);
            this.a.b().a(w.e.l);
         } else {
            this.a.b().a(w.e.i);
            this.a.b().a(ADFNativeAdStatus.clicked);
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }
   }
}
