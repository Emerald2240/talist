package com.noqoush.adfalcon.android.sdk.urlactions;

import android.content.Intent;

public class f extends b {
   public boolean a(e var1) {
      try {
         boolean var3 = this.e(var1.b());
         return var3;
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
         return false;
      }
   }

   public boolean b(e var1) throws Exception {
      Exception var10000;
      label72: {
         boolean var10001;
         Intent var3;
         try {
            var3 = Intent.parseUri(this.a(var1.b()).toString(), 1);
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label72;
         }

         try {
            l.a(var1.a(), var3);
            if (var1.c() != null) {
               var1.c().a(i.b, m.d);
            }

            return true;
         } catch (Exception var14) {
            label79: {
               Exception var4 = var14;

               String var5;
               try {
                  com.noqoush.adfalcon.android.sdk.util.a.a(var4);
                  var5 = var3.getStringExtra("browser_fallback_url");
               } catch (Exception var13) {
                  var10000 = var13;
                  var10001 = false;
                  break label79;
               }

               if (var5 != null) {
                  label78: {
                     try {
                        if (var5.length() == 0) {
                           break label78;
                        }
                     } catch (Exception var12) {
                        var10000 = var12;
                        var10001 = false;
                        break label79;
                     }

                     try {
                        var1.a(var5);
                        boolean var7 = (new com.noqoush.adfalcon.android.sdk.handler.c()).a(var1);
                        return var7;
                     } catch (Exception var8) {
                        var10000 = var8;
                        var10001 = false;
                        break label79;
                     }
                  }
               }

               label51: {
                  try {
                     if ("market".equalsIgnoreCase(var3.getScheme())) {
                        break label51;
                     }
                  } catch (Exception var11) {
                     var10000 = var11;
                     var10001 = false;
                     break label79;
                  }

                  try {
                     Intent var6 = new Intent("android.intent.action.VIEW", l.a(var3));
                     l.a(var1.a(), var6);
                     if (var1.c() != null) {
                        var1.c().a(i.b, m.c);
                     }
                  } catch (Exception var10) {
                     var10000 = var10;
                     var10001 = false;
                     break label79;
                  }
               }

               try {
                  return true;
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
               }
            }
         }
      }

      Exception var2 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      if (var1.c() != null) {
         var1.c().a();
      }

      return false;
   }
}
