package com.iab.omid.library.adfalcon.c;

import android.view.View;
import com.iab.omid.library.adfalcon.d.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c implements com.iab.omid.library.adfalcon.c.a {
   private final com.iab.omid.library.adfalcon.c.a a;

   public c(com.iab.omid.library.adfalcon.c.a var1) {
      this.a = var1;
   }

   ArrayList a() {
      ArrayList var1 = new ArrayList();
      com.iab.omid.library.adfalcon.b.a var2 = com.iab.omid.library.adfalcon.b.a.a();
      if (var2 != null) {
         Collection var3 = var2.c();
         IdentityHashMap var4 = new IdentityHashMap(3 + 2 * var3.size());
         Iterator var5 = var3.iterator();

         while(true) {
            View var7;
            do {
               do {
                  View var6;
                  do {
                     do {
                        if (!var5.hasNext()) {
                           return var1;
                        }

                        var6 = ((com.iab.omid.library.adfalcon.adsession.a)var5.next()).c();
                     } while(var6 == null);
                  } while(!f.c(var6));

                  var7 = var6.getRootView();
               } while(var7 == null);
            } while(var4.containsKey(var7));

            var4.put(var7, var7);
            float var9 = f.a(var7);

            int var10;
            for(var10 = var1.size(); var10 > 0 && f.a((View)var1.get(var10 - 1)) > var9; --var10) {
            }

            var1.add(var10, var7);
         }
      } else {
         return var1;
      }
   }

   public JSONObject a(View var1) {
      return com.iab.omid.library.adfalcon.d.b.a(0, 0, 0, 0);
   }

   public void a(View var1, JSONObject var2, com.iab.omid.library.adfalcon.c.a.a var3, boolean var4) {
      Iterator var5 = this.a().iterator();

      while(var5.hasNext()) {
         var3.a((View)var5.next(), this.a, var2);
      }

   }
}
