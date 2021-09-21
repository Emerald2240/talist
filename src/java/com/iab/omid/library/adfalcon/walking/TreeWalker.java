package com.iab.omid.library.adfalcon.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.adfalcon.d.d;
import com.iab.omid.library.adfalcon.d.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements com.iab.omid.library.adfalcon.c.a.a {
   private static TreeWalker a = new TreeWalker();
   private static Handler b = new Handler(Looper.getMainLooper());
   private static Handler c = null;
   private static final Runnable j = new TreeWalker$2();
   private static final Runnable k = new TreeWalker$3();
   private List d = new ArrayList();
   private int e;
   private com.iab.omid.library.adfalcon.c.b f = new com.iab.omid.library.adfalcon.c.b();
   private a g = new a();
   private b h = new b(new com.iab.omid.library.adfalcon.walking.a.c());
   private long i;

   TreeWalker() {
   }

   // $FF: synthetic method
   static b a(TreeWalker var0) {
      return var0.h;
   }

   private void a(long var1) {
      if (this.d.size() > 0) {
         Iterator var3 = this.d.iterator();

         while(var3.hasNext()) {
            <undefinedtype> var4 = (<undefinedtype>)var3.next();
            var4.onTreeProcessed(this.e, TimeUnit.NANOSECONDS.toMillis(var1));
            if (var4 instanceof TreeWalker.TreeWalkerNanoTimeLogger) {
               ((TreeWalker.TreeWalkerNanoTimeLogger)var4).onTreeProcessedNano(this.e, var1);
            }
         }
      }

   }

   private void a(View var1, com.iab.omid.library.adfalcon.c.a var2, JSONObject var3, c var4) {
      boolean var5;
      if (var4 == com.iab.omid.library.adfalcon.walking.c.a) {
         var5 = true;
      } else {
         var5 = false;
      }

      var2.a(var1, var3, this, var5);
   }

   private void a(String var1, View var2, JSONObject var3) {
      com.iab.omid.library.adfalcon.c.a var4 = this.f.b();
      String var5 = this.g.a(var1);
      if (var5 != null) {
         JSONObject var6 = var4.a(var2);
         com.iab.omid.library.adfalcon.d.b.a(var6, var1);
         com.iab.omid.library.adfalcon.d.b.b(var6, var5);
         com.iab.omid.library.adfalcon.d.b.a(var3, var6);
      }

   }

   private boolean a(View var1, JSONObject var2) {
      String var3 = this.g.a(var1);
      if (var3 != null) {
         com.iab.omid.library.adfalcon.d.b.a(var2, var3);
         this.g.e();
         return true;
      } else {
         return false;
      }
   }

   private void b(View var1, JSONObject var2) {
      ArrayList var3 = this.g.b(var1);
      if (var3 != null) {
         com.iab.omid.library.adfalcon.d.b.a((JSONObject)var2, (List)var3);
      }

   }

   // $FF: synthetic method
   static void b(TreeWalker var0) {
      var0.h();
   }

   // $FF: synthetic method
   static Handler e() {
      return c;
   }

   // $FF: synthetic method
   static Runnable f() {
      return j;
   }

   // $FF: synthetic method
   static Runnable g() {
      return k;
   }

   public static TreeWalker getInstance() {
      return a;
   }

   private void h() {
      this.i();
      this.d();
      this.j();
   }

   private void i() {
      this.e = 0;
      this.i = com.iab.omid.library.adfalcon.d.d.a();
   }

   private void j() {
      this.a(com.iab.omid.library.adfalcon.d.d.a() - this.i);
   }

   private void k() {
      if (c == null) {
         Handler var1 = new Handler(Looper.getMainLooper());
         c = var1;
         var1.post(j);
         c.postDelayed(k, 200L);
      }

   }

   private void l() {
      Handler var1 = c;
      if (var1 != null) {
         var1.removeCallbacks(k);
         c = null;
      }

   }

   public void a() {
      this.k();
   }

   public void a(View var1, com.iab.omid.library.adfalcon.c.a var2, JSONObject var3) {
      if (com.iab.omid.library.adfalcon.d.f.d(var1)) {
         c var4 = this.g.c(var1);
         if (var4 != com.iab.omid.library.adfalcon.walking.c.c) {
            JSONObject var5 = var2.a(var1);
            com.iab.omid.library.adfalcon.d.b.a(var3, var5);
            if (!this.a(var1, var5)) {
               this.b(var1, var5);
               this.a(var1, var2, var5, var4);
            }

            ++this.e;
         }
      }
   }

   public void addTimeLogger(Object var1) {
      if (!this.d.contains(var1)) {
         this.d.add(var1);
      }

   }

   public void b() {
      this.c();
      this.d.clear();
      b.post(new TreeWalker$1(this));
   }

   public void c() {
      this.l();
   }

   void d() {
      this.g.c();
      long var1 = com.iab.omid.library.adfalcon.d.d.a();
      com.iab.omid.library.adfalcon.c.a var3 = this.f.a();
      if (this.g.b().size() > 0) {
         Iterator var5 = this.g.b().iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            JSONObject var7 = var3.a((View)null);
            this.a(var6, this.g.b(var6), var7);
            com.iab.omid.library.adfalcon.d.b.a(var7);
            HashSet var8 = new HashSet();
            var8.add(var6);
            this.h.b(var7, var8, var1);
         }
      }

      if (this.g.a().size() > 0) {
         JSONObject var4 = var3.a((View)null);
         this.a((View)null, var3, var4, com.iab.omid.library.adfalcon.walking.c.a);
         com.iab.omid.library.adfalcon.d.b.a(var4);
         this.h.a(var4, this.g.a(), var1);
      } else {
         this.h.a();
      }

      this.g.d();
   }

   public void removeTimeLogger(Object var1) {
      if (this.d.contains(var1)) {
         this.d.remove(var1);
      }

   }

   public interface TreeWalkerNanoTimeLogger extends <undefinedtype> {
      void onTreeProcessedNano(int var1, long var2);
   }
}
