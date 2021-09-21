package com.applovin.impl.sdk.ad;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

public final class g extends AppLovinAdBase {
   private AppLovinAd a;
   private final d b;

   public g(d var1, com.applovin.impl.sdk.j var2) {
      super(new JSONObject(), new JSONObject(), com.applovin.impl.sdk.ad.b.a, var2);
      this.b = var1;
   }

   private AppLovinAd c() {
      return (AppLovinAd)this.sdk.T().c(this.b);
   }

   private String d() {
      d var1 = this.getAdZone();
      return var1 != null && !var1.i() ? var1.a() : null;
   }

   public AppLovinAd a() {
      return this.a;
   }

   public void a(AppLovinAd var1) {
      this.a = var1;
   }

   public AppLovinAd b() {
      AppLovinAd var1 = this.a;
      return var1 != null ? var1 : this.c();
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         AppLovinAd var2 = this.b();
         return var2 != null ? var2.equals(var1) : super.equals(var1);
      } else {
         return false;
      }
   }

   public long getAdIdNumber() {
      AppLovinAd var1 = this.b();
      return var1 != null ? var1.getAdIdNumber() : 0L;
   }

   public d getAdZone() {
      AppLovinAdBase var1 = (AppLovinAdBase)this.b();
      return var1 != null ? var1.getAdZone() : this.b;
   }

   public AppLovinAdSize getSize() {
      return this.getAdZone().b();
   }

   public b getSource() {
      AppLovinAdBase var1 = (AppLovinAdBase)this.b();
      return var1 != null ? var1.getSource() : com.applovin.impl.sdk.ad.b.a;
   }

   public AppLovinAdType getType() {
      return this.getAdZone().c();
   }

   public String getZoneId() {
      return this.b.i() ? null : this.b.a();
   }

   public int hashCode() {
      AppLovinAd var1 = this.b();
      return var1 != null ? var1.hashCode() : super.hashCode();
   }

   public boolean isVideoAd() {
      AppLovinAd var1 = this.b();
      return var1 != null && var1.isVideoAd();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinAd{ #");
      var1.append(this.getAdIdNumber());
      var1.append(", adType=");
      var1.append(this.getType());
      var1.append(", adSize=");
      var1.append(this.getSize());
      var1.append(", zoneId='");
      var1.append(this.d());
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }
}
