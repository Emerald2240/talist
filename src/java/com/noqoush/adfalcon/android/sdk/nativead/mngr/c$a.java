package com.noqoush.adfalcon.android.sdk.nativead.mngr;

import android.content.Context;
import android.view.View;
import com.noqoush.adfalcon.android.sdk.w;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.nativead.ADFNativeAdStatus;
import com.noqoush.adfalcon.android.sdk.response.k;

class c$a implements com.noqoush.adfalcon.android.sdk.handler.b {
   // $FF: synthetic field
   final boolean a;
   // $FF: synthetic field
   final c b;

   c$a(c var1, boolean var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(ADFNativeAdStatus var1) {
      try {
         c.a(this.b).a(var1, (String)null, (ADFErrorCode)null);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public void a(w.e var1) {
   }

   public boolean a() {
      return true;
   }

   public k b() {
      return c.a(this.b).i();
   }

   public com.noqoush.adfalcon.android.sdk.nativead.a c() {
      return c.a(this.b).c();
   }

   public Context d() {
      return c.a(this.b).b();
   }

   public boolean e() {
      return this.a;
   }

   public View f() {
      return null;
   }
}
