package com.iab.omid.library.adfalcon.b;

import android.content.Context;

public class c {
   private static c a = new c();
   private Context b;

   private c() {
   }

   public static c a() {
      return a;
   }

   public void a(Context var1) {
      Context var2;
      if (var1 != null) {
         var2 = var1.getApplicationContext();
      } else {
         var2 = null;
      }

      this.b = var2;
   }

   public Context b() {
      return this.b;
   }
}
