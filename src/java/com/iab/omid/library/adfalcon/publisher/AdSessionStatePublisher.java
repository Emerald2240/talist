package com.iab.omid.library.adfalcon.publisher;

import android.webkit.WebView;
import com.iab.omid.library.adfalcon.adsession.AdEvents;
import com.iab.omid.library.adfalcon.adsession.AdSessionConfiguration;
import com.iab.omid.library.adfalcon.adsession.AdSessionContext;
import com.iab.omid.library.adfalcon.adsession.ErrorType;
import com.iab.omid.library.adfalcon.adsession.VerificationScriptResource;
import com.iab.omid.library.adfalcon.adsession.video.VideoEvents;
import com.iab.omid.library.adfalcon.b.c;
import com.iab.omid.library.adfalcon.b.d;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {
   private com.iab.omid.library.adfalcon.e.b a;
   private AdEvents b;
   private VideoEvents c;
   private AdSessionStatePublisher.a d;
   private long e;

   public AdSessionStatePublisher() {
      this.h();
      this.a = new com.iab.omid.library.adfalcon.e.b((WebView)null);
   }

   public void a() {
   }

   public void a(float var1) {
      com.iab.omid.library.adfalcon.b.d.a().a(this.getWebView(), var1);
   }

   void a(WebView var1) {
      this.a = new com.iab.omid.library.adfalcon.e.b(var1);
   }

   public void a(AdEvents var1) {
      this.b = var1;
   }

   public void a(AdSessionConfiguration var1) {
      com.iab.omid.library.adfalcon.b.d.a().a(this.getWebView(), var1.toJsonObject());
   }

   public void a(ErrorType var1, String var2) {
      com.iab.omid.library.adfalcon.b.d.a().a(this.getWebView(), var1, var2);
   }

   public void a(com.iab.omid.library.adfalcon.adsession.a var1, AdSessionContext var2) {
      this.a(var1, var2, (JSONObject)null);
   }

   protected void a(com.iab.omid.library.adfalcon.adsession.a var1, AdSessionContext var2, JSONObject var3) {
      String var4 = var1.getAdSessionId();
      JSONObject var5 = new JSONObject();
      com.iab.omid.library.adfalcon.d.b.a(var5, "environment", "app");
      com.iab.omid.library.adfalcon.d.b.a(var5, "adSessionType", var2.getAdSessionContextType());
      com.iab.omid.library.adfalcon.d.b.a(var5, "deviceInfo", com.iab.omid.library.adfalcon.d.a.d());
      JSONArray var6 = new JSONArray();
      var6.put("clid");
      var6.put("vlid");
      com.iab.omid.library.adfalcon.d.b.a(var5, "supports", var6);
      JSONObject var9 = new JSONObject();
      com.iab.omid.library.adfalcon.d.b.a(var9, "partnerName", var2.getPartner().getName());
      com.iab.omid.library.adfalcon.d.b.a(var9, "partnerVersion", var2.getPartner().getVersion());
      com.iab.omid.library.adfalcon.d.b.a(var5, "omidNativeInfo", var9);
      JSONObject var10 = new JSONObject();
      com.iab.omid.library.adfalcon.d.b.a(var10, "libraryVersion", "1.2.22-Adfalcon");
      com.iab.omid.library.adfalcon.d.b.a(var10, "appId", com.iab.omid.library.adfalcon.b.c.a().b().getApplicationContext().getPackageName());
      com.iab.omid.library.adfalcon.d.b.a(var5, "app", var10);
      if (var2.getCustomReferenceData() != null) {
         com.iab.omid.library.adfalcon.d.b.a(var5, "customReferenceData", var2.getCustomReferenceData());
      }

      JSONObject var11 = new JSONObject();
      Iterator var12 = var2.getVerificationScriptResources().iterator();

      while(var12.hasNext()) {
         VerificationScriptResource var13 = (VerificationScriptResource)var12.next();
         com.iab.omid.library.adfalcon.d.b.a(var11, var13.getVendorKey(), var13.getVerificationParameters());
      }

      com.iab.omid.library.adfalcon.b.d.a().a(this.getWebView(), var4, var5, var11, var3);
   }

   public void a(VideoEvents var1) {
      this.c = var1;
   }

   public void a(String var1) {
      com.iab.omid.library.adfalcon.b.d.a().a(this.getWebView(), (String)var1, (JSONObject)null);
   }

   public void a(String var1, long var2) {
      if (var2 >= this.e) {
         this.d = AdSessionStatePublisher.a.b;
         com.iab.omid.library.adfalcon.b.d.a().b(this.getWebView(), var1);
      }

   }

   public void a(String var1, JSONObject var2) {
      com.iab.omid.library.adfalcon.b.d.a().a(this.getWebView(), var1, var2);
   }

   public void a(boolean var1) {
      if (this.e()) {
         String var2;
         if (var1) {
            var2 = "foregrounded";
         } else {
            var2 = "backgrounded";
         }

         com.iab.omid.library.adfalcon.b.d.a().c(this.getWebView(), var2);
      }

   }

   public void b() {
      this.a.clear();
   }

   public void b(String var1, long var2) {
      if (var2 >= this.e) {
         AdSessionStatePublisher.a var4 = this.d;
         AdSessionStatePublisher.a var5 = AdSessionStatePublisher.a.c;
         if (var4 != var5) {
            this.d = var5;
            com.iab.omid.library.adfalcon.b.d.a().b(this.getWebView(), var1);
         }
      }

   }

   public AdEvents c() {
      return this.b;
   }

   public VideoEvents d() {
      return this.c;
   }

   public boolean e() {
      return this.a.get() != null;
   }

   public void f() {
      com.iab.omid.library.adfalcon.b.d.a().a(this.getWebView());
   }

   public void g() {
      com.iab.omid.library.adfalcon.b.d.a().b(this.getWebView());
   }

   public WebView getWebView() {
      return (WebView)this.a.get();
   }

   public void h() {
      this.e = com.iab.omid.library.adfalcon.d.d.a();
      this.d = AdSessionStatePublisher.a.a;
   }

   static enum a {
      a,
      b,
      c;

      static {
         AdSessionStatePublisher.a var0 = new AdSessionStatePublisher.a("AD_STATE_NOTVISIBLE", 2);
         c = var0;
         AdSessionStatePublisher.a[] var1 = new AdSessionStatePublisher.a[]{a, b, var0};
      }
   }
}
