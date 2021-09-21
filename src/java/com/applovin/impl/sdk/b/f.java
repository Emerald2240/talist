package com.applovin.impl.sdk.b;

import java.util.HashSet;

public class f {
   public static final f A = new f("com.applovin.sdk.mediation_provider", String.class);
   public static final f B = new f("com.applovin.sdk.mediation.test_mode_network", String.class);
   public static final f a = new f("com.applovin.sdk.impl.isFirstRun", String.class);
   public static final f b = new f("com.applovin.sdk.launched_before", Boolean.class);
   public static final f c = new f("com.applovin.sdk.user_id", String.class);
   public static final f d = new f("com.applovin.sdk.compass_id", String.class);
   public static final f e = new f("com.applovin.sdk.compass_random_token", String.class);
   public static final f f = new f("com.applovin.sdk.applovin_random_token", String.class);
   public static final f g = new f("com.applovin.sdk.device_test_group", String.class);
   public static final f h = new f("com.applovin.sdk.local_test_group", String.class);
   public static final f i = new f("com.applovin.sdk.variables", String.class);
   public static final f j = new f("com.applovin.sdk.compliance.has_user_consent", Boolean.class);
   public static final f k = new f("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);
   public static final f l = new f("com.applovin.sdk.compliance.is_do_not_sell", Boolean.class);
   public static final f m = new f("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);
   public static final f n = new f("com.applovin.sdk.stats", String.class);
   public static final f o = new f("com.applovin.sdk.errors", String.class);
   public static final f p = new f("com.applovin.sdk.task.stats", HashSet.class);
   public static final f q = new f("com.applovin.sdk.network_response_code_mapping", String.class);
   public static final f r = new f("com.applovin.sdk.event_tracking.super_properties", String.class);
   public static final f s = new f("com.applovin.sdk.request_tracker.counter", String.class);
   public static final f t = new f("com.applovin.sdk.zones", String.class);
   public static final f u = new f("com.applovin.sdk.ad.stats", HashSet.class);
   public static final f v = new f("com.applovin.sdk.last_video_position", Integer.class);
   public static final f w = new f("com.applovin.sdk.should_resume_video", Boolean.class);
   public static final f x = new f("com.applovin.sdk.mediation.signal_providers", String.class);
   public static final f y = new f("com.applovin.sdk.mediation.auto_init_adapters", String.class);
   public static final f z = new f("com.applovin.sdk.persisted_data", String.class);
   private final String C;
   private final Class D;

   public f(String var1, Class var2) {
      this.C = var1;
      this.D = var2;
   }

   public String a() {
      return this.C;
   }

   public Class b() {
      return this.D;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Key{name='");
      var1.append(this.C);
      var1.append('\'');
      var1.append(", type=");
      var1.append(this.D);
      var1.append('}');
      return var1.toString();
   }
}
