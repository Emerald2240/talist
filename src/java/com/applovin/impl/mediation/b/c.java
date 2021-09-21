package com.applovin.impl.mediation.b;

import com.applovin.impl.mediation.i;
import com.applovin.impl.sdk.j;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class c extends a {
   private String c;
   private final AtomicReference d;
   private final AtomicBoolean e;

   private c(c var1, i var2) {
      super(var1.B(), var1.A(), var2, var1.b);
      this.d = var1.d;
      this.e = var1.e;
   }

   public c(JSONObject var1, JSONObject var2, j var3) {
      super(var1, var2, (i)null, var3);
      this.d = new AtomicReference();
      this.e = new AtomicBoolean();
   }

   public a a(i var1) {
      return new c(this, var1);
   }

   public void a(com.applovin.impl.sdk.a.c var1) {
      this.d.set(var1);
   }

   public void a(String var1) {
      this.c = var1;
   }

   public boolean j() {
      return this.b("fa", false);
   }

   public long k() {
      return this.b("ifacd_ms", -1L);
   }

   public long l() {
      return this.b("fard_ms", TimeUnit.HOURS.toMillis(1L));
   }

   public String m() {
      return this.c;
   }

   public long n() {
      long var1 = this.b("ad_expiration_ms", -1L);
      return var1 >= 0L ? var1 : this.a("ad_expiration_ms", (Long)this.b.a(com.applovin.impl.sdk.b.c.H));
   }

   public long o() {
      long var1 = this.b("ad_hidden_timeout_ms", -1L);
      return var1 >= 0L ? var1 : this.a("ad_hidden_timeout_ms", (Long)this.b.a(com.applovin.impl.sdk.b.c.K));
   }

   public boolean p() {
      return this.b("schedule_ad_hidden_on_ad_dismiss", false) ? true : this.a("schedule_ad_hidden_on_ad_dismiss", (Boolean)this.b.a(com.applovin.impl.sdk.b.c.L));
   }

   public long q() {
      long var1 = this.b("ad_hidden_on_ad_dismiss_callback_delay_ms", -1L);
      return var1 >= 0L ? var1 : this.a("ad_hidden_on_ad_dismiss_callback_delay_ms", (Long)this.b.a(com.applovin.impl.sdk.b.c.M));
   }

   public String r() {
      return this.b("bcode", "");
   }

   public String s() {
      return this.a("mcode", "");
   }

   public boolean t() {
      return this.e.get();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediatedFullscreenAd{format=");
      var1.append(this.getFormat());
      var1.append(", adUnitId=");
      var1.append(this.getAdUnitId());
      var1.append(", isReady=");
      var1.append(this.a());
      var1.append(", adapterClass='");
      var1.append(this.C());
      var1.append("', adapterName='");
      var1.append(this.D());
      var1.append("', isTesting=");
      var1.append(this.E());
      var1.append(", isRefreshEnabled=");
      var1.append(this.I());
      var1.append(", getAdRefreshMillis=");
      var1.append(this.J());
      var1.append('}');
      return var1.toString();
   }

   public void u() {
      this.e.set(true);
   }

   public com.applovin.impl.sdk.a.c v() {
      return (com.applovin.impl.sdk.a.c)this.d.getAndSet((Object)null);
   }

   public boolean w() {
      return this.b("show_nia", this.a("show_nia", false));
   }

   public String x() {
      return this.b("nia_title", this.a("nia_title", ""));
   }

   public String y() {
      return this.b("nia_message", this.a("nia_message", ""));
   }

   public String z() {
      return this.b("nia_button_title", this.a("nia_button_title", ""));
   }
}
