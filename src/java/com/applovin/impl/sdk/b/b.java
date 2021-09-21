package com.applovin.impl.sdk.b;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.q;
import java.util.ArrayList;
import java.util.List;

public class b {
   private final j a;
   private final e b;
   private final List c = new ArrayList(25);
   private final List d = new ArrayList(25);
   private final Object e = new Object();

   public b(e var1, j var2) {
      this.a = var2;
      this.b = var1;
      q.a(f.h, 25, var2);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
      this.a(com.applovin.impl.sdk.b.d.U, (Object)null);
   }

   private void a(d var1, Object var2) {
      this.c.add(var1);
      this.d.add(var2);
   }

   public Object a(d var1) {
      Object var2 = this.e;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label164: {
         int var4;
         try {
            var4 = this.c.indexOf(var1);
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label164;
         }

         if (var4 != -1) {
            label158:
            try {
               Object var5 = this.d.get(var4);
               return var5;
            } catch (Throwable var24) {
               var10000 = var24;
               var10001 = false;
               break label158;
            }
         } else {
            label160:
            try {
               return null;
            } catch (Throwable var25) {
               var10000 = var25;
               var10001 = false;
               break label160;
            }
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            continue;
         }
      }
   }

   public void a() {
      List var1 = this.b.b(com.applovin.impl.sdk.b.d.V);
      int var2 = Integer.valueOf(q.a(f.h, this.a));

      int var9;
      for(int var3 = 0; var3 < 25; var3 = var9) {
         d var8 = (d)this.c.get(var3);
         var9 = var3 + 1;
         if (var9 != var2 || var1.contains(var8.a())) {
            p var10 = this.a.v();
            StringBuilder var11 = new StringBuilder();
            var11.append("Disabling local setting: ");
            var11.append(var8.a());
            var10.b("LocalSettingsProvider", var11.toString());
            this.c.set(var3, com.applovin.impl.sdk.b.d.U);
         }
      }

      p var4 = this.a.v();
      StringBuilder var5 = new StringBuilder();
      var5.append("Enabled local settings: ");
      var5.append(this.c);
      var4.b("LocalSettingsProvider", var5.toString());
   }
}
