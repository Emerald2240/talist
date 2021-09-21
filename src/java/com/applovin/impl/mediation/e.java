package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.n;

public class e {
   public static final e EMPTY = new e(0);
   private final int errorCode;
   private final String errorMessage;

   public e(int var1) {
      this(var1, "");
   }

   public e(int var1, String var2) {
      this.errorCode = var1;
      this.errorMessage = n.c(var2);
   }

   public e(String var1) {
      this(-1, var1);
   }

   public int getErrorCode() {
      return this.errorCode;
   }

   public String getErrorMessage() {
      return this.errorMessage;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MaxError{errorCode=");
      var1.append(this.getErrorCode());
      var1.append(", errorMessage='");
      var1.append(this.getErrorMessage());
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }
}
