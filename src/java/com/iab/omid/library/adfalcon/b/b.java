package com.iab.omid.library.adfalcon.b;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Iterator;

public class b {
   private static b a = new b();
   private Context b;
   private BroadcastReceiver c;
   private boolean d;
   private boolean e;
   private b.a f;

   private b() {
   }

   public static b a() {
      return a;
   }

   private void a(boolean var1) {
      if (this.e != var1) {
         this.e = var1;
         if (this.d) {
            this.g();
            b.a var2 = this.f;
            if (var2 != null) {
               var2.a(this.d());
            }
         }
      }

   }

   private void e() {
      this.c = new BroadcastReceiver() {
         public void onReceive(Context var1, Intent var2) {
            if (var2 != null) {
               b var4;
               boolean var5;
               if ("android.intent.action.SCREEN_OFF".equals(var2.getAction())) {
                  var4 = b.this;
                  var5 = true;
               } else {
                  if (!"android.intent.action.USER_PRESENT".equals(var2.getAction())) {
                     if (!"android.intent.action.SCREEN_ON".equals(var2.getAction())) {
                        return;
                     }

                     KeyguardManager var3 = (KeyguardManager)var1.getSystemService("keyguard");
                     if (var3 == null || var3.inKeyguardRestrictedInputMode()) {
                        return;
                     }
                  }

                  var4 = b.this;
                  var5 = false;
               }

               var4.a(var5);
            }
         }
      };
      IntentFilter var1 = new IntentFilter();
      var1.addAction("android.intent.action.SCREEN_OFF");
      var1.addAction("android.intent.action.SCREEN_ON");
      var1.addAction("android.intent.action.USER_PRESENT");
      this.b.registerReceiver(this.c, var1);
   }

   private void f() {
      Context var1 = this.b;
      if (var1 != null) {
         BroadcastReceiver var2 = this.c;
         if (var2 != null) {
            var1.unregisterReceiver(var2);
            this.c = null;
         }
      }

   }

   private void g() {
      boolean var1 = true ^ this.e;
      Iterator var2 = com.iab.omid.library.adfalcon.b.a.a().b().iterator();

      while(var2.hasNext()) {
         ((com.iab.omid.library.adfalcon.adsession.a)var2.next()).getAdSessionStatePublisher().a(var1);
      }

   }

   public void a(Context var1) {
      this.b = var1.getApplicationContext();
   }

   public void a(b.a var1) {
      this.f = var1;
   }

   public void b() {
      this.e();
      this.d = true;
      this.g();
   }

   public void c() {
      this.f();
      this.d = false;
      this.e = false;
      this.f = null;
   }

   public boolean d() {
      return true ^ this.e;
   }

   public interface a {
      void a(boolean var1);
   }
}
