package com.iab.omid.library.adfalcon.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class a {
   private static a a = new a();
   private final ArrayList b = new ArrayList();
   private final ArrayList c = new ArrayList();

   private a() {
   }

   public static a a() {
      return a;
   }

   public void a(com.iab.omid.library.adfalcon.adsession.a var1) {
      this.b.add(var1);
   }

   public Collection b() {
      return Collections.unmodifiableCollection(this.b);
   }

   public void b(com.iab.omid.library.adfalcon.adsession.a var1) {
      boolean var2 = this.d();
      this.c.add(var1);
      if (!var2) {
         e.a().b();
      }

   }

   public Collection c() {
      return Collections.unmodifiableCollection(this.c);
   }

   public void c(com.iab.omid.library.adfalcon.adsession.a var1) {
      boolean var2 = this.d();
      this.b.remove(var1);
      this.c.remove(var1);
      if (var2 && !this.d()) {
         e.a().c();
      }

   }

   public boolean d() {
      return this.c.size() > 0;
   }
}
