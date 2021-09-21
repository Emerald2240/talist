package com.iab.omid.library.adfalcon.a;

public class a {
   public float a(int var1, int var2) {
      if (var2 > 0 && var1 > 0) {
         float var3 = (float)var1 / (float)var2;
         if (var3 > 1.0F) {
            var3 = 1.0F;
         }

         return var3;
      } else {
         return 0.0F;
      }
   }
}
