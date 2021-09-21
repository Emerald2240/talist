package com.applovin.impl.mediation;

import android.os.Bundle;

public class f {
   private final Bundle a;

   private f(f.a var1) {
      this.a = var1.a;
   }

   // $FF: synthetic method
   f(f.a var1, Object var2) {
      this(var1);
   }

   public Bundle a() {
      return this.a;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediatedRequestParameters{extraParameters=");
      var1.append(this.a);
      var1.append('}');
      return var1.toString();
   }

   public static class a {
      private final Bundle a = new Bundle();

      public f.a a(String var1) {
         if (var1 != null) {
            this.a.remove(var1);
            return this;
         } else {
            throw new IllegalArgumentException("No key specified.");
         }
      }

      public f.a a(String var1, String var2) {
         if (var1 != null) {
            this.a.putString(var1, var2);
            return this;
         } else {
            throw new IllegalArgumentException("No key specified");
         }
      }

      public f a() {
         return new f(this);
      }
   }
}
