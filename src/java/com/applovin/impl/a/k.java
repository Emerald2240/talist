package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.s;
import java.util.Locale;

public class k {
   private Uri a;
   private Uri b;
   private k.a c;
   private String d;
   private int e;
   private int f;
   private int g;

   private k() {
   }

   private static k.a a(String var0) {
      if (n.b(var0)) {
         if ("progressive".equalsIgnoreCase(var0)) {
            return k.a.a;
         }

         if ("streaming".equalsIgnoreCase(var0)) {
            return k.a.b;
         }
      }

      return k.a.a;
   }

   public static k a(s var0, com.applovin.impl.sdk.j var1) {
      if (var0 == null) {
         throw new IllegalArgumentException("No node specified.");
      } else if (var1 != null) {
         try {
            String var3 = var0.c();
            if (URLUtil.isValidUrl(var3)) {
               Uri var4 = Uri.parse(var3);
               k var5 = new k();
               var5.a = var4;
               var5.b = var4;
               var5.g = n.a((String)var0.b().get("bitrate"));
               var5.c = a((String)var0.b().get("delivery"));
               var5.f = n.a((String)var0.b().get("height"));
               var5.e = n.a((String)var0.b().get("width"));
               var5.d = ((String)var0.b().get("type")).toLowerCase(Locale.ENGLISH);
               return var5;
            }

            var1.v().e("VastVideoFile", "Unable to create video file. Could not find URL.");
         } catch (Throwable var7) {
            var1.v().b("VastVideoFile", "Error occurred while initializing", var7);
            return null;
         }

         return null;
      } else {
         throw new IllegalArgumentException("No sdk specified.");
      }
   }

   public Uri a() {
      return this.a;
   }

   public void a(Uri var1) {
      this.b = var1;
   }

   public Uri b() {
      return this.b;
   }

   public boolean c() {
      return this.c == k.a.b;
   }

   public String d() {
      return this.d;
   }

   public int e() {
      return this.g;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof k)) {
         return false;
      } else {
         k var2 = (k)var1;
         if (this.e != var2.e) {
            return false;
         } else if (this.f != var2.f) {
            return false;
         } else if (this.g != var2.g) {
            return false;
         } else {
            Uri var3 = this.a;
            if (var3 != null) {
               if (!var3.equals(var2.a)) {
                  return false;
               }
            } else if (var2.a != null) {
               return false;
            }

            Uri var4 = this.b;
            if (var4 != null) {
               if (!var4.equals(var2.b)) {
                  return false;
               }
            } else if (var2.b != null) {
               return false;
            }

            if (this.c != var2.c) {
               return false;
            } else {
               String var5 = this.d;
               String var6 = var2.d;
               if (var5 != null) {
                  return var5.equals(var6);
               } else {
                  return var6 == null;
               }
            }
         }
      }
   }

   public int hashCode() {
      Uri var1 = this.a;
      int var2;
      if (var1 != null) {
         var2 = var1.hashCode();
      } else {
         var2 = 0;
      }

      int var3 = var2 * 31;
      Uri var4 = this.b;
      int var5;
      if (var4 != null) {
         var5 = var4.hashCode();
      } else {
         var5 = 0;
      }

      int var6 = 31 * (var3 + var5);
      k.a var7 = this.c;
      int var8;
      if (var7 != null) {
         var8 = var7.hashCode();
      } else {
         var8 = 0;
      }

      int var9 = 31 * (var6 + var8);
      String var10 = this.d;
      int var11 = 0;
      if (var10 != null) {
         var11 = var10.hashCode();
      }

      return 31 * (31 * (31 * (var9 + var11) + this.e) + this.f) + this.g;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VastVideoFile{sourceVideoUri=");
      var1.append(this.a);
      var1.append(", videoUri=");
      var1.append(this.b);
      var1.append(", deliveryType=");
      var1.append(this.c);
      var1.append(", fileType='");
      var1.append(this.d);
      var1.append('\'');
      var1.append(", width=");
      var1.append(this.e);
      var1.append(", height=");
      var1.append(this.f);
      var1.append(", bitrate=");
      var1.append(this.g);
      var1.append('}');
      return var1.toString();
   }

   public static enum a {
      a,
      b;

      static {
         k.a[] var0 = new k.a[]{a, b};
      }
   }
}
