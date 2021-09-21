package com.iab.omid.library.adfalcon.adsession;

public enum ErrorType {
   GENERIC("generic"),
   VIDEO;

   private final String errorType;

   static {
      ErrorType var0 = new ErrorType("VIDEO", 1, "video");
      VIDEO = var0;
      ErrorType[] var1 = new ErrorType[]{GENERIC, var0};
   }

   private ErrorType(String var3) {
      this.errorType = var3;
   }

   public String toString() {
      return this.errorType;
   }
}
