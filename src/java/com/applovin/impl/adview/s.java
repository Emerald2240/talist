package com.applovin.impl.adview;

import org.json.JSONObject;

public class s {
   private final int a;
   private final int b;
   private final int c;
   private final int d;
   private final boolean e;
   private final int f;
   private final int g;
   private final int h;
   private final float i;
   private final float j;

   public s(JSONObject var1, com.applovin.impl.sdk.j var2) {
      com.applovin.impl.sdk.p var3 = var2.v();
      StringBuilder var4 = new StringBuilder();
      var4.append("Updating video button properties with JSON = ");
      var4.append(com.applovin.impl.sdk.utils.i.d(var1));
      var3.c("VideoButtonProperties", var4.toString());
      this.a = com.applovin.impl.sdk.utils.i.b(var1, "width", 64, var2);
      this.b = com.applovin.impl.sdk.utils.i.b(var1, "height", 7, var2);
      this.c = com.applovin.impl.sdk.utils.i.b(var1, "margin", 20, var2);
      this.d = com.applovin.impl.sdk.utils.i.b(var1, "gravity", 85, var2);
      this.e = com.applovin.impl.sdk.utils.i.a(var1, "tap_to_fade", false, var2);
      this.f = com.applovin.impl.sdk.utils.i.b(var1, "tap_to_fade_duration_milliseconds", 500, var2);
      this.g = com.applovin.impl.sdk.utils.i.b(var1, "fade_in_duration_milliseconds", 500, var2);
      this.h = com.applovin.impl.sdk.utils.i.b(var1, "fade_out_duration_milliseconds", 500, var2);
      this.i = com.applovin.impl.sdk.utils.i.a(var1, "fade_in_delay_seconds", 1.0F, var2);
      this.j = com.applovin.impl.sdk.utils.i.a(var1, "fade_out_delay_seconds", 6.0F, var2);
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   public int c() {
      return this.c;
   }

   public int d() {
      return this.d;
   }

   public boolean e() {
      return this.e;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null) {
         if (this.getClass() != var1.getClass()) {
            return false;
         } else {
            s var2 = (s)var1;
            if (this.a != var2.a) {
               return false;
            } else if (this.b != var2.b) {
               return false;
            } else if (this.c != var2.c) {
               return false;
            } else if (this.d != var2.d) {
               return false;
            } else if (this.e != var2.e) {
               return false;
            } else if (this.f != var2.f) {
               return false;
            } else if (this.g != var2.g) {
               return false;
            } else if (this.h != var2.h) {
               return false;
            } else if (Float.compare(var2.i, this.i) != 0) {
               return false;
            } else {
               return Float.compare(var2.j, this.j) == 0;
            }
         }
      } else {
         return false;
      }
   }

   public long f() {
      return (long)this.f;
   }

   public long g() {
      return (long)this.g;
   }

   public long h() {
      return (long)this.h;
   }

   public int hashCode() {
      int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * this.a + this.b) + this.c) + this.d) + this.e) + this.f) + this.g) + this.h);
      float var2 = this.i;
      int var3;
      if (var2 != 0.0F) {
         var3 = Float.floatToIntBits(var2);
      } else {
         var3 = 0;
      }

      int var4 = 31 * (var1 + var3);
      float var5 = this.j;
      float var8;
      int var6 = (var8 = var5 - 0.0F) == 0.0F ? 0 : (var8 < 0.0F ? -1 : 1);
      int var7 = 0;
      if (var6 != 0) {
         var7 = Float.floatToIntBits(var5);
      }

      return var4 + var7;
   }

   public float i() {
      return this.i;
   }

   public float j() {
      return this.j;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VideoButtonProperties{widthPercentOfScreen=");
      var1.append(this.a);
      var1.append(", heightPercentOfScreen=");
      var1.append(this.b);
      var1.append(", margin=");
      var1.append(this.c);
      var1.append(", gravity=");
      var1.append(this.d);
      var1.append(", tapToFade=");
      var1.append(this.e);
      var1.append(", tapToFadeDurationMillis=");
      var1.append(this.f);
      var1.append(", fadeInDurationMillis=");
      var1.append(this.g);
      var1.append(", fadeOutDurationMillis=");
      var1.append(this.h);
      var1.append(", fadeInDelay=");
      var1.append(this.i);
      var1.append(", fadeOutDelay=");
      var1.append(this.j);
      var1.append('}');
      return var1.toString();
   }
}
