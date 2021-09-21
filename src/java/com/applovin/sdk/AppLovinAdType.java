package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdType {
   public static final AppLovinAdType INCENTIVIZED = new AppLovinAdType("VIDEOA");
   public static final AppLovinAdType NATIVE = new AppLovinAdType("NATIVE");
   public static final AppLovinAdType REGULAR = new AppLovinAdType("REGULAR");
   private final String a;

   private AppLovinAdType(String var1) {
      this.a = var1;
   }

   public static Set allTypes() {
      HashSet var0 = new HashSet(2);
      var0.add(REGULAR);
      var0.add(INCENTIVIZED);
      return var0;
   }

   public static AppLovinAdType fromString(String var0) {
      if ("REGULAR".equalsIgnoreCase(var0)) {
         return REGULAR;
      } else if ("VIDEOA".equalsIgnoreCase(var0)) {
         return INCENTIVIZED;
      } else if ("NATIVE".equalsIgnoreCase(var0)) {
         return NATIVE;
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append("Unknown Ad Type: ");
         var1.append(var0);
         throw new IllegalArgumentException(var1.toString());
      }
   }

   public String getLabel() {
      return this.a.toUpperCase(Locale.ENGLISH);
   }

   public String toString() {
      return this.getLabel();
   }
}
