package com.iab.omid.library.adfalcon.publisher;

import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.adfalcon.adsession.AdSessionContext;
import com.iab.omid.library.adfalcon.adsession.VerificationScriptResource;
import com.iab.omid.library.adfalcon.b.c;
import com.iab.omid.library.adfalcon.d.d;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b extends AdSessionStatePublisher {
   private WebView a;
   private Long b = null;
   private Map c;
   private final String d;

   public b(Map var1, String var2) {
      this.c = var1;
      this.d = var2;
   }

   // $FF: synthetic method
   static WebView a(b var0) {
      return var0.a;
   }

   public void a() {
      super.a();
      this.i();
   }

   public void a(com.iab.omid.library.adfalcon.adsession.a var1, AdSessionContext var2) {
      JSONObject var3 = new JSONObject();
      Map var4 = var2.getInjectedResourcesMap();
      Iterator var5 = var4.keySet().iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         com.iab.omid.library.adfalcon.d.b.a(var3, var6, (VerificationScriptResource)var4.get(var6));
      }

      this.a(var1, var2, var3);
   }

   public void b() {
      super.b();
      long var1;
      if (this.b == null) {
         var1 = 4000L;
      } else {
         var1 = TimeUnit.MILLISECONDS.convert(com.iab.omid.library.adfalcon.d.d.a() - this.b, TimeUnit.NANOSECONDS);
      }

      long var3 = Math.max(4000L - var1, 2000L);
      (new Handler()).postDelayed(new b$1(this), var3);
      this.a = null;
   }

   void i() {
      WebView var1 = new WebView(com.iab.omid.library.adfalcon.b.c.a().b());
      this.a = var1;
      var1.getSettings().setJavaScriptEnabled(true);
      this.a(this.a);
      com.iab.omid.library.adfalcon.b.d.a().a(this.a, this.d);
      Iterator var3 = this.c.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var5 = ((VerificationScriptResource)this.c.get(var4)).getResourceUrl().toExternalForm();
         com.iab.omid.library.adfalcon.b.d.a().a(this.a, var5, var4);
      }

      this.b = com.iab.omid.library.adfalcon.d.d.a();
   }
}
