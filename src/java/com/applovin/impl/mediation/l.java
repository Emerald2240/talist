package com.applovin.impl.mediation;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;

public class l implements MaxAd {
   private final String a;
   private final MaxAdFormat b;
   private final String c;

   public l(String var1, MaxAdFormat var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public String getAdUnitId() {
      return this.a;
   }

   public MaxAdFormat getFormat() {
      return this.b;
   }

   public String getNetworkName() {
      return this.c;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MaxAd{adUnitId=");
      var1.append(this.a);
      var1.append(", format=");
      var1.append(this.b);
      var1.append(", network=");
      var1.append(this.c);
      var1.append("}");
      return var1.toString();
   }
}
