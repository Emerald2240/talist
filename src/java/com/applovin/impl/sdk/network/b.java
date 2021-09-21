package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b {
   private String a;
   private String b;
   private Map c;
   private Map d;
   private final JSONObject e;
   private String f;
   private final Object g;
   private final boolean h;
   private final int i;
   private int j;
   private final int k;
   private final int l;
   private final boolean m;
   private final boolean n;

   protected b(b.a var1) {
      this.a = var1.b;
      this.b = var1.a;
      this.c = var1.d;
      this.d = var1.e;
      this.e = var1.f;
      this.f = var1.c;
      this.g = var1.g;
      this.h = var1.h;
      this.i = var1.i;
      this.j = var1.i;
      this.k = var1.j;
      this.l = var1.k;
      this.m = var1.l;
      this.n = var1.m;
   }

   public static b.a a(j var0) {
      return new b.a(var0);
   }

   public String a() {
      return this.a;
   }

   public void a(int var1) {
      this.j = var1;
   }

   public void a(String var1) {
      this.a = var1;
   }

   public String b() {
      return this.b;
   }

   public void b(String var1) {
      this.b = var1;
   }

   public Map c() {
      return this.c;
   }

   public Map d() {
      return this.d;
   }

   public JSONObject e() {
      return this.e;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof b)) {
         return false;
      } else {
         b var2 = (b)var1;
         String var3 = this.a;
         if (var3 != null) {
            if (!var3.equals(var2.a)) {
               return false;
            }
         } else if (var2.a != null) {
            return false;
         }

         Map var4 = this.c;
         if (var4 != null) {
            if (!var4.equals(var2.c)) {
               return false;
            }
         } else if (var2.c != null) {
            return false;
         }

         Map var5 = this.d;
         if (var5 != null) {
            if (!var5.equals(var2.d)) {
               return false;
            }
         } else if (var2.d != null) {
            return false;
         }

         String var6 = this.f;
         if (var6 != null) {
            if (!var6.equals(var2.f)) {
               return false;
            }
         } else if (var2.f != null) {
            return false;
         }

         String var7 = this.b;
         if (var7 != null) {
            if (!var7.equals(var2.b)) {
               return false;
            }
         } else if (var2.b != null) {
            return false;
         }

         JSONObject var8 = this.e;
         if (var8 != null) {
            if (!var8.equals(var2.e)) {
               return false;
            }
         } else if (var2.e != null) {
            return false;
         }

         Object var9 = this.g;
         if (var9 != null) {
            if (!var9.equals(var2.g)) {
               return false;
            }
         } else if (var2.g != null) {
            return false;
         }

         if (this.h != var2.h) {
            return false;
         } else if (this.i != var2.i) {
            return false;
         } else if (this.j != var2.j) {
            return false;
         } else if (this.k != var2.k) {
            return false;
         } else if (this.l != var2.l) {
            return false;
         } else if (this.m != var2.m) {
            return false;
         } else {
            return this.n == var2.n;
         }
      }
   }

   public String f() {
      return this.f;
   }

   public Object g() {
      return this.g;
   }

   public boolean h() {
      return this.h;
   }

   public int hashCode() {
      int var1 = 31 * super.hashCode();
      String var2 = this.a;
      int var3;
      if (var2 != null) {
         var3 = var2.hashCode();
      } else {
         var3 = 0;
      }

      int var4 = 31 * (var1 + var3);
      String var5 = this.f;
      int var6;
      if (var5 != null) {
         var6 = var5.hashCode();
      } else {
         var6 = 0;
      }

      int var7 = 31 * (var4 + var6);
      String var8 = this.b;
      int var9;
      if (var8 != null) {
         var9 = var8.hashCode();
      } else {
         var9 = 0;
      }

      int var10 = 31 * (var7 + var9);
      Object var11 = this.g;
      int var12 = 0;
      if (var11 != null) {
         var12 = var11.hashCode();
      }

      int var13 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (var10 + var12) + this.h) + this.i) + this.j) + this.k) + this.l) + this.m) + this.n;
      Map var14 = this.c;
      if (var14 != null) {
         var13 = var13 * 31 + var14.hashCode();
      }

      Map var15 = this.d;
      if (var15 != null) {
         var13 = var13 * 31 + var15.hashCode();
      }

      JSONObject var16 = this.e;
      if (var16 != null) {
         char[] var17 = var16.toString().toCharArray();
         Arrays.sort(var17);
         String var18 = new String(var17);
         var13 = var13 * 31 + var18.hashCode();
      }

      return var13;
   }

   public int i() {
      return this.i - this.j;
   }

   public int j() {
      return this.j;
   }

   public int k() {
      return this.k;
   }

   public int l() {
      return this.l;
   }

   public boolean m() {
      return this.m;
   }

   public boolean n() {
      return this.n;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("HttpRequest {endpoint=");
      var1.append(this.a);
      var1.append(", backupEndpoint=");
      var1.append(this.f);
      var1.append(", httpMethod=");
      var1.append(this.b);
      var1.append(", httpHeaders=");
      var1.append(this.d);
      var1.append(", body=");
      var1.append(this.e);
      var1.append(", emptyResponse=");
      var1.append(this.g);
      var1.append(", requiresResponse=");
      var1.append(this.h);
      var1.append(", initialRetryAttempts=");
      var1.append(this.i);
      var1.append(", retryAttemptsLeft=");
      var1.append(this.j);
      var1.append(", timeoutMillis=");
      var1.append(this.k);
      var1.append(", retryDelayMillis=");
      var1.append(this.l);
      var1.append(", encodingEnabled=");
      var1.append(this.m);
      var1.append(", trackConnectionSpeed=");
      var1.append(this.n);
      var1.append('}');
      return var1.toString();
   }

   public static class a {
      String a;
      String b;
      String c;
      Map d;
      Map e;
      JSONObject f;
      Object g;
      boolean h = true;
      int i = 1;
      int j;
      int k;
      boolean l;
      boolean m;

      public a(j var1) {
         this.j = (Integer)var1.a(com.applovin.impl.sdk.b.d.dw);
         this.k = (Integer)var1.a(com.applovin.impl.sdk.b.d.dv);
         this.l = (Boolean)var1.a(com.applovin.impl.sdk.b.d.eR);
         this.d = new HashMap();
      }

      public b.a a(int var1) {
         this.i = var1;
         return this;
      }

      public b.a a(Object var1) {
         this.g = var1;
         return this;
      }

      public b.a a(String var1) {
         this.b = var1;
         return this;
      }

      public b.a a(Map var1) {
         this.d = var1;
         return this;
      }

      public b.a a(JSONObject var1) {
         this.f = var1;
         return this;
      }

      public b.a a(boolean var1) {
         this.l = var1;
         return this;
      }

      public b a() {
         return new b(this);
      }

      public b.a b(int var1) {
         this.j = var1;
         return this;
      }

      public b.a b(String var1) {
         this.a = var1;
         return this;
      }

      public b.a b(boolean var1) {
         this.m = var1;
         return this;
      }

      public b.a c(int var1) {
         this.k = var1;
         return this;
      }

      public b.a c(String var1) {
         this.c = var1;
         return this;
      }
   }
}
