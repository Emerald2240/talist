package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.s;

public class e {
   private e.a a;
   private Uri b;
   private String c;

   private e() {
   }

   static e a(s var0, e var1, com.applovin.impl.sdk.j var2) {
      if (var0 != null) {
         if (var2 == null) {
            throw new IllegalArgumentException("No sdk specified.");
         } else {
            Throwable var10000;
            label640: {
               boolean var10001;
               if (var1 == null) {
                  try {
                     var1 = new e();
                  } catch (Throwable var59) {
                     var10000 = var59;
                     var10001 = false;
                     break label640;
                  }
               }

               String var5;
               label632: {
                  label641: {
                     try {
                        if (var1.b != null || n.b(var1.c)) {
                           break label641;
                        }

                        String var4 = a(var0, "StaticResource");
                        if (URLUtil.isValidUrl(var4)) {
                           var1.b = Uri.parse(var4);
                           var1.a = e.a.b;
                           return var1;
                        }
                     } catch (Throwable var61) {
                        var10000 = var61;
                        var10001 = false;
                        break label640;
                     }

                     try {
                        var5 = a(var0, "IFrameResource");
                        if (n.b(var5)) {
                           var1.a = e.a.c;
                           if (!URLUtil.isValidUrl(var5)) {
                              break label632;
                           }

                           var1.b = Uri.parse(var5);
                           return var1;
                        }
                     } catch (Throwable var62) {
                        var10000 = var62;
                        var10001 = false;
                        break label640;
                     }

                     String var6;
                     try {
                        var6 = a(var0, "HTMLResource");
                        if (!n.b(var6)) {
                           break label641;
                        }

                        var1.a = e.a.d;
                        if (URLUtil.isValidUrl(var6)) {
                           var1.b = Uri.parse(var6);
                           return var1;
                        }
                     } catch (Throwable var60) {
                        var10000 = var60;
                        var10001 = false;
                        break label640;
                     }

                     try {
                        var1.c = var6;
                     } catch (Throwable var58) {
                        var10000 = var58;
                        var10001 = false;
                        break label640;
                     }
                  }

                  try {
                     return var1;
                  } catch (Throwable var57) {
                     var10000 = var57;
                     var10001 = false;
                     break label640;
                  }
               }

               label600:
               try {
                  var1.c = var5;
                  return var1;
               } catch (Throwable var56) {
                  var10000 = var56;
                  var10001 = false;
                  break label600;
               }
            }

            Throwable var3 = var10000;
            var2.v().b("VastNonVideoResource", "Error occurred while initializing", var3);
            return null;
         }
      } else {
         throw new IllegalArgumentException("No node specified.");
      }
   }

   private static String a(s var0, String var1) {
      s var2 = var0.b(var1);
      return var2 != null ? var2.c() : null;
   }

   public e.a a() {
      return this.a;
   }

   public void a(Uri var1) {
      this.b = var1;
   }

   public void a(String var1) {
      this.c = var1;
   }

   public Uri b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof e)) {
         return false;
      } else {
         e var2 = (e)var1;
         if (this.a != var2.a) {
            return false;
         } else {
            Uri var3 = this.b;
            if (var3 != null) {
               if (!var3.equals(var2.b)) {
                  return false;
               }
            } else if (var2.b != null) {
               return false;
            }

            String var4 = this.c;
            String var5 = var2.c;
            if (var4 != null) {
               return var4.equals(var5);
            } else {
               return var5 == null;
            }
         }
      }
   }

   public int hashCode() {
      e.a var1 = this.a;
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
      String var7 = this.c;
      int var8 = 0;
      if (var7 != null) {
         var8 = var7.hashCode();
      }

      return var6 + var8;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VastNonVideoResource{type=");
      var1.append(this.a);
      var1.append(", resourceUri=");
      var1.append(this.b);
      var1.append(", resourceContents='");
      var1.append(this.c);
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }

   public static enum a {
      a,
      b,
      c,
      d;

      static {
         e.a[] var0 = new e.a[]{a, b, c, d};
      }
   }
}
