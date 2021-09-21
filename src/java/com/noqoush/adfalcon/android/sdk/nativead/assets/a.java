package com.noqoush.adfalcon.android.sdk.nativead.assets;

import android.view.View;
import com.noqoush.adfalcon.android.sdk.response.g;
import com.noqoush.adfalcon.android.sdk.response.h;
import com.noqoush.adfalcon.android.sdk.response.i;
import com.noqoush.adfalcon.android.sdk.response.j;

public abstract class a {
   public static final int e = 0;
   public static final int f = 1;
   private int a;
   private String b;
   private String c;
   private int d;

   public a(int var1, int var2, String var3, String var4) throws Exception {
      this.b(var1);
      this.a(var2);
      this.a(var3);
      this.b(var4);
   }

   public String a() {
      return this.b;
   }

   public void a(int var1) throws Exception {
      this.a = var1;
   }

   public void a(View var1, int var2) {
      var1.findViewById(this.d()).setVisibility(var2);
   }

   public void a(com.noqoush.adfalcon.android.sdk.conn.c var1) {
      Object[] var2 = new Object[]{this.b};
      String var3 = String.format("R_N%sRF", var2);
      StringBuilder var4 = new StringBuilder();
      var4.append("");
      String var6;
      if (this.c() == 1) {
         var6 = "true";
      } else {
         var6 = "false";
      }

      var4.append(var6);
      var1.b(var3, var4.toString());
      var1.a("R_NASSETS", this.b());
   }

   public void a(String var1) throws Exception {
      if (var1 != null && var1.length() != 0) {
         this.b = var1;
      } else {
         throw new Exception("Invalid key");
      }
   }

   public abstract boolean a(View var1, com.noqoush.adfalcon.android.sdk.response.f var2);

   public boolean a(com.noqoush.adfalcon.android.sdk.response.f var1) throws Exception {
      if (var1 instanceof i) {
         if (this instanceof f) {
            return true;
         }
      } else if (var1 instanceof g) {
         if (this instanceof c) {
            g var2 = (g)var1;
            StringBuilder var3 = new StringBuilder();
            var3.append("D");
            var3.append(var2.b());
            if (var3.toString().equalsIgnoreCase(this.a())) {
               return true;
            }
         }
      } else if (var1 instanceof h) {
         if (this instanceof e) {
            if (((h)var1).d() == 2) {
               return true;
            }
         } else if (this instanceof d && ((h)var1).d() == 1) {
            return true;
         }
      } else if (var1 instanceof j && this instanceof e) {
         return true;
      }

      return false;
   }

   public String b() {
      return this.c;
   }

   public void b(int var1) {
      this.d = var1;
   }

   public void b(String var1) throws Exception {
      if (var1 != null && var1.length() >= 3) {
         this.c = var1;
      } else {
         throw new Exception("Invalid asset's name");
      }
   }

   public int c() {
      return this.a;
   }

   public int d() {
      return this.d;
   }
}
