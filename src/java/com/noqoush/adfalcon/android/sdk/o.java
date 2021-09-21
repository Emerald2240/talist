package com.noqoush.adfalcon.android.sdk;

import com.noqoush.adfalcon.android.sdk.constant.ADFMraidPlacementType;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidState;

class o {
   public static final String p = "top-left";
   public static final String q = "top-right";
   public static final String r = "center";
   public static final String s = "bottom-left";
   public static final String t = "bottom-right";
   public static final String u = "none";
   public static final String v = "portrait";
   public static final String w = "landscape";
   private ADFMraidState a;
   private ADFMraidPlacementType b;
   private boolean c;
   private o.a d;
   private o.c e;
   private o.b f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private int m;
   private int n;
   private boolean o;

   o() {
      this.a = ADFMraidState.LOADING;
      this.b = ADFMraidPlacementType.INLINE;
      this.c = true;
   }

   protected int a() {
      return this.n;
   }

   protected void a(int var1, int var2) {
      this.i = var1;
      this.j = var2;
   }

   protected void a(int var1, int var2, int var3, int var4) {
      this.k = var1;
      this.l = var2;
      this.m = var3;
      this.n = var4;
   }

   public void a(ADFMraidPlacementType var1) {
      this.b = var1;
   }

   public void a(ADFMraidState var1) {
      this.a = var1;
   }

   public void a(o.a var1) {
      this.d = var1;
   }

   protected void a(o.b var1) {
      this.f = var1;
   }

   protected void a(o.c var1) {
      this.e = var1;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public int b() {
      return this.k;
   }

   protected void b(int var1, int var2) {
      this.g = var1;
      this.h = var2;
   }

   protected void b(boolean var1) {
      this.o = var1;
   }

   public int c() {
      return this.l;
   }

   protected int d() {
      return this.m;
   }

   public o.a e() {
      return this.d;
   }

   protected int f() {
      return this.j;
   }

   protected int g() {
      return this.i;
   }

   protected o.b h() {
      return this.f;
   }

   public ADFMraidPlacementType i() {
      return this.b;
   }

   protected o.c j() {
      return this.e;
   }

   protected int k() {
      return this.h;
   }

   protected int l() {
      return this.g;
   }

   public ADFMraidState m() {
      return this.a;
   }

   protected boolean n() {
      return this.o;
   }

   public boolean o() {
      return this.c;
   }

   public class a {
      int a = -1;
      int b = -1;
      boolean c = false;
      boolean d = true;

      public int a() {
         return this.b;
      }

      public void a(int var1) {
         this.b = var1;
      }

      public void a(boolean var1) {
         this.d = var1;
      }

      public int b() {
         return this.a;
      }

      public void b(int var1) {
         this.a = var1;
      }

      public void b(boolean var1) {
         this.c = var1;
      }

      public boolean c() {
         return this.d;
      }

      public boolean d() {
         return this.c;
      }
   }

   protected static class b {
      private boolean a = true;
      private String b = "none";

      public String a() {
         return this.b;
      }

      public void a(String var1) throws Exception {
         if (!var1.equalsIgnoreCase("none") && !var1.equalsIgnoreCase("portrait") && !var1.equalsIgnoreCase("landscape")) {
            throw new Exception("invalid forceOrientation value");
         } else {
            this.b = var1;
         }
      }

      public void a(boolean var1) {
         this.a = var1;
      }

      public boolean b() {
         return this.a;
      }
   }

   public class c {
      int a;
      int b;
      int c;
      int d;
      String e;
      boolean f;

      public String a() {
         return this.e;
      }

      public void a(int var1) throws Exception {
         if (var1 != 0) {
            this.b = var1;
         } else {
            throw new Exception("invalid height");
         }
      }

      public void a(String var1) throws Exception {
         if (var1 != null && var1.length() != 0 && !var1.equalsIgnoreCase("undefined")) {
            if (!var1.equalsIgnoreCase("bottom-left") && !var1.equalsIgnoreCase("bottom-right") && !var1.equalsIgnoreCase("center") && !var1.equalsIgnoreCase("top-left") && !var1.equalsIgnoreCase("top-right")) {
               throw new Exception("invalid value for customClosePosition");
            } else {
               this.e = var1;
            }
         } else {
            throw new Exception("invalid customClosePosition");
         }
      }

      public void a(boolean var1) {
         this.f = var1;
      }

      public int b() {
         return this.b;
      }

      public void b(int var1) {
         this.c = var1;
      }

      public int c() {
         return this.c;
      }

      public void c(int var1) {
         this.d = var1;
      }

      public int d() {
         return this.d;
      }

      public void d(int var1) throws Exception {
         if (var1 != 0) {
            this.a = var1;
         } else {
            throw new Exception("invalid width");
         }
      }

      public int e() {
         return this.a;
      }

      public boolean f() {
         return this.f;
      }
   }
}
