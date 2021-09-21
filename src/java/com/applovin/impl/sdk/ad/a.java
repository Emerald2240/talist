package com.applovin.impl.sdk.ad;

import android.net.Uri;
import com.applovin.impl.sdk.utils.n;
import org.json.JSONObject;

public final class a extends f {
   public a(JSONObject var1, JSONObject var2, b var3, com.applovin.impl.sdk.j var4) {
      super(var1, var2, var3, var4);
   }

   private String aK() {
      return this.getStringFromAdObject("stream_url", "");
   }

   public String a() {
      // $FF: Couldn't be decompiled
   }

   public void a(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(String param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean b() {
      return this.adObject.has("stream_url");
   }

   public void c() {
      // $FF: Couldn't be decompiled
   }

   public Uri d() {
      String var1 = this.aK();
      if (n.b(var1)) {
         return Uri.parse(var1);
      } else {
         String var2 = this.e();
         return n.b(var2) ? Uri.parse(var2) : null;
      }
   }

   public String e() {
      return this.getStringFromAdObject("video", "");
   }

   public Uri f() {
      String var1 = this.getStringFromAdObject("click_url", "");
      return n.b(var1) ? Uri.parse(var1) : null;
   }

   public Uri g() {
      String var1 = this.getStringFromAdObject("video_click_url", "");
      return n.b(var1) ? Uri.parse(var1) : this.f();
   }

   public float h() {
      return this.getFloatFromAdObject("mraid_close_delay_graphic", 0.0F);
   }

   public boolean hasVideoUrl() {
      return this.d() != null;
   }

   public boolean i() {
      return this.getBooleanFromAdObject("close_button_graphic_hidden", false);
   }

   public boolean j() {
      return this.adObject.has("close_button_expandable_hidden") ? this.getBooleanFromAdObject("close_button_expandable_hidden", false) : true;
   }

   public com.applovin.impl.adview.h.a k() {
      return this.a(this.getIntFromAdObject("expandable_style", com.applovin.impl.adview.h.a.c.a()));
   }
}
