package com.noqoush.adfalcon.android.sdk;

import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public abstract class u extends WebViewClient {
   private int a;
   private CountDownTimer b;
   private boolean c = true;

   public u(int var1) {
      this.a(var1);
   }

   public u(int var1, boolean var2) {
      this.a(var1);
      this.a(var2);
   }

   private void b(final WebView var1) {
      try {
         if (this.a() > 100) {
            StringBuilder var3 = new StringBuilder();
            var3.append("timeout: startTimeoutTimer ");
            var3.append(this.a());
            var3.append("ms");
            com.noqoush.adfalcon.android.sdk.util.a.a(var3.toString());
            CountDownTimer var7 = new CountDownTimer((long)this.a(), 1000L) {
               public void onFinish() {
                  try {
                     com.noqoush.adfalcon.android.sdk.util.a.a("timeout: on timeout happened");
                     if (u.this.b()) {
                        var1.stopLoading();
                     }

                     u.this.a(var1);
                  } catch (Exception var2) {
                     com.noqoush.adfalcon.android.sdk.util.a.a(var2);
                  }
               }

               public void onTick(long var1x) {
               }
            };
            this.b = var7.start();
            return;
         }
      } catch (Exception var8) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var8);
      }

   }

   private void c() {
      try {
         if (this.b != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("timeout: cancelTimeoutTimer");
            this.b.cancel();
            this.b = null;
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public int a() {
      return this.a;
   }

   public void a(int var1) {
      this.a = var1;
   }

   public abstract void a(WebView var1);

   public void a(boolean var1) {
      this.c = var1;
   }

   public boolean b() {
      return this.c;
   }

   public void onPageFinished(WebView var1, String var2) {
      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("timeout: onPageFinished");
         this.c();
         super.onPageFinished(var1, var2);
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }
   }

   public void onPageStarted(WebView var1, String var2, Bitmap var3) {
      super.onPageStarted(var1, var2, var3);

      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("timeout: onPageStarted");
         this.b(var1);
      } catch (Exception var6) {
         StringBuilder var5 = new StringBuilder();
         var5.append("ADFInterstitialWebViewClient->onPageStarted->");
         var5.append(var6.toString());
         k.b(var5.toString());
      }
   }

   public void onReceivedError(WebView var1, WebResourceRequest var2, WebResourceError var3) {
      try {
         com.noqoush.adfalcon.android.sdk.util.a.a("timeout: onReceivedError");
         this.c();
         super.onReceivedError(var1, var2, var3);
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }
   }
}
