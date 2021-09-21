package com.iab.omid.library.adfalcon.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.adfalcon.d.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class a {
   private final HashMap a = new HashMap();
   private final HashMap b = new HashMap();
   private final HashMap c = new HashMap();
   private final HashSet d = new HashSet();
   private final HashSet e = new HashSet();
   private final HashSet f = new HashSet();
   private final HashMap g = new HashMap();
   private boolean h;

   private void a(View var1, com.iab.omid.library.adfalcon.adsession.a var2) {
      ArrayList var3 = (ArrayList)this.c.get(var1);
      if (var3 == null) {
         var3 = new ArrayList();
         this.c.put(var1, var3);
      }

      var3.add(var2.getAdSessionId());
   }

   private void a(com.iab.omid.library.adfalcon.adsession.a var1) {
      Iterator var2 = var1.a().iterator();

      while(var2.hasNext()) {
         View var3 = (View)((com.iab.omid.library.adfalcon.e.a)var2.next()).get();
         if (var3 != null) {
            this.a(var3, var1);
         }
      }

   }

   private String d(View var1) {
      if (!var1.hasWindowFocus()) {
         return "noWindowFocus";
      } else {
         HashSet var2 = new HashSet();

         while(var1 != null) {
            String var4 = com.iab.omid.library.adfalcon.d.f.e(var1);
            if (var4 != null) {
               return var4;
            }

            var2.add(var1);
            ViewParent var6 = var1.getParent();
            if (var6 instanceof View) {
               var1 = (View)var6;
            } else {
               var1 = null;
            }
         }

         this.d.addAll(var2);
         return null;
      }
   }

   public String a(View var1) {
      if (this.a.size() == 0) {
         return null;
      } else {
         String var2 = (String)this.a.get(var1);
         if (var2 != null) {
            this.a.remove(var1);
         }

         return var2;
      }
   }

   public String a(String var1) {
      return (String)this.g.get(var1);
   }

   public HashSet a() {
      return this.e;
   }

   public View b(String var1) {
      return (View)this.b.get(var1);
   }

   public ArrayList b(View var1) {
      if (this.c.size() == 0) {
         return null;
      } else {
         ArrayList var2 = (ArrayList)this.c.get(var1);
         if (var2 != null) {
            this.c.remove(var1);
            Collections.sort(var2);
         }

         return var2;
      }
   }

   public HashSet b() {
      return this.f;
   }

   public c c(View var1) {
      if (this.d.contains(var1)) {
         return com.iab.omid.library.adfalcon.walking.c.a;
      } else {
         return this.h ? com.iab.omid.library.adfalcon.walking.c.b : com.iab.omid.library.adfalcon.walking.c.c;
      }
   }

   public void c() {
      com.iab.omid.library.adfalcon.b.a var1 = com.iab.omid.library.adfalcon.b.a.a();
      if (var1 != null) {
         Iterator var2 = var1.c().iterator();

         while(var2.hasNext()) {
            com.iab.omid.library.adfalcon.adsession.a var3 = (com.iab.omid.library.adfalcon.adsession.a)var2.next();
            View var4 = var3.c();
            if (var3.d()) {
               String var5 = var3.getAdSessionId();
               if (var4 != null) {
                  String var8 = this.d(var4);
                  if (var8 == null) {
                     this.e.add(var5);
                     this.a.put(var4, var5);
                     this.a(var3);
                  } else {
                     this.f.add(var5);
                     this.b.put(var5, var4);
                     this.g.put(var5, var8);
                  }
               } else {
                  this.f.add(var5);
                  this.g.put(var5, "noAdView");
               }
            }
         }
      }

   }

   public void d() {
      this.a.clear();
      this.b.clear();
      this.c.clear();
      this.d.clear();
      this.e.clear();
      this.f.clear();
      this.g.clear();
      this.h = false;
   }

   public void e() {
      this.h = true;
   }
}
