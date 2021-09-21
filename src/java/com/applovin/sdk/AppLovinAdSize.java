package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdSize {
   public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
   public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
   public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
   public static final AppLovinAdSize MREC = new AppLovinAdSize(300, 250, "MREC");
   public static final AppLovinAdSize NATIVE = new AppLovinAdSize("NATIVE");
   public static final int SPAN = -1;
   private final int a;
   private final int b;
   private final String c;

   private AppLovinAdSize(int var1, int var2, String var3) {
      if (var1 < 0 && var1 != -1) {
         StringBuilder var16 = new StringBuilder();
         var16.append("Ad width must be a positive number. Number provided: ");
         var16.append(var1);
         throw new IllegalArgumentException(var16.toString());
      } else if (var1 <= 9999) {
         if (var2 < 0 && var2 != -1) {
            StringBuilder var13 = new StringBuilder();
            var13.append("Ad height must be a positive number. Number provided: ");
            var13.append(var2);
            throw new IllegalArgumentException(var13.toString());
         } else if (var2 <= 9999) {
            if (var3 != null) {
               if (var3.length() <= 9) {
                  this.a = var1;
                  this.b = var2;
                  this.c = var3;
               } else {
                  StringBuilder var10 = new StringBuilder();
                  var10.append("Provided label is too long. Label provided: ");
                  var10.append(var3);
                  throw new IllegalArgumentException(var10.toString());
               }
            } else {
               throw new IllegalArgumentException("No label specified");
            }
         } else {
            StringBuilder var7 = new StringBuilder();
            var7.append("Ad height must be less then 9999. Number provided: ");
            var7.append(var2);
            throw new IllegalArgumentException(var7.toString());
         }
      } else {
         StringBuilder var4 = new StringBuilder();
         var4.append("Ad width must be less then 9999. Number provided: ");
         var4.append(var1);
         throw new IllegalArgumentException(var4.toString());
      }
   }

   private AppLovinAdSize(String var1) {
      this(0, 0, var1);
   }

   public static Set allSizes() {
      HashSet var0 = new HashSet(4);
      var0.add(BANNER);
      var0.add(MREC);
      var0.add(INTERSTITIAL);
      var0.add(LEADER);
      return var0;
   }

   public static AppLovinAdSize fromString(String var0) {
      if ("BANNER".equalsIgnoreCase(var0)) {
         return BANNER;
      } else if ("MREC".equalsIgnoreCase(var0)) {
         return MREC;
      } else if ("LEADER".equalsIgnoreCase(var0)) {
         return LEADER;
      } else if (!"INTERSTITIAL".equalsIgnoreCase(var0) && !"INTER".equalsIgnoreCase(var0)) {
         if ("NATIVE".equalsIgnoreCase(var0)) {
            return NATIVE;
         } else {
            StringBuilder var1 = new StringBuilder();
            var1.append("Unknown Ad Size: ");
            var1.append(var0);
            throw new IllegalArgumentException(var1.toString());
         }
      } else {
         return INTERSTITIAL;
      }
   }

   public int getHeight() {
      return this.b;
   }

   public String getLabel() {
      return this.c.toUpperCase(Locale.ENGLISH);
   }

   public int getWidth() {
      return this.a;
   }

   public String toString() {
      return this.getLabel();
   }
}
