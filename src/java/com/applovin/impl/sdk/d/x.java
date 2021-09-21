package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;

public abstract class x extends a implements com.applovin.impl.sdk.network.a.c {
   private final com.applovin.impl.sdk.network.b a;
   private final com.applovin.impl.sdk.network.a.c c;
   protected com.applovin.impl.sdk.network.a.a d;
   private r.a e;
   private com.applovin.impl.sdk.b.d f;
   private com.applovin.impl.sdk.b.d g;

   public x(com.applovin.impl.sdk.network.b var1, com.applovin.impl.sdk.j var2) {
      this(var1, var2, false);
   }

   public x(com.applovin.impl.sdk.network.b var1, final com.applovin.impl.sdk.j var2, boolean var3) {
      super("TaskRepeatRequest", var2, var3);
      this.e = r.a.c;
      this.f = null;
      this.g = null;
      if (var1 != null) {
         this.a = var1;
         this.d = new com.applovin.impl.sdk.network.a.a();
         this.c = new com.applovin.impl.sdk.network.a.c() {
            public void a(int var1) {
               boolean var2x;
               if (var1 >= 200 && var1 < 500) {
                  var2x = false;
               } else {
                  var2x = true;
               }

               boolean var3;
               if (var1 == 429) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               boolean var4 = false;
               if (var1 != -103) {
                  var4 = true;
               }

               if (var4 && (var2x || var3)) {
                  String var5 = x.this.a.f();
                  if (x.this.a.j() > 0) {
                     x var8 = x.this;
                     StringBuilder var9 = new StringBuilder();
                     var9.append("Unable to send request due to server failure (code ");
                     var9.append(var1);
                     var9.append("). ");
                     var9.append(x.this.a.j());
                     var9.append(" attempts left, retrying in ");
                     var9.append(TimeUnit.MILLISECONDS.toSeconds((long)x.this.a.l()));
                     var9.append(" seconds...");
                     var8.c((String)var9.toString());
                     int var17 = x.this.a.j() - 1;
                     x.this.a.a(var17);
                     if (var17 == 0) {
                        x var20 = x.this;
                        var20.c(var20.f);
                        if (com.applovin.impl.sdk.utils.n.b(var5) && var5.length() >= 4) {
                           x.this.a.a(var5);
                           x var21 = x.this;
                           StringBuilder var22 = new StringBuilder();
                           var22.append("Switching to backup endpoint ");
                           var22.append(var5);
                           var21.b((String)var22.toString());
                        }
                     }

                     r var18 = var2.K();
                     x var19 = x.this;
                     var18.a(var19, var19.e, (long)x.this.a.l());
                     return;
                  }

                  x var6;
                  com.applovin.impl.sdk.b.d var7;
                  if (var5 != null && var5.equals(x.this.a.a())) {
                     var6 = x.this;
                     var7 = var6.g;
                  } else {
                     var6 = x.this;
                     var7 = var6.f;
                  }

                  var6.c(var7);
               }

               x.this.a(var1);
            }

            public void a(Object var1, int var2x) {
               x.this.a.a(0);
               x.this.a(var1, var2x);
            }
         };
      } else {
         throw new IllegalArgumentException("No request specified");
      }
   }

   private void c(com.applovin.impl.sdk.b.d var1) {
      if (var1 != null) {
         com.applovin.impl.sdk.b.e var2 = this.e().C();
         var2.a(var1, var1.b());
         var2.b();
      }

   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.e;
   }

   public abstract void a(int var1);

   public void a(com.applovin.impl.sdk.b.d var1) {
      this.f = var1;
   }

   public void a(r.a var1) {
      this.e = var1;
   }

   public abstract void a(Object var1, int var2);

   public void b(com.applovin.impl.sdk.b.d var1) {
      this.g = var1;
   }

   public void run() {
      com.applovin.impl.sdk.network.a var1 = this.e().J();
      short var2;
      if (!this.e().c() && !this.e().d()) {
         this.d("AppLovin SDK is disabled: please check your connection");
         com.applovin.impl.sdk.p.j("AppLovinSdk", "AppLovin SDK is disabled: please check your connection");
         var2 = -22;
      } else {
         if (com.applovin.impl.sdk.utils.n.b(this.a.a()) && this.a.a().length() >= 4) {
            if (TextUtils.isEmpty(this.a.b())) {
               String var3;
               if (this.a.e() != null) {
                  var3 = "POST";
               } else {
                  var3 = "GET";
               }

               this.a.b(var3);
            }

            var1.a(this.a, this.d, this.c);
            return;
         }

         this.d("Task has an invalid or null request endpoint.");
         var2 = -900;
      }

      this.a(var2);
   }
}
