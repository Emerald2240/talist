package com.noqoush.adfalcon.android.sdk.urlactions;

import android.content.Intent;
import com.noqoush.adfalcon.android.sdk.ADFActivity;

public class k extends b {
   public boolean a(e var1) {
      boolean var4;
      label26: {
         boolean var5;
         try {
            String var3 = var1.b().toLowerCase();
            if (this.d(var3) && var3.contains(".mp4") || var3.contains(".mp3")) {
               break label26;
            }

            var5 = var3.contains(".3gp");
         } catch (Exception var6) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var6);
            return false;
         }

         var4 = false;
         if (!var5) {
            return var4;
         }
      }

      var4 = true;
      return var4;
   }

   public boolean b(e var1) throws Exception {
      try {
         ADFActivity.b = new com.noqoush.adfalcon.android.sdk.l();
         Intent var3 = new Intent(var1.a(), ADFActivity.class);
         var3.putExtra("url", var1.b());
         var1.a().startActivity(var3);
         if (var1.c() != null) {
            var1.c().a(i.a, m.a);
         }

         return true;
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
         if (var1.c() != null) {
            var1.c().a();
         }

         return false;
      }
   }
}
