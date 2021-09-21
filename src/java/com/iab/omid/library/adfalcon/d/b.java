package com.iab.omid.library.adfalcon.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
   static float a;
   private static WindowManager b;
   private static String[] c = new String[]{"x", "y", "width", "height"};

   static {
      a = Resources.getSystem().getDisplayMetrics().density;
   }

   static float a(int var0) {
      return (float)var0 / a;
   }

   public static JSONObject a(int var0, int var1, int var2, int var3) {
      JSONObject var4 = new JSONObject();

      try {
         var4.put("x", (double)a(var0));
         var4.put("y", (double)a(var1));
         var4.put("width", (double)a(var2));
         var4.put("height", (double)a(var3));
         return var4;
      } catch (JSONException var6) {
         com.iab.omid.library.adfalcon.d.c.a("Error with creating viewStateObject", var6);
         return var4;
      }
   }

   public static void a(Context var0) {
      if (var0 != null) {
         a = var0.getResources().getDisplayMetrics().density;
         b = (WindowManager)var0.getSystemService("window");
      }

   }

   public static void a(JSONObject var0) {
      b.a var1 = b(var0);

      try {
         var0.put("width", (double)var1.a);
         var0.put("height", (double)var1.b);
      } catch (JSONException var3) {
         var3.printStackTrace();
      }
   }

   public static void a(JSONObject var0, String var1) {
      try {
         var0.put("adSessionId", var1);
      } catch (JSONException var3) {
         com.iab.omid.library.adfalcon.d.c.a("Error with setting ad session id", var3);
      }
   }

   public static void a(JSONObject var0, String var1, Object var2) {
      try {
         var0.put(var1, var2);
      } catch (JSONException var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("JSONException during JSONObject.put for name [");
         var4.append(var1);
         var4.append("]");
         com.iab.omid.library.adfalcon.d.c.a(var4.toString(), var5);
      }
   }

   public static void a(JSONObject var0, List var1) {
      JSONArray var2 = new JSONArray();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.put((String)var3.next());
      }

      try {
         var0.put("isFriendlyObstructionFor", var2);
      } catch (JSONException var5) {
         com.iab.omid.library.adfalcon.d.c.a("Error with setting friendly obstruction", var5);
      }
   }

   public static void a(JSONObject var0, JSONObject var1) {
      JSONException var10000;
      label27: {
         boolean var10001;
         JSONArray var3;
         try {
            var3 = var0.optJSONArray("childViews");
         } catch (JSONException var6) {
            var10000 = var6;
            var10001 = false;
            break label27;
         }

         if (var3 == null) {
            try {
               var3 = new JSONArray();
               var0.put("childViews", var3);
            } catch (JSONException var5) {
               var10000 = var5;
               var10001 = false;
               break label27;
            }
         }

         try {
            var3.put(var1);
            return;
         } catch (JSONException var4) {
            var10000 = var4;
            var10001 = false;
         }
      }

      JSONException var2 = var10000;
      var2.printStackTrace();
   }

   private static boolean a(JSONArray var0, JSONArray var1) {
      if (var0 == null && var1 == null) {
         return true;
      } else if (var0 != null) {
         if (var1 == null) {
            return false;
         } else {
            return var0.length() == var1.length();
         }
      } else {
         return false;
      }
   }

   private static b.a b(JSONObject var0) {
      int var1 = VERSION.SDK_INT;
      float var2 = 0.0F;
      int var3 = 0;
      float var5;
      if (var1 >= 17) {
         if (b != null) {
            Point var17 = new Point(0, 0);
            b.getDefaultDisplay().getRealSize(var17);
            var2 = a(var17.x);
            var5 = a(var17.y);
            return new b.a(var2, var5);
         }
      } else {
         JSONArray var4 = var0.optJSONArray("childViews");
         if (var4 != null) {
            int var6 = var4.length();

            float var7;
            for(var7 = 0.0F; var3 < var6; ++var3) {
               JSONObject var8 = var4.optJSONObject(var3);
               if (var8 != null) {
                  double var9 = var8.optDouble("x");
                  double var11 = var8.optDouble("y");
                  double var13 = var8.optDouble("width");
                  double var15 = var8.optDouble("height");
                  var2 = Math.max(var2, (float)(var9 + var13));
                  var7 = Math.max(var7, (float)(var11 + var15));
               }
            }

            var5 = var7;
            return new b.a(var2, var5);
         }
      }

      var5 = 0.0F;
      return new b.a(var2, var5);
   }

   public static void b(JSONObject var0, String var1) {
      try {
         var0.put("notVisibleReason", var1);
      } catch (JSONException var3) {
         com.iab.omid.library.adfalcon.d.c.a("Error with setting not visible reason", var3);
      }
   }

   public static boolean b(JSONObject var0, JSONObject var1) {
      if (var0 == null && var1 == null) {
         return true;
      } else if (var0 != null) {
         if (var1 == null) {
            return false;
         } else {
            return c(var0, var1) && d(var0, var1) && e(var0, var1) && f(var0, var1);
         }
      } else {
         return false;
      }
   }

   private static boolean c(JSONObject var0, JSONObject var1) {
      String[] var2 = c;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if (var0.optDouble(var5) != var1.optDouble(var5)) {
            return false;
         }
      }

      return true;
   }

   private static boolean d(JSONObject var0, JSONObject var1) {
      return var0.optString("adSessionId", "").equals(var1.optString("adSessionId", ""));
   }

   private static boolean e(JSONObject var0, JSONObject var1) {
      JSONArray var2 = var0.optJSONArray("isFriendlyObstructionFor");
      JSONArray var3 = var1.optJSONArray("isFriendlyObstructionFor");
      if (var2 == null && var3 == null) {
         return true;
      } else if (!a(var2, var3)) {
         return false;
      } else {
         for(int var4 = 0; var4 < var2.length(); ++var4) {
            if (!var2.optString(var4, "").equals(var3.optString(var4, ""))) {
               return false;
            }
         }

         return true;
      }
   }

   private static boolean f(JSONObject var0, JSONObject var1) {
      JSONArray var2 = var0.optJSONArray("childViews");
      JSONArray var3 = var1.optJSONArray("childViews");
      if (var2 == null && var3 == null) {
         return true;
      } else if (!a(var2, var3)) {
         return false;
      } else {
         for(int var4 = 0; var4 < var2.length(); ++var4) {
            if (!b(var2.optJSONObject(var4), var3.optJSONObject(var4))) {
               return false;
            }
         }

         return true;
      }
   }

   private static class a {
      final float a;
      final float b;

      a(float var1, float var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
