package com.applovin.impl.mediation.c;

import android.app.Activity;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class e extends com.applovin.impl.sdk.d.a {
   private final String a;
   private final JSONObject c;
   private final JSONObject d;
   private final MaxAdListener e;
   private final WeakReference f;

   e(String var1, JSONObject var2, JSONObject var3, j var4, Activity var5, MaxAdListener var6) {
      StringBuilder var7 = new StringBuilder();
      var7.append("TaskLoadAdapterAd ");
      var7.append(var1);
      super(var7.toString(), var4);
      this.a = var1;
      this.c = var2;
      this.d = var3;
      this.f = new WeakReference(var5);
      this.e = var6;
   }

   private void b() {
      com.applovin.impl.mediation.b.a var1 = this.d();
      this.b.y().loadThirdPartyMediatedAd(this.a, var1, this.c(), this.e);
   }

   private Activity c() {
      Activity var1 = (Activity)this.f.get();
      return var1 != null ? var1 : this.b.ag();
   }

   private com.applovin.impl.mediation.b.a d() {
      String var1 = i.b(this.d, "ad_format", (String)null, this.b);
      MaxAdFormat var2 = q.c(var1);
      if (var2 != MaxAdFormat.BANNER && var2 != MaxAdFormat.MREC && var2 != MaxAdFormat.LEADER) {
         if (var2 == MaxAdFormat.NATIVE) {
            return new com.applovin.impl.mediation.b.d(this.c, this.d, this.b);
         } else if (var2 != MaxAdFormat.INTERSTITIAL && var2 != MaxAdFormat.REWARDED) {
            StringBuilder var3 = new StringBuilder();
            var3.append("Unsupported ad format: ");
            var3.append(var1);
            throw new IllegalArgumentException(var3.toString());
         } else {
            return new com.applovin.impl.mediation.b.c(this.c, this.d, this.b);
         }
      } else {
         return new com.applovin.impl.mediation.b.b(this.c, this.d, this.b);
      }
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.D;
   }

   public void run() {
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.fe)) {
         try {
            this.b();
         } catch (Throwable var3) {
            this.a("Unable to process adapter ad", var3);
            this.b.M().a(this.a());
            com.applovin.impl.sdk.utils.j.a((MaxAdListener)this.e, (String)this.a, -5001);
            return;
         }
      } else {
         this.b();
      }
   }
}
