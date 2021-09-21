package com.noqoush.adfalcon.android.sdk.helper;

import android.content.Context;
import com.noqoush.adfalcon.android.sdk.z;
import com.noqoush.adfalcon.android.sdk.response.d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.net.ssl.HttpsURLConnection;

public class c {
   private static final int d = 21;
   private static ExecutorService e = Executors.newFixedThreadPool(5);
   private d a;
   private Vector b;
   private String c;

   public c(Context var1, d var2) {
      try {
         this.a(var2);
         this.a((new z(var1)).getSettings().getUserAgentString());
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }
   }

   public c(Context var1, Vector var2) {
      try {
         this.a(var2);
         this.a((new z(var1)).getSettings().getUserAgentString());
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }
   }

   public c(Vector var1, String var2) {
      try {
         this.a(var1);
         this.a(var2);
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }
   }

   private Boolean a(String var1, com.noqoush.adfalcon.android.sdk.response.c var2) {
      System.setProperty("http.maxRedirects", "21");
      if (this.c() != null) {
         System.setProperty("http.agent", this.c());
      }

      int var4 = 1;

      while(true) {
         boolean var5 = this.a((String)var1, (String)null);
         if (var5 || var4 >= 5) {
            if (var2 != null) {
               var2.a(true);
            }

            return var5;
         }

         ++var4;
      }
   }

   private URLConnection a(URLConnection var1, URL var2, String var3) throws IOException, Exception {
      Object var4;
      if (var2.getProtocol().startsWith("https")) {
         var4 = (HttpsURLConnection)var2.openConnection();
         ((HttpsURLConnection)var4).setInstanceFollowRedirects(false);
      } else {
         if (!var2.getProtocol().startsWith("http")) {
            throw new Exception("Protocol not supported!");
         }

         var4 = (HttpURLConnection)var2.openConnection();
         ((HttpURLConnection)var4).setInstanceFollowRedirects(false);
      }

      ((URLConnection)var4).setConnectTimeout(5000);
      ((URLConnection)var4).setReadTimeout(5000);
      ((URLConnection)var4).setUseCaches(false);
      if (var3 != null) {
         ((URLConnection)var4).setRequestProperty("Cookie", var3);
      }

      if (this.c() != null) {
         ((URLConnection)var4).setRequestProperty("User-Agent", this.c());
      }

      return (URLConnection)var4;
   }

   private void a(String var1) {
      this.c = var1;
   }

   private void a(URLConnection var1) {
      if (var1 instanceof HttpsURLConnection) {
         ((HttpsURLConnection)var1).disconnect();
      } else {
         if (var1 instanceof HttpURLConnection) {
            ((HttpURLConnection)var1).disconnect();
         }

      }
   }

   private void a(Vector var1) {
      this.b = var1;
   }

   private boolean a(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private int b(URLConnection var1) throws IOException {
      if (var1 instanceof HttpsURLConnection) {
         return ((HttpsURLConnection)var1).getResponseCode();
      } else {
         return var1 instanceof HttpURLConnection ? ((HttpURLConnection)var1).getResponseCode() : 0;
      }
   }

   private Vector b() {
      return this.b;
   }

   private void b(final String var1, final com.noqoush.adfalcon.android.sdk.response.c var2) {
      try {
         FutureTask var3 = new FutureTask(new c.b(var1, var2));
         e.execute(var3);
      } catch (Exception var5) {
         (new Thread(new Runnable() {
            public void run() {
               try {
                  c.this.a(var1, var2);
               } catch (Exception var2x) {
                  com.noqoush.adfalcon.android.sdk.util.a.a(var2x);
               }
            }
         })).start();
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }
   }

   private String c() {
      return this.c;
   }

   public d a() {
      return this.a;
   }

   public void a(d var1) {
      this.a = var1;
   }

   public boolean a(com.noqoush.adfalcon.android.sdk.response.b var1, String var2) {
      Exception var10000;
      label68: {
         boolean var10001;
         if (var1 != null && var2 != null) {
            try {
               if (var1.b() != null && var1.b().trim().equalsIgnoreCase(var2.trim())) {
                  return false;
               }
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label68;
            }
         }

         label59: {
            Iterator var5;
            try {
               if (this.a() == null) {
                  break label59;
               }

               var5 = this.a().a().iterator();
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break label68;
            }

            while(true) {
               try {
                  com.noqoush.adfalcon.android.sdk.response.c var6;
                  do {
                     if (!var5.hasNext()) {
                        return true;
                     }

                     var6 = (com.noqoush.adfalcon.android.sdk.response.c)var5.next();
                  } while(var6.b());

                  var6.a(true);
                  this.b(var6.a(), var6);
               } catch (Exception var7) {
                  var10000 = var7;
                  var10001 = false;
                  break label68;
               }
            }
         }

         Iterator var4;
         try {
            var4 = this.b().iterator();
         } catch (Exception var9) {
            var10000 = var9;
            var10001 = false;
            break label68;
         }

         while(true) {
            try {
               if (!var4.hasNext()) {
                  return true;
               }

               this.b((String)var4.next(), (com.noqoush.adfalcon.android.sdk.response.c)null);
            } catch (Exception var8) {
               var10000 = var8;
               var10001 = false;
               break;
            }
         }
      }

      Exception var3 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      return true;
   }

   private class b implements Callable {
      String a;
      com.noqoush.adfalcon.android.sdk.response.c b;

      b(String var2, com.noqoush.adfalcon.android.sdk.response.c var3) {
         this.a = var2;
         this.b = var3;
      }

      public Boolean call() throws Exception {
         return c.this.a(this.a, this.b);
      }
   }
}
