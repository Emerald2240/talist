package com.applovin.impl.mediation.a.c.b.a;

import android.text.SpannedString;
import com.applovin.impl.mediation.a.a.c;

public class a extends c {
   final String d;
   final int e;
   final int f;
   final boolean g;

   private a(com.applovin.impl.mediation.a.c.b.a.a.a var1) {
      super(var1.d);
      this.b = var1.a;
      this.c = var1.b;
      this.d = var1.c;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
   }

   // $FF: synthetic method
   a(com.applovin.impl.mediation.a.c.b.a.a.a var1, a$1 var2) {
      this(var1);
   }

   public static com.applovin.impl.mediation.a.c.b.a.a.a j() {
      return new com.applovin.impl.mediation.a.c.b.a.a.a();
   }

   public boolean b() {
      return this.g;
   }

   public int g() {
      return this.e;
   }

   public int h() {
      return this.f;
   }

   public String i() {
      return this.d;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("NetworkDetailListItemViewModel{text=");
      var1.append(this.b);
      var1.append(", detailText=");
      var1.append(this.b);
      var1.append("}");
      return var1.toString();
   }

   public static class a {
      SpannedString a;
      SpannedString b;
      String c;
      c.a d;
      int e;
      int f;
      boolean g;

      public a() {
         this.d = c.a.c;
         this.g = false;
      }

      public com.applovin.impl.mediation.a.c.b.a.a.a a(int var1) {
         this.e = var1;
         return this;
      }

      public com.applovin.impl.mediation.a.c.b.a.a.a a(SpannedString var1) {
         this.b = var1;
         return this;
      }

      public com.applovin.impl.mediation.a.c.b.a.a.a a(c.a var1) {
         this.d = var1;
         return this;
      }

      public com.applovin.impl.mediation.a.c.b.a.a.a a(String var1) {
         this.a = new SpannedString(var1);
         return this;
      }

      public com.applovin.impl.mediation.a.c.b.a.a.a a(boolean var1) {
         this.g = var1;
         return this;
      }

      public com.applovin.impl.mediation.a.c.b.a.a a() {
         return new com.applovin.impl.mediation.a.c.b.a.a(this, (a$1)null);
      }

      public com.applovin.impl.mediation.a.c.b.a.a.a b(int var1) {
         this.f = var1;
         return this;
      }

      public com.applovin.impl.mediation.a.c.b.a.a.a b(String var1) {
         return this.a(new SpannedString(var1));
      }

      public com.applovin.impl.mediation.a.c.b.a.a.a c(String var1) {
         this.c = var1;
         return this;
      }
   }
}
