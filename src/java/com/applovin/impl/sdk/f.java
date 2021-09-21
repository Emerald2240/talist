package com.applovin.impl.sdk;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.AppLovinSdkTopic;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {
   private final j a;
   private final AppLovinCommunicator b;

   f(j var1) {
      this.a = var1;
      this.b = AppLovinCommunicator.getInstance(var1.D());
      if (!var1.e()) {
         this.b.a(var1);
         this.b.subscribe(this, (List)AppLovinSdkTopic.ALL_TOPICS);
      }

   }

   private void a(Bundle var1, String var2) {
      if (!this.a.e()) {
         if (!"log".equals(var2)) {
            p var4 = this.a.v();
            StringBuilder var5 = new StringBuilder();
            var5.append("Sending message ");
            var5.append(var1);
            var5.append(" for topic: ");
            var5.append(var2);
            var5.append("...");
            var4.b("CommunicatorService", var5.toString());
         }

         AppLovinCommunicatorMessage var3 = CommunicatorMessageImpl.create(var1, var2, this, this.a.b(com.applovin.impl.sdk.b.a.a).contains(var2));
         this.b.getMessagingService().publish(var3);
      }
   }

   public void a(com.applovin.impl.mediation.b.a var1, String var2) {
      boolean var3;
      if (var1 instanceof com.applovin.impl.mediation.b.c) {
         var3 = ((com.applovin.impl.mediation.b.c)var1).j();
      } else {
         var3 = false;
      }

      Bundle var4 = new Bundle();
      var4.putString("type", var2);
      var4.putString("id", var1.b());
      var4.putString("network_name", var1.D());
      var4.putString("max_ad_unit_id", var1.getAdUnitId());
      var4.putString("third_party_ad_placement_id", var1.e());
      var4.putString("ad_format", var1.getFormat().getLabel());
      var4.putString("is_fallback_ad", String.valueOf(var3));
      this.a(var4, "max_ad_events");
   }

   public void a(String var1, String var2, int var3, Object var4) {
      Bundle var5 = new Bundle();
      var5.putString("id", var1);
      var5.putString("url", var2);
      var5.putInt("code", var3);
      var5.putBundle("body", com.applovin.impl.sdk.utils.i.a(var4));
      this.a(var5, "receive_http_response");
   }

   public void a(JSONObject var1, boolean var2) {
      Bundle var3 = com.applovin.impl.sdk.utils.i.c(com.applovin.impl.sdk.utils.i.b(com.applovin.impl.sdk.utils.i.b(var1, "communicator_settings", new JSONObject(), this.a), "safedk_settings", new JSONObject(), this.a));
      Bundle var4 = new Bundle();
      var4.putString("sdk_key", this.a.t());
      var4.putString("applovin_random_token", this.a.k());
      String var5;
      if (AppLovinSdkUtils.isTablet(this.a.D())) {
         var5 = "tablet";
      } else {
         var5 = "phone";
      }

      var4.putString("device_type", var5);
      var4.putString("init_success", String.valueOf(var2));
      var4.putBundle("settings", var3);
      var4.putBoolean("debug_mode", (Boolean)this.a.a(com.applovin.impl.sdk.b.d.eR));
      this.a(var4, "safedk_init");
   }

   public String getCommunicatorId() {
      return "applovin_sdk";
   }

   public void onMessageReceived(AppLovinCommunicatorMessage var1) {
      if ("send_http_request".equalsIgnoreCase(var1.getTopic())) {
         Bundle var2 = var1.getMessageData();
         Map var3 = com.applovin.impl.sdk.utils.i.a(var2.getBundle("query_params"));
         Map var4 = BundleUtils.toMap(var2.getBundle("post_body"));
         Map var5 = com.applovin.impl.sdk.utils.i.a(var2.getBundle("headers"));
         String var6 = var2.getString("id", "");
         if (!var4.containsKey("sdk_key")) {
            var4.put("sdk_key", this.a.t());
         }

         com.applovin.impl.sdk.network.f var7 = (new com.applovin.impl.sdk.network.f.a()).a(var2.getString("url")).b(var2.getString("backup_url")).a(var3).c(var4).b(var5).a((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eR)).c(var6).a();
         this.a.N().a(var7);
      }

   }
}
