package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.utils.l;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.t;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

public class a {
   private final j a;
   private final p b;
   private com.applovin.impl.sdk.network.a.b c;

   public a(j var1) {
      this.a = var1;
      this.b = var1.v();
   }

   private int a(Throwable var1) {
      if (var1 instanceof UnknownHostException) {
         return -103;
      } else if (var1 instanceof SocketTimeoutException) {
         return -102;
      } else if (var1 instanceof IOException) {
         return -100;
      } else {
         return var1 instanceof JSONException ? -104 : -1;
      }
   }

   private Object a(String var1, Object var2) throws JSONException, SAXException, ClassCastException {
      if (var2 == null) {
         return var1;
      } else {
         if (var1 != null) {
            if (var1.length() < 3) {
               return var2;
            }

            if (var2 instanceof JSONObject) {
               return new JSONObject(var1);
            }

            if (var2 instanceof s) {
               return t.a(var1, this.a);
            }

            if (var2 instanceof String) {
               return var1;
            }

            p var3 = this.b;
            StringBuilder var4 = new StringBuilder();
            var4.append("Failed to process response of type '");
            var4.append(var2.getClass().getName());
            var4.append("'");
            var3.e("ConnectionManager", var4.toString());
         }

         return var2;
      }
   }

   private HttpURLConnection a(String var1, String var2, Map var3, int var4) throws IOException {
      HttpURLConnection var5 = (HttpURLConnection)(new URL(var1)).openConnection();
      var5.setRequestMethod(var2);
      int var6;
      if (var4 < 0) {
         var6 = (Integer)this.a.a(com.applovin.impl.sdk.b.d.dw);
      } else {
         var6 = var4;
      }

      var5.setConnectTimeout(var6);
      if (var4 < 0) {
         var4 = (Integer)this.a.a(com.applovin.impl.sdk.b.d.dx);
      }

      var5.setReadTimeout(var4);
      var5.setDefaultUseCaches(false);
      var5.setAllowUserInteraction(false);
      var5.setUseCaches(false);
      var5.setInstanceFollowRedirects(true);
      var5.setDoInput(true);
      if (var3 != null && var3.size() > 0) {
         Iterator var7 = var3.keySet().iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            StringBuilder var9 = new StringBuilder();
            var9.append("AppLovin-");
            var9.append(var8);
            var5.setRequestProperty(var9.toString(), (String)var3.get(var8));
         }
      }

      return var5;
   }

   private void a(int var1, String var2) {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.af)) {
         try {
            d.a(var1, var2, this.a.D());
         } catch (Throwable var7) {
            p var4 = this.a.v();
            StringBuilder var5 = new StringBuilder();
            var5.append("Failed to track response code for URL: ");
            var5.append(var2);
            var4.b("ConnectionManager", var5.toString(), var7);
            return;
         }
      }
   }

   private void a(String var1) {
      com.applovin.impl.sdk.c.g var3;
      h var2;
      if (!n.a(var1, com.applovin.impl.sdk.utils.h.g(this.a)) && !n.a(var1, com.applovin.impl.sdk.utils.h.h(this.a))) {
         if (!n.a(var1, com.applovin.impl.mediation.d.b.a(this.a)) && !n.a(var1, com.applovin.impl.mediation.d.b.b(this.a))) {
            var2 = this.a.L();
            var3 = com.applovin.impl.sdk.c.g.i;
         } else {
            var2 = this.a.L();
            var3 = com.applovin.impl.sdk.c.g.n;
         }
      } else {
         var2 = this.a.L();
         var3 = com.applovin.impl.sdk.c.g.h;
      }

      var2.a(var3);
   }

   private void a(String var1, int var2, String var3, Object var4, boolean var5, com.applovin.impl.sdk.network.a.c var6) {
      p var7 = this.b;
      StringBuilder var8 = new StringBuilder();
      var8.append(var2);
      var8.append(" received from \"");
      var8.append(var3);
      var7.b("ConnectionManager", var8.toString());
      this.b.a("ConnectionManager", (String)var1);
      if (var2 >= 200 && var2 < 300) {
         if (var5) {
            var1 = l.a((String)var1, (String)this.a.t());
         }

         boolean var18;
         if (var1 != null && ((String)var1).length() > 2) {
            var18 = true;
         } else {
            var18 = false;
         }

         if (var2 != 204 && var18) {
            label50: {
               label49: {
                  Object var19;
                  String var22;
                  StringBuilder var21;
                  p var20;
                  try {
                     if (!(var4 instanceof String)) {
                        if (!(var4 instanceof s)) {
                           if (var4 instanceof JSONObject) {
                              var4 = new JSONObject((String)var1);
                           } else {
                              p var26 = this.b;
                              StringBuilder var27 = new StringBuilder();
                              var27.append("Unable to handle '");
                              var27.append(var4.getClass().getName());
                              var27.append("'");
                              var26.e("ConnectionManager", var27.toString());
                           }
                           break label50;
                        }

                        var1 = t.a((String)var1, (j)this.a);
                     }
                     break label49;
                  } catch (JSONException var28) {
                     var19 = var28;
                     this.a(var3);
                     var20 = this.b;
                     var21 = new StringBuilder();
                     var22 = "Invalid JSON returned from \"";
                  } catch (SAXException var29) {
                     var19 = var29;
                     this.a(var3);
                     var20 = this.b;
                     var21 = new StringBuilder();
                     var22 = "Invalid XML returned from \"";
                  }

                  var21.append(var22);
                  var21.append(var3);
                  var21.append("\"");
                  var20.b("ConnectionManager", var21.toString(), (Throwable)var19);
                  break label50;
               }

               var4 = var1;
            }
         }

         var6.a(var4, var2);
      } else {
         p var12 = this.b;
         StringBuilder var13 = new StringBuilder();
         var13.append(var2);
         var13.append(" error received from \"");
         var13.append(var3);
         var13.append("\"");
         var12.e("ConnectionManager", var13.toString());
         var6.a(var2);
      }
   }

   private void a(String var1, String var2, int var3, long var4) {
      p var6 = this.b;
      StringBuilder var7 = new StringBuilder();
      var7.append("Successful ");
      var7.append(var1);
      var7.append(" returned ");
      var7.append(var3);
      var7.append(" in ");
      var7.append((float)(System.currentTimeMillis() - var4) / 1000.0F);
      var7.append(" s over ");
      var7.append(com.applovin.impl.sdk.utils.h.f(this.a));
      var7.append(" to \"");
      var7.append(var2);
      var7.append("\"");
      var6.c("ConnectionManager", var7.toString());
   }

   private void a(String var1, String var2, int var3, long var4, Throwable var6) {
      p var7 = this.b;
      StringBuilder var8 = new StringBuilder();
      var8.append("Failed ");
      var8.append(var1);
      var8.append(" returned ");
      var8.append(var3);
      var8.append(" in ");
      var8.append((float)(System.currentTimeMillis() - var4) / 1000.0F);
      var8.append(" s over ");
      var8.append(com.applovin.impl.sdk.utils.h.f(this.a));
      var8.append(" to \"");
      var8.append(var2);
      var8.append("\"");
      var7.b("ConnectionManager", var8.toString(), var6);
   }

   public com.applovin.impl.sdk.network.a.b a() {
      return this.c;
   }

   public void a(com.applovin.impl.sdk.network.b param1, com.applovin.impl.sdk.network.a.a param2, com.applovin.impl.sdk.network.a.c param3) {
      // $FF: Couldn't be decompiled
   }

   public static class a {
      private long a;
      private long b;

      private void a(long var1) {
         this.a = var1;
      }

      // $FF: synthetic method
      static void a(com.applovin.impl.sdk.network.a.a var0, long var1) {
         var0.b(var1);
      }

      private void b(long var1) {
         this.b = var1;
      }

      // $FF: synthetic method
      static void b(com.applovin.impl.sdk.network.a.a var0, long var1) {
         var0.a(var1);
      }

      public long a() {
         return this.a;
      }

      public long b() {
         return this.b;
      }
   }

   public static class b {
      private final long a = System.currentTimeMillis();
      private final String b;
      private final long c;
      private final long d;

      b(String var1, long var2, long var4) {
         this.b = var1;
         this.c = var2;
         this.d = var4;
      }

      public long a() {
         return this.a;
      }

      public String b() {
         return this.b;
      }

      public long c() {
         return this.c;
      }

      public long d() {
         return this.d;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("RequestMeasurement{timestampMillis=");
         var1.append(this.a);
         var1.append(", urlHostAndPathString='");
         var1.append(this.b);
         var1.append('\'');
         var1.append(", responseSize=");
         var1.append(this.c);
         var1.append(", connectionTimeMillis=");
         var1.append(this.d);
         var1.append('}');
         return var1.toString();
      }
   }

   public interface c {
      void a(int var1);

      void a(Object var1, int var2);
   }
}
