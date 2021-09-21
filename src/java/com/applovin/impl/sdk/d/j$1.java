package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class j$1 extends x {
   // $FF: synthetic field
   final String a;
   // $FF: synthetic field
   final j c;

   j$1(j var1, com.applovin.impl.sdk.network.b var2, com.applovin.impl.sdk.j var3, String var4) {
      super(var2, var3);
      this.c = var1;
      this.a = var4;
   }

   public void a(int var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Failed to dispatch postback. Error code: ");
      var2.append(var1);
      var2.append(" URL: ");
      var2.append(this.a);
      this.d(var2.toString());
      if (j.b(this.c) != null) {
         j.b(this.c).onPostbackFailure(this.a, var1);
      }

      if (j.a(this.c).o()) {
         this.b.ac().a(j.a(this.c).p(), j.a(this.c).a(), var1, (Object)null);
      }

   }

   public void a(Object var1, int var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("Successfully dispatched postback to URL: ");
      var3.append(this.a);
      this.a(var3.toString());
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.fc)) {
         if (var1 instanceof JSONObject) {
            JSONObject var14 = (JSONObject)var1;
            Iterator var15 = this.b.b(com.applovin.impl.sdk.b.d.aI).iterator();

            while(var15.hasNext()) {
               String var16 = (String)var15.next();
               if (j.a(this.c).a().startsWith(var16)) {
                  StringBuilder var17 = new StringBuilder();
                  var17.append("Updating settings from: ");
                  var17.append(j.a(this.c).a());
                  this.a(var17.toString());
                  com.applovin.impl.sdk.utils.h.d(var14, this.b);
                  com.applovin.impl.sdk.utils.h.c(var14, this.b);
                  break;
               }
            }
         }
      } else if (var1 instanceof String) {
         Iterator var6 = this.b.b(com.applovin.impl.sdk.b.d.aI).iterator();

         label42:
         while(true) {
            String var8;
            do {
               String var7;
               do {
                  if (!var6.hasNext()) {
                     break label42;
                  }

                  var7 = (String)var6.next();
               } while(!j.a(this.c).a().startsWith(var7));

               var8 = (String)var1;
            } while(TextUtils.isEmpty(var8));

            try {
               StringBuilder var9 = new StringBuilder();
               var9.append("Updating settings from: ");
               var9.append(j.a(this.c).a());
               this.a(var9.toString());
               JSONObject var13 = new JSONObject(var8);
               com.applovin.impl.sdk.utils.h.d(var13, this.b);
               com.applovin.impl.sdk.utils.h.c(var13, this.b);
               break;
            } catch (JSONException var18) {
            }
         }
      }

      if (j.b(this.c) != null) {
         j.b(this.c).onPostbackSuccess(this.a);
      }

      if (j.a(this.c).o()) {
         this.b.ac().a(j.a(this.c).p(), j.a(this.c).a(), var2, var1);
      }

   }
}
