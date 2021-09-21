package com.iab.omid.library.adfalcon.adsession;

import android.view.View;
import com.iab.omid.library.adfalcon.d.e;
import com.iab.omid.library.adfalcon.publisher.AdSessionStatePublisher;
import com.iab.omid.library.adfalcon.publisher.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class a extends AdSession {
   private final AdSessionContext a;
   private final AdSessionConfiguration b;
   private final List c = new ArrayList();
   private com.iab.omid.library.adfalcon.e.a d;
   private AdSessionStatePublisher e;
   private boolean f = false;
   private boolean g = false;
   private String h;
   private boolean i;

   a(AdSessionConfiguration var1, AdSessionContext var2) {
      this.b = var1;
      this.a = var2;
      this.h = UUID.randomUUID().toString();
      this.c((View)null);
      Object var3;
      if (var2.getAdSessionContextType() == AdSessionContextType.HTML) {
         var3 = new com.iab.omid.library.adfalcon.publisher.a(var2.getWebView());
      } else {
         var3 = new b(var2.getInjectedResourcesMap(), var2.getOmidJsScriptContent());
      }

      this.e = (AdSessionStatePublisher)var3;
      this.e.a();
      com.iab.omid.library.adfalcon.b.a.a().a(this);
      this.e.a(var1);
   }

   private com.iab.omid.library.adfalcon.e.a a(View var1) {
      Iterator var2 = this.c.iterator();

      com.iab.omid.library.adfalcon.e.a var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (com.iab.omid.library.adfalcon.e.a)var2.next();
      } while(var3.get() != var1);

      return var3;
   }

   private void b(View var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("FriendlyObstruction is null");
      }
   }

   private void c(View var1) {
      this.d = new com.iab.omid.library.adfalcon.e.a(var1);
   }

   private void d(View var1) {
      Collection var2 = com.iab.omid.library.adfalcon.b.a.a().b();
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            a var4 = (a)var3.next();
            if (var4 != this && var4.c() == var1) {
               var4.d.clear();
            }
         }
      }

   }

   private void i() {
      if (this.i) {
         throw new IllegalStateException("Impression event can only be sent once");
      }
   }

   public List a() {
      return this.c;
   }

   public void addFriendlyObstruction(View var1) {
      if (!this.g) {
         this.b(var1);
         if (this.a(var1) == null) {
            this.c.add(new com.iab.omid.library.adfalcon.e.a(var1));
         }

      }
   }

   void b() {
      this.i();
      this.getAdSessionStatePublisher().g();
      this.i = true;
   }

   public View c() {
      return (View)this.d.get();
   }

   public boolean d() {
      return this.f && !this.g;
   }

   public boolean e() {
      return this.f;
   }

   public void error(ErrorType var1, String var2) {
      if (!this.g) {
         com.iab.omid.library.adfalcon.d.e.a((Object)var1, "Error type is null");
         com.iab.omid.library.adfalcon.d.e.a(var2, "Message is null");
         this.getAdSessionStatePublisher().a(var1, var2);
      } else {
         throw new IllegalStateException("AdSession is finished");
      }
   }

   public boolean f() {
      return this.g;
   }

   public void finish() {
      if (!this.g) {
         this.d.clear();
         this.removeAllFriendlyObstructions();
         this.g = true;
         this.getAdSessionStatePublisher().f();
         com.iab.omid.library.adfalcon.b.a.a().c(this);
         this.getAdSessionStatePublisher().b();
         this.e = null;
      }
   }

   public boolean g() {
      return this.b.isNativeImpressionOwner();
   }

   public String getAdSessionId() {
      return this.h;
   }

   public AdSessionStatePublisher getAdSessionStatePublisher() {
      return this.e;
   }

   public boolean h() {
      return this.b.isNativeVideoEventsOwner();
   }

   public void registerAdView(View var1) {
      if (!this.g) {
         com.iab.omid.library.adfalcon.d.e.a((Object)var1, "AdView is null");
         if (this.c() != var1) {
            this.c(var1);
            this.getAdSessionStatePublisher().h();
            this.d(var1);
         }
      }
   }

   public void removeAllFriendlyObstructions() {
      if (!this.g) {
         this.c.clear();
      }
   }

   public void removeFriendlyObstruction(View var1) {
      if (!this.g) {
         this.b(var1);
         com.iab.omid.library.adfalcon.e.a var2 = this.a(var1);
         if (var2 != null) {
            this.c.remove(var2);
         }

      }
   }

   public void start() {
      if (!this.f) {
         this.f = true;
         com.iab.omid.library.adfalcon.b.a.a().b(this);
         float var1 = com.iab.omid.library.adfalcon.b.e.a().d();
         this.e.a(var1);
         this.e.a(this, this.a);
      }
   }
}
