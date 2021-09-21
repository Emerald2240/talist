package com.noqoush.adfalcon.android.sdk.urlactions;

import android.app.Activity;
import android.content.Intent;

public class h extends b {
   public boolean a(e var1) {
      try {
         boolean var3 = this.f(var1.b());
         return var3;
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
         return false;
      }
   }

   public boolean b(e var1) throws Exception {
      try {
         Intent var2 = new Intent("android.intent.action.VIEW", this.a(var1.b()));
         if (!(var1.a() instanceof Activity)) {
            var2.addFlags(268435456);
         }

         var1.a().startActivity(var2);
         if (var1.c() != null) {
            var1.c().a(i.b, m.c);
         }

         return true;
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
         if (var1.c() != null) {
            var1.c().a();
         }

         return false;
      }
   }
}
