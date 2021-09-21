package com.iab.omid.library.adfalcon.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.adfalcon.walking.TreeWalker;
import java.util.Iterator;

public class e implements com.iab.omid.library.adfalcon.a.c, b.a {
   private static e a;
   private float b = 0.0F;
   private final com.iab.omid.library.adfalcon.a.e c;
   private final com.iab.omid.library.adfalcon.a.b d;
   private com.iab.omid.library.adfalcon.a.d e;
   private a f;

   public e(com.iab.omid.library.adfalcon.a.e var1, com.iab.omid.library.adfalcon.a.b var2) {
      this.c = var1;
      this.d = var2;
   }

   public static e a() {
      if (a == null) {
         com.iab.omid.library.adfalcon.a.b var0 = new com.iab.omid.library.adfalcon.a.b();
         a = new e(new com.iab.omid.library.adfalcon.a.e(), var0);
      }

      return a;
   }

   private a e() {
      if (this.f == null) {
         this.f = com.iab.omid.library.adfalcon.b.a.a();
      }

      return this.f;
   }

   public void a(float var1) {
      this.b = var1;
      Iterator var2 = this.e().c().iterator();

      while(var2.hasNext()) {
         ((com.iab.omid.library.adfalcon.adsession.a)var2.next()).getAdSessionStatePublisher().a(var1);
      }

   }

   public void a(Context var1) {
      com.iab.omid.library.adfalcon.a.a var2 = this.d.a();
      this.e = this.c.a(new Handler(), var1, var2, this);
   }

   public void a(boolean var1) {
      if (var1) {
         TreeWalker.getInstance().a();
      } else {
         TreeWalker.getInstance().c();
      }
   }

   public void b() {
      com.iab.omid.library.adfalcon.b.b.a().a((b.a)this);
      com.iab.omid.library.adfalcon.b.b.a().b();
      if (com.iab.omid.library.adfalcon.b.b.a().d()) {
         TreeWalker.getInstance().a();
      }

      this.e.a();
   }

   public void c() {
      TreeWalker.getInstance().b();
      com.iab.omid.library.adfalcon.b.b.a().c();
      this.e.b();
   }

   public float d() {
      return this.b;
   }
}
