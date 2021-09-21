package com.iab.omid.library.adfalcon.adsession;

import android.webkit.WebView;
import com.iab.omid.library.adfalcon.d.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AdSessionContext {
   private final AdSessionContextType adSessionContextType;
   private final String customReferenceData;
   private final Map injectedResourcesMap = new HashMap();
   private final String omidJsScriptContent;
   private final Partner partner;
   private final List verificationScriptResources = new ArrayList();
   private final WebView webView;

   private AdSessionContext(Partner var1, WebView var2, String var3, List var4, String var5) {
      this.partner = var1;
      this.webView = var2;
      this.omidJsScriptContent = var3;
      AdSessionContextType var6;
      if (var4 != null) {
         this.verificationScriptResources.addAll(var4);
         Iterator var8 = var4.iterator();

         while(var8.hasNext()) {
            VerificationScriptResource var9 = (VerificationScriptResource)var8.next();
            String var10 = UUID.randomUUID().toString();
            this.injectedResourcesMap.put(var10, var9);
         }

         var6 = AdSessionContextType.NATIVE;
      } else {
         var6 = AdSessionContextType.HTML;
      }

      this.adSessionContextType = var6;
      this.customReferenceData = var5;
   }

   public static AdSessionContext createHtmlAdSessionContext(Partner var0, WebView var1, String var2) {
      e.a((Object)var0, "Partner is null");
      e.a((Object)var1, "WebView is null");
      if (var2 != null) {
         e.a(var2, 256, "CustomReferenceData is greater than 256 characters");
      }

      AdSessionContext var3 = new AdSessionContext(var0, var1, (String)null, (List)null, var2);
      return var3;
   }

   public static AdSessionContext createNativeAdSessionContext(Partner var0, String var1, List var2, String var3) {
      e.a((Object)var0, "Partner is null");
      e.a((Object)var1, "OM SDK JS script content is null");
      e.a((Object)var2, "VerificationScriptResources is null");
      if (var3 != null) {
         e.a(var3, 256, "CustomReferenceData is greater than 256 characters");
      }

      AdSessionContext var4 = new AdSessionContext(var0, (WebView)null, var1, var2, var3);
      return var4;
   }

   public AdSessionContextType getAdSessionContextType() {
      return this.adSessionContextType;
   }

   public String getCustomReferenceData() {
      return this.customReferenceData;
   }

   public Map getInjectedResourcesMap() {
      return Collections.unmodifiableMap(this.injectedResourcesMap);
   }

   public String getOmidJsScriptContent() {
      return this.omidJsScriptContent;
   }

   public Partner getPartner() {
      return this.partner;
   }

   public List getVerificationScriptResources() {
      return Collections.unmodifiableList(this.verificationScriptResources);
   }

   public WebView getWebView() {
      return this.webView;
   }
}
