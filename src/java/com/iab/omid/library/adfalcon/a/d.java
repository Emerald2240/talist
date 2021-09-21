package com.iab.omid.library.adfalcon.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings.System;

public final class d extends ContentObserver {
   private final Context a;
   private final AudioManager b;
   private final a c;
   private final c d;
   private float e;

   public d(Handler var1, Context var2, a var3, c var4) {
      super(var1);
      this.a = var2;
      this.b = (AudioManager)var2.getSystemService("audio");
      this.c = var3;
      this.d = var4;
   }

   private boolean a(float var1) {
      return var1 != this.e;
   }

   private float c() {
      int var1 = this.b.getStreamVolume(3);
      int var2 = this.b.getStreamMaxVolume(3);
      return this.c.a(var1, var2);
   }

   private void d() {
      this.d.a(this.e);
   }

   public void a() {
      this.e = this.c();
      this.d();
      this.a.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this);
   }

   public void b() {
      this.a.getContentResolver().unregisterContentObserver(this);
   }

   public void onChange(boolean var1) {
      super.onChange(var1);
      float var2 = this.c();
      if (this.a(var2)) {
         this.e = var2;
         this.d();
      }

   }
}
