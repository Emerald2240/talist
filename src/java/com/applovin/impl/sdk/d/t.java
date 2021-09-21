package com.applovin.impl.sdk.d;

import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

abstract class t extends com.applovin.impl.sdk.d.a {
   private final AppLovinAdLoadListener a;
   private final t.a c;

   t(com.applovin.impl.a.c var1, AppLovinAdLoadListener var2, com.applovin.impl.sdk.j var3) {
      super("TaskProcessVastResponse", var3);
      if (var1 != null) {
         this.a = var2;
         this.c = (t.a)var1;
      } else {
         throw new IllegalArgumentException("No context specified.");
      }
   }

   public static t a(com.applovin.impl.sdk.utils.s var0, com.applovin.impl.a.c var1, AppLovinAdLoadListener var2, com.applovin.impl.sdk.j var3) {
      return new t.c(var0, var1, var2, var3);
   }

   public static t a(JSONObject var0, JSONObject var1, com.applovin.impl.sdk.ad.b var2, AppLovinAdLoadListener var3, com.applovin.impl.sdk.j var4) {
      return new t.b(new t.a(var0, var1, var2, var4), var3, var4);
   }

   void a(com.applovin.impl.a.d var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Failed to process VAST response due to VAST error code ");
      var2.append(var1);
      this.d(var2.toString());
      com.applovin.impl.a.i.a(this.c, this.a, var1, -6, this.b);
   }

   void a(com.applovin.impl.sdk.utils.s var1) {
      Object var7;
      label19: {
         int var2 = this.c.a();
         StringBuilder var3 = new StringBuilder();
         var3.append("Finished parsing XML at depth ");
         var3.append(var2);
         this.a((String)var3.toString());
         this.c.a(var1);
         com.applovin.impl.a.d var6;
         if (com.applovin.impl.a.i.a(var1)) {
            int var8 = (Integer)this.b.a(com.applovin.impl.sdk.b.d.eJ);
            if (var2 < var8) {
               this.a((String)"VAST response is wrapper. Resolving...");
               var7 = new aa(this.c, this.a, this.b);
               break label19;
            }

            StringBuilder var9 = new StringBuilder();
            var9.append("Reached beyond max wrapper depth of ");
            var9.append(var8);
            this.d(var9.toString());
            var6 = com.applovin.impl.a.d.e;
         } else {
            if (com.applovin.impl.a.i.b(var1)) {
               this.a((String)"VAST response is inline. Rendering ad...");
               var7 = new w(this.c, this.a, this.b);
               break label19;
            }

            this.d("VAST response is an error");
            var6 = com.applovin.impl.a.d.f;
         }

         this.a(var6);
         return;
      }

      this.b.K().a((com.applovin.impl.sdk.d.a)var7);
   }

   private static final class a extends com.applovin.impl.a.c {
      a(JSONObject var1, JSONObject var2, com.applovin.impl.sdk.ad.b var3, com.applovin.impl.sdk.j var4) {
         super(var1, var2, var3, var4);
      }

      void a(com.applovin.impl.sdk.utils.s var1) {
         if (var1 != null) {
            this.a.add(var1);
         } else {
            throw new IllegalArgumentException("No aggregated vast response specified");
         }
      }
   }

   private static final class b extends t {
      private final JSONObject a;

      b(com.applovin.impl.a.c var1, AppLovinAdLoadListener var2, com.applovin.impl.sdk.j var3) {
         super(var1, var2, var3);
         if (var2 != null) {
            this.a = var1.c();
         } else {
            throw new IllegalArgumentException("No callback specified.");
         }
      }

      public com.applovin.impl.sdk.c.i a() {
         return com.applovin.impl.sdk.c.i.s;
      }

      public void run() {
         this.a("Processing SDK JSON response...");
         String var1 = com.applovin.impl.sdk.utils.i.b(this.a, "xml", (String)null, this.b);
         com.applovin.impl.a.d var2;
         if (com.applovin.impl.sdk.utils.n.b(var1)) {
            if (var1.length() < (Integer)this.b.a(com.applovin.impl.sdk.b.d.eI)) {
               try {
                  this.a(com.applovin.impl.sdk.utils.t.a(var1, this.b));
                  return;
               } catch (Throwable var5) {
                  this.a("Unable to parse VAST response", var5);
                  this.a(com.applovin.impl.a.d.b);
                  this.b.M().a(this.a());
                  return;
               }
            }

            this.d("VAST response is over max length");
            var2 = com.applovin.impl.a.d.b;
         } else {
            this.d("No VAST response received.");
            var2 = com.applovin.impl.a.d.f;
         }

         this.a(var2);
      }
   }

   private static final class c extends t {
      private final com.applovin.impl.sdk.utils.s a;

      c(com.applovin.impl.sdk.utils.s var1, com.applovin.impl.a.c var2, AppLovinAdLoadListener var3, com.applovin.impl.sdk.j var4) {
         super(var2, var3, var4);
         if (var1 != null) {
            if (var2 != null) {
               if (var3 != null) {
                  this.a = var1;
               } else {
                  throw new IllegalArgumentException("No callback specified.");
               }
            } else {
               throw new IllegalArgumentException("No context specified.");
            }
         } else {
            throw new IllegalArgumentException("No response specified.");
         }
      }

      public com.applovin.impl.sdk.c.i a() {
         return com.applovin.impl.sdk.c.i.t;
      }

      public void run() {
         this.a("Processing VAST Wrapper response...");
         this.a(this.a);
      }
   }
}
