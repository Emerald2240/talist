package com.iab.omid.library.adfalcon;

import com.iab.omid.library.adfalcon.d.e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class b {
   private static final Pattern a = Pattern.compile("<(head)( [^>]*)?>", 2);
   private static final Pattern b = Pattern.compile("<(head)( [^>]*)?/>", 2);
   private static final Pattern c = Pattern.compile("<(body)( [^>]*?)?>", 2);
   private static final Pattern d = Pattern.compile("<(body)( [^>]*?)?/>", 2);
   private static final Pattern e = Pattern.compile("<(html)( [^>]*?)?>", 2);
   private static final Pattern f = Pattern.compile("<(html)( [^>]*?)?/>", 2);
   private static final Pattern g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

   static String a(String var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("<script type=\"text/javascript\">");
      var2.append(var0);
      var2.append("</script>");
      return b(var1, var2.toString());
   }

   private static boolean a(int var0, int[][] var1) {
      if (var1 != null) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            int[] var4 = var1[var3];
            if (var0 >= var4[0] && var0 <= var4[1]) {
               return true;
            }
         }
      }

      return false;
   }

   private static boolean a(String var0, StringBuilder var1, Pattern var2, String var3, int[][] var4) {
      Matcher var5 = var2.matcher(var0);

      int var8;
      for(int var6 = 0; var5.find(var6); var6 = var8) {
         int var7 = var5.start();
         var8 = var5.end();
         if (!a(var7, var4)) {
            var1.append(var0.substring(0, var5.end()));
            var1.append(var3);
            var1.append(var0.substring(var5.end()));
            return true;
         }
      }

      return false;
   }

   private static int[][] a(String var0) {
      ArrayList var1 = new ArrayList();
      int var2 = var0.length();
      int var3 = 0;

      while(true) {
         while(var3 < var2) {
            int var4 = var0.indexOf("<!--", var3);
            if (var4 >= 0) {
               int var5 = var0.indexOf("-->", var4);
               int[] var6 = new int[2];
               if (var5 >= 0) {
                  var6[0] = var4;
                  var6[1] = var5;
                  var1.add(var6);
                  var3 = var5 + 3;
                  continue;
               }

               var6[0] = var4;
               var6[1] = var2;
               var1.add(var6);
            }

            var3 = var2;
         }

         return (int[][])var1.toArray((int[][])Array.newInstance(I.class, new int[]{0, 2}));
      }
   }

   static String b(String var0, String var1) {
      com.iab.omid.library.adfalcon.d.e.a(var0, "HTML is null or empty");
      int[][] var2 = a(var0);
      StringBuilder var3 = new StringBuilder(16 + var0.length() + var1.length());
      if (b(var0, var3, b, var1, var2)) {
         return var3.toString();
      } else if (a(var0, var3, a, var1, var2)) {
         return var3.toString();
      } else if (b(var0, var3, d, var1, var2)) {
         return var3.toString();
      } else if (a(var0, var3, c, var1, var2)) {
         return var3.toString();
      } else if (b(var0, var3, f, var1, var2)) {
         return var3.toString();
      } else if (a(var0, var3, e, var1, var2)) {
         return var3.toString();
      } else if (a(var0, var3, g, var1, var2)) {
         return var3.toString();
      } else {
         StringBuilder var4 = new StringBuilder();
         var4.append(var1);
         var4.append(var0);
         return var4.toString();
      }
   }

   private static boolean b(String var0, StringBuilder var1, Pattern var2, String var3, int[][] var4) {
      Matcher var5 = var2.matcher(var0);

      int var8;
      for(int var6 = 0; var5.find(var6); var6 = var8) {
         int var7 = var5.start();
         var8 = var5.end();
         if (!a(var7, var4)) {
            var1.append(var0.substring(0, -2 + var5.end()));
            var1.append(">");
            var1.append(var3);
            var1.append("</");
            var1.append(var5.group(1));
            var1.append(">");
            var1.append(var0.substring(var5.end()));
            return true;
         }
      }

      return false;
   }
}
