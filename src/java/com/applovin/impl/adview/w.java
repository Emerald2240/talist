package com.applovin.impl.adview;

import android.webkit.WebSettings.PluginState;
import org.json.JSONObject;

public final class w {
   private com.applovin.impl.sdk.j a;
   private JSONObject b;

   public w(JSONObject var1, com.applovin.impl.sdk.j var2) {
      this.a = var2;
      this.b = var1;
   }

   Integer a() {
      String var1 = com.applovin.impl.sdk.utils.i.b(this.b, "mixed_content_mode", (String)null, this.a);
      if (com.applovin.impl.sdk.utils.n.b(var1)) {
         byte var2;
         if ("always_allow".equalsIgnoreCase(var1)) {
            var2 = 0;
            return Integer.valueOf(var2);
         }

         if ("never_allow".equalsIgnoreCase(var1)) {
            var2 = 1;
            return Integer.valueOf(var2);
         }

         if ("compatibility_mode".equalsIgnoreCase(var1)) {
            var2 = 2;
            return Integer.valueOf(var2);
         }
      }

      return null;
   }

   PluginState b() {
      String var1 = com.applovin.impl.sdk.utils.i.b(this.b, "plugin_state", (String)null, this.a);
      if (com.applovin.impl.sdk.utils.n.b(var1)) {
         if ("on".equalsIgnoreCase(var1)) {
            return PluginState.ON;
         }

         if ("on_demand".equalsIgnoreCase(var1)) {
            return PluginState.ON_DEMAND;
         }

         if ("off".equalsIgnoreCase(var1)) {
            return PluginState.OFF;
         }
      }

      return null;
   }

   Boolean c() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "allow_file_access", (Boolean)null, this.a);
   }

   Boolean d() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "load_with_overview_mode", (Boolean)null, this.a);
   }

   Boolean e() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "use_wide_view_port", (Boolean)null, this.a);
   }

   Boolean f() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "allow_content_access", (Boolean)null, this.a);
   }

   Boolean g() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "use_built_in_zoom_controls", (Boolean)null, this.a);
   }

   Boolean h() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "display_zoom_controls", (Boolean)null, this.a);
   }

   Boolean i() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "save_form_data", (Boolean)null, this.a);
   }

   Boolean j() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "geolocation_enabled", (Boolean)null, this.a);
   }

   Boolean k() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "need_initial_focus", (Boolean)null, this.a);
   }

   Boolean l() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "allow_file_access_from_file_urls", (Boolean)null, this.a);
   }

   Boolean m() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "allow_universal_access_from_file_urls", (Boolean)null, this.a);
   }

   Boolean n() {
      return com.applovin.impl.sdk.utils.i.a(this.b, "offscreen_pre_raster", (Boolean)null, this.a);
   }
}
