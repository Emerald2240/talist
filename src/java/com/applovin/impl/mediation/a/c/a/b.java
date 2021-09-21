package com.applovin.impl.mediation.a.c.a;

import android.content.Context;
import com.applovin.impl.mediation.a.a.c;
import com.applovin.impl.mediation.a.a.d;
import com.applovin.impl.mediation.a.a.g;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class b extends com.applovin.impl.mediation.a.c.a {
   private final AtomicBoolean c = new AtomicBoolean();
   private final c d = new g("INCOMPLETE INTEGRATIONS");
   private final c e = new g("COMPLETED INTEGRATIONS");
   private final c f = new g("MISSING INTEGRATIONS");
   private final c g = new g("");
   private b.a h;

   public b(Context var1) {
      super(var1);
   }

   private List b(List var1, j var2) {
      var2.v().b("MediationDebuggerListAdapter", "Updating networks...");
      ArrayList var3 = new ArrayList(var1.size());
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      Iterator var7 = var1.iterator();

      while(true) {
         while(var7.hasNext()) {
            d var15 = (d)var7.next();
            com.applovin.impl.mediation.a.c.a.a.a var16 = new com.applovin.impl.mediation.a.c.a.a.a(var15, this.a);
            if (var15.a() != d.a.b && var15.a() != d.a.c) {
               if (var15.a() == d.a.d) {
                  var5.add(var16);
               } else if (var15.a() == d.a.a) {
                  var6.add(var16);
               }
            } else {
               var4.add(var16);
            }
         }

         if (var4.size() > 0) {
            var3.add(this.d);
            var3.addAll(var4);
         }

         if (var5.size() > 0) {
            var3.add(this.e);
            var3.addAll(var5);
         }

         if (var6.size() > 0) {
            var3.add(this.f);
            var3.addAll(var6);
         }

         var3.add(this.g);
         return var3;
      }
   }

   protected void a(c var1) {
      if (this.h != null && var1 instanceof com.applovin.impl.mediation.a.c.a.a.a) {
         d var2 = ((com.applovin.impl.mediation.a.c.a.a.a)var1).i();
         this.h.a(var2);
      }

   }

   public void a(b.a var1) {
      this.h = var1;
   }

   public void a(List var1, j var2) {
      if (var1 != null && this.c.compareAndSet(false, true)) {
         this.b.addAll(this.b(var1, var2));
      }

      AppLovinSdkUtils.runOnUiThread(new b$1(this));
   }

   public boolean a() {
      return this.c.get();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediationDebuggerListAdapter{isInitialized=");
      var1.append(this.c.get());
      var1.append(", listItems=");
      var1.append(this.b);
      var1.append("}");
      return var1.toString();
   }

   public interface a {
      void a(d var1);
   }
}
