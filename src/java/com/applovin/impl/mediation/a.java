package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.sdk.p;

public class a extends com.applovin.impl.sdk.utils.a {
   private final com.applovin.impl.sdk.a a;
   private final p b;
   private <undefinedtype> c;
   private com.applovin.impl.mediation.b.c d;
   private int e;
   private boolean f;

   a(com.applovin.impl.sdk.j var1) {
      this.b = var1.v();
      this.a = var1.aa();
   }

   public void a() {
      this.b.b("AdActivityObserver", "Cancelling...");
      this.a.b(this);
      this.c = null;
      this.d = null;
      this.e = 0;
      this.f = false;
   }

   public void a(com.applovin.impl.mediation.b.c var1, Object var2) {
      p var3 = this.b;
      StringBuilder var4 = new StringBuilder();
      var4.append("Starting for ad ");
      var4.append(var1.getAdUnitId());
      var4.append("...");
      var3.b("AdActivityObserver", var4.toString());
      this.a();
      this.c = var2;
      this.d = var1;
      this.a.a(this);
   }

   public void onActivityCreated(Activity var1, Bundle var2) {
      if (!this.f) {
         this.f = true;
      }

      ++this.e;
      p var3 = this.b;
      StringBuilder var4 = new StringBuilder();
      var4.append("Created Activity: ");
      var4.append(var1);
      var4.append(", counter is ");
      var4.append(this.e);
      var3.b("AdActivityObserver", var4.toString());
   }

   public void onActivityDestroyed(Activity var1) {
      if (this.f) {
         this.e += -1;
         p var2 = this.b;
         StringBuilder var3 = new StringBuilder();
         var3.append("Destroyed Activity: ");
         var3.append(var1);
         var3.append(", counter is ");
         var3.append(this.e);
         var2.b("AdActivityObserver", var3.toString());
         if (this.e <= 0) {
            this.b.b("AdActivityObserver", "Last ad Activity destroyed");
            if (this.c != null) {
               this.b.b("AdActivityObserver", "Invoking callback...");
               this.c.a(this.d);
            }

            this.a();
         }

      }
   }
}
