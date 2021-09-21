package com.applovin.impl.sdk.ad;

import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
   private final com.applovin.impl.sdk.j a;
   private final p b;
   private LinkedHashSet c;
   private final Object d = new Object();
   private volatile boolean e;

   public e(com.applovin.impl.sdk.j var1) {
      this.a = var1;
      this.b = var1.v();
      this.c = this.b();
   }

   private LinkedHashSet b() {
      LinkedHashSet var1 = new LinkedHashSet();

      try {
         String var14 = (String)this.a.a(com.applovin.impl.sdk.b.f.t);
         if (n.b(var14)) {
            JSONArray var15 = new JSONArray(var14);
            if (var15.length() > 0) {
               var1 = this.b(var15);
            } else {
               p var16 = this.b;
               StringBuilder var17 = new StringBuilder();
               var17.append("Unable to inflate json string: ");
               var17.append(var14);
               var16.b("AdZoneManager", var17.toString());
            }
         }
      } catch (Throwable var31) {
         Throwable var2 = var31;
         boolean var27 = false;

         try {
            var27 = true;
            this.b.b("AdZoneManager", "Encountered error retrieving persisted zones", var2);
            var27 = false;
         } finally {
            if (var27) {
               if (!var1.isEmpty()) {
                  p var4 = this.b;
                  StringBuilder var5 = new StringBuilder();
                  var5.append("Retrieved persisted zones: ");
                  var5.append(var1);
                  var4.b("AdZoneManager", var5.toString());
                  Iterator var8 = var1.iterator();

                  while(var8.hasNext()) {
                     ((d)var8.next()).a(this.a);
                  }
               }

            }
         }

         if (!var1.isEmpty()) {
            p var9 = this.b;
            StringBuilder var10 = new StringBuilder();
            var10.append("Retrieved persisted zones: ");
            var10.append(var1);
            var9.b("AdZoneManager", var10.toString());
            Iterator var13 = var1.iterator();

            while(var13.hasNext()) {
               ((d)var13.next()).a(this.a);
            }
         }

         return var1;
      }

      if (!var1.isEmpty()) {
         p var20 = this.b;
         StringBuilder var21 = new StringBuilder();
         var21.append("Retrieved persisted zones: ");
         var21.append(var1);
         var20.b("AdZoneManager", var21.toString());
         Iterator var24 = var1.iterator();

         while(var24.hasNext()) {
            ((d)var24.next()).a(this.a);
         }
      }

      return var1;
   }

   private LinkedHashSet b(JSONArray var1) {
      LinkedHashSet var2 = new LinkedHashSet(var1.length());

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         JSONObject var4 = com.applovin.impl.sdk.utils.i.a(var1, var3, (JSONObject)null, this.a);
         p var5 = this.b;
         StringBuilder var6 = new StringBuilder();
         var6.append("Loading zone: ");
         var6.append(com.applovin.impl.sdk.utils.i.d(var4));
         var6.append("...");
         var5.b("AdZoneManager", var6.toString());
         var2.add(com.applovin.impl.sdk.ad.d.a(com.applovin.impl.sdk.utils.i.b(var4, "id", (String)null, this.a), var4, this.a));
      }

      return var2;
   }

   private void c(JSONArray var1) {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dL)) {
         this.b.b("AdZoneManager", "Persisting zones...");
         this.a.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.t, (Object)var1.toString());
      }

   }

   public LinkedHashSet a() {
      // $FF: Couldn't be decompiled
   }

   public LinkedHashSet a(JSONArray var1) {
      if (var1 == null) {
         return new LinkedHashSet();
      } else {
         LinkedHashSet var2 = new LinkedHashSet(var1.length());
         Object var3 = this.d;
         synchronized(var3){}

         LinkedHashSet var6;
         label229: {
            boolean var10001;
            Throwable var10000;
            label230: {
               boolean var5;
               try {
                  var5 = this.e;
               } catch (Throwable var33) {
                  var10000 = var33;
                  var10001 = false;
                  break label230;
               }

               var6 = null;
               if (!var5) {
                  try {
                     p var7 = this.b;
                     StringBuilder var8 = new StringBuilder();
                     var8.append("Found ");
                     var8.append(var1.length());
                     var8.append(" zone(s)...");
                     var7.b("AdZoneManager", var8.toString());
                     var6 = this.b(var1);
                     var2 = new LinkedHashSet(var6);
                     var2.removeAll(this.c);
                     this.c = var6;
                     this.e = true;
                  } catch (Throwable var32) {
                     var10000 = var32;
                     var10001 = false;
                     break label230;
                  }
               }

               label215:
               try {
                  break label229;
               } catch (Throwable var31) {
                  var10000 = var31;
                  var10001 = false;
                  break label215;
               }
            }

            while(true) {
               Throwable var4 = var10000;

               try {
                  throw var4;
               } catch (Throwable var30) {
                  var10000 = var30;
                  var10001 = false;
                  continue;
               }
            }
         }

         if (var6 != null) {
            this.c(var1);
            this.b.b("AdZoneManager", "Finished loading zones");
         }

         return var2;
      }
   }

   public boolean a(d param1) {
      // $FF: Couldn't be decompiled
   }
}
