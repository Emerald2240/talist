package com.applovin.impl.mediation.c;

import android.app.Activity;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a extends com.applovin.impl.sdk.d.a {
   private final Activity a;

   public a(Activity var1, j var2) {
      super("TaskAutoInitAdapters", var2, true);
      this.a = var1;
   }

   // $FF: synthetic method
   static Activity a(a var0) {
      return var0.a;
   }

   private List a(JSONArray var1, JSONObject var2) {
      ArrayList var3 = new ArrayList(var1.length());

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3.add(new com.applovin.impl.mediation.b.e(i.a(var1, var4, (JSONObject)null, this.b), var2, this.b));
      }

      return var3;
   }

   // $FF: synthetic method
   static void a(a var0, String var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static j b(a var0) {
      return var0.b;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.A;
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }
}
