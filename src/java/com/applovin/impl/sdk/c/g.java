package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class g {
   public static final g a = a("ad_req");
   public static final g b = a("ad_imp");
   public static final g c = a("ad_session_start");
   public static final g d = a("ad_imp_session");
   public static final g e = a("cached_files_expired");
   public static final g f = a("cache_drop_count");
   public static final g g = a("sdk_reset_state_count", true);
   public static final g h = a("ad_response_process_failures", true);
   public static final g i = a("response_process_failures", true);
   public static final g j = a("incent_failed_to_display_count", true);
   public static final g k = a("app_paused_and_resumed");
   public static final g l = a("ad_rendered_with_mismatched_sdk_key", true);
   public static final g m = a("med_ad_req");
   public static final g n = a("med_ad_response_process_failures", true);
   public static final g o = a("med_adapters_failed_init_missing_activity", true);
   public static final g p = a("med_waterfall_ad_no_fill", true);
   public static final g q = a("med_waterfall_ad_adapter_load_failed", true);
   public static final g r = a("med_waterfall_ad_invalid_response", true);
   private static final Set s = new HashSet(32);
   private static final Set u = new HashSet(16);
   private final String t;

   static {
      a("fullscreen_ad_nil_vc_count");
      a("applovin_bundle_missing");
   }

   private g(String var1) {
      this.t = var1;
   }

   private static g a(String var0) {
      return a(var0, false);
   }

   private static g a(String var0, boolean var1) {
      if (!TextUtils.isEmpty(var0)) {
         if (!s.contains(var0)) {
            s.add(var0);
            g var6 = new g(var0);
            if (var1) {
               u.add(var6);
            }

            return var6;
         } else {
            StringBuilder var2 = new StringBuilder();
            var2.append("Key has already been used: ");
            var2.append(var0);
            throw new IllegalArgumentException(var2.toString());
         }
      } else {
         throw new IllegalArgumentException("No key name specified");
      }
   }

   public static Set b() {
      return u;
   }

   public String a() {
      return this.t;
   }
}
