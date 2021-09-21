package com.applovin.impl.sdk.c;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.d.r;
import com.applovin.impl.sdk.utils.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
   private final com.applovin.impl.sdk.j a;
   private final p b;
   private final Object c = new Object();
   private final com.applovin.impl.sdk.c.c.c d = new com.applovin.impl.sdk.c.c.c((c$1)null);

   public c(com.applovin.impl.sdk.j var1) {
      if (var1 != null) {
         this.a = var1;
         this.b = var1.v();
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   // $FF: synthetic method
   static p a(com.applovin.impl.sdk.c.c var0) {
      return var0.b;
   }

   private void a(com.applovin.impl.sdk.c.b var1, long var2, AppLovinAdBase var4) {
      if (var4 != null) {
         if (var1 == null) {
            throw new IllegalArgumentException("No key specified");
         } else if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ey)) {
            Object var5 = this.c;
            synchronized(var5){}

            boolean var10001;
            Throwable var10000;
            label261: {
               String var7;
               label249: {
                  try {
                     if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eC)) {
                        var7 = var1.b();
                        break label249;
                     }
                  } catch (Throwable var28) {
                     var10000 = var28;
                     var10001 = false;
                     break label261;
                  }

                  try {
                     var7 = var1.a();
                  } catch (Throwable var27) {
                     var10000 = var27;
                     var10001 = false;
                     break label261;
                  }
               }

               label240:
               try {
                  this.b(var4).a(var7, var2);
                  return;
               } catch (Throwable var26) {
                  var10000 = var26;
                  var10001 = false;
                  break label240;
               }
            }

            while(true) {
               Throwable var6 = var10000;

               try {
                  throw var6;
               } catch (Throwable var25) {
                  var10000 = var25;
                  var10001 = false;
                  continue;
               }
            }
         }
      } else {
         throw new IllegalArgumentException("No ad specified");
      }
   }

   private void a(com.applovin.impl.sdk.c.b var1, String var2, AppLovinAdBase var3) {
      if (var3 != null) {
         if (var1 == null) {
            throw new IllegalArgumentException("No key specified");
         } else if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ey)) {
            com.applovin.impl.sdk.c.c.c var4 = this.d;
            synchronized(var4){}

            boolean var10001;
            Throwable var10000;
            label262: {
               String var6;
               label250: {
                  try {
                     if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eC)) {
                        var6 = var1.b();
                        break label250;
                     }
                  } catch (Throwable var27) {
                     var10000 = var27;
                     var10001 = false;
                     break label262;
                  }

                  try {
                     var6 = var1.a();
                  } catch (Throwable var26) {
                     var10000 = var26;
                     var10001 = false;
                     break label262;
                  }
               }

               label241:
               try {
                  this.b(var3).a(var6, var2);
                  return;
               } catch (Throwable var25) {
                  var10000 = var25;
                  var10001 = false;
                  break label241;
               }
            }

            while(true) {
               Throwable var5 = var10000;

               try {
                  throw var5;
               } catch (Throwable var24) {
                  var10000 = var24;
                  var10001 = false;
                  continue;
               }
            }
         }
      } else {
         throw new IllegalArgumentException("No ad specified");
      }
   }

   private void a(JSONObject var1) {
      c$1 var2 = new c$1(this, com.applovin.impl.sdk.network.b.a(this.a).a(this.c()).c(this.d()).a(com.applovin.impl.sdk.utils.h.e(this.a)).b("POST").a(var1).b((Integer)this.a.a(com.applovin.impl.sdk.b.d.ez)).a((Integer)this.a.a(com.applovin.impl.sdk.b.d.eA)).a(), this.a);
      var2.a(com.applovin.impl.sdk.b.d.aN);
      var2.b(com.applovin.impl.sdk.b.d.aO);
      this.a.K().a((com.applovin.impl.sdk.d.a)var2, r.a.c);
   }

   private com.applovin.impl.sdk.c.c.a b(AppLovinAdBase var1) {
      Object var2 = this.c;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label186: {
         com.applovin.impl.sdk.c.c.a var5;
         String var4;
         try {
            var4 = var1.getPrimaryKey();
            var5 = (com.applovin.impl.sdk.c.c.a)this.d.get(var4);
         } catch (Throwable var28) {
            var10000 = var28;
            var10001 = false;
            break label186;
         }

         if (var5 == null) {
            com.applovin.impl.sdk.c.c.a var6;
            try {
               var6 = new com.applovin.impl.sdk.c.c.a(var4, var1.getSecondaryKey1(), var1.getSecondaryKey2(), this.a, (c$1)null);
               this.d.put(var4, var6);
            } catch (Throwable var27) {
               var10000 = var27;
               var10001 = false;
               break label186;
            }

            var5 = var6;
         }

         label174:
         try {
            return var5;
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label174;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            continue;
         }
      }
   }

   // $FF: synthetic method
   static Object b(com.applovin.impl.sdk.c.c var0) {
      return var0.c;
   }

   private void b(com.applovin.impl.sdk.c.b var1, long var2, AppLovinAdBase var4) {
      if (var4 != null) {
         if (var1 == null) {
            throw new IllegalArgumentException("No key specified");
         } else if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ey)) {
            Object var5 = this.c;
            synchronized(var5){}

            boolean var10001;
            Throwable var10000;
            label261: {
               String var7;
               label249: {
                  try {
                     if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eC)) {
                        var7 = var1.b();
                        break label249;
                     }
                  } catch (Throwable var28) {
                     var10000 = var28;
                     var10001 = false;
                     break label261;
                  }

                  try {
                     var7 = var1.a();
                  } catch (Throwable var27) {
                     var10000 = var27;
                     var10001 = false;
                     break label261;
                  }
               }

               label240:
               try {
                  this.b(var4).b(var7, var2);
                  return;
               } catch (Throwable var26) {
                  var10000 = var26;
                  var10001 = false;
                  break label240;
               }
            }

            while(true) {
               Throwable var6 = var10000;

               try {
                  throw var6;
               } catch (Throwable var25) {
                  var10000 = var25;
                  var10001 = false;
                  continue;
               }
            }
         }
      } else {
         throw new IllegalArgumentException("No ad specified");
      }
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.c.c.c c(com.applovin.impl.sdk.c.c var0) {
      return var0.d;
   }

   private String c() {
      return com.applovin.impl.sdk.utils.h.a("2.0/s", this.a);
   }

   private String d() {
      return com.applovin.impl.sdk.utils.h.b("2.0/s", this.a);
   }

   private void e() {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ey)) {
         this.a.K().b().execute(new Runnable() {
            public void run() {
               // $FF: Couldn't be decompiled
            }
         });
      }
   }

   public com.applovin.impl.sdk.c.c.b a(AppLovinAdBase var1) {
      return new com.applovin.impl.sdk.c.c.b(var1, this);
   }

   public void a() {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ey)) {
         Set var1 = (Set)this.a.b(com.applovin.impl.sdk.b.f.u, new HashSet(0));
         this.a.b(com.applovin.impl.sdk.b.f.u);
         if (var1 != null && !var1.isEmpty()) {
            p var2 = this.b;
            StringBuilder var3 = new StringBuilder();
            var3.append("De-serializing ");
            var3.append(var1.size());
            var3.append(" stat ad events");
            var2.b("AdEventStatsManager", var3.toString());
            JSONArray var7 = new JSONArray();
            Iterator var8 = var1.iterator();

            while(var8.hasNext()) {
               String var12 = (String)var8.next();

               try {
                  var7.put(new JSONObject(var12));
               } catch (JSONException var17) {
                  p var14 = this.b;
                  StringBuilder var15 = new StringBuilder();
                  var15.append("Failed to parse: ");
                  var15.append(var12);
                  var14.b("AdEventStatsManager", var15.toString(), var17);
               }
            }

            try {
               JSONObject var9 = new JSONObject();
               var9.put("stats", var7);
               this.a(var9);
               return;
            } catch (JSONException var16) {
               this.b.b("AdEventStatsManager", "Failed to create stats to submit", var16);
               return;
            }
         }

         this.b.b("AdEventStatsManager", "No serialized ad events found");
      }

   }

   public void b() {
      // $FF: Couldn't be decompiled
   }

   private static class a {
      private final com.applovin.impl.sdk.j a;
      private final JSONObject b;

      private a(String var1, String var2, String var3, com.applovin.impl.sdk.j var4) {
         this.b = new JSONObject();
         this.a = var4;
         com.applovin.impl.sdk.utils.i.a(this.b, "pk", var1, var4);
         com.applovin.impl.sdk.utils.i.b(this.b, "ts", System.currentTimeMillis(), var4);
         if (n.b(var2)) {
            com.applovin.impl.sdk.utils.i.a(this.b, "sk1", var2, var4);
         }

         if (n.b(var3)) {
            com.applovin.impl.sdk.utils.i.a(this.b, "sk2", var3, var4);
         }

      }

      // $FF: synthetic method
      a(String var1, String var2, String var3, com.applovin.impl.sdk.j var4, c$1 var5) {
         this(var1, var2, var3, var4);
      }

      private String a() throws OutOfMemoryError {
         return this.b.toString();
      }

      // $FF: synthetic method
      static String a(com.applovin.impl.sdk.c.c.a var0) throws OutOfMemoryError {
         return var0.a();
      }

      void a(String var1, long var2) {
         this.b(var1, var2 + com.applovin.impl.sdk.utils.i.a(this.b, var1, 0L, this.a));
      }

      void a(String var1, String var2) {
         JSONArray var3 = com.applovin.impl.sdk.utils.i.b(this.b, var1, new JSONArray(), this.a);
         var3.put(var2);
         com.applovin.impl.sdk.utils.i.a(this.b, var1, var3, this.a);
      }

      void b(String var1, long var2) {
         com.applovin.impl.sdk.utils.i.b(this.b, var1, var2, this.a);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("AdEventStats{stats='");
         var1.append(this.b);
         var1.append('\'');
         var1.append('}');
         return var1.toString();
      }
   }

   public class b {
      private final AppLovinAdBase b;
      private final com.applovin.impl.sdk.c.c c;

      public b(AppLovinAdBase var2, com.applovin.impl.sdk.c.c var3) {
         this.b = var2;
         this.c = var3;
      }

      public com.applovin.impl.sdk.c.c.b a(com.applovin.impl.sdk.c.b var1) {
         this.c.a(var1, 1L, this.b);
         return this;
      }

      public com.applovin.impl.sdk.c.c.b a(com.applovin.impl.sdk.c.b var1, long var2) {
         this.c.b(var1, var2, this.b);
         return this;
      }

      public com.applovin.impl.sdk.c.c.b a(com.applovin.impl.sdk.c.b var1, String var2) {
         this.c.a(var1, var2, this.b);
         return this;
      }

      public void a() {
         this.c.e();
      }
   }

   private class c extends LinkedHashMap {
      private c() {
      }

      // $FF: synthetic method
      c(c$1 var2) {
         this();
      }

      protected boolean removeEldestEntry(Entry var1) {
         return this.size() > (Integer)c.this.a.a(com.applovin.impl.sdk.b.d.eB);
      }
   }
}
