package com.noqoush.adfalcon.android.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebSettings.PluginState;
import com.noqoush.adfalcon.android.sdk.R;
import com.noqoush.adfalcon.android.sdk.z;
import com.noqoush.adfalcon.android.sdk.response.k;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e {
   public static final String a = "<!DOCTYPE html><html><head><meta http-equiv=\"Content-Security-Policy\" content=\" script-src * 'unsafe-inline'   'unsafe-eval'   ; \"><meta name='viewport' content='width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'></head><body style='margin:0px;padding:0px;' bgcolor='transparent'>%s</body></html>";

   public static String a(Context var0) throws Exception {
      Scanner var1 = null;

      InputStream var6;
      try {
         var6 = var0.getResources().openRawResource(R.raw.mraid);
      } finally {
         ;
      }

      String var8;
      Scanner var7;
      label206: {
         Throwable var5;
         label207: {
            try {
               var7 = new Scanner(var6, "UTF-8");
            } catch (Throwable var25) {
               var5 = var25;
               var6 = var6;
               break label207;
            }

            var8 = "";

            while(true) {
               try {
                  if (!var7.hasNextLine()) {
                     break label206;
                  }

                  StringBuilder var10 = new StringBuilder();
                  var10.append(var8);
                  var10.append(var7.nextLine());
                  var8 = var10.toString();
               } catch (Throwable var24) {
                  var5 = var24;
                  var1 = var7;
                  break;
               }
            }
         }

         if (var6 != null) {
            var6.close();
         }

         if (var1 != null) {
            var1.close();
         }

         throw var5;
      }

      if (var6 != null) {
         var6.close();
      }

      var7.close();
      return var8;
   }

   public static String a(Context var0, k var1) throws Exception {
      if (var1.i().toLowerCase().contains("<html>")) {
         String var8 = var1.i();
         Matcher var9 = Pattern.compile("<script{1}(\\w|=|\"|'|\\.|/|\\s|\\\\)+(\"|'){1}mraid.js{1}(\"|'){1}(\\s|>)*(</script>|/>){1}").matcher(var8);
         StringBuilder var10 = new StringBuilder();
         var10.append("<script>");
         var10.append(a(var0));
         var10.append("</script>");
         String var14 = var9.replaceAll(var10.toString());
         if (var14.contains("var mraid = window.mraid = {};")) {
            return var14;
         } else if (var14.contains("mraid.js")) {
            if (!var14.contains("'mraid.js'") && !var14.contains("\"mraid.js\"")) {
               return var14;
            } else {
               StringBuilder var20 = new StringBuilder();
               var20.append("<script>");
               var20.append(a(var0));
               var20.append("</script>");
               var20.append(var8);
               return var20.toString();
            }
         } else {
            StringBuilder var15 = new StringBuilder();
            var15.append("<script>");
            var15.append(a(var0));
            var15.append("</script>");
            var15.append(var8);
            return var15.toString();
         }
      } else {
         Object[] var2 = new Object[1];
         StringBuilder var3 = new StringBuilder();
         var3.append("<script>");
         var3.append(a(var0));
         var3.append("</script>");
         var3.append(var1.i().replace("<script src='mraid.js'></script>", ""));
         var2[0] = var3.toString();
         return String.format("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Security-Policy\" content=\" script-src * 'unsafe-inline'   'unsafe-eval'   ; \"><meta name='viewport' content='width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'></head><body style='margin:0px;padding:0px;' bgcolor='transparent'>%s</body></html>", var2);
      }
   }

   public static void a(z var0) {
      if (var0 != null) {
         try {
            WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(var0, new Object[0]);
         } catch (Exception var2) {
         }
      }
   }

   private static void a(z var0, WebSettings var1) {
      var1.setCacheMode(-1);
      var1.setAppCacheEnabled(true);
      var1.setDomStorageEnabled(true);
      File var2 = var0.getContext().getCacheDir();
      if (!var2.exists()) {
         var2.mkdirs();
      }

      var1.setAppCachePath(var2.getPath());
   }

   public static void b(z var0) {
      if (var0 != null) {
         try {
            WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(var0, new Object[0]);
         } catch (Exception var2) {
         }
      }
   }

   public static void c(z var0) {
      try {
         d(var0);
         WebSettings var2 = var0.getSettings();
         var2.setBuiltInZoomControls(true);
         var2.setSupportZoom(true);
         var2.setUseWideViewPort(true);
         var2.setLoadWithOverviewMode(true);
         var2.setJavaScriptCanOpenWindowsAutomatically(true);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   private static void d(final z var0) {
      WebSettings var1 = var0.getSettings();
      var1.setJavaScriptEnabled(true);
      var1.setJavaScriptCanOpenWindowsAutomatically(true);
      if (VERSION.SDK_INT < 18) {
         var1.setPluginState(PluginState.ON);
      }

      var1.setGeolocationEnabled(true);
      if (VERSION.SDK_INT >= 17) {
         var1.setMediaPlaybackRequiresUserGesture(false);
      }

      var0.setDownloadListener(new DownloadListener() {
         public void onDownloadStart(String var1, String var2, String var3, String var4, long var5) {
            try {
               Intent var7 = new Intent("android.intent.action.VIEW");
               var7.setData(Uri.parse(var1));
               var0.getContext().startActivity(var7);
            } catch (Exception var9) {
               com.noqoush.adfalcon.android.sdk.k.b(var9.getMessage());
            }
         }
      });
      a(var0, var1);
      if (VERSION.SDK_INT >= 21) {
         CookieManager var2 = CookieManager.getInstance();
         var2.acceptThirdPartyCookies(var0);
         var2.setAcceptThirdPartyCookies(var0, true);
         var2.setAcceptCookie(true);
         var1.setMixedContentMode(0);
      }

   }

   public static void e(z var0) {
      try {
         d(var0);
         WebSettings var2 = var0.getSettings();
         var2.setBuiltInZoomControls(false);
         var2.setSupportZoom(false);
         var2.setUseWideViewPort(false);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }
}
