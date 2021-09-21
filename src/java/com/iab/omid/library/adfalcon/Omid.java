package com.iab.omid.library.adfalcon;

import android.content.Context;

public final class Omid {
   private static a INSTANCE = new a();

   private Omid() {
   }

   public static boolean activateWithOmidApiVersion(String var0, Context var1) {
      INSTANCE.a(var1.getApplicationContext());
      return true;
   }

   public static String getVersion() {
      return INSTANCE.a();
   }

   public static boolean isActive() {
      return INSTANCE.b();
   }

   public static boolean isCompatibleWithOmidApiVersion(String var0) {
      return INSTANCE.a(var0);
   }
}
