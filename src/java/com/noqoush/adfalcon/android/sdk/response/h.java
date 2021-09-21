package com.noqoush.adfalcon.android.sdk.response;

public class h extends f {
   public static final int f = 1;
   public static final int g = 2;
   public static final int h = 3;
   int a;
   String b;
   b c;
   int d;
   int e;

   public String a() {
      int var1 = this.d();
      if (var1 != 1) {
         return var1 != 2 && var1 == 3 ? "DAA_ICON" : "MASS";
      } else {
         return "I";
      }
   }

   public void a(int var1) {
      this.e = var1;
   }

   public void a(b var1) {
      this.c = var1;
      if (var1 != null && var1.a() != null) {
         this.a(this.c.a());
         this.b(3);
         this.c(20);
         this.a(20);
      }

   }

   public void a(String var1) {
      this.b = var1;
   }

   public b b() {
      return this.c;
   }

   public void b(int var1) {
      this.a = var1;
   }

   public int c() {
      return this.e;
   }

   public void c(int var1) {
      this.d = var1;
   }

   public int d() {
      return this.a;
   }

   public String e() {
      return this.b;
   }

   public int f() {
      return this.d;
   }
}
