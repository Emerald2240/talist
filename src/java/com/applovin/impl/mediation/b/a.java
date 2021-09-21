package com.applovin.impl.mediation.b;

import android.os.SystemClock;
import com.applovin.impl.mediation.i;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class a extends e implements MaxAd {
   protected i a;
   private final AtomicBoolean c = new AtomicBoolean();

   protected a(JSONObject var1, JSONObject var2, i var3, j var4) {
      super(var1, var2, var4);
      this.a = var3;
   }

   private long j() {
      return this.b("load_started_time_ms", 0L);
   }

   public abstract a a(i var1);

   public boolean a() {
      i var1 = this.a;
      boolean var2 = false;
      if (var1 != null) {
         boolean var3 = var1.c();
         var2 = false;
         if (var3) {
            boolean var4 = this.a.d();
            var2 = false;
            if (var4) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public String b() {
      return this.a("event_id", "");
   }

   public i c() {
      return this.a;
   }

   public String d() {
      return this.b("bid_response", (String)null);
   }

   public String e() {
      return this.b("third_party_ad_placement_id", (String)null);
   }

   public long f() {
      return this.j() > 0L ? SystemClock.elapsedRealtime() - this.j() : -1L;
   }

   public void g() {
      this.c("load_started_time_ms", SystemClock.elapsedRealtime());
   }

   public String getAdUnitId() {
      return this.a("ad_unit_id", "");
   }

   public MaxAdFormat getFormat() {
      return q.c(this.a("ad_format", (String)null));
   }

   public String getNetworkName() {
      return this.b("network_name", "");
   }

   public AtomicBoolean h() {
      return this.c;
   }

   public void i() {
      this.a = null;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName());
      var1.append("{thirdPartyAdPlacementId=");
      var1.append(this.e());
      var1.append(", adUnitId=");
      var1.append(this.getAdUnitId());
      var1.append(", format=");
      var1.append(this.getFormat().getLabel());
      var1.append(", networkName='");
      var1.append(this.getNetworkName());
      var1.append('}');
      return var1.toString();
   }
}
