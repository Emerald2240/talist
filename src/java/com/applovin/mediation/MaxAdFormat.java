package com.applovin.mediation;

public class MaxAdFormat {
   public static final MaxAdFormat BANNER = new MaxAdFormat("BANNER");
   public static final MaxAdFormat INTERSTITIAL = new MaxAdFormat("INTER");
   public static final MaxAdFormat LEADER = new MaxAdFormat("LEADER");
   public static final MaxAdFormat MREC = new MaxAdFormat("MREC");
   public static final MaxAdFormat NATIVE = new MaxAdFormat("NATIVE");
   public static final MaxAdFormat REWARDED = new MaxAdFormat("REWARDED");
   private final String a;

   private MaxAdFormat(String var1) {
      this.a = var1;
   }

   public String getLabel() {
      return this.a;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MaxAdFormat{label='");
      var1.append(this.a);
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }
}
