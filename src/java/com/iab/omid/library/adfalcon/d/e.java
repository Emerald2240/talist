package com.iab.omid.library.adfalcon.d;

import android.text.TextUtils;
import com.iab.omid.library.adfalcon.Omid;
import com.iab.omid.library.adfalcon.adsession.Owner;

public class e {
   public static void a() {
      if (!Omid.isActive()) {
         throw new IllegalStateException("Method called before OM SDK activation");
      }
   }

   public static void a(Owner var0) {
      if (var0.equals(Owner.NONE)) {
         throw new IllegalArgumentException("Impression owner is none");
      }
   }

   public static void a(com.iab.omid.library.adfalcon.adsession.a var0) {
      if (var0.e()) {
         throw new IllegalStateException("AdSession is started");
      }
   }

   public static void a(Object var0, String var1) {
      if (var0 == null) {
         throw new IllegalArgumentException(var1);
      }
   }

   public static void a(String var0, int var1, String var2) {
      if (var0.length() > var1) {
         throw new IllegalArgumentException(var2);
      }
   }

   public static void a(String var0, String var1) {
      if (TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException(var1);
      }
   }

   public static void b(com.iab.omid.library.adfalcon.adsession.a var0) {
      if (var0.f()) {
         throw new IllegalStateException("AdSession is finished");
      }
   }

   public static void c(com.iab.omid.library.adfalcon.adsession.a var0) {
      h(var0);
      b(var0);
   }

   public static void d(com.iab.omid.library.adfalcon.adsession.a var0) {
      if (var0.getAdSessionStatePublisher().c() != null) {
         throw new IllegalStateException("AdEvents already exists for AdSession");
      }
   }

   public static void e(com.iab.omid.library.adfalcon.adsession.a var0) {
      if (var0.getAdSessionStatePublisher().d() != null) {
         throw new IllegalStateException("VideoEvents already exists for AdSession");
      }
   }

   public static void f(com.iab.omid.library.adfalcon.adsession.a var0) {
      if (!var0.g()) {
         throw new IllegalStateException("Impression event is not expected from the Native AdSession");
      }
   }

   public static void g(com.iab.omid.library.adfalcon.adsession.a var0) {
      if (!var0.h()) {
         throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
      }
   }

   private static void h(com.iab.omid.library.adfalcon.adsession.a var0) {
      if (!var0.e()) {
         throw new IllegalStateException("AdSession is not started");
      }
   }
}
