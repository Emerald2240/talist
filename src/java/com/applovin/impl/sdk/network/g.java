package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import java.util.Map;
import org.json.JSONObject;

public class g extends b {
   private String a;

   protected g(g.a var1) {
      super(var1);
      this.a = var1.n;
   }

   public static g.a b(j var0) {
      return new g.a(var0);
   }

   public boolean o() {
      return this.a != null;
   }

   public String p() {
      return this.a;
   }

   public static class a extends b.a {
      private String n;

      public a(j var1) {
         super(var1);
         this.h = false;
         this.i = (Integer)var1.a(com.applovin.impl.sdk.b.d.dt);
         this.j = (Integer)var1.a(com.applovin.impl.sdk.b.d.ds);
         this.k = (Integer)var1.a(com.applovin.impl.sdk.b.d.dv);
      }

      // $FF: synthetic method
      public b.a a(int var1) {
         return this.d(var1);
      }

      // $FF: synthetic method
      public b.a a(Object var1) {
         return this.b(var1);
      }

      // $FF: synthetic method
      public b.a a(String var1) {
         return this.d(var1);
      }

      // $FF: synthetic method
      public b.a a(Map var1) {
         return this.b(var1);
      }

      // $FF: synthetic method
      public b.a a(JSONObject var1) {
         return this.b(var1);
      }

      // $FF: synthetic method
      public b.a a(boolean var1) {
         return this.c(var1);
      }

      // $FF: synthetic method
      public b a() {
         return this.b();
      }

      // $FF: synthetic method
      public b.a b(int var1) {
         return this.e(var1);
      }

      // $FF: synthetic method
      public b.a b(String var1) {
         return this.f(var1);
      }

      public g.a b(Object var1) {
         this.g = var1;
         return this;
      }

      public g.a b(Map var1) {
         this.d = var1;
         return this;
      }

      public g.a b(JSONObject var1) {
         this.f = var1;
         return this;
      }

      public g b() {
         return new g(this);
      }

      // $FF: synthetic method
      public b.a c(int var1) {
         return this.f(var1);
      }

      // $FF: synthetic method
      public b.a c(String var1) {
         return this.e(var1);
      }

      public g.a c(Map var1) {
         this.e = var1;
         return this;
      }

      public g.a c(boolean var1) {
         this.l = var1;
         return this;
      }

      public g.a d(int var1) {
         this.i = var1;
         return this;
      }

      public g.a d(String var1) {
         this.b = var1;
         return this;
      }

      public g.a e(int var1) {
         this.j = var1;
         return this;
      }

      public g.a e(String var1) {
         this.c = var1;
         return this;
      }

      public g.a f(int var1) {
         this.k = var1;
         return this;
      }

      public g.a f(String var1) {
         this.a = var1;
         return this;
      }

      public g.a g(String var1) {
         this.n = var1;
         return this;
      }
   }
}
