package com.noqoush.adfalcon.android.sdk.video.vast.manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.noqoush.adfalcon.android.sdk.R;
import com.noqoush.adfalcon.android.sdk.k;
import com.noqoush.adfalcon.android.sdk.m;

class a implements com.noqoush.adfalcon.android.sdk.a {
   private e a;
   private Activity b;

   a(e var1) {
      this.a(var1);
   }

   // $FF: synthetic method
   static e a(a var0) {
      return var0.h();
   }

   private void a(e var1) {
      this.a = var1;
   }

   private e h() {
      return this.a;
   }

   public void a() {
      // $FF: Couldn't be decompiled
   }

   public void a(Activity var1) {
      this.b = var1;
   }

   public void a(Bundle var1) {
   }

   public void a(Bundle var1, Activity var2, Window var3, Intent var4) {
      this.a(var2);
      this.g().setVolumeControlStream(3);
      this.g().setTheme(16974065);
      if (this.h() != null) {
         try {
            this.h().setVastPlayer(new com.noqoush.adfalcon.android.sdk.video.vast.player.h(var2));
            this.h().getVastPlayer().setVastActivity(this.g());
            var2.setContentView(R.layout.activity_adfvast);
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      var3.addFlags(128);
   }

   public void a(m var1) {
   }

   public void b() {
   }

   public void b(Bundle var1) {
   }

   public void b(Bundle var1, Activity var2, Window var3, Intent var4) {
   }

   public void c() {
      try {
         if (this.h() != null && this.h().getVastPlayer() != null) {
            this.h().getVastPlayer().l();
            return;
         }
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFActivity->onPause->");
         var2.append(var3.toString());
         k.b(var2.toString());
      }

   }

   public void d() {
      try {
         if (this.h() != null && this.h().getVastPlayer() != null) {
            this.h().getVastPlayer().n();
            return;
         }
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFActivity->onPause->");
         var2.append(var3.toString());
         k.b(var2.toString());
      }

   }

   public void e() {
   }

   public void f() {
      try {
         if (this.h() != null && this.h().getVastPlayer() != null) {
            this.h().getVastPlayer().i();
            return;
         }
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFActivity->onDestroy->");
         var2.append(var3.toString());
         k.b(var2.toString());
      }

   }

   public Activity g() {
      return this.b;
   }
}
