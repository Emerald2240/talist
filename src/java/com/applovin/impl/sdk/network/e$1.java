package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.j;
import com.applovin.sdk.AppLovinPostbackListener;

class e$1 implements AppLovinPostbackListener {
   // $FF: synthetic field
   final f a;
   // $FF: synthetic field
   final AppLovinPostbackListener b;
   // $FF: synthetic field
   final e c;

   e$1(e var1, f var2, AppLovinPostbackListener var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void onPostbackFailure(String var1, int var2) {
      p var3 = e.a(this.c);
      StringBuilder var4 = new StringBuilder();
      var4.append("Failed to submit postback with errorCode ");
      var4.append(var2);
      var4.append(". Will retry later...  Postback: ");
      var4.append(this.a);
      var3.c("PersistentPostbackManager", var4.toString());
      e.b(this.c, this.a);
      j.a(this.b, var1, var2);
   }

   public void onPostbackSuccess(String var1) {
      e.a(this.c, this.a);
      p var2 = e.a(this.c);
      StringBuilder var3 = new StringBuilder();
      var3.append("Successfully submitted postback: ");
      var3.append(this.a);
      var2.b("PersistentPostbackManager", var3.toString());
      e.b(this.c);
      j.a(this.b, var1);
   }
}
