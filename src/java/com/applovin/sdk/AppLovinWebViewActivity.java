package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import java.util.Set;

public class AppLovinWebViewActivity extends Activity {
   public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
   public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
   public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";
   private WebView a;
   private AppLovinWebViewActivity.EventListener b;

   public void loadUrl(String var1, AppLovinWebViewActivity.EventListener var2) {
      this.b = var2;
      this.a.loadUrl(var1);
   }

   public void onBackPressed() {
      AppLovinWebViewActivity.EventListener var1 = this.b;
      if (var1 != null) {
         var1.onReceivedEvent("dismissed_via_back_button");
      }

      super.onBackPressed();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      String var2 = this.getIntent().getStringExtra("sdk_key");
      if (!TextUtils.isEmpty(var2)) {
         final AppLovinSdk var3 = AppLovinSdk.getInstance(var2, new AppLovinSdkSettings(), this.getApplicationContext());
         this.a = new WebView(this);
         this.setContentView(this.a);
         WebSettings var4 = this.a.getSettings();
         var4.setSupportMultipleWindows(false);
         var4.setJavaScriptEnabled(true);
         this.a.setVerticalScrollBarEnabled(true);
         this.a.setHorizontalScrollBarEnabled(true);
         this.a.setScrollBarStyle(33554432);
         this.a.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
               Uri var3x = Uri.parse(var2);
               String var4 = var3x.getScheme();
               String var5 = var3x.getHost();
               String var6 = var3x.getPath();
               p var7 = var3.getLogger();
               StringBuilder var8 = new StringBuilder();
               var8.append("Handling url load: ");
               var8.append(var2);
               var7.b("AppLovinWebViewActivity", var8.toString());
               if ("applovin".equalsIgnoreCase(var4) && "com.applovin.sdk".equalsIgnoreCase(var5) && AppLovinWebViewActivity.this.b != null) {
                  if (var6.endsWith("webview_event")) {
                     Set var11 = var3x.getQueryParameterNames();
                     String var12;
                     if (var11.isEmpty()) {
                        var12 = "";
                     } else {
                        var12 = (String)var11.toArray()[0];
                     }

                     if (n.b(var12)) {
                        String var13 = var3x.getQueryParameter(var12);
                        p var14 = var3.getLogger();
                        StringBuilder var15 = new StringBuilder();
                        var15.append("Parsed WebView event parameter name: ");
                        var15.append(var12);
                        var15.append(" and value: ");
                        var15.append(var13);
                        var14.b("AppLovinWebViewActivity", var15.toString());
                        AppLovinWebViewActivity.this.b.onReceivedEvent(var13);
                     } else {
                        var3.getLogger().e("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                     }
                  }

                  return true;
               } else {
                  return super.shouldOverrideUrlLoading(var1, var2);
               }
            }
         });
         if (this.getIntent().getBooleanExtra("immersive_mode_on", false)) {
            this.getWindow().getDecorView().setSystemUiVisibility(5894);
         }

      } else {
         throw new IllegalArgumentException("No SDK key specified");
      }
   }

   public interface EventListener {
      void onReceivedEvent(String var1);
   }
}
