package com.noqoush.adfalcon.android.sdk.video.vast.manager;

public class h {
   public static int a(String var0, int var1) {
      if (var0 != null) {
         if (var0.length() == 0) {
            return 0;
         } else {
            int var7;
            try {
               if (!var0.contains("%")) {
                  String[] var3 = var0.split(":");
                  int var4 = com.noqoush.adfalcon.android.sdk.util.d.b(var3[0]);
                  int var5 = com.noqoush.adfalcon.android.sdk.util.d.b(var3[1]);
                  int var6 = com.noqoush.adfalcon.android.sdk.util.d.b(var0.split(":")[2].split("\\.")[0]);
                  return var6 + var4 * 3600 + var5 * 60;
               }

               var7 = com.noqoush.adfalcon.android.sdk.util.d.b(var0.replace("%", ""));
            } catch (Exception var15) {
               return 0;
            }

            double var8 = (double)var1;
            double var10 = (double)var7;
            Double.isNaN(var10);
            double var13 = var10 / 100.0D;
            Double.isNaN(var8);
            return (int)(var8 * var13);
         }
      } else {
         return 0;
      }
   }

   public static String a(double var0) {
      double var2 = var0 / 3600.0D;

      Exception var10000;
      label33: {
         boolean var10001;
         double var5;
         try {
            var5 = Math.floor(var2);
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
            break label33;
         }

         double var7 = var0 - 60.0D * var5 * 60.0D;

         double var9;
         try {
            var9 = Math.floor(var7 / 60.0D);
         } catch (Exception var16) {
            var10000 = var16;
            var10001 = false;
            break label33;
         }

         double var11 = var7 - 60.0D * var9;

         try {
            Object[] var13 = new Object[]{(int)var5, (int)var9, (int)var11};
            String var14 = String.format("%2d:%2d:%2d", var13).replace(" ", "0");
            return var14;
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
         }
      }

      Exception var4 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      return "00:00:00";
   }
}
