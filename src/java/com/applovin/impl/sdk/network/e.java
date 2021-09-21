package com.applovin.impl.sdk.network;

import android.content.SharedPreferences;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

public class e {
   private final j a;
   private final p b;
   private final SharedPreferences c;
   private final Object d = new Object();
   private final ArrayList e;
   private final ArrayList f = new ArrayList();
   private final Set g = new HashSet();

   public e(j var1) {
      if (var1 != null) {
         this.a = var1;
         this.b = var1.v();
         this.c = var1.D().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
         this.e = this.b();
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   // $FF: synthetic method
   static p a(e var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static void a(e var0, f var1) {
      var0.d(var1);
   }

   private void a(f param1, AppLovinPostbackListener param2) {
      // $FF: Couldn't be decompiled
   }

   private ArrayList b() {
      Set var1 = (Set)this.a.b(com.applovin.impl.sdk.b.f.m, new LinkedHashSet(0), this.c);
      ArrayList var2 = new ArrayList(Math.max(1, var1.size()));
      int var3 = (Integer)this.a.a(com.applovin.impl.sdk.b.d.du);
      p var4 = this.b;
      StringBuilder var5 = new StringBuilder();
      var5.append("Deserializing ");
      var5.append(var1.size());
      var5.append(" postback(s).");
      var4.b("PersistentPostbackManager", var5.toString());
      Iterator var9 = var1.iterator();

      while(var9.hasNext()) {
         String var15 = (String)var9.next();

         try {
            f var16 = new f(new JSONObject(var15), this.a);
            if (var16.h() < var3) {
               var2.add(var16);
            } else {
               p var22 = this.b;
               StringBuilder var23 = new StringBuilder();
               var23.append("Skipping deserialization because maximum attempt count exceeded for postback: ");
               var23.append(var16);
               var22.b("PersistentPostbackManager", var23.toString());
            }
         } catch (Throwable var25) {
            p var18 = this.b;
            StringBuilder var19 = new StringBuilder();
            var19.append("Unable to deserialize postback request from json: ");
            var19.append(var15);
            var18.b("PersistentPostbackManager", var19.toString(), var25);
            continue;
         }
      }

      p var10 = this.b;
      StringBuilder var11 = new StringBuilder();
      var11.append("Successfully loaded postback queue with ");
      var11.append(var2.size());
      var11.append(" postback(s).");
      var10.b("PersistentPostbackManager", var11.toString());
      return var2;
   }

   // $FF: synthetic method
   static void b(e var0) {
      var0.d();
   }

   // $FF: synthetic method
   static void b(e var0, f var1) {
      var0.e(var1);
   }

   private void b(f param1) {
      // $FF: Couldn't be decompiled
   }

   private void c() {
      LinkedHashSet var1 = new LinkedHashSet(this.e.size());
      Iterator var2 = this.e.iterator();

      while(var2.hasNext()) {
         f var3 = (f)var2.next();

         try {
            var1.add(var3.k().toString());
         } catch (Throwable var6) {
            this.b.b("PersistentPostbackManager", "Unable to serialize postback request to JSON.", var6);
            continue;
         }
      }

      this.a.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.m, (Object)var1, (SharedPreferences)this.c);
      this.b.b("PersistentPostbackManager", "Wrote updated postback queue to disk.");
   }

   private void c(f var1) {
      this.a((f)var1, (AppLovinPostbackListener)null);
   }

   private void d() {
      Object var1 = this.d;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label203: {
         Iterator var3;
         try {
            var3 = this.f.iterator();
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            break label203;
         }

         while(true) {
            try {
               if (!var3.hasNext()) {
                  break;
               }

               this.c((f)var3.next());
            } catch (Throwable var24) {
               var10000 = var24;
               var10001 = false;
               break label203;
            }
         }

         label188:
         try {
            this.f.clear();
            return;
         } catch (Throwable var22) {
            var10000 = var22;
            var10001 = false;
            break label188;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var21) {
            var10000 = var21;
            var10001 = false;
            continue;
         }
      }
   }

   private void d(f param1) {
      // $FF: Couldn't be decompiled
   }

   private void e(f param1) {
      // $FF: Couldn't be decompiled
   }

   public void a() {
      Object var1 = this.d;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label205: {
         label204: {
            Iterator var3;
            try {
               if (this.e == null) {
                  break label204;
               }

               var3 = (new ArrayList(this.e)).iterator();
            } catch (Throwable var24) {
               var10000 = var24;
               var10001 = false;
               break label205;
            }

            while(true) {
               try {
                  if (!var3.hasNext()) {
                     break;
                  }

                  this.c((f)var3.next());
               } catch (Throwable var23) {
                  var10000 = var23;
                  var10001 = false;
                  break label205;
               }
            }
         }

         label193:
         try {
            return;
         } catch (Throwable var22) {
            var10000 = var22;
            var10001 = false;
            break label193;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var21) {
            var10000 = var21;
            var10001 = false;
            continue;
         }
      }
   }

   public void a(f var1) {
      this.a(var1, true);
   }

   public void a(f var1, boolean var2) {
      this.a(var1, var2, (AppLovinPostbackListener)null);
   }

   public void a(f param1, boolean param2, AppLovinPostbackListener param3) {
      // $FF: Couldn't be decompiled
   }
}
