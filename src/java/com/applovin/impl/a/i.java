package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.q;
import com.applovin.impl.sdk.utils.s;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class i {
   private static DateFormat a;
   private static Random b;

   static {
      a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
      b = new Random(System.currentTimeMillis());
   }

   public static Uri a(String var0, long var1, Uri var3, d var4, com.applovin.impl.sdk.j var5) {
      if (URLUtil.isValidUrl(var0)) {
         Throwable var10000;
         label176: {
            String var11;
            boolean var10001;
            try {
               var11 = var0.replace("[ERRORCODE]", Integer.toString(var4.a()));
            } catch (Throwable var32) {
               var10000 = var32;
               var10001 = false;
               break label176;
            }

            if (var1 >= 0L) {
               try {
                  var11 = var11.replace("[CONTENTPLAYHEAD]", a(var1));
               } catch (Throwable var31) {
                  var10000 = var31;
                  var10001 = false;
                  break label176;
               }
            }

            if (var3 != null) {
               try {
                  var11 = var11.replace("[ASSETURI]", var3.toString());
               } catch (Throwable var30) {
                  var10000 = var30;
                  var10001 = false;
                  break label176;
               }
            }

            label161:
            try {
               Uri var12 = Uri.parse(var11.replace("[CACHEBUSTING]", a()).replace("[TIMESTAMP]", b()));
               return var12;
            } catch (Throwable var29) {
               var10000 = var29;
               var10001 = false;
               break label161;
            }
         }

         Throwable var6 = var10000;
         p var7 = var5.v();
         StringBuilder var8 = new StringBuilder();
         var8.append("Unable to replace macros in URL string ");
         var8.append(var0);
         var7.b("VastUtils", var8.toString(), var6);
         return null;
      } else {
         var5.v().e("VastUtils", "Unable to replace macros in invalid URL string.");
         return null;
      }
   }

   public static d a(a var0) {
      return !b(var0) && !c(var0) ? d.c : null;
   }

   private static String a() {
      return Integer.toString(10000000 + b.nextInt(89999999));
   }

   private static String a(long var0) {
      if (var0 > 0L) {
         long var2 = TimeUnit.SECONDS.toHours(var0);
         long var4 = TimeUnit.SECONDS.toMinutes(var0) % TimeUnit.MINUTES.toSeconds(1L);
         long var6 = var0 % TimeUnit.MINUTES.toSeconds(1L);
         Locale var8 = Locale.US;
         Object[] var9 = new Object[]{var2, var4, var6};
         return String.format(var8, "%02d:%02d:%02d.000", var9);
      } else {
         return "00:00:00.000";
      }
   }

   public static String a(c var0) {
      if (var0 != null) {
         List var1 = var0.b();
         int var2 = var0.b().size();
         if (var2 > 0) {
            s var3 = ((s)var1.get(var2 - 1)).c("VASTAdTagURI");
            if (var3 != null) {
               return var3.c();
            }
         }

         return null;
      } else {
         throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
      }
   }

   public static String a(s var0, String var1, String var2) {
      s var3 = var0.b(var1);
      if (var3 != null) {
         String var4 = var3.c();
         if (n.b(var4)) {
            return var4;
         }
      }

      return var2;
   }

   private static Set a(c var0, com.applovin.impl.sdk.j var1) {
      if (var0 != null) {
         List var2 = var0.b();
         Object var3 = new HashSet(var2.size());

         List var13;
         for(Iterator var4 = var2.iterator(); var4.hasNext(); var3 = a((Set)var3, (List)var13, var0, var1)) {
            s var11 = (s)var4.next();
            s var12 = var11.c("Wrapper");
            if (var12 == null) {
               var12 = var11.c("InLine");
            }

            if (var12 != null) {
               var13 = var12.a("Error");
            } else {
               var13 = var11.a("Error");
            }
         }

         p var5 = var1.v();
         StringBuilder var6 = new StringBuilder();
         var6.append("Retrieved ");
         var6.append(((Set)var3).size());
         var6.append(" top level error trackers: ");
         var6.append(var3);
         var5.b("VastUtils", var6.toString());
         return (Set)var3;
      } else {
         return null;
      }
   }

   private static Set a(Set var0, List var1, c var2, com.applovin.impl.sdk.j var3) {
      if (var1 != null) {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            g var5 = g.a((s)var4.next(), var2, var3);
            if (var5 != null) {
               var0.add(var5);
            }
         }
      }

      return var0;
   }

   public static void a(c var0, AppLovinAdLoadListener var1, d var2, int var3, com.applovin.impl.sdk.j var4) {
      if (var4 != null) {
         q.a(var1, var0.g(), var3, var4);
         a(a(var0, var4), var2, var4);
      } else {
         throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
      }
   }

   public static void a(s var0, Map var1, c var2, com.applovin.impl.sdk.j var3) {
      if (var3 == null) {
         IllegalArgumentException var4 = new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
         throw var4;
      } else {
         String var21;
         p var20;
         if (var0 == null) {
            var20 = var3.v();
            var21 = "Unable to render event trackers; null node provided";
         } else {
            if (var1 != null) {
               s var5 = var0.b("TrackingEvents");
               if (var5 != null) {
                  List var6 = var5.a("Tracking");
                  if (var6 != null) {
                     Iterator var7 = var6.iterator();

                     while(var7.hasNext()) {
                        s var8 = (s)var7.next();
                        String var9 = (String)var8.b().get("event");
                        if (n.b(var9)) {
                           g var14 = g.a(var8, var2, var3);
                           if (var14 != null) {
                              Set var15 = (Set)var1.get(var9);
                              if (var15 != null) {
                                 var15.add(var14);
                              } else {
                                 HashSet var16 = new HashSet();
                                 var16.add(var14);
                                 var1.put(var9, var16);
                              }
                           }
                        } else {
                           p var10 = var3.v();
                           StringBuilder var11 = new StringBuilder();
                           var11.append("Could not find event for tracking node = ");
                           var11.append(var8);
                           var10.e("VastUtils", var11.toString());
                        }
                     }
                  }
               }

               return;
            }

            var20 = var3.v();
            var21 = "Unable to render event trackers; null event trackers provided";
         }

         var20.e("VastUtils", var21);
      }
   }

   public static void a(List var0, Set var1, c var2, com.applovin.impl.sdk.j var3) {
      if (var3 != null) {
         p var8;
         String var9;
         if (var0 == null) {
            var8 = var3.v();
            var9 = "Unable to render trackers; null nodes provided";
         } else {
            if (var1 != null) {
               Iterator var5 = var0.iterator();

               while(var5.hasNext()) {
                  g var6 = g.a((s)var5.next(), var2, var3);
                  if (var6 != null) {
                     var1.add(var6);
                  }
               }

               return;
            }

            var8 = var3.v();
            var9 = "Unable to render trackers; null trackers provided";
         }

         var8.e("VastUtils", var9);
      } else {
         IllegalArgumentException var4 = new IllegalArgumentException("Unable to render trackers. No sdk specified.");
         throw var4;
      }
   }

   public static void a(Set var0, long var1, Uri var3, d var4, com.applovin.impl.sdk.j var5) {
      if (var5 == null) {
         IllegalArgumentException var6 = new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
         throw var6;
      } else {
         if (var0 != null && !var0.isEmpty()) {
            Iterator var7 = var0.iterator();

            while(var7.hasNext()) {
               Uri var8 = a(((g)var7.next()).b(), var1, var3, var4, var5);
               if (var8 != null) {
                  var5.N().a(com.applovin.impl.sdk.network.f.l().a(var8.toString()).a(false).a(), false);
               }
            }
         }

      }
   }

   public static void a(Set var0, d var1, com.applovin.impl.sdk.j var2) {
      a((Set)var0, -1L, (Uri)null, var1, var2);
   }

   public static void a(Set var0, com.applovin.impl.sdk.j var1) {
      a((Set)var0, -1L, (Uri)null, d.a, var1);
   }

   public static boolean a(s var0) {
      if (var0 != null) {
         return var0.c("Wrapper") != null;
      } else {
         throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
      }
   }

   private static String b() {
      a.setTimeZone(TimeZone.getDefault());
      return a.format(new Date());
   }

   public static boolean b(a var0) {
      if (var0 == null) {
         return false;
      } else {
         j var1 = var0.h();
         boolean var2 = false;
         if (var1 != null) {
            List var3 = var1.a();
            var2 = false;
            if (var3 != null) {
               boolean var4 = var3.isEmpty();
               var2 = false;
               if (!var4) {
                  var2 = true;
               }
            }
         }

         return var2;
      }
   }

   public static boolean b(s var0) {
      if (var0 != null) {
         return var0.c("InLine") != null;
      } else {
         throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
      }
   }

   public static boolean c(a var0) {
      if (var0 == null) {
         return false;
      } else {
         b var1 = var0.j();
         boolean var2 = false;
         if (var1 != null) {
            e var3 = var1.b();
            var2 = false;
            if (var3 != null) {
               if (var3.b() == null) {
                  boolean var4 = n.b(var3.c());
                  var2 = false;
                  if (!var4) {
                     return var2;
                  }
               }

               var2 = true;
            }
         }

         return var2;
      }
   }
}
