package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;

public class ADFBrowser extends Activity implements com.noqoush.adfalcon.android.sdk.helper.b, com.noqoush.adfalcon.android.sdk.urlactions.g {
   public static w c;
   public static com.noqoush.adfalcon.android.sdk.nativead.a d;
   private boolean a;
   private com.noqoush.adfalcon.android.sdk.helper.a b;

   private void a(z var1) throws Exception {
      if (var1 != null) {
         var1.stopLoading();
         var1.postDelayed(new ADFBrowser$a(this, var1), 3000L);
      }

   }

   public void a() {
   }

   public void a(com.noqoush.adfalcon.android.sdk.urlactions.i var1, com.noqoush.adfalcon.android.sdk.urlactions.m var2) {
      try {
         if (var1 == com.noqoush.adfalcon.android.sdk.urlactions.i.a && var2 == com.noqoush.adfalcon.android.sdk.urlactions.m.a) {
            return;
         }

         z var4 = this.b.i();
         if (c != null) {
            c.f();
            this.a = true;
            this.a(var4);
         }

         if (d != null) {
            d.d();
            this.a = true;
            this.a(var4);
            return;
         }
      } catch (Exception var5) {
      }

   }

   public void a(String var1) {
      this.setTitle(var1);
   }

   public void b() {
      this.finish();
   }

   public void c() throws Exception {
      this.b.a(true);
      ProgressBar var2 = this.b.a();
      this.b.a(var2, true);
      this.setContentView(this.b.f());

      boolean var10001;
      View var5;
      try {
         this.b.j();
         var5 = this.getWindow().findViewById(16908310);
      } catch (Exception var9) {
         var10001 = false;
         return;
      }

      if (var5 != null) {
         ViewParent var6;
         try {
            var6 = var5.getParent();
         } catch (Exception var8) {
            var10001 = false;
            return;
         }

         if (var6 != null) {
            try {
               if (var6 instanceof View) {
                  ((View)var6).setBackgroundColor(-16777216);
                  return;
               }
            } catch (Exception var7) {
               var10001 = false;
            }
         }
      }

   }

   protected String d() {
      return this.getIntent().getStringExtra("url");
   }

   public void onBackPressed() {
      try {
         this.b.i().stopLoading();
         if (this.b.c() == null || !this.b.c().b()) {
            this.finish();
         }
      } catch (Exception var2) {
      }
   }

   protected void onCreate(Bundle var1) {
      label24: {
         Exception var10000;
         label23: {
            this.a = false;
            this.b = new com.noqoush.adfalcon.android.sdk.helper.a(this, this, this.d(), this);
            boolean var10001;
            if (var1 != null) {
               try {
                  if (var1.containsKey("mShouldFinishBrowser")) {
                     this.a = var1.getBoolean("mShouldFinishBrowser");
                  }
               } catch (Exception var5) {
                  var10000 = var5;
                  var10001 = false;
                  break label23;
               }
            }

            try {
               this.requestWindowFeature(1);
               this.c();
               this.getWindow().addFlags(128);
               break label24;
            } catch (Exception var4) {
               var10000 = var4;
               var10001 = false;
            }
         }

         Exception var2 = var10000;
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFBrowser->onCreate: ");
         var3.append(var2.toString());
         k.b(var3.toString());
      }

      super.onCreate(var1);
   }

   protected void onDestroy() {
      try {
         c = null;
         d = null;
         this.a(this.b.i());
      } catch (Exception var2) {
      }

      super.onDestroy();
   }

   protected void onPause() {
      label33: {
         Exception var10000;
         label35: {
            boolean var10001;
            z var2;
            try {
               var2 = this.b.i();
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break label35;
            }

            if (var2 != null) {
               Class var3;
               try {
                  var3 = Class.forName("android.webkit.WebView");
               } catch (Exception var6) {
                  var10000 = var6;
                  var10001 = false;
                  break label35;
               }

               try {
                  var3.getMethod("onPause", (Class[])null).invoke(var2, (Object[])null);
               } catch (Exception var5) {
                  var10000 = var5;
                  var10001 = false;
                  break label35;
               }
            }

            try {
               this.b.c().b();
               break label33;
            } catch (Exception var4) {
               var10000 = var4;
               var10001 = false;
            }
         }

         Exception var1 = var10000;
         com.noqoush.adfalcon.android.sdk.util.a.a(var1);
      }

      super.onPause();
   }

   public void onRestoreInstanceState(Bundle var1) {
      if (var1 != null && var1.containsKey("mShouldFinishBrowser")) {
         this.a = var1.getBoolean("mShouldFinishBrowser");
      }

      super.onRestoreInstanceState(var1);
   }

   protected void onResume() {
      label35: {
         Exception var10000;
         label37: {
            boolean var10001;
            z var2;
            try {
               var2 = this.b.i();
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break label37;
            }

            if (var2 != null) {
               Class var3;
               try {
                  var3 = Class.forName("android.webkit.WebView");
               } catch (Exception var6) {
                  var10000 = var6;
                  var10001 = false;
                  break label37;
               }

               try {
                  var3.getMethod("onResume", (Class[])null).invoke(var2, (Object[])null);
               } catch (Exception var5) {
                  var10000 = var5;
                  var10001 = false;
                  break label37;
               }
            }

            try {
               if (this.a) {
                  this.finish();
               }
               break label35;
            } catch (Exception var4) {
               var10000 = var4;
               var10001 = false;
            }
         }

         Exception var1 = var10000;
         com.noqoush.adfalcon.android.sdk.util.a.a(var1);
      }

      super.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      var1.putBoolean("mShouldFinishBrowser", this.a);
      super.onSaveInstanceState(var1);
   }
}
