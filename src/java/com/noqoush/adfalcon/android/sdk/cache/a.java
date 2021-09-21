package com.noqoush.adfalcon.android.sdk.cache;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class a {
   static com.noqoush.adfalcon.android.sdk.cache.a b;
   Hashtable a = new Hashtable();

   private a() {
   }

   public static com.noqoush.adfalcon.android.sdk.cache.a a() {
      if (b == null) {
         b = new com.noqoush.adfalcon.android.sdk.cache.a();
      }

      return b;
   }

   private void b() {
      Exception var10000;
      label48: {
         boolean var10001;
         Iterator var3;
         Vector var1;
         try {
            var1 = new Vector();
            var3 = this.a.keySet().iterator();
         } catch (Exception var13) {
            var10000 = var13;
            var10001 = false;
            break label48;
         }

         label47:
         while(true) {
            try {
               while(var3.hasNext()) {
                  String var7 = (String)var3.next();
                  com.noqoush.adfalcon.android.sdk.cache.a.a var8 = (com.noqoush.adfalcon.android.sdk.cache.a.a)this.a.get(var7);
                  if (var8.a()) {
                     var1.add(var7);
                     StringBuilder var10 = new StringBuilder();
                     var10.append("Cache remove (key: ");
                     var10.append(var7);
                     var10.append(", ");
                     var10.append(var8.a);
                     var10.append(")");
                     com.noqoush.adfalcon.android.sdk.util.a.c(var10.toString());
                  }
               }
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break;
            }

            Iterator var4;
            try {
               var4 = var1.iterator();
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break;
            }

            while(true) {
               try {
                  if (!var4.hasNext()) {
                     return;
                  }

                  String var5 = (String)var4.next();
                  this.a.remove(var5);
               } catch (Exception var11) {
                  var10000 = var11;
                  var10001 = false;
                  break label47;
               }
            }
         }
      }

      Exception var2 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var2);
   }

   public String a(String var1) {
      try {
         this.b();
         if (!this.a.containsKey(var1)) {
            return null;
         } else {
            com.noqoush.adfalcon.android.sdk.cache.a.a var3 = (com.noqoush.adfalcon.android.sdk.cache.a.a)this.a.get(var1);
            ++var3.d;
            StringBuilder var4 = new StringBuilder();
            var4.append("Cache get (key: ");
            var4.append(var1);
            var4.append(", ");
            var4.append(var3.a);
            var4.append(")");
            com.noqoush.adfalcon.android.sdk.util.a.c(var4.toString());
            String var10 = var3.a;
            return var10;
         }
      } catch (Exception var11) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var11);
         return null;
      }
   }

   public void a(String var1, String var2, long var3) {
      try {
         this.b();
         StringBuilder var6 = new StringBuilder();
         var6.append("Cache add (key: ");
         var6.append(var1);
         var6.append(", ");
         var6.append(var2);
         var6.append(")");
         com.noqoush.adfalcon.android.sdk.util.a.c(var6.toString());
         this.a.put(var1, new com.noqoush.adfalcon.android.sdk.cache.a.a(var2, var3));
      } catch (Exception var7) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var7);
      }
   }

   private class a {
      String a;
      long b;
      long c;
      int d;
      int e;

      a(String var2, long var3) {
         this.a = var2;
         if (var3 != 0L && var3 <= 120000L) {
            this.c = var3;
         } else {
            this.c = 120000L;
         }

         this.e = 3;
         this.b = Calendar.getInstance().getTimeInMillis();
      }

      boolean a() {
         return Calendar.getInstance().getTimeInMillis() > this.b + this.c || this.d >= this.e;
      }
   }
}
