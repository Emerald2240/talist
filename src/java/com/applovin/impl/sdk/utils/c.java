package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

public class c {
   private static c a;
   private static final Object b = new Object();
   private final Bundle c;
   private final int d;

   private c(Context var1) {
      boolean var10001;
      Bundle var3;
      Throwable var10000;
      label663: {
         label667: {
            NameNotFoundException var2;
            try {
               try {
                  var3 = var1.getPackageManager().getApplicationInfo(var1.getPackageName(), 128).metaData;
                  break label663;
               } catch (NameNotFoundException var75) {
                  var2 = var75;
               }
            } catch (Throwable var76) {
               var10000 = var76;
               var10001 = false;
               break label667;
            }

            try {
               com.applovin.impl.sdk.p.c("AndroidManifest", "Failed to get meta data.", var2);
            } catch (Throwable var74) {
               var10000 = var74;
               var10001 = false;
               break label667;
            }

            var3 = null;
            break label663;
         }

         Throwable var12 = var10000;
         this.c = null;
         throw var12;
      }

      this.c = var3;

      int var8;
      XmlResourceParser var7;
      try {
         var7 = var1.getAssets().openXmlResourceParser("AndroidManifest.xml");
         var8 = var7.getEventType();
      } finally {
         ;
      }

      int var5 = 0;

      do {
         label672: {
            if (2 == var8) {
               label671: {
                  try {
                     if (!var7.getName().equals("application")) {
                        break label671;
                     }
                  } catch (Throwable var72) {
                     var10000 = var72;
                     var10001 = false;
                     break label672;
                  }

                  int var9 = 0;

                  while(true) {
                     try {
                        if (var9 >= var7.getAttributeCount()) {
                           break;
                        }

                        String var10 = var7.getAttributeName(var9);
                        String var11 = var7.getAttributeValue(var9);
                        if (var10.equals("networkSecurityConfig")) {
                           var5 = Integer.valueOf(var11.substring(1));
                           break;
                        }
                     } catch (Throwable var73) {
                        var10000 = var73;
                        var10001 = false;
                        break label672;
                     }

                     ++var9;
                  }
               }
            }

            label630:
            try {
               var8 = var7.next();
               continue;
            } catch (Throwable var71) {
               var10000 = var71;
               var10001 = false;
               break label630;
            }
         }

         Throwable var4 = var10000;

         try {
            com.applovin.impl.sdk.p.c("AndroidManifest", "Failed to parse AndroidManifest.xml.", var4);
            break;
         } finally {
            this.d = var5;
         }
      } while(var8 != 1);

   }

   public static c a(Context var0) {
      Object var1 = b;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label122: {
         try {
            if (a == null) {
               a = new c(var0);
            }
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            c var3 = a;
            return var3;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            continue;
         }
      }
   }

   public String a(String var1, String var2) {
      return this.c.getString(var1, var2);
   }

   public boolean a() {
      return this.d != 0;
   }

   public boolean a(String var1) {
      return this.c.containsKey(var1);
   }

   public boolean a(String var1, boolean var2) {
      return this.c.getBoolean(var1, var2);
   }
}
