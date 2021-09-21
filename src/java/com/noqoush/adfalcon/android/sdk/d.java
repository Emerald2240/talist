package com.noqoush.adfalcon.android.sdk;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;

public class d implements OnDismissListener, OnKeyListener, com.noqoush.adfalcon.android.sdk.helper.b, com.noqoush.adfalcon.android.sdk.urlactions.g {
   public static w g;
   private String a;
   private ADFMraidInterface b;
   private Dialog c;
   private Context d;
   private boolean e;
   private com.noqoush.adfalcon.android.sdk.helper.a f;

   public d(String var1, Context var2, ADFMraidInterface var3) {
      this.b(var1);
      this.a(var2);
      this.a(var3);
      this.f = new com.noqoush.adfalcon.android.sdk.helper.a(var2, this, this.d(), this);
      g = null;
   }

   // $FF: synthetic method
   static com.noqoush.adfalcon.android.sdk.helper.a a(d var0) {
      return var0.f;
   }

   private void a(Context var1) {
      this.d = var1;
   }

   private Context g() {
      return this.d;
   }

   public void a() {
   }

   protected void a(ADFMraidInterface var1) {
      this.b = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.urlactions.i var1, com.noqoush.adfalcon.android.sdk.urlactions.m var2) {
      try {
         if (var1 == com.noqoush.adfalcon.android.sdk.urlactions.i.b && g != null) {
            g.f();
            return;
         }
      } catch (Exception var4) {
      }

   }

   public void a(String var1) {
      this.c.setTitle(var1);
   }

   protected void a(boolean var1) {
      this.e = var1;
   }

   public void b() {
      this.c.dismiss();
   }

   protected void b(String var1) {
      this.a = var1;
   }

   protected ADFMraidInterface c() {
      return this.b;
   }

   protected String d() {
      return this.a;
   }

   protected boolean e() {
      return this.e;
   }

   public void f() throws Exception {
      if (this.c == null) {
         Dialog var1 = new Dialog(this.g(), 16973832);
         this.c = var1;
         var1.getWindow().getAttributes().windowAnimations = 16973827;
         this.c.setOnDismissListener(this);
         this.c.setOnKeyListener(this);
         this.f.a(false);
         ProgressBar var3 = this.f.a();
         this.f.a(var3, false);
         this.c.setContentView(this.f.f());
         this.c.show();

         Exception var10000;
         label54: {
            boolean var10001;
            try {
               this.f.j();
               if (this.c() != null) {
                  this.c().setViewableChange(false);
               }
            } catch (Exception var15) {
               var10000 = var15;
               var10001 = false;
               break label54;
            }

            View var9;
            try {
               var9 = this.c.getWindow().findViewById(16908310);
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label54;
            }

            if (var9 != null) {
               ViewParent var10;
               try {
                  var10 = var9.getParent();
               } catch (Exception var13) {
                  var10000 = var13;
                  var10001 = false;
                  break label54;
               }

               if (var10 != null) {
                  try {
                     if (var10 instanceof View) {
                        ((View)var10).setBackgroundColor(-16777216);
                     }
                  } catch (Exception var12) {
                     var10000 = var12;
                     var10001 = false;
                     break label54;
                  }
               }
            }

            try {
               this.a(true);
               return;
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
            }
         }

         Exception var5 = var10000;
         StringBuilder var6 = new StringBuilder();
         var6.append("ADFBrowserDlg->show: ");
         var6.append(var5.toString());
         k.b(var6.toString());
      } else {
         throw new Exception("browser is already running");
      }
   }

   public void onDismiss(DialogInterface var1) {
      try {
         this.f.i().stopLoading();
         if (this.c() != null) {
            this.c().setViewableChange(true);
         }

         if (this.f.c() != null) {
            this.f.c().b();
         }

         this.f.i().postDelayed(new d$a(this), 3000L);
         this.a(false);
      } catch (Exception var3) {
      }
   }

   public boolean onKey(DialogInterface var1, int var2, KeyEvent var3) {
      if (var2 == 4 && var3.getAction() == 1) {
         boolean var8;
         try {
            if (this.f.c() == null) {
               return false;
            }

            var8 = this.f.c().b();
         } catch (Exception var9) {
            StringBuilder var5 = new StringBuilder();
            var5.append("ADFBrowserDlg->onKey: ");
            var5.append(var9.toString());
            k.b(var5.toString());
            return false;
         }

         if (var8) {
            return true;
         }
      }

      return false;
   }
}
