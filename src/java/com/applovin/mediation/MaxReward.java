package com.applovin.mediation;

public class MaxReward {
   public static final int DEFAULT_AMOUNT = 0;
   public static final String DEFAULT_LABEL = "";
   private final String a;
   private final int b;

   private MaxReward(int var1, String var2) {
      if (var1 >= 0) {
         this.a = var2;
         this.b = var1;
      } else {
         throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
      }
   }

   public static MaxReward create(int var0, String var1) {
      return new MaxReward(var0, var1);
   }

   public static MaxReward createDefault() {
      return create(0, "");
   }

   public final int getAmount() {
      return this.b;
   }

   public final String getLabel() {
      return this.a;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MaxReward{amount=");
      var1.append(this.b);
      var1.append(", label='");
      var1.append(this.a);
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }
}
