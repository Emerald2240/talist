package com.iab.omid.library.adfalcon.walking.a;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public class f extends com.iab.omid.library.adfalcon.walking.a.a {
   public f(com.iab.omid.library.adfalcon.walking.a.b.b var1, HashSet var2, JSONObject var3, long var4) {
      super(var1, var2, var3, var4);
   }

   private void b(String var1) {
      com.iab.omid.library.adfalcon.b.a var2 = com.iab.omid.library.adfalcon.b.a.a();
      if (var2 != null) {
         Iterator var3 = var2.b().iterator();

         while(var3.hasNext()) {
            com.iab.omid.library.adfalcon.adsession.a var4 = (com.iab.omid.library.adfalcon.adsession.a)var3.next();
            if (super.a.contains(var4.getAdSessionId())) {
               var4.getAdSessionStatePublisher().a(var1, super.c);
            }
         }
      }

   }

   protected String a(Object... var1) {
      if (com.iab.omid.library.adfalcon.d.b.b(super.b, super.d.b())) {
         return null;
      } else {
         super.d.a(super.b);
         return super.b.toString();
      }
   }

   protected void a(String var1) {
      if (!TextUtils.isEmpty(var1)) {
         this.b(var1);
      }

      super.a(var1);
   }

   // $FF: synthetic method
   protected Object doInBackground(Object[] var1) {
      return this.a(var1);
   }

   // $FF: synthetic method
   protected void onPostExecute(Object var1) {
      this.a((String)var1);
   }
}
