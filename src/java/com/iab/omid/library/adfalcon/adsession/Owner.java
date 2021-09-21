package com.iab.omid.library.adfalcon.adsession;

public enum Owner {
   JAVASCRIPT("javascript"),
   NATIVE("native"),
   NONE;

   private final String owner;

   static {
      Owner var0 = new Owner("NONE", 2, "none");
      NONE = var0;
      Owner[] var1 = new Owner[]{NATIVE, JAVASCRIPT, var0};
   }

   private Owner(String var3) {
      this.owner = var3;
   }

   public String toString() {
      return this.owner;
   }
}
