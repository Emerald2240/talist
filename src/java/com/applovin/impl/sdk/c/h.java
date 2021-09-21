package com.applovin.impl.sdk.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
   private final com.applovin.impl.sdk.j a;
   private final Map b = new HashMap();

   public h(com.applovin.impl.sdk.j var1) {
      if (var1 != null) {
         this.a = var1;
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   private void e() {
      try {
         this.a.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.n, (Object)this.c().toString());
      } catch (Throwable var3) {
         this.a.v().b("GlobalStatsManager", "Unable to save stats", var3);
         return;
      }
   }

   public long a(g var1) {
      return this.a(var1, 1L);
   }

   long a(g var1, long var2) {
      Map var4 = this.b;
      synchronized(var4){}

      long var7;
      label189: {
         boolean var10001;
         Throwable var10000;
         label190: {
            Long var6;
            try {
               var6 = (Long)this.b.get(var1.a());
            } catch (Throwable var30) {
               var10000 = var30;
               var10001 = false;
               break label190;
            }

            if (var6 == null) {
               try {
                  var6 = 0L;
               } catch (Throwable var29) {
                  var10000 = var29;
                  var10001 = false;
                  break label190;
               }
            }

            label177:
            try {
               var7 = var2 + var6;
               this.b.put(var1.a(), var7);
               break label189;
            } catch (Throwable var28) {
               var10000 = var28;
               var10001 = false;
               break label177;
            }
         }

         while(true) {
            Throwable var5 = var10000;

            try {
               throw var5;
            } catch (Throwable var27) {
               var10000 = var27;
               var10001 = false;
               continue;
            }
         }
      }

      this.e();
      return var7;
   }

   public void a() {
      // $FF: Couldn't be decompiled
   }

   public long b(g var1) {
      Map var2 = this.b;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label176: {
         Long var4;
         try {
            var4 = (Long)this.b.get(var1.a());
         } catch (Throwable var27) {
            var10000 = var27;
            var10001 = false;
            break label176;
         }

         if (var4 == null) {
            try {
               var4 = 0L;
            } catch (Throwable var26) {
               var10000 = var26;
               var10001 = false;
               break label176;
            }
         }

         label165:
         try {
            long var5 = var4;
            return var5;
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label165;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            continue;
         }
      }
   }

   public void b() {
      Map var1 = this.b;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label203: {
         Iterator var3;
         try {
            var3 = g.b().iterator();
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label203;
         }

         while(true) {
            try {
               if (!var3.hasNext()) {
                  break;
               }

               g var4 = (g)var3.next();
               this.b.remove(var4.a());
            } catch (Throwable var26) {
               var10000 = var26;
               var10001 = false;
               break label203;
            }
         }

         label188:
         try {
            this.e();
            return;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label188;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            continue;
         }
      }
   }

   public void b(g param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public JSONObject c() throws JSONException {
      Map var1 = this.b;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label203: {
         Iterator var4;
         JSONObject var2;
         try {
            var2 = new JSONObject();
            var4 = this.b.entrySet().iterator();
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label203;
         }

         while(true) {
            try {
               if (!var4.hasNext()) {
                  break;
               }

               Entry var5 = (Entry)var4.next();
               var2.put((String)var5.getKey(), var5.getValue());
            } catch (Throwable var27) {
               var10000 = var27;
               var10001 = false;
               break label203;
            }
         }

         label188:
         try {
            return var2;
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label188;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            continue;
         }
      }
   }

   public void c(g param1) {
      // $FF: Couldn't be decompiled
   }

   public void d() {
      // $FF: Couldn't be decompiled
   }
}
