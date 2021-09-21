package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.d.r;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

public class PostbackServiceImpl implements AppLovinPostbackService {
   private final j a;

   public PostbackServiceImpl(j var1) {
      this.a = var1;
   }

   public void dispatchPostbackAsync(String var1, AppLovinPostbackListener var2) {
      this.dispatchPostbackRequest(g.b(this.a).d(var1).c(false).b(), var2);
   }

   public void dispatchPostbackRequest(g var1, r.a var2, AppLovinPostbackListener var3) {
      com.applovin.impl.sdk.d.j var4 = new com.applovin.impl.sdk.d.j(var1, var2, this.a, var3);
      this.a.K().a((com.applovin.impl.sdk.d.a)var4, var2);
   }

   public void dispatchPostbackRequest(g var1, AppLovinPostbackListener var2) {
      this.dispatchPostbackRequest(var1, r.a.e, var2);
   }

   public String toString() {
      return "PostbackService{}";
   }
}
