package com.applovin.impl.sdk.d;

import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

public class ad extends ae {
   private final com.applovin.impl.sdk.ad.f a;
   private final AppLovinAdRewardListener c;

   public ad(com.applovin.impl.sdk.ad.f var1, AppLovinAdRewardListener var2, com.applovin.impl.sdk.j var3) {
      super("TaskValidateAppLovinReward", var3);
      this.a = var1;
      this.c = var2;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.z;
   }

   protected void a(int var1) {
      super.a(var1);
      String var2;
      if (var1 >= 400 && var1 < 500) {
         this.c.userRewardRejected(this.a, Collections.emptyMap());
         var2 = "rejected";
      } else {
         this.c.validationRequestFailed(this.a, var1);
         var2 = "network_timeout";
      }

      this.a.a(com.applovin.impl.sdk.a.c.a(var2));
   }

   protected void a(com.applovin.impl.sdk.a.c var1) {
      this.a.a(var1);
      String var2 = var1.b();
      Map var3 = var1.a();
      if (var2.equals("accepted")) {
         this.c.userRewardVerified(this.a, var3);
      } else if (var2.equals("quota_exceeded")) {
         this.c.userOverQuota(this.a, var3);
      } else if (var2.equals("rejected")) {
         this.c.userRewardRejected(this.a, var3);
      } else {
         this.c.validationRequestFailed(this.a, -400);
      }
   }

   protected void a(JSONObject var1) {
      com.applovin.impl.sdk.utils.i.a(var1, "zone_id", this.a.getAdZone().a(), this.b);
      String var2 = this.a.getClCode();
      if (!com.applovin.impl.sdk.utils.n.b(var2)) {
         var2 = "NO_CLCODE";
      }

      com.applovin.impl.sdk.utils.i.a(var1, "clcode", var2, this.b);
   }

   public String b() {
      return "2.0/vr";
   }

   protected boolean c() {
      return this.a.aH();
   }
}
