package com.noqoush.adfalcon.android.sdk.viewability.omsdk;

import android.content.Context;
import android.view.View;
import com.iab.omid.library.adfalcon.adsession.AdEvents;
import com.iab.omid.library.adfalcon.adsession.AdSession;
import com.iab.omid.library.adfalcon.adsession.AdSessionConfiguration;
import com.iab.omid.library.adfalcon.adsession.AdSessionContext;
import com.iab.omid.library.adfalcon.adsession.Owner;
import com.iab.omid.library.adfalcon.adsession.VerificationScriptResource;
import com.noqoush.adfalcon.android.sdk.response.k;
import com.noqoush.adfalcon.android.sdk.response.m;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a implements com.noqoush.adfalcon.android.sdk.viewability.a {
   private static boolean e;
   static AdSessionConfiguration f;
   private AdSession a = null;
   private View b;
   AdSessionContext c;
   List d = new ArrayList();

   private void a(String var1, String var2, String var3) throws MalformedURLException {
      VerificationScriptResource var4;
      if (var3 != null && var3.length() > 0) {
         var4 = VerificationScriptResource.createVerificationScriptResourceWithParameters(var2, new URL(var1), var3);
      } else {
         var4 = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(var2, new URL(var1));
      }

      this.d.add(var4);
   }

   private void e() throws Exception {
      if (this.a == null) {
         AdSessionContext var1 = this.g();
         AdSession var2 = AdSession.createAdSession(this.f(), var1);
         this.a = var2;
         var2.registerAdView(this.b);
      }
   }

   private AdSessionConfiguration f() throws Exception {
      Owner var1 = Owner.NATIVE;
      if (f == null) {
         f = AdSessionConfiguration.createAdSessionConfiguration(var1, (Owner)null, false);
      }

      return f;
   }

   private AdSessionContext g() throws Exception {
      if (this.c == null) {
         this.c = AdSessionContext.createNativeAdSessionContext(com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.b(), com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.a(), this.h(), "");
      }

      return this.c;
   }

   private List h() throws Exception {
      return this.d;
   }

   public void a() {
      try {
         if (!e) {
            return;
         }

         if (this.a != null) {
            this.a.finish();
            this.a = null;
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void a(Context var1) {
      e = com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.a(var1);
   }

   public void a(Context var1, k var2) {
      Iterator var3 = var2.d().iterator();

      while(var3.hasNext()) {
         m var4 = (m)var3.next();
         if (var4.a().equalsIgnoreCase("omid1")) {
            try {
               this.a(var4.d(), var4.e(), var4.c());
            } catch (Exception var6) {
               com.noqoush.adfalcon.android.sdk.util.a.a(var6);
            }
         }
      }

   }

   public void a(Object var1) {
      try {
         if (e) {
            this.b = (View)var1;
            this.e();
            this.a.start();
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public void b() {
      try {
         if (e) {
            AdEvents.createAdEvents(this.a).impressionOccurred();
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void c() {
   }

   public void d() {
   }
}
