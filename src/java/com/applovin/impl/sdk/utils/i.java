package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
   public static float a(JSONObject var0, String var1, float var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var0.has(var1)) {
         double var9;
         try {
            var9 = var0.getDouble(var1);
         } catch (JSONException var11) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to retrieve float property for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var11);
            }

            return var2;
         }

         if (-3.4028234663852886E38D < var9 && var9 < 3.4028234663852886E38D) {
            return (float)var9;
         }
      }

      return var2;
   }

   public static long a(JSONObject var0, String var1, long var2, com.applovin.impl.sdk.j var4) {
      if (var0 != null && var0.has(var1)) {
         try {
            long var10 = var0.getLong(var1);
            return var10;
         } catch (JSONException var12) {
            if (var4 != null) {
               com.applovin.impl.sdk.p var6 = var4.v();
               StringBuilder var7 = new StringBuilder();
               var7.append("Failed to retrieve int property for key = ");
               var7.append(var1);
               var6.b("JsonUtils", var7.toString(), var12);
            }
         }
      }

      return var2;
   }

   public static Bundle a(Object var0) {
      JSONObject var1;
      if (var0 instanceof JSONObject) {
         var1 = (JSONObject)var0;
      } else {
         if (var0 instanceof String) {
            label28: {
               String var2 = (String)var0;

               JSONObject var3;
               try {
                  var3 = new JSONObject(var2);
               } catch (JSONException var5) {
                  break label28;
               }

               var1 = var3;
               return c(var1);
            }
         }

         var1 = null;
      }

      return c(var1);
   }

   public static Boolean a(JSONObject var0, String var1, Boolean var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var0.has(var1)) {
         try {
            Boolean var7 = var0.getBoolean(var1);
            return var7;
         } catch (JSONException var8) {
            boolean var5 = true;
            byte var6;
            if (var2 != null && var2) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            if (b(var0, var1, var6, var3) <= 0) {
               var5 = false;
            }

            return var5;
         }
      } else {
         return var2;
      }
   }

   public static Object a(JSONArray var0, int var1, Object var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var0.length() > var1) {
         try {
            Object var10 = var0.get(var1);
            return var10;
         } catch (JSONException var11) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to retrieve object at index ");
               var6.append(var1);
               var6.append(" for JSON array");
               var5.b("JsonUtils", var6.toString(), var11);
            }
         }
      }

      return var2;
   }

   public static Object a(JSONObject var0, String var1, Object var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var0.has(var1)) {
         Object var9;
         try {
            var9 = var0.get(var1);
         } catch (JSONException var10) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to retrieve Object for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var10);
            }

            return var2;
         }

         if (var9 != null) {
            return var9;
         }
      }

      return var2;
   }

   public static String a(Map var0, String var1, com.applovin.impl.sdk.j var2) {
      try {
         String var9 = a(var0).toString();
         return var9;
      } catch (JSONException var10) {
         com.applovin.impl.sdk.p var4 = var2.v();
         StringBuilder var5 = new StringBuilder();
         var5.append("Failed to convert map '");
         var5.append(var0);
         var5.append("' to JSON string.");
         var4.b("JsonUtils", var5.toString(), var10);
         return var1;
      }
   }

   public static ArrayList a(JSONArray var0) {
      if (var0 != null && var0.length() != 0) {
         ArrayList var1 = new ArrayList(var0.length());

         for(int var2 = 0; var2 < var0.length(); ++var2) {
            var1.add(c(var0.optJSONObject(var2)));
         }

         return var1;
      } else {
         return new ArrayList();
      }
   }

   public static List a(JSONObject param0, String param1, List param2, com.applovin.impl.sdk.j param3) {
      // $FF: Couldn't be decompiled
   }

   public static Map a(Bundle var0) {
      if (var0 == null) {
         return Collections.emptyMap();
      } else {
         HashMap var1 = new HashMap(var0.size());
         Iterator var2 = var0.keySet().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.put(var3, String.valueOf(var0.get(var3)));
         }

         return var1;
      }
   }

   public static Map a(String var0, Map var1, com.applovin.impl.sdk.j var2) {
      try {
         Map var9 = b(new JSONObject(var0));
         return var9;
      } catch (JSONException var10) {
         com.applovin.impl.sdk.p var4 = var2.v();
         StringBuilder var5 = new StringBuilder();
         var5.append("Failed to convert json string '");
         var5.append(var0);
         var5.append("' to map");
         var4.b("JsonUtils", var5.toString(), var10);
         return var1;
      }
   }

   public static Map a(JSONObject var0) throws JSONException {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.keys();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, b(var0.get(var3)).toString());
      }

      return var1;
   }

   public static JSONObject a(String var0, com.applovin.impl.sdk.j var1) {
      if (TextUtils.isEmpty(var0)) {
         return null;
      } else {
         try {
            JSONObject var2 = new JSONObject(var0);
            return var2;
         } finally {
            com.applovin.impl.sdk.p var4 = var1.v();
            StringBuilder var5 = new StringBuilder();
            var5.append("Failed to deserialize into JSON: ");
            var5.append(var0);
            var4.e("JsonUtils", var5.toString());
            return null;
         }
      }
   }

   public static JSONObject a(String var0, JSONObject var1, com.applovin.impl.sdk.j var2) {
      try {
         JSONObject var3 = new JSONObject(var0);
         return var3;
      } catch (JSONException var7) {
         if (var2 != null) {
            com.applovin.impl.sdk.p var5 = var2.v();
            StringBuilder var6 = new StringBuilder();
            var6.append("Failed to convert JSON string '");
            var6.append(var0);
            var6.append("' to JSONObject");
            var5.b("JsonUtils", var6.toString(), var7);
         }

         return var1;
      }
   }

   public static JSONObject a(Map var0) throws JSONException {
      if (var0 == null) {
         return new JSONObject();
      } else {
         JSONObject var1 = new JSONObject();
         Iterator var2 = var0.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.put((String)var3.getKey(), var3.getValue());
         }

         return var1;
      }
   }

   public static JSONObject a(JSONArray var0, int var1, JSONObject var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var1 < var0.length()) {
         try {
            JSONObject var9 = var0.getJSONObject(var1);
            return var9;
         } catch (JSONException var10) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to retrieve JSON object from array for index = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var10);
            }
         }
      }

      return var2;
   }

   public static void a(JSONObject var0, String var1, int var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null) {
         try {
            var0.put(var1, var2);
            return;
         } catch (JSONException var7) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to put int property for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var7);
            }
         }
      }

   }

   public static void a(JSONObject var0, String var1, String var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null) {
         try {
            var0.put(var1, var2);
            return;
         } catch (JSONException var7) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to put String property for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var7);
            }
         }
      }

   }

   public static void a(JSONObject var0, String var1, JSONArray var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null) {
         try {
            var0.put(var1, var2);
            return;
         } catch (JSONException var7) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to put JSONArray property for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var7);
            }
         }
      }

   }

   public static void a(JSONObject var0, String var1, JSONObject var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null) {
         try {
            var0.put(var1, var2);
            return;
         } catch (JSONException var7) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to put JSON property for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var7);
            }
         }
      }

   }

   public static boolean a(String var0, JSONArray var1) {
      int var2 = 0;

      while(true) {
         label23: {
            boolean var5;
            try {
               if (var2 >= var1.length()) {
                  break;
               }

               Object var4 = var1.get(var2);
               if (!(var4 instanceof String)) {
                  break label23;
               }

               var5 = ((String)var4).equalsIgnoreCase(var0);
            } catch (JSONException var6) {
               break;
            }

            if (var5) {
               return true;
            }
         }

         ++var2;
      }

      return false;
   }

   public static boolean a(JSONObject var0, String var1) {
      return var0 != null && var0.has(var1);
   }

   public static int b(JSONObject var0, String var1, int var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var0.has(var1)) {
         try {
            int var9 = var0.getInt(var1);
            return var9;
         } catch (JSONException var10) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to retrieve int property for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var10);
            }
         }
      }

      return var2;
   }

   private static Object b(Object var0) throws JSONException {
      if (var0 == JSONObject.NULL) {
         return null;
      } else if (var0 instanceof JSONObject) {
         return b((JSONObject)var0);
      } else {
         if (var0 instanceof JSONArray) {
            var0 = b((JSONArray)var0);
         }

         return var0;
      }
   }

   public static String b(JSONObject var0, String var1, String var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var0.has(var1)) {
         try {
            String var9 = var0.getString(var1);
            return var9;
         } catch (JSONException var10) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to retrieve string property for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var10);
            }
         }
      }

      return var2;
   }

   public static List b(JSONArray var0) throws JSONException {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var1 = new ArrayList(var0.length());

         for(int var2 = 0; var2 < var0.length(); ++var2) {
            var1.add(b(var0.get(var2)));
         }

         return var1;
      }
   }

   public static Map b(JSONObject var0) throws JSONException {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.keys();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, b(var0.get(var3)));
      }

      return var1;
   }

   public static JSONArray b(JSONObject var0, String var1, JSONArray var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var0.has(var1)) {
         try {
            JSONArray var9 = var0.getJSONArray(var1);
            return var9;
         } catch (JSONException var10) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to retrieve JSON array for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var10);
            }
         }
      }

      return var2;
   }

   public static JSONObject b(JSONObject var0, String var1, JSONObject var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null && var0.has(var1)) {
         try {
            JSONObject var9 = var0.getJSONObject(var1);
            return var9;
         } catch (JSONException var10) {
            if (var3 != null) {
               com.applovin.impl.sdk.p var5 = var3.v();
               StringBuilder var6 = new StringBuilder();
               var6.append("Failed to retrieve JSON property for key = ");
               var6.append(var1);
               var5.b("JsonUtils", var6.toString(), var10);
            }
         }
      }

      return var2;
   }

   public static void b(JSONObject var0, String var1, long var2, com.applovin.impl.sdk.j var4) {
      if (var0 != null) {
         try {
            var0.put(var1, var2);
            return;
         } catch (JSONException var8) {
            if (var4 != null) {
               com.applovin.impl.sdk.p var6 = var4.v();
               StringBuilder var7 = new StringBuilder();
               var7.append("Failed to put long property for key = ");
               var7.append(var1);
               var6.b("JsonUtils", var7.toString(), var8);
            }
         }
      }

   }

   public static Bundle c(JSONObject var0) {
      if (var0 != null && var0.length() != 0) {
         Bundle var1 = new Bundle();
         Iterator var2 = var0.keys();

         while(true) {
            while(var2.hasNext()) {
               String var3 = (String)var2.next();
               if (var0.isNull(var3)) {
                  var1.putString(var3, (String)null);
               } else {
                  Object var4 = var0.opt(var3);
                  if (var4 instanceof JSONObject) {
                     var1.putBundle(var3, c((JSONObject)var4));
                  } else if (!(var4 instanceof JSONArray)) {
                     if (var4 instanceof Boolean) {
                        var1.putBoolean(var3, (Boolean)var4);
                     } else if (var4 instanceof String) {
                        var1.putString(var3, (String)var4);
                     } else if (var4 instanceof Integer) {
                        var1.putInt(var3, (Integer)var4);
                     } else if (var4 instanceof Long) {
                        var1.putLong(var3, (Long)var4);
                     } else if (var4 instanceof Double) {
                        var1.putDouble(var3, (Double)var4);
                     }
                  } else {
                     JSONArray var5 = (JSONArray)var4;
                     int var6 = var5.length();
                     int var7 = 0;
                     if (var6 == 0) {
                        var1.putStringArrayList(var3, new ArrayList(0));
                     } else if (!(a(var5, 0, (Object)null, (com.applovin.impl.sdk.j)null) instanceof String)) {
                        var1.putParcelableArrayList(var3, a(var5));
                     } else {
                        ArrayList var8;
                        for(var8 = new ArrayList(var5.length()); var7 < var5.length(); ++var7) {
                           var8.add((String)a(var5, var7, (Object)null, (com.applovin.impl.sdk.j)null));
                        }

                        var1.putStringArrayList(var3, var8);
                     }
                  }
               }
            }

            return var1;
         }
      } else {
         return new Bundle();
      }
   }

   public static String d(JSONObject var0) {
      if (var0 == null) {
         return null;
      } else {
         try {
            String var2 = var0.toString(4);
            return var2;
         } catch (JSONException var3) {
            return var0.toString();
         }
      }
   }
}
