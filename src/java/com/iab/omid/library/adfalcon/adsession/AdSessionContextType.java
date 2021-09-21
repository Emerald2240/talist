package com.iab.omid.library.adfalcon.adsession;

public enum AdSessionContextType {
   HTML("html"),
   NATIVE;

   private final String typeString;

   static {
      AdSessionContextType var0 = new AdSessionContextType("NATIVE", 1, "native");
      NATIVE = var0;
      AdSessionContextType[] var1 = new AdSessionContextType[]{HTML, var0};
   }

   private AdSessionContextType(String var3) {
      this.typeString = var3;
   }

   public String toString() {
      return this.typeString;
   }
}
