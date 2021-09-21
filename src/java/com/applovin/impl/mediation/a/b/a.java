package com.applovin.impl.mediation.a.b;

import android.os.Build.VERSION;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.utils.n;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a extends com.applovin.impl.sdk.d.a {
   private final com.applovin.impl.sdk.network.a.c a;

   public a(com.applovin.impl.sdk.network.a.c var1, j var2) {
      super("TaskFetchMediationDebuggerInfo", var2, true);
      this.a = var1;
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.network.a.c a(a var0) {
      return var0.a;
   }

   public i a() {
      return i.J;
   }

   protected Map b() {
      HashMap var1 = new HashMap();
      var1.put("sdk_version", AppLovinSdk.VERSION);
      var1.put("build", String.valueOf(131));
      if (!(Boolean)this.b.a(com.applovin.impl.sdk.b.d.eR)) {
         var1.put("sdk_key", this.b.t());
      }

      k.b var4 = this.b.O().c();
      var1.put("package_name", n.e(var4.c));
      var1.put("app_version", n.e(var4.b));
      var1.put("platform", "android");
      var1.put("os", n.e(VERSION.RELEASE));
      return var1;
   }

   public void run() {
      Map var1 = this.b();
      a$1 var2 = new a$1(this, com.applovin.impl.sdk.network.b.a(this.b).a(com.applovin.impl.mediation.d.b.c(this.b)).c(com.applovin.impl.mediation.d.b.d(this.b)).a(var1).b("GET").a((Object)(new JSONObject())).b(((Long)this.b.a(com.applovin.impl.sdk.b.c.g)).intValue()).a(), this.b, this.h());
      var2.a(com.applovin.impl.sdk.b.c.c);
      var2.b(com.applovin.impl.sdk.b.c.d);
      this.b.K().a((com.applovin.impl.sdk.d.a)var2);
   }
}
