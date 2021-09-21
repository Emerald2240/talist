package com.noqoush.adfalcon.android.sdk.nativead.assets;

import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import com.noqoush.adfalcon.android.sdk.m;
import com.noqoush.adfalcon.android.sdk.y;
import com.noqoush.adfalcon.android.sdk.response.h;
import com.noqoush.adfalcon.android.sdk.response.j;

public class e extends a {
   public static final int i = 1;
   public static final int j = 2;
   private static final String k = "R_NXHTMLT";
   private static final String l = "R_NMLA";
   private static final String m = "R_NMH";
   private static final String n = "R_NMW";
   private static final String o = "xhtml,image";
   public static final String p = "MASS";
   private static final String q = "XHTML,MRAID";
   private int g;
   private int h;

   public e(int var1, int var2, int var3) throws Exception {
      super(var1, 2, "MASS", "xhtml,image");
      this.c(var3);
      this.d(var2);
   }

   public void a(com.noqoush.adfalcon.android.sdk.conn.c var1) {
      String var2 = String.format("R_N%sRF", new Object[]{"MASS"});
      StringBuilder var3 = new StringBuilder();
      var3.append("");
      var3.append(this.c());
      var1.b(var2, var3.toString());
      var1.a("R_NASSETS", this.b());
      StringBuilder var6 = new StringBuilder();
      var6.append("");
      var6.append(this.f());
      var1.b("R_NMW", var6.toString());
      StringBuilder var9 = new StringBuilder();
      var9.append("");
      var9.append(this.e());
      var1.b("R_NMH", var9.toString());
      var1.b("R_NMLA", "true");
      var1.b("R_NXHTMLT", "XHTML,MRAID");
   }

   public boolean a(View var1, com.noqoush.adfalcon.android.sdk.response.f var2) {
      Exception var10000;
      label62: {
         boolean var10001;
         RelativeLayout var4;
         try {
            var4 = (RelativeLayout)var1.findViewById(this.d());
            if (var2 instanceof h) {
               h var10 = (h)var2;
               ImageView var11 = new ImageView(var1.getContext());
               var11.setScaleType(ScaleType.CENTER_INSIDE);
               var4.removeAllViews();
               var4.addView(var11, com.noqoush.adfalcon.android.sdk.util.f.a(), -2);
               com.noqoush.adfalcon.android.sdk.images.c.a().a(var10.e(), var11);
               return true;
            }
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
            break label62;
         }

         String var5;
         label63: {
            try {
               if (var2 instanceof j) {
                  var5 = ((j)var2).b();
                  break label63;
               }
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
               break label62;
            }

            var5 = "";
         }

         m var7;
         try {
            y var6 = new y(var1.getContext(), var4, (ProgressBar)null);
            var7 = new m(var1.getContext(), var4, var6, false);
            var7.setVisibility(0);
            var4.removeAllViews();
            var4.addView(var7, com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
            if (VERSION.SDK_INT >= 21) {
               WebView.enableSlowWholeDocumentDraw();
            }
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label62;
         }

         boolean var8;
         try {
            var8 = var5.toLowerCase().contains("<html>");
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label62;
         }

         String var9;
         if (var8) {
            var9 = var5;
         } else {
            try {
               var9 = String.format("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Security-Policy\" content=\" script-src * 'unsafe-inline'   'unsafe-eval'   ; \"><meta name='viewport' content='width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'></head><body style='margin:0px;padding:0px;' bgcolor='transparent'>%s</body></html>", new Object[]{var5});
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label62;
            }
         }

         try {
            var7.loadDataWithBaseURL("", var9, "text/html", "utf-8", (String)null);
            return true;
         } catch (Exception var12) {
            var10000 = var12;
            var10001 = false;
         }
      }

      Exception var3 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      return false;
   }

   public void c(int var1) {
      this.h = var1;
   }

   public void d(int var1) {
      this.g = var1;
   }

   public int e() {
      return this.h;
   }

   public int f() {
      return this.g;
   }
}
