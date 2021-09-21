package com.applovin.impl.mediation.d;

import android.text.TextUtils;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.d.r;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.n;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
   private static final List a = new ArrayList();
   private static c.a b;

   static {
      a.add("com.applovin.mediation.adapters.AdColonyMediationAdapter");
      a.add("com.applovin.mediation.adapters.AmazonMediationAdapter");
      a.add("com.applovin.mediation.adapters.AmazonBiddingMediationAdapter");
      a.add("com.applovin.mediation.adapters.AppLovinMediationAdapter");
      a.add("com.applovin.mediation.adapters.ChartboostMediationAdapter");
      a.add("com.applovin.mediation.adapters.FacebookMediationAdapter");
      a.add("com.applovin.mediation.adapters.GoogleMediationAdapter");
      a.add("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter");
      a.add("com.applovin.mediation.adapters.HyperMXMediationAdapter");
      a.add("com.applovin.mediation.adapters.IMobileMediationAdapter");
      a.add("com.applovin.mediation.adapters.InMobiMediationAdapter");
      a.add("com.applovin.mediation.adapters.InneractiveMediationAdapter");
      a.add("com.applovin.mediation.adapters.IronSourceMediationAdapter");
      a.add("com.applovin.mediation.adapters.LeadboltMediationAdapter");
      a.add("com.applovin.mediation.adapters.MadvertiseMediationAdapter");
      a.add("com.applovin.mediation.adapters.MaioMediationAdapter");
      a.add("com.applovin.mediation.adapters.MintegralMediationAdapter");
      a.add("com.applovin.mediation.adapters.MoPubMediationAdapter");
      a.add("com.applovin.mediation.adapters.MyTargetMediationAdapter");
      a.add("com.applovin.mediation.adapters.NendMediationAdapter");
      a.add("com.applovin.mediation.adapters.OguryMediationAdapter");
      a.add("com.applovin.mediation.adapters.OguryPresageMediationAdapter");
      a.add("com.applovin.mediation.adapters.SmaatoMediationAdapter");
      a.add("com.applovin.mediation.adapters.TapjoyMediationAdapter");
      a.add("com.applovin.mediation.adapters.TencentMediationAdapter");
      a.add("com.applovin.mediation.adapters.UnityAdsMediationAdapter");
      a.add("com.applovin.mediation.adapters.VerizonAdsMediationAdapter");
      a.add("com.applovin.mediation.adapters.VoodooAdsMediationAdapter");
      a.add("com.applovin.mediation.adapters.VungleMediationAdapter");
      a.add("com.applovin.mediation.adapters.YandexMediationAdapter");
   }

   public static c.a a(j var0) {
      if (!(Boolean)var0.a(com.applovin.impl.sdk.b.c.T)) {
         c.a var13 = b;
         if (var13 != null) {
            return var13;
         }
      }

      if (b != null) {
         b(var0);
      } else {
         JSONArray var1 = new JSONArray();
         JSONArray var2 = new JSONArray();
         Iterator var3 = a.iterator();

         while(true) {
            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               MaxAdapter var5 = a(var4, var0);
               if (var5 != null) {
                  JSONObject var6 = new JSONObject();

                  label77:
                  try {
                     var6.put("class", var4);
                     var6.put("sdk_version", var5.getSdkVersion());
                     var6.put("version", var5.getAdapterVersion());
                  } finally {
                     break label77;
                  }

                  var1.put(var6);
               } else {
                  var2.put(var4);
               }
            }

            b = new c.a(var1, var2);
            break;
         }
      }

      return b;
   }

   public static r.a a(MaxAdFormat var0) {
      if (var0 == MaxAdFormat.INTERSTITIAL) {
         return r.a.o;
      } else {
         return var0 == MaxAdFormat.REWARDED ? r.a.p : r.a.n;
      }
   }

   public static MaxAdapter a(String var0, j var1) {
      if (TextUtils.isEmpty(var0)) {
         var1.v().e("AppLovinSdk", "Failed to create adapter instance. No class name provided");
         return null;
      } else {
         try {
            try {
               Class var8 = Class.forName(var0);
               if (MaxAdapter.class.isAssignableFrom(var8)) {
                  Constructor var15 = var8.getConstructor(new Class[]{AppLovinSdk.class});
                  Object[] var16 = new Object[]{var1.S()};
                  return (MaxAdapter)var15.newInstance(var16);
               } else {
                  p var9 = var1.v();
                  StringBuilder var10 = new StringBuilder();
                  var10.append(var0);
                  var10.append(" error: not an instance of '");
                  var10.append(MaxAdapter.class.getName());
                  var10.append("'.");
                  var9.e("AppLovinSdk", var10.toString());
                  return null;
               }
            } catch (ClassNotFoundException var19) {
               return null;
            }
         } catch (Throwable var20) {
            p var4 = var1.v();
            StringBuilder var5 = new StringBuilder();
            var5.append("Failed to load: ");
            var5.append(var0);
            var4.b("AppLovinSdk", var5.toString(), var20);
            return null;
         }
      }
   }

   public static String b(MaxAdFormat var0) {
      return var0.getLabel();
   }

   private static void b(j var0) {
      JSONArray var1 = b.a();

      for(int var2 = 0; var2 < var1.length(); ++var2) {
         JSONObject var3 = i.a(var1, var2, (JSONObject)null, var0);
         String var4 = i.b(var3, "class", "", var0);
         if (!n.b(i.b(var3, "sdk_version", "", var0))) {
            MaxAdapter var5 = a(var4, var0);
            if (var5 != null) {
               i.a(var3, "sdk_version", var5.getSdkVersion(), var0);
            }
         }
      }

   }

   public static class a {
      private final JSONArray a;
      private final JSONArray b;

      private a(JSONArray var1, JSONArray var2) {
         this.a = var1;
         this.b = var2;
      }

      // $FF: synthetic method
      a(JSONArray var1, JSONArray var2, Object var3) {
         this(var1, var2);
      }

      public JSONArray a() {
         return this.a;
      }

      public JSONArray b() {
         return this.b;
      }
   }
}
