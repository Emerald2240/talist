package com.applovin.impl.mediation.b;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.n;
import com.applovin.sdk.AppLovinPrivacySettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
   private final JSONObject a;
   protected final j b;
   private final JSONObject c;
   private final Object d = new Object();
   private final Object e = new Object();
   private volatile String f;

   public e(JSONObject var1, JSONObject var2, j var3) {
      if (var3 != null) {
         if (var2 != null) {
            if (var1 != null) {
               this.b = var3;
               this.a = var2;
               this.c = var1;
            } else {
               throw new IllegalArgumentException("No spec object specified");
            }
         } else {
            throw new IllegalArgumentException("No full response specified");
         }
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   private int a() {
      return this.b("mute_state", this.a("mute_state", (Integer)this.b.a(com.applovin.impl.sdk.b.c.S)));
   }

   private List a(String var1) {
      try {
         List var3 = i.b(this.a(var1, new JSONArray()));
         return var3;
      } catch (JSONException var4) {
         return Collections.EMPTY_LIST;
      }
   }

   private List a(List var1, Map var2) {
      Map var3 = this.b();
      ArrayList var4 = new ArrayList(var1.size());
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();

         String var11;
         for(Iterator var7 = var3.keySet().iterator(); var7.hasNext(); var6 = var6.replace(var11, this.f((String)var3.get(var11)))) {
            var11 = (String)var7.next();
         }

         String var10;
         for(Iterator var8 = var2.keySet().iterator(); var8.hasNext(); var6 = var6.replace(var10, (CharSequence)var2.get(var10))) {
            var10 = (String)var8.next();
         }

         var4.add(var6);
      }

      return var4;
   }

   private Map b() {
      String var1 = (String)this.b.a(com.applovin.impl.sdk.b.c.i);

      try {
         Map var3 = i.a(new JSONObject(var1));
         return var3;
      } catch (JSONException var4) {
         return Collections.EMPTY_MAP;
      }
   }

   private List e(String var1) {
      try {
         List var3 = i.b(this.b(var1, new JSONArray()));
         return var3;
      } catch (JSONException var4) {
         return Collections.EMPTY_LIST;
      }
   }

   private String f(String var1) {
      String var2 = this.b(var1, "");
      return n.b(var2) ? var2 : this.a(var1, "");
   }

   protected JSONObject A() {
      // $FF: Couldn't be decompiled
   }

   protected JSONObject B() {
      // $FF: Couldn't be decompiled
   }

   public String C() {
      return this.b("class", (String)null);
   }

   public String D() {
      return this.b("name", (String)null);
   }

   public boolean E() {
      return this.b("is_testing", false);
   }

   public boolean F() {
      return this.b("run_on_ui_thread", true);
   }

   public Bundle G() {
      Bundle var1;
      if (this.c("server_parameters") instanceof JSONObject) {
         var1 = i.c(this.a((String)"server_parameters", (JSONObject)null));
      } else {
         var1 = new Bundle();
      }

      int var2 = this.a();
      if (var2 != -1) {
         boolean var3;
         if (var2 == 2) {
            var3 = this.b.l().isMuted();
         } else if (var2 == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         var1.putBoolean("is_muted", var3);
         return var1;
      } else {
         return var1;
      }
   }

   public long H() {
      return this.b("adapter_timeout_ms", (Long)this.b.a(com.applovin.impl.sdk.b.c.o));
   }

   public boolean I() {
      return this.J() >= 0L;
   }

   public long J() {
      long var1 = this.b("ad_refresh_ms", -1L);
      return var1 >= 0L ? var1 : this.a("ad_refresh_ms", (Long)this.b.a(com.applovin.impl.sdk.b.c.r));
   }

   public long K() {
      long var1 = this.b("fullscreen_display_delay_ms", -1L);
      return var1 >= 0L ? var1 : (Long)this.b.a(com.applovin.impl.sdk.b.c.A);
   }

   public long L() {
      return this.b("init_completion_delay_ms", -1L);
   }

   public long M() {
      return this.b("ahdm", (Long)this.b.a(com.applovin.impl.sdk.b.c.B));
   }

   public String N() {
      return this.f;
   }

   protected float a(String param1, float param2) {
      // $FF: Couldn't be decompiled
   }

   protected int a(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   protected long a(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   protected String a(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public List a(String var1, Map var2) {
      if (var1 != null) {
         List var3 = this.a(var1);
         List var4 = this.e(var1);
         ArrayList var5 = new ArrayList(var3.size() + var4.size());
         var5.addAll(var3);
         var5.addAll(var4);
         return this.a((List)var5, (Map)var2);
      } else {
         throw new IllegalArgumentException("No key specified");
      }
   }

   protected JSONArray a(String param1, JSONArray param2) {
      // $FF: Couldn't be decompiled
   }

   protected JSONObject a(String param1, JSONObject param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean a(Context var1) {
      return this.b("huc") ? this.b("huc", false) : this.a("huc", AppLovinPrivacySettings.hasUserConsent(var1));
   }

   protected boolean a(String param1, Boolean param2) {
      // $FF: Couldn't be decompiled
   }

   protected int b(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   protected long b(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   protected String b(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   protected JSONArray b(String param1, JSONArray param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean b(Context var1) {
      return this.b("aru") ? this.b("aru", false) : this.a("aru", AppLovinPrivacySettings.isAgeRestrictedUser(var1));
   }

   protected boolean b(String param1) {
      // $FF: Couldn't be decompiled
   }

   protected boolean b(String param1, Boolean param2) {
      // $FF: Couldn't be decompiled
   }

   protected Object c(String param1) {
      // $FF: Couldn't be decompiled
   }

   protected void c(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean c(Context var1) {
      return this.b("dns") ? this.b("dns", false) : this.a("dns", AppLovinPrivacySettings.isDoNotSell(var1));
   }

   public void d(String var1) {
      this.f = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediationAdapterSpec{adapterClass='");
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
}
