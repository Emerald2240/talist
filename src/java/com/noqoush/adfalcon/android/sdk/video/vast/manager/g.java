package com.noqoush.adfalcon.android.sdk.video.vast.manager;

import android.content.Context;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class g {
   private static final String A = "[PAGEURL]";
   private static final String B = "[APPBUNDLE]";
   private static final String C = "[VASTVERSIONS]";
   private static final String D = "[APIFRAMEWORKS]";
   private static final String E = "[EXTENSIONS]";
   private static final String F = "[VERIFICATIONVENDORS]";
   private static final String G = "[OMIDPARTNER]";
   private static final String H = "[MEDIAMIME]";
   private static final String I = "[PLAYERCAPABILITIES]";
   private static final String J = "[CLICKTYPE]";
   private static final String K = "[PLAYERSTATE]";
   private static final String L = "[INVENTORYSTATE]";
   private static final String M = "[PLAYERSIZE]";
   private static final String N = "[ADPLAYHEAD]";
   private static final String O = "[CONTENTID]";
   private static final String P = "[CONTENTURI]";
   private static final String Q = "[PODSEQUENCE]";
   private static final String R = "[CLICKPOS]";
   private static final String S = "[LIMITADTRACKING]";
   private static final String T = "[REGULATIONS]";
   private static final String U = "[GDPRCONSENT]";
   private static final String c = "[TIMESTAMP]";
   private static final String d = "[ERRORCODE]";
   private static final String e = "[CONTENTPLAYHEAD]";
   private static final String f = "[CACHEBUSTING]";
   private static final String g = "[ASSETURI]";
   private static final String h = "[REASON]";
   private static final String i = "[ADSERVINGID]";
   private static final String j = "[DOMAIN]";
   private static final String k = "[PLAYERUA]";
   private static final String l = "[MEDIAPLAYHEAD]";
   private static final String m = "[BREAKPOSITION]";
   private static final String n = "[ADCATEGORIES]";
   private static final String o = "[ADCOUNT]";
   private static final String p = "[TRANSACTIONID]";
   private static final String q = "[PLACEMENTTYPE]";
   private static final String r = "[ADTYPE]";
   private static final String s = "[UNIVERSALADID]";
   private static final String t = "[IFA]";
   private static final String u = "[IFATYPE]";
   private static final String v = "[CLIENTUA]";
   private static final String w = "[DEVICEUA]";
   private static final String x = "[SERVERSIDE]";
   private static final String y = "[DEVICEIP]";
   private static final String z = "[LATLONG]";
   private int a;
   private HashMap b = new HashMap();

   public g(Context var1, r var2) {
      this.a(0);
      this.a("[ASSETURI]", var2.o().a(var1).k());
      this.a("[ADCATEGORIES]", "-1");
      this.a("[ADCOUNT]", "-1");
      this.a("[TRANSACTIONID]", "-1");
      if (var2.s() != null && var2.s().d() != null && var2.s().c() != null) {
         StringBuilder var15 = new StringBuilder();
         var15.append("");
         var15.append(var2.s().d());
         var15.append(" ");
         var15.append(var2.s().c());
         this.a("[UNIVERSALADID]", var15.toString());
      }

      com.noqoush.adfalcon.android.sdk.g var3 = com.noqoush.adfalcon.android.sdk.g.c(var1);
      this.a("[PLAYERUA]", "AdFalconSDK/sdk-a-5.2.0");
      this.a("[BREAKPOSITION]", "1");
      this.a("[PLACEMENTTYPE]", "5");
      this.a("[ADTYPE]", "video");
      this.a("[IFA]", var3.a((Context)null).getId());
      this.a("[IFATYPE]", "idfa");
      this.a("[CLIENTUA]", "AdFalconSDK/sdk-a-5.2.0 Rewareded video ad/sdk-a-5.2.0");
      this.a("[DEVICEUA]", var3.w());
      this.a("[SERVERSIDE]", "0");
      this.a("[DEVICEIP]", "-1");
      if (var3.i() != 0.0D && var3.j() != 0.0D) {
         StringBuilder var11 = new StringBuilder();
         var11.append(var3.i());
         var11.append(",");
         var11.append(var3.j());
         this.a("[LATLONG]", var11.toString());
      }

      this.a("[PAGEURL]", "-1");
      this.a("[APPBUNDLE]", var3.p());
      this.a("[VASTVERSIONS]", "2,3,4,5,6,7,8,11,12,13,14");
      this.a("[APIFRAMEWORKS]", "7");
      this.a("[EXTENSIONS]", "AdVerifications");
      this.a("[VERIFICATIONVENDORS]", "-1");
      this.a("[OMIDPARTNER]", "Adfalcon/sdk-a-5.2.0");
      this.a("[MEDIAMIME]", "video/mp4,video/3gp");
      this.a("[PLAYERCAPABILITIES]", "mute,autoplay,fullscreen");
      this.a("[CLICKTYPE]", "2");
      this.a("[PLAYERSTATE]", "fullscreen");
      this.a("[INVENTORYSTATE]", "skippable,autoplayed");
      StringBuilder var4 = new StringBuilder();
      var4.append(var3.v());
      var4.append(",");
      var4.append(var3.u());
      this.a("[PLAYERSIZE]", var4.toString());
      this.a("[PLAYERSTATE]", "fullscreen");
      if (var2.a() > 0) {
         StringBuilder var8 = new StringBuilder();
         var8.append("");
         var8.append(var2.a());
         this.a("[PODSEQUENCE]", var8.toString());
      }

      this.a("[ADSERVINGID]", var2.b());
      this.a("[CLICKPOS]", "-1");
      this.a("[LIMITADTRACKING]", "-1");
      this.a("[REGULATIONS]", "-1");
      this.a("[GDPRCONSENT]", "-1");
   }

   public String a() {
      StringBuilder var1 = new StringBuilder();
      var1.append("");
      var1.append(Calendar.getInstance().getTimeInMillis());
      return var1.toString();
   }

   public String a(String var1) {
      return this.a(var1, (String)null, (String)null);
   }

   public String a(String var1, String var2, String var3) {
      Exception var10000;
      label97: {
         boolean var10001;
         try {
            var1 = var1.replace("[CONTENTPLAYHEAD]", this.c());
         } catch (Exception var23) {
            var10000 = var23;
            var10001 = false;
            break label97;
         }

         try {
            var1 = var1.replace("[MEDIAPLAYHEAD]", this.c());
         } catch (Exception var22) {
            var10000 = var22;
            var10001 = false;
            break label97;
         }

         try {
            var1 = var1.replace("[ADPLAYHEAD]", this.c());
         } catch (Exception var21) {
            var10000 = var21;
            var10001 = false;
            break label97;
         }

         try {
            var1 = var1.replace("[CACHEBUSTING]", this.a());
         } catch (Exception var20) {
            var10000 = var20;
            var10001 = false;
            break label97;
         }

         try {
            StringBuilder var5 = new StringBuilder();
            var5.append("");
            var5.append(Calendar.getInstance().getTimeInMillis());
            var1 = var1.replace("[TIMESTAMP]", var5.toString());
         } catch (Exception var19) {
            var10000 = var19;
            var10001 = false;
            break label97;
         }

         if (var3 != null) {
            try {
               var1 = var1.replace("[REASON]", var3);
            } catch (Exception var18) {
               var10000 = var18;
               var10001 = false;
               break label97;
            }
         }

         if (var2 != null) {
            try {
               var1 = var1.replace("[ERRORCODE]", var2);
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
               break label97;
            }
         }

         Iterator var8;
         try {
            var8 = this.b.keySet().iterator();
         } catch (Exception var16) {
            var10000 = var16;
            var10001 = false;
            break label97;
         }

         while(true) {
            String var9;
            try {
               if (!var8.hasNext()) {
                  return var1;
               }

               var9 = (String)var8.next();
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break;
            }

            label99: {
               String var11;
               try {
                  var11 = (String)this.b.get(var9);
               } catch (Exception var15) {
                  var10000 = var15;
                  var10001 = false;
                  break label99;
               }

               if (var11 == null) {
                  continue;
               }

               try {
                  var1 = var1.replace(var9, URLEncoder.encode(var11, "UTF-8"));
                  continue;
               } catch (Exception var14) {
                  var10000 = var14;
                  var10001 = false;
               }
            }

            Exception var10 = var10000;

            try {
               var10.printStackTrace();
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break;
            }
         }
      }

      Exception var4 = var10000;
      var4.printStackTrace();
      return var1;
   }

   public void a(int var1) {
      this.a = var1;
   }

   public void a(String var1, String var2) {
      this.b.put(var1, var2);
   }

   public int b() {
      return this.a;
   }

   public String c() {
      return com.noqoush.adfalcon.android.sdk.video.vast.manager.h.a((double)this.b());
   }
}
