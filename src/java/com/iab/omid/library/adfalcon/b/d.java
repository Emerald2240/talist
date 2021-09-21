package com.iab.omid.library.adfalcon.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.adfalcon.adsession.ErrorType;
import org.json.JSONObject;

public class d {
   private static d a = new d();

   private d() {
   }

   public static d a() {
      return a;
   }

   public void a(WebView var1) {
      this.a(var1, "finishSession");
   }

   public void a(WebView var1, float var2) {
      Object[] var3 = new Object[]{var2};
      this.a(var1, "setDeviceVolume", var3);
   }

   public void a(WebView var1, ErrorType var2, String var3) {
      Object[] var4 = new Object[]{var2.toString(), var3};
      this.a(var1, "error", var4);
   }

   public void a(WebView var1, String var2, String var3) {
      if (var2 != null && !TextUtils.isEmpty(var3)) {
         this.a(var1, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", var2).replace("%INJECTION_ID%", var3));
      }

   }

   public void a(WebView var1, String var2, JSONObject var3) {
      if (var3 != null) {
         this.a(var1, "publishVideoEvent", var2, var3);
      } else {
         this.a(var1, "publishVideoEvent", var2);
      }
   }

   public void a(WebView var1, String var2, JSONObject var3, JSONObject var4, JSONObject var5) {
      this.a(var1, "startSession", var2, var3, var4, var5);
   }

   void a(WebView var1, String var2, Object... var3) {
      if (var1 != null) {
         StringBuilder var4 = new StringBuilder(128);
         var4.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
         var4.append(var2);
         var4.append("(");
         this.a(var4, var3);
         var4.append(")}");
         this.a(var1, var4);
      } else {
         StringBuilder var9 = new StringBuilder();
         var9.append("The WebView is null for ");
         var9.append(var2);
         com.iab.omid.library.adfalcon.d.c.a(var9.toString());
      }
   }

   void a(final WebView var1, StringBuilder var2) {
      final String var3 = var2.toString();
      Handler var4 = var1.getHandler();
      if (var4 != null && Looper.myLooper() != var4.getLooper()) {
         var4.post(new Runnable() {
            public void run() {
               var1.loadUrl(var3);
            }
         });
      } else {
         var1.loadUrl(var3);
      }
   }

   public void a(WebView var1, JSONObject var2) {
      this.a(var1, "init", var2);
   }

   void a(StringBuilder var1, Object[] var2) {
      if (var2 != null && var2.length > 0) {
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            label27: {
               Object var5 = var2[var4];
               if (var5 == null) {
                  var1.append('"');
               } else {
                  if (!(var5 instanceof String)) {
                     var1.append(var5);
                     break label27;
                  }

                  String var8 = var5.toString();
                  if (var8.startsWith("{")) {
                     var1.append(var8);
                     break label27;
                  }

                  var1.append('"');
                  var1.append(var8);
               }

               var1.append('"');
            }

            var1.append(",");
         }

         var1.setLength(-1 + var1.length());
      }

   }

   public boolean a(WebView var1, String var2) {
      if (var1 != null && !TextUtils.isEmpty(var2)) {
         StringBuilder var3 = new StringBuilder();
         var3.append("javascript: ");
         var3.append(var2);
         var1.loadUrl(var3.toString());
         return true;
      } else {
         return false;
      }
   }

   public void b(WebView var1) {
      this.a(var1, "publishImpressionEvent");
   }

   public void b(WebView var1, String var2) {
      this.a(var1, "setNativeViewHierarchy", var2);
   }

   public void c(WebView var1, String var2) {
      this.a(var1, "setState", var2);
   }
}
