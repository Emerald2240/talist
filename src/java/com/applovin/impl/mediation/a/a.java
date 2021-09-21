package com.applovin.impl.mediation.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.applovin.impl.mediation.a.a.d;
import com.applovin.impl.mediation.a.c.a.b;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.d.r;
import com.applovin.impl.sdk.utils.i;
import com.applovin.mediation.MaxDebuggerActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements com.applovin.impl.sdk.network.a.c {
   private static WeakReference a;
   private static final AtomicBoolean b = new AtomicBoolean();
   private final j c;
   private final p d;
   private final b e;
   private final AtomicBoolean f = new AtomicBoolean();
   private boolean g;

   public a(j var1) {
      this.c = var1;
      this.d = var1.v();
      this.e = new b(var1.D());
   }

   private List a(JSONObject var1, j var2) {
      JSONArray var3 = i.b(var1, "networks", new JSONArray(), var2);
      ArrayList var4 = new ArrayList(var3.length());

      for(int var5 = 0; var5 < var3.length(); ++var5) {
         JSONObject var6 = i.a(var3, var5, (JSONObject)null, var2);
         if (var6 != null) {
            var4.add(new d(var6, var2));
         }
      }

      Collections.sort(var4);
      return var4;
   }

   private void e() {
      if (this.f.compareAndSet(false, true)) {
         com.applovin.impl.mediation.a.b.a var1 = new com.applovin.impl.mediation.a.b.a(this, this.c);
         this.c.K().a((com.applovin.impl.sdk.d.a)var1, r.a.j);
      }

   }

   private boolean f() {
      WeakReference var1 = a;
      return var1 != null && var1.get() != null;
   }

   public void a(int var1) {
      p var2 = this.d;
      StringBuilder var3 = new StringBuilder();
      var3.append("Unable to fetch mediation debugger info: server returned ");
      var3.append(var1);
      var2.e("MediationDebuggerService", var3.toString());
      p.j("AppLovinSdk", "Unable to show mediation debugger.");
      this.e.a((List)null, this.c);
      this.f.set(false);
   }

   public void a(JSONObject var1, int var2) {
      List var3 = this.a(var1, this.c);
      this.e.a(var3, this.c);
      StringBuilder var4 = new StringBuilder();
      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         var4.append(((d)var5.next()).l());
      }

      var4.append("\n------------------ END ------------------");
      this.d.f("MediationDebuggerService", var4.toString());
   }

   public void a(boolean var1) {
      this.g = var1;
   }

   public boolean a() {
      return this.g;
   }

   public void b() {
      this.e();
      if (!this.f() && b.compareAndSet(false, true)) {
         this.c.aa().a(new com.applovin.impl.sdk.utils.a() {
            public void onActivityDestroyed(Activity var1) {
               if (var1 instanceof MaxDebuggerActivity) {
                  a.this.c.aa().b(this);
                  com.applovin.impl.mediation.a.a.a = null;
               }

            }

            public void onActivityStarted(Activity var1) {
               if (var1 instanceof MaxDebuggerActivity) {
                  if (!a.this.f() || com.applovin.impl.mediation.a.a.a.get() != var1) {
                     MaxDebuggerActivity var2 = (MaxDebuggerActivity)var1;
                     com.applovin.impl.mediation.a.a.a = new WeakReference(var2);
                     var2.setListAdapter(a.this.e, a.this.c.aa());
                  }

                  com.applovin.impl.mediation.a.a.b.set(false);
               }

            }
         });
         Context var1 = this.c.D();
         Intent var2 = new Intent(var1, MaxDebuggerActivity.class);
         var2.setFlags(268435456);
         var1.startActivity(var2);
      } else {
         p.j("AppLovinSdk", "Mediation Debugger is already showing.");
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediationDebuggerService{, listAdapter=");
      var1.append(this.e);
      var1.append("}");
      return var1.toString();
   }
}
