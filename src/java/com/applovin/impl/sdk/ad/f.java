package com.applovin.impl.sdk.ad;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.w;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.n;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public abstract class f extends AppLovinAdBase {
   private final AtomicBoolean a = new AtomicBoolean();
   private final AtomicBoolean b = new AtomicBoolean();
   private final AtomicReference c = new AtomicReference();
   private List d;
   private List e;
   private List f;
   private List g;

   public f(JSONObject var1, JSONObject var2, b var3, com.applovin.impl.sdk.j var4) {
      super(var1, var2, var3, var4);
   }

   private String a() {
      String var1 = this.getStringFromAdObject("video_end_url", (String)null);
      String var2 = null;
      if (var1 != null) {
         var2 = var1.replace("{CLCODE}", this.getClCode());
      }

      return var2;
   }

   private List a(PointF param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   private com.applovin.impl.adview.h.a b(boolean var1) {
      return var1 ? com.applovin.impl.adview.h.a.b : com.applovin.impl.adview.h.a.a;
   }

   private String b(PointF var1, boolean var2) {
      String var3 = this.getStringFromAdObject("click_tracking_url", (String)null);
      Map var4 = this.c(var1, var2);
      String var5 = null;
      if (var3 != null) {
         var5 = n.a(var3, var4);
      }

      return var5;
   }

   private Map c(PointF var1, boolean var2) {
      Point var3 = com.applovin.impl.sdk.utils.g.a(this.sdk.D());
      HashMap var4 = new HashMap(5);
      var4.put("{CLCODE}", this.getClCode());
      var4.put("{CLICK_X}", String.valueOf(var1.x));
      var4.put("{CLICK_Y}", String.valueOf(var1.y));
      var4.put("{SCREEN_WIDTH}", String.valueOf(var3.x));
      var4.put("{SCREEN_HEIGHT}", String.valueOf(var3.y));
      var4.put("{IS_VIDEO_CLICK}", String.valueOf(var2));
      return var4;
   }

   public int A() {
      return this.getIntFromAdObject("countdown_length", 0);
   }

   public int B() {
      int var1 = Color.parseColor("#C8FFFFFF");
      String var2 = this.getStringFromAdObject("countdown_color", (String)null);
      if (n.b(var2)) {
         try {
            int var4 = Color.parseColor(var2);
            return var4;
         } catch (Throwable var6) {
            this.sdk.v().b("DirectAd", "Unable to parse countdown color", var6);
            return var1;
         }
      } else {
         return var1;
      }
   }

   public int C() {
      String var1 = this.getStringFromAdObject("video_background_color", (String)null);
      if (n.b(var1)) {
         try {
            int var3 = Color.parseColor(var1);
            return var3;
         } finally {
            return -16777216;
         }
      } else {
         return -16777216;
      }
   }

   public int D() {
      int var1;
      if (this.hasVideoUrl()) {
         var1 = -16777216;
      } else {
         var1 = -1157627904;
      }

      String var2 = this.getStringFromAdObject("graphic_background_color", (String)null);
      if (n.b(var2)) {
         try {
            int var4 = Color.parseColor(var2);
            return var4;
         } finally {
            return var1;
         }
      } else {
         return var1;
      }
   }

   public <undefinedtype> E() {
      String var1 = this.getStringFromAdObject("poststitial_dismiss_type", (String)null);
      if (n.b(var1)) {
         if ("dismiss".equalsIgnoreCase(var1)) {
            return null.b;
         }

         if ("no_dismiss".equalsIgnoreCase(var1)) {
            return null.c;
         }
      }

      return null.a;
   }

   public List F() {
      String var1 = this.getStringFromAdObject("resource_cache_prefix", (String)null);
      return var1 != null ? com.applovin.impl.sdk.utils.e.a(var1) : this.sdk.b(com.applovin.impl.sdk.b.d.bM);
   }

   public String G() {
      return this.getStringFromAdObject("cache_prefix", (String)null);
   }

   public boolean H() {
      return this.getBooleanFromAdObject("daome", true);
   }

   public boolean I() {
      return this.getBooleanFromAdObject("utpfc", false);
   }

   public boolean J() {
      return this.getBooleanFromAdObject("sscomt", false);
   }

   public String K() {
      return this.getStringFromFullResponse("event_id", (String)null);
   }

   public boolean L() {
      return this.getBooleanFromAdObject("progress_bar_enabled", false);
   }

   public int M() {
      String var1 = this.getStringFromAdObject("progress_bar_color", "#C8FFFFFF");
      if (n.b(var1)) {
         try {
            int var3 = Color.parseColor(var1);
            return var3;
         } finally {
            return 0;
         }
      } else {
         return 0;
      }
   }

   public boolean N() {
      return this.getBooleanFromAdObject("vs_buffer_indicator_enabled", false);
   }

   public boolean O() {
      return this.getBooleanFromAdObject("vs_buffer_indicator_initial_load_enabled", false);
   }

   public int P() {
      return this.getIntFromAdObject("vs_buffer_indicator_style", 16842874);
   }

   public int Q() {
      String var1 = this.getStringFromAdObject("vs_buffer_indicator_color", (String)null);
      if (n.b(var1)) {
         try {
            int var3 = Color.parseColor(var1);
            return var3;
         } finally {
            return -1;
         }
      } else {
         return -1;
      }
   }

   public int R() {
      int var1 = Color.parseColor("#66000000");
      String var2 = this.getStringFromAdObject("vs_buffer_indicator_bg_color", (String)null);
      if (n.b(var2)) {
         try {
            int var4 = Color.parseColor(var2);
            return var4;
         } finally {
            return var1;
         }
      } else {
         return var1;
      }
   }

   public boolean S() {
      return this.getBooleanFromAdObject("clear_dismissible", false);
   }

   public int T() {
      // $FF: Couldn't be decompiled
   }

   public int U() {
      return this.getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
   }

   public int V() {
      return this.getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
   }

   public boolean W() {
      return this.getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", false);
   }

   public boolean X() {
      return this.getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", false);
   }

   public boolean Y() {
      return this.getBooleanFromAdObject("vkuv", false);
   }

   public boolean Z() {
      return this.getBooleanFromAdObject("forward_lifecycle_events_to_webview", false);
   }

   protected com.applovin.impl.adview.h.a a(int var1) {
      if (var1 == 1) {
         return com.applovin.impl.adview.h.a.b;
      } else {
         return var1 == 2 ? com.applovin.impl.adview.h.a.c : com.applovin.impl.adview.h.a.a;
      }
   }

   public List a(PointF var1) {
      return this.a(var1, false);
   }

   public void a(com.applovin.impl.sdk.a.c var1) {
      this.c.set(var1);
   }

   public void a(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public List aA() {
      return com.applovin.impl.sdk.utils.e.a(this.getStringFromAdObject("wls", ""));
   }

   public List aB() {
      return com.applovin.impl.sdk.utils.e.a(this.getStringFromAdObject("wlh", (String)null));
   }

   public boolean aC() {
      return this.getBooleanFromAdObject("tvv", false);
   }

   public boolean aD() {
      return this.getBooleanFromAdObject("ibbdfs", false);
   }

   public boolean aE() {
      return this.getBooleanFromAdObject("ibbdfc", false);
   }

   public Uri aF() {
      String var1 = this.getStringFromAdObject("mute_image", (String)null);
      if (n.b(var1)) {
         try {
            Uri var3 = Uri.parse(var1);
            return var3;
         } finally {
            return null;
         }
      } else {
         return null;
      }
   }

   public Uri aG() {
      String var1 = this.getStringFromAdObject("unmute_image", "");
      if (n.b(var1)) {
         try {
            Uri var3 = Uri.parse(var1);
            return var3;
         } finally {
            return null;
         }
      } else {
         return null;
      }
   }

   public boolean aH() {
      return this.b.get();
   }

   public void aI() {
      this.b.set(true);
   }

   public com.applovin.impl.sdk.a.c aJ() {
      return (com.applovin.impl.sdk.a.c)this.c.getAndSet((Object)null);
   }

   public int aa() {
      return this.getIntFromAdObject("close_button_size", (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cD));
   }

   public int ab() {
      return this.getIntFromAdObject("close_button_top_margin", (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cE));
   }

   public int ac() {
      return this.getIntFromAdObject("close_button_horizontal_margin", (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.cC));
   }

   public boolean ad() {
      return this.getBooleanFromAdObject("lhs_close_button", (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cB));
   }

   public boolean ae() {
      return this.getBooleanFromAdObject("lhs_skip_button", (Boolean)this.sdk.a(com.applovin.impl.sdk.b.d.cU));
   }

   public boolean af() {
      return this.getBooleanFromAdObject("stop_video_player_after_poststitial_render", false);
   }

   public boolean ag() {
      return this.getBooleanFromAdObject("unhide_adview_on_render", false);
   }

   public long ah() {
      long var1 = -1L;
      long var3 = this.getLongFromAdObject("report_reward_duration", var1);
      if (var3 >= 0L) {
         var1 = TimeUnit.SECONDS.toMillis(var3);
      }

      return var1;
   }

   public int ai() {
      return this.getIntFromAdObject("report_reward_percent", -1);
   }

   public boolean aj() {
      return this.getBooleanFromAdObject("report_reward_percent_include_close_delay", true);
   }

   public AtomicBoolean ak() {
      return this.a;
   }

   public boolean al() {
      return this.getBooleanFromAdObject("show_skip_button_on_click", false);
   }

   public boolean am() {
      return this.getBooleanFromAdObject("show_nia", false);
   }

   public String an() {
      return this.getStringFromAdObject("nia_title", "");
   }

   public String ao() {
      return this.getStringFromAdObject("nia_message", "");
   }

   public String ap() {
      return this.getStringFromAdObject("nia_button_title", "");
   }

   public boolean aq() {
      return this.getBooleanFromAdObject("avoms", false);
   }

   public List ar() {
      // $FF: Couldn't be decompiled
   }

   public List as() {
      // $FF: Couldn't be decompiled
   }

   public List at() {
      // $FF: Couldn't be decompiled
   }

   public List au() {
      // $FF: Couldn't be decompiled
   }

   public boolean av() {
      return this.getBooleanFromAdObject("playback_requires_user_action", true);
   }

   public boolean aw() {
      return this.getBooleanFromAdObject("sanitize_webview", false);
   }

   public String ax() {
      String var1 = this.getStringFromAdObject("base_url", "/");
      if ("null".equalsIgnoreCase(var1)) {
         var1 = null;
      }

      return var1;
   }

   public boolean ay() {
      return this.getBooleanFromAdObject("web_contents_debugging_enabled", false);
   }

   public w az() {
      JSONObject var1 = this.getJsonObjectFromAdObject("web_view_settings", (JSONObject)null);
      w var2 = null;
      if (var1 != null) {
         var2 = new w(var1, this.sdk);
      }

      return var2;
   }

   public List b(PointF param1) {
      // $FF: Couldn't be decompiled
   }

   public void b(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean b() {
      this.sdk.v().e("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
      return false;
   }

   public void c(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public Uri d() {
      this.sdk.v().e("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
      return null;
   }

   public Uri f() {
      this.sdk.v().e("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
      return null;
   }

   public Uri g() {
      this.sdk.v().e("DirectAd", "Attempting to invoke getVideoClickDestinationUri() from base ad class");
      return null;
   }

   public f.b l() {
      String var1 = this.getStringFromAdObject("ad_target", f.b.a.toString()).toUpperCase(Locale.ENGLISH);
      if ("ACTIVITY_PORTRAIT".equalsIgnoreCase(var1)) {
         return f.b.b;
      } else {
         return "ACTIVITY_LANDSCAPE".equalsIgnoreCase(var1) ? f.b.c : f.b.a;
      }
   }

   public float m() {
      return this.getFloatFromAdObject("close_delay", 0.0F);
   }

   public float n() {
      return this.getFloatFromAdObject("close_delay_graphic", 0.0F);
   }

   public com.applovin.impl.adview.h.a o() {
      int var1 = this.getIntFromAdObject("close_style", -1);
      return var1 == -1 ? this.b(this.hasVideoUrl()) : this.a(var1);
   }

   public com.applovin.impl.adview.h.a p() {
      int var1 = this.getIntFromAdObject("skip_style", -1);
      return var1 == -1 ? this.o() : this.a(var1);
   }

   public boolean q() {
      return this.getBooleanFromAdObject("dismiss_on_skip", false);
   }

   public boolean r() {
      return this.getBooleanFromAdObject("html_resources_cached", false);
   }

   public String s() {
      JSONObject var1 = this.getJsonObjectFromAdObject("video_button_properties", (JSONObject)null);
      return var1 != null ? com.applovin.impl.sdk.utils.i.b(var1, "video_button_html", "", this.sdk) : "";
   }

   public s t() {
      return new s(this.getJsonObjectFromAdObject("video_button_properties", (JSONObject)null), this.sdk);
   }

   public boolean u() {
      return this.getBooleanFromAdObject("video_clickable", false);
   }

   public boolean v() {
      return this.getBooleanFromAdObject("accelerate_hardware", false);
   }

   public boolean w() {
      return this.getBooleanFromAdObject("keep_screen_on", false);
   }

   public boolean x() {
      return this.getBooleanFromAdObject("hide_close_on_exit_graphic", false);
   }

   public boolean y() {
      return this.getBooleanFromAdObject("hide_close_on_exit", false);
   }

   public boolean z() {
      return this.getBooleanFromAdObject("lock_current_orientation", false);
   }

   public static enum b {
      a,
      b,
      c;

      static {
         f.b[] var0 = new f.b[]{a, b, c};
      }
   }
}
