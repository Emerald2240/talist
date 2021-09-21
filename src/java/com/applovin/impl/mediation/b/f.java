package com.applovin.impl.mediation.b;

import com.applovin.impl.mediation.i;

public class f {
   private final g a;
   private final String b;
   private final String c;
   private final String d;
   private final String e;

   private f(g var1, i var2, String var3, String var4) {
      this.a = var1;
      this.e = var4;
      if (var3 != null) {
         int var5 = var1.a();
         this.d = var3.substring(0, Math.min(var3.length(), var5));
      } else {
         this.d = null;
      }

      if (var2 != null) {
         this.b = var2.e();
         this.c = var2.f();
      } else {
         this.b = null;
         this.c = null;
      }
   }

   public static f a(g var0, i var1, String var2) {
      if (var0 != null) {
         if (var1 != null) {
            return new f(var0, var1, var2, (String)null);
         } else {
            throw new IllegalArgumentException("No adapterWrapper specified");
         }
      } else {
         throw new IllegalArgumentException("No spec specified");
      }
   }

   public static f a(g var0, String var1) {
      return b(var0, (i)null, var1);
   }

   public static f b(g var0, i var1, String var2) {
      if (var0 != null) {
         return new f(var0, var1, (String)null, var2);
      } else {
         throw new IllegalArgumentException("No spec specified");
      }
   }

   public g a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public String d() {
      return this.d;
   }

   public String e() {
      return this.e;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("SignalCollectionResult{mSignalProviderSpec=");
      var1.append(this.a);
      var1.append(", mSdkVersion='");
      var1.append(this.b);
      var1.append('\'');
      var1.append(", mAdapterVersion='");
      var1.append(this.c);
      var1.append('\'');
      var1.append(", mSignalDataLength='");
      String var11 = this.d;
      int var12;
      if (var11 != null) {
         var12 = var11.length();
      } else {
         var12 = 0;
      }

      var1.append(var12);
      var1.append('\'');
      var1.append(", mErrorMessage=");
      var1.append(this.e);
      var1.append('}');
      return var1.toString();
   }

   public interface a {
      void a(f var1);
   }
}
