package com.noqoush.adfalcon.android.sdk.viewability.omsdk;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.adfalcon.ScriptInjector;
import com.iab.omid.library.adfalcon.adsession.AdEvents;
import com.iab.omid.library.adfalcon.adsession.AdSession;
import com.iab.omid.library.adfalcon.adsession.AdSessionConfiguration;
import com.iab.omid.library.adfalcon.adsession.AdSessionContext;
import com.iab.omid.library.adfalcon.adsession.Owner;
import com.noqoush.adfalcon.android.sdk.viewability.e;

public class d implements e {
   private static boolean h;
   private AdSession a = null;
   private AdEvents b = null;
   private boolean c = false;
   private boolean d = false;
   private boolean e = false;
   private boolean f = false;
   private WebView g;

   private void b(WebView var1) {
      try {
         if (this.a == null) {
            AdSessionContext var3 = this.c(var1);
            AdSession var4 = AdSession.createAdSession(this.e(), var3);
            this.a = var4;
            var4.registerAdView(var1);
            this.b = AdEvents.createAdEvents(this.a);
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }
   }

   private AdSessionContext c(WebView var1) {
      return AdSessionContext.createHtmlAdSessionContext(com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.b(), var1, "");
   }

   private AdSessionConfiguration e() {
      Owner var1 = Owner.NATIVE;
      Owner var2 = Owner.NONE;
      if (this.c()) {
         var1 = Owner.JAVASCRIPT;
         var2 = var1;
      }

      return AdSessionConfiguration.createAdSessionConfiguration(var1, var2, false);
   }

   public String a(String var1) {
      try {
         String var3 = ScriptInjector.injectScriptContentIntoHtml(this.d(), var1);
         return var3;
      } catch (Exception var4) {
         var4.printStackTrace();
         return var1;
      }
   }

   public void a() {
      try {
         if (!h) {
            return;
         }

         if (this.a != null) {
            StringBuilder var2 = new StringBuilder();
            var2.append("OM-stopTracking-");
            var2.append(this.a);
            com.noqoush.adfalcon.android.sdk.util.a.a(var2.toString());
            this.a.finish();
            this.a = null;
            this.g.postDelayed(new d$a(this), 1000L);
            return;
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public void a(Context var1) {
      h = com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.a(var1);
   }

   public void a(WebView var1) {
      this.g = var1;
   }

   public void a(WebView var1, String var2) {
      try {
         this.c = true;
         this.a((Object)var1);
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   public void a(Object var1) {
      try {
         if (!h) {
            return;
         }

         if (!this.c) {
            return;
         }

         if (this.c && this.a == null && this.g.getParent() != null) {
            this.b((WebView)var1);
            this.a.start();
            StringBuilder var3 = new StringBuilder();
            var3.append("OM-startTracking-");
            var3.append(this.a);
            com.noqoush.adfalcon.android.sdk.util.a.a(var3.toString());
            return;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void b() {
      try {
         if (!h) {
            return;
         }

         if (!this.c() && !this.d) {
            if (this.b == null) {
               this.e = true;
               return;
            }

            this.b.impressionOccurred();
            this.d = true;
            StringBuilder var2 = new StringBuilder();
            var2.append("OM-impressionOccurred-");
            var2.append(this.a);
            com.noqoush.adfalcon.android.sdk.util.a.a(var2.toString());
            return;
         }
      } catch (Exception var3) {
         this.e = true;
         var3.printStackTrace();
      }

   }

   public boolean c() {
      return this.f;
   }

   public String d() {
      return com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.a();
   }
}
