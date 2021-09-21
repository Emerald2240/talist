package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Arrays;
import org.json.JSONObject;

public abstract class AppLovinAdBase implements com.applovin.impl.sdk.ad.j, AppLovinAd {
   private final int a;
   protected final JSONObject adObject;
   protected final Object adObjectLock;
   private com.applovin.impl.sdk.ad.d b;
   private final long c;
   private com.applovin.impl.sdk.ad.g d;
   protected final JSONObject fullResponse;
   protected final Object fullResponseLock;
   protected final j sdk;
   protected final com.applovin.impl.sdk.ad.b source;

   protected AppLovinAdBase(JSONObject var1, JSONObject var2, com.applovin.impl.sdk.ad.b var3, j var4) {
      if (var1 != null) {
         if (var2 != null) {
            if (var4 != null) {
               this.adObject = var1;
               this.fullResponse = var2;
               this.source = var3;
               this.sdk = var4;
               this.adObjectLock = new Object();
               this.fullResponseLock = new Object();
               this.c = System.currentTimeMillis();
               char[] var5 = var1.toString().toCharArray();
               Arrays.sort(var5);
               this.a = (new String(var5)).hashCode();
            } else {
               throw new IllegalArgumentException("No sdk specified");
            }
         } else {
            throw new IllegalArgumentException("No response specified");
         }
      } else {
         throw new IllegalArgumentException("No ad object specified");
      }
   }

   protected boolean containsKeyForAdObject(String param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean equals(Object var1) {
      if (var1 instanceof com.applovin.impl.sdk.ad.g) {
         AppLovinAd var4 = ((com.applovin.impl.sdk.ad.g)var1).b();
         if (var4 != null) {
            var1 = var4;
         }
      }

      if (this == var1) {
         return true;
      } else if (var1 != null) {
         if (this.getClass() != var1.getClass()) {
            return false;
         } else {
            AppLovinAdBase var2 = (AppLovinAdBase)var1;
            com.applovin.impl.sdk.ad.d var3 = this.b;
            if (var3 != null) {
               if (!var3.equals(var2.b)) {
                  return false;
               }
            } else if (var2.b != null) {
               return false;
            }

            if (this.source != var2.source) {
               return false;
            } else {
               return this.a == var2.a;
            }
         }
      } else {
         return false;
      }
   }

   public long getAdIdNumber() {
      return this.getLongFromAdObject("ad_id", -1L);
   }

   public String getAdValue(String var1) {
      if (TextUtils.isEmpty(var1)) {
         return null;
      } else {
         JSONObject var2 = this.getJsonObjectFromAdObject("ad_values", (JSONObject)null);
         return var2 != null && var2.length() > 0 ? com.applovin.impl.sdk.utils.i.b(var2, var1, (String)null, this.sdk) : null;
      }
   }

   public com.applovin.impl.sdk.ad.d getAdZone() {
      com.applovin.impl.sdk.ad.d var1 = this.b;
      if (var1 != null) {
         return var1;
      } else {
         String var2 = this.getStringFromFullResponse("zone_id", (String)null);
         this.b = com.applovin.impl.sdk.ad.d.a(this.getSize(), this.getType(), var2, this.sdk);
         return this.b;
      }
   }

   protected boolean getBooleanFromAdObject(String param1, Boolean param2) {
      // $FF: Couldn't be decompiled
   }

   protected boolean getBooleanFromFullResponse(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public String getClCode() {
      String var1 = this.getStringFromAdObject("clcode", "");
      return com.applovin.impl.sdk.utils.n.b(var1) ? var1 : this.getStringFromFullResponse("clcode", "");
   }

   public long getCreatedAtMillis() {
      return this.c;
   }

   public com.applovin.impl.sdk.ad.g getDummyAd() {
      return this.d;
   }

   public long getFetchLatencyMillis() {
      return this.getLongFromFullResponse("ad_fetch_latency_millis", -1L);
   }

   public long getFetchResponseSize() {
      return this.getLongFromFullResponse("ad_fetch_response_size", -1L);
   }

   protected float getFloatFromAdObject(String param1, float param2) {
      // $FF: Couldn't be decompiled
   }

   protected float getFloatFromFullResponse(String param1, float param2) {
      // $FF: Couldn't be decompiled
   }

   protected int getIntFromAdObject(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   protected int getIntFromFullResponse(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   protected JSONObject getJsonObjectFromAdObject(String param1, JSONObject param2) {
      // $FF: Couldn't be decompiled
   }

   protected JSONObject getJsonObjectFromFullResponse(String param1, JSONObject param2) {
      // $FF: Couldn't be decompiled
   }

   protected long getLongFromAdObject(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   protected long getLongFromFullResponse(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public String getPrimaryKey() {
      return this.getStringFromAdObject("pk", "NA");
   }

   public j getSdk() {
      return this.sdk;
   }

   public String getSecondaryKey1() {
      return this.getStringFromAdObject("sk1", (String)null);
   }

   public String getSecondaryKey2() {
      return this.getStringFromAdObject("sk2", (String)null);
   }

   public AppLovinAdSize getSize() {
      return AppLovinAdSize.fromString(this.getStringFromFullResponse("ad_size", (String)null));
   }

   public com.applovin.impl.sdk.ad.b getSource() {
      return this.source;
   }

   protected String getStringFromAdObject(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   protected String getStringFromFullResponse(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public AppLovinAdType getType() {
      return AppLovinAdType.fromString(this.getStringFromFullResponse("ad_type", (String)null));
   }

   public String getZoneId() {
      return this.getAdZone().i() ? null : this.getStringFromFullResponse("zone_id", (String)null);
   }

   public boolean hasShown() {
      return this.getBooleanFromAdObject("shown", false);
   }

   public boolean hasVideoUrl() {
      this.sdk.v().e("AppLovinAdBase", "Attempting to invoke hasVideoUrl() from base ad class");
      return false;
   }

   public int hashCode() {
      return this.a;
   }

   public boolean isVideoAd() {
      return this.adObject.has("is_video_ad") ? this.getBooleanFromAdObject("is_video_ad", false) : this.hasVideoUrl();
   }

   public void setDummyAd(com.applovin.impl.sdk.ad.g var1) {
      this.d = var1;
   }

   public void setHasShown(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean shouldCancelHtmlCachingIfShown() {
      return this.getBooleanFromAdObject("chcis", false);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinAd{adIdNumber");
      var1.append(this.getAdIdNumber());
      var1.append(", source=");
      var1.append(this.getSource());
      var1.append(", zoneId='");
      var1.append(this.getZoneId());
      var1.append("'");
      var1.append('}');
      return var1.toString();
   }
}
