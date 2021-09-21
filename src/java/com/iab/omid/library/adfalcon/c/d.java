package com.iab.omid.library.adfalcon.c;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class d implements com.iab.omid.library.adfalcon.c.a {
   private final int[] a = new int[2];

   private void a(ViewGroup var1, JSONObject var2, com.iab.omid.library.adfalcon.c.a.a var3) {
      for(int var4 = 0; var4 < var1.getChildCount(); ++var4) {
         var3.a(var1.getChildAt(var4), this, var2);
      }

   }

   private void b(ViewGroup var1, JSONObject var2, com.iab.omid.library.adfalcon.c.a.a var3) {
      HashMap var4 = new HashMap();

      for(int var5 = 0; var5 < var1.getChildCount(); ++var5) {
         View var9 = var1.getChildAt(var5);
         ArrayList var10 = (ArrayList)var4.get(var9.getZ());
         if (var10 == null) {
            var10 = new ArrayList();
            var4.put(var9.getZ(), var10);
         }

         var10.add(var9);
      }

      ArrayList var6 = new ArrayList(var4.keySet());
      Collections.sort(var6);
      Iterator var7 = var6.iterator();

      while(var7.hasNext()) {
         Iterator var8 = ((ArrayList)var4.get((Float)var7.next())).iterator();

         while(var8.hasNext()) {
            var3.a((View)var8.next(), this, var2);
         }
      }

   }

   public JSONObject a(View var1) {
      if (var1 == null) {
         return com.iab.omid.library.adfalcon.d.b.a(0, 0, 0, 0);
      } else {
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         var1.getLocationOnScreen(this.a);
         int[] var4 = this.a;
         return com.iab.omid.library.adfalcon.d.b.a(var4[0], var4[1], var2, var3);
      }
   }

   public void a(View var1, JSONObject var2, com.iab.omid.library.adfalcon.c.a.a var3, boolean var4) {
      if (var1 instanceof ViewGroup) {
         ViewGroup var5 = (ViewGroup)var1;
         if (var4 && VERSION.SDK_INT >= 21) {
            this.b(var5, var2, var3);
         } else {
            this.a(var5, var2, var3);
         }
      }
   }
}
