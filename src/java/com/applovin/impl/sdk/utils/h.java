package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
   private static final int[] a = new int[]{7, 4, 2, 1, 11};
   private static final int[] b = new int[]{5, 6, 10, 3, 9, 8, 14};
   private static final int[] c = new int[]{15, 12, 13};

   public static String a(InputStream var0, com.applovin.impl.sdk.j var1) {
      if (var0 == null) {
         return null;
      } else {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();

         Throwable var10000;
         label180: {
            boolean var10001;
            byte[] var4;
            try {
               var4 = new byte[(Integer)var1.a(com.applovin.impl.sdk.b.d.dD)];
            } catch (Throwable var26) {
               var10000 = var26;
               var10001 = false;
               break label180;
            }

            while(true) {
               int var5;
               try {
                  var5 = var0.read(var4);
               } catch (Throwable var24) {
                  var10000 = var24;
                  var10001 = false;
                  break;
               }

               if (var5 <= 0) {
                  try {
                     String var6 = var2.toString("UTF-8");
                     return var6;
                  } catch (Throwable var23) {
                     var10000 = var23;
                     var10001 = false;
                     break;
                  }
               }

               try {
                  var2.write(var4, 0, var5);
               } catch (Throwable var25) {
                  var10000 = var25;
                  var10001 = false;
                  break;
               }
            }
         }

         Throwable var3 = var10000;
         var1.v().b("ConnectionUtils", "Encountered error while reading stream", var3);
         return null;
      }
   }

   public static String a(String var0, com.applovin.impl.sdk.j var1) {
      return a((String)var1.a(com.applovin.impl.sdk.b.d.aN), var0, var1);
   }

   public static String a(String var0, String var1, com.applovin.impl.sdk.j var2) {
      if (var0 != null && var0.length() >= 4) {
         if (var1 != null) {
            if (var2 != null) {
               StringBuilder var3 = new StringBuilder();
               var3.append(var0);
               var3.append(var1);
               return var3.toString();
            } else {
               throw new IllegalArgumentException("No sdk specified");
            }
         } else {
            throw new IllegalArgumentException("No endpoint specified");
         }
      } else {
         throw new IllegalArgumentException("Invalid domain specified");
      }
   }

   public static JSONObject a(JSONObject var0) throws JSONException {
      return (JSONObject)var0.getJSONArray("results").get(0);
   }

   public static void a(int var0, com.applovin.impl.sdk.j var1) {
      com.applovin.impl.sdk.b.e var2 = var1.C();
      String var6;
      StringBuilder var3;
      if (var0 == 401) {
         var2.a((com.applovin.impl.sdk.b.d)com.applovin.impl.sdk.b.d.X, (Object)"");
         var2.a((com.applovin.impl.sdk.b.d)com.applovin.impl.sdk.b.d.Y, (Object)"");
         var2.b();
         var3 = new StringBuilder();
         var3.append("SDK key \"");
         var3.append(var1.t());
         var6 = "\" is rejected by AppLovin. Please make sure the SDK key is correct.";
      } else {
         if (var0 != 418) {
            if (var0 >= 400 && var0 < 500 || var0 == -1) {
               var1.g();
            }

            return;
         }

         var2.a((com.applovin.impl.sdk.b.d)com.applovin.impl.sdk.b.d.W, (Object)true);
         var2.b();
         var3 = new StringBuilder();
         var3.append("SDK key \"");
         var3.append(var1.t());
         var6 = "\" has been blocked. Please contact AppLovin support at support@applovin.com.";
      }

      var3.append(var6);
      com.applovin.impl.sdk.p.j("AppLovinSdk", var3.toString());
   }

   public static void a(JSONObject var0, boolean var1, com.applovin.impl.sdk.j var2) {
      var2.ac().a(var0, var1);
   }

   public static boolean a() {
      return a((String)null);
   }

   private static boolean a(int var0, int[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if (var1[var3] == var0) {
            return true;
         }
      }

      return false;
   }

   public static boolean a(Context var0) {
      if (var0.getSystemService("connectivity") != null) {
         NetworkInfo var1 = b(var0);
         return var1 != null ? var1.isConnected() : false;
      } else {
         return true;
      }
   }

   public static boolean a(String var0) {
      if (g.e()) {
         return g.f() && !TextUtils.isEmpty(var0) ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(var0) : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
      } else {
         return true;
      }
   }

   private static NetworkInfo b(Context var0) {
      ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");
      return var1 != null ? var1.getActiveNetworkInfo() : null;
   }

   public static String b(String var0, com.applovin.impl.sdk.j var1) {
      return a((String)var1.a(com.applovin.impl.sdk.b.d.aO), var0, var1);
   }

   public static void c(JSONObject var0, com.applovin.impl.sdk.j var1) {
      String var2 = i.b(var0, "persisted_data", (String)null, var1);
      if (n.b(var2)) {
         var1.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.z, (Object)var2);
         var1.v().c("ConnectionUtils", "Updated persisted data");
      }

   }

   public static void d(JSONObject var0, com.applovin.impl.sdk.j var1) {
      if (var0 != null) {
         if (var1 != null) {
            try {
               if (var0.has("settings")) {
                  com.applovin.impl.sdk.b.e var3 = var1.C();
                  if (!var0.isNull("settings")) {
                     var3.a(var0.getJSONObject("settings"));
                     var3.b();
                     var1.v().b("ConnectionUtils", "New settings processed");
                     return;
                  }
               }
            } catch (JSONException var4) {
               var1.v().b("ConnectionUtils", "Unable to parse settings out of API response", var4);
            }

         } else {
            throw new IllegalArgumentException("No sdk specified");
         }
      } else {
         throw new IllegalArgumentException("No response specified");
      }
   }

   public static Map e(com.applovin.impl.sdk.j var0) {
      HashMap var1;
      label14: {
         var1 = new HashMap();
         String var2 = (String)var0.a(com.applovin.impl.sdk.b.d.Y);
         String var6;
         if (n.b(var2)) {
            var6 = "device_token";
         } else {
            if ((Boolean)var0.a(com.applovin.impl.sdk.b.d.eR)) {
               break label14;
            }

            var2 = var0.t();
            var6 = "api_key";
         }

         var1.put(var6, var2);
      }

      var1.put("sc", n.e((String)var0.a(com.applovin.impl.sdk.b.d.aa)));
      var1.put("sc2", n.e((String)var0.a(com.applovin.impl.sdk.b.d.ab)));
      var1.put("server_installed_at", n.e((String)var0.a(com.applovin.impl.sdk.b.d.ac)));
      q.a((String)"persisted_data", (String)n.e((String)var0.a(com.applovin.impl.sdk.b.f.z)), (Map)var1);
      return var1;
   }

   public static void e(JSONObject var0, com.applovin.impl.sdk.j var1) {
      JSONArray var2 = i.b(var0, "zones", (JSONArray)null, var1);
      if (var2 != null) {
         Iterator var3 = var1.W().a(var2).iterator();

         while(var3.hasNext()) {
            com.applovin.impl.sdk.ad.d var4 = (com.applovin.impl.sdk.ad.d)var3.next();
            if (var4.d()) {
               var1.p().preloadAds(var4);
            } else {
               var1.o().preloadAds(var4);
            }
         }

         var1.T().a(var1.W().a());
         var1.U().a(var1.W().a());
      }

   }

   public static String f(com.applovin.impl.sdk.j var0) {
      NetworkInfo var1 = b(var0.D());
      String var2 = "unknown";
      if (var1 != null) {
         int var3 = var1.getType();
         int var4 = var1.getSubtype();
         if (var3 == 1) {
            return "wifi";
         }

         if (var3 == 0) {
            if (a(var4, a)) {
               return "2g";
            }

            if (a(var4, b)) {
               return "3g";
            }

            if (a(var4, c)) {
               return "4g";
            }

            var2 = "mobile";
         }
      }

      return var2;
   }

   public static void f(JSONObject var0, com.applovin.impl.sdk.j var1) {
      JSONObject var2 = i.b(var0, "variables", (JSONObject)null, var1);
      if (var2 != null) {
         var1.s().updateVariables(var2);
      }

   }

   public static String g(com.applovin.impl.sdk.j var0) {
      return a((String)var0.a(com.applovin.impl.sdk.b.d.aL), "4.0/ad", var0);
   }

   public static String h(com.applovin.impl.sdk.j var0) {
      return a((String)var0.a(com.applovin.impl.sdk.b.d.aM), "4.0/ad", var0);
   }

   public static String i(com.applovin.impl.sdk.j var0) {
      return a((String)var0.a(com.applovin.impl.sdk.b.d.aR), "1.0/variable_config", var0);
   }

   public static String j(com.applovin.impl.sdk.j var0) {
      return a((String)var0.a(com.applovin.impl.sdk.b.d.aS), "1.0/variable_config", var0);
   }
}
