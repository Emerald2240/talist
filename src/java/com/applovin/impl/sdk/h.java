package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.DialogInterface.OnClickListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

class h extends BroadcastReceiver {
   private static AlertDialog b;
   private static final AtomicBoolean c = new AtomicBoolean();
   private final i a;
   private com.applovin.impl.sdk.utils.o d;

   h(i var1, j var2) {
      this.a = var1;
      var2.af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
      var2.af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
   }

   public void a(long var1, final j var3, final h.a var4) {
      if (var1 > 0L) {
         AlertDialog var5 = b;
         if (var5 == null || !var5.isShowing()) {
            if (c.getAndSet(true)) {
               if (var1 >= this.d.a()) {
                  p var11 = var3.v();
                  StringBuilder var12 = new StringBuilder();
                  var12.append("Skip scheduling consent alert - one scheduled already with remaining time of ");
                  var12.append(this.d.a());
                  var12.append(" milliseconds");
                  var11.d("ConsentAlertManager", var12.toString());
                  return;
               }

               p var16 = var3.v();
               StringBuilder var17 = new StringBuilder();
               var17.append("Scheduling consent alert earlier (");
               var17.append(var1);
               var17.append("ms) than remaining scheduled time (");
               var17.append(this.d.a());
               var17.append("ms)");
               var16.b("ConsentAlertManager", var17.toString());
               this.d.d();
            }

            p var6 = var3.v();
            StringBuilder var7 = new StringBuilder();
            var7.append("Scheduling consent alert for ");
            var7.append(var1);
            var7.append(" milliseconds");
            var6.b("ConsentAlertManager", var7.toString());
            this.d = com.applovin.impl.sdk.utils.o.a(var1, var3, new Runnable() {
               public void run() {
                  if (h.this.a.c()) {
                     var3.v().e("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                  } else {
                     Activity var1 = var3.aa().a();
                     if (var1 != null && com.applovin.impl.sdk.utils.h.a(var3.D())) {
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                           public void run() {
                              h.b = (new Builder(var3.aa().a())).setTitle((CharSequence)var3.a(com.applovin.impl.sdk.b.d.aB)).setMessage((CharSequence)var3.a(com.applovin.impl.sdk.b.d.aC)).setCancelable(false).setPositiveButton((CharSequence)var3.a(com.applovin.impl.sdk.b.d.aD), new OnClickListener() {
                                 public void onClick(DialogInterface var1, int var2) {
                                    var4.a();
                                    var1.dismiss();
                                    h.c.set(false);
                                 }
                              }).setNegativeButton((CharSequence)var3.a(com.applovin.impl.sdk.b.d.aE), new OnClickListener() {
                                 public void onClick(DialogInterface var1, int var2) {
                                    var4.b();
                                    var1.dismiss();
                                    h.c.set(false);
                                    long var3x = (Long)var3.a(com.applovin.impl.sdk.b.d.az);
                                    h.this.a(var3x, var3, var4);
                                 }
                              }).create();
                              h.b.show();
                           }
                        });
                     } else {
                        p var2;
                        String var3x;
                        if (var1 == null) {
                           var2 = var3.v();
                           var3x = "No parent Activity found - rescheduling consent alert...";
                        } else {
                           var2 = var3.v();
                           var3x = "No internet available - rescheduling consent alert...";
                        }

                        var2.e("ConsentAlertManager", var3x);
                        h.c.set(false);
                        long var4x = (Long)var3.a(com.applovin.impl.sdk.b.d.aA);
                        h.this.a(var4x, var3, var4);
                     }
                  }
               }
            });
         }
      }
   }

   public void onReceive(Context var1, Intent var2) {
      if (this.d != null) {
         String var3 = var2.getAction();
         if ("com.applovin.application_paused".equals(var3)) {
            this.d.b();
         } else {
            if ("com.applovin.application_resumed".equals(var3)) {
               this.d.c();
            }

         }
      }
   }

   public interface a {
      void a();

      void b();
   }
}
